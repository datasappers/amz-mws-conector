package com.datasappers.aw.connector.client.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonservices.mws.products.MWSProductsAsyncClient;
import com.amazonservices.mws.products.MWSProductsClient;
import com.amazonservices.mws.products.MWSProductsException;
import com.amazonservices.mws.products.model.Categories;
import com.amazonservices.mws.products.model.GetProductCategoriesForASINRequest;
import com.amazonservices.mws.products.model.GetProductCategoriesForASINResponse;
import com.datasappers.aw.connector.client.service.MWSCategoryService;
import com.datasappers.aw.connector.configs.MWSAsyncProductsClientFactory;
import com.datasappers.aw.connector.configs.ProductConfiguration;
import com.nykart.data.persister.service.PersisterService;
import com.nykart.dto.ErrorReporting;
import com.nykart.enums.Operations;

@Component("mwsCategoryService")
public class MWSCategoryServiceImpl implements MWSCategoryService{

	private static final Logger logger = Logger.getLogger("aw-mws-connector-logger");

	@Autowired
	private MWSAsyncProductsClientFactory mwsAsyncProductsClientFactory;

	@Autowired
	private ProductConfiguration productConfiguration;

	@Autowired
	private PersisterService  persisterService;

	@Override
	public List<Categories> getCategoriesForASIN(final String asin) {

		final List<Categories> caregories = new ArrayList<Categories>();

		final GetProductCategoriesForASINRequest request = this.createRequest(asin);
		final MWSProductsAsyncClient asyncClient = this.mwsAsyncProductsClientFactory.getAsyncClient();
		final Future<GetProductCategoriesForASINResponse> futureTask = this.getFutureTaskForCategoryList(asyncClient, request);
		try {
			final GetProductCategoriesForASINResponse response = futureTask.get();
			caregories.addAll(response.getGetProductCategoriesForASINResult().getSelf());
		} catch (final InterruptedException e) {
			logger.error(e, e);
		} catch (final ExecutionException e) {
			if(e.getCause().toString().contains("Request is throttled")){
				//sleep for 10 seconds and try with normal client.
				try {
					Thread.sleep(10000);
				} catch (final InterruptedException e1) {
					logger.error(e1, e1);
				}
				try {
					final MWSProductsClient client = this.mwsAsyncProductsClientFactory.getClient();
					final GetProductCategoriesForASINResponse productCategoriesForASIN = client.getProductCategoriesForASIN(request);
					caregories.addAll(productCategoriesForASIN.getGetProductCategoriesForASINResult().getSelf());
				} catch (final MWSProductsException e1) {
					if(e.getCause().toString().contains("Request is throttled")){
						//sleep for 25 seconds and try with normal client.
						try {
							Thread.sleep(25000);
						} catch (final InterruptedException e2) {
							logger.error(e2, e2);
						}

						try {
							final MWSProductsClient client = this.mwsAsyncProductsClientFactory.getClient();
							final GetProductCategoriesForASINResponse productCategoriesForASIN = client.getProductCategoriesForASIN(request);
							caregories.addAll(productCategoriesForASIN.getGetProductCategoriesForASINResult().getSelf());
						} catch (final Exception e3) {

							final ErrorReporting defaultInstance = ErrorReporting.getDefaultInstance(
									Operations.MWS_CATEGROY_FIND_BY_ASIN.name(), "Couldn't find one more ASINs", new String [] {asin});
							this.persisterService.save(defaultInstance);
							logger.error(e3, e3);
						}
					}
				}
			}
		}

		if(logger.isDebugEnabled()){
			for(final Categories c : caregories){
				logger.debug("Response: "+c.toXML());
			}
		}

		return caregories;
	}

	private Future<GetProductCategoriesForASINResponse> getFutureTaskForCategoryList(MWSProductsAsyncClient client,
			GetProductCategoriesForASINRequest request) {

        if(logger.isDebugEnabled()){
           	logger.debug("Request: "+request.toXML());
        }

       return client.getProductCategoriesForASINAsync(request);
	}

	private GetProductCategoriesForASINRequest createRequest(final String asin){

        final GetProductCategoriesForASINRequest request = new GetProductCategoriesForASINRequest();
        request.setSellerId(this.productConfiguration.getSellerId());
        request.setMWSAuthToken(this.productConfiguration.getMwsAuthToken());
        request.setMarketplaceId(this.productConfiguration.getMarketplaceId());
        request.setASIN(asin);

        return request;
	}

}
