package com.nykart.aw.connector.client.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonservices.mws.products.MWSProductsAsyncClient;
import com.amazonservices.mws.products.model.ASINListType;
import com.amazonservices.mws.products.model.GetLowestOfferListingsForASINRequest;
import com.amazonservices.mws.products.model.GetLowestOfferListingsForASINResponse;
import com.amazonservices.mws.products.model.GetLowestOfferListingsForASINResult;
import com.amazonservices.mws.products.model.LowestOfferListingList;
import com.amazonservices.mws.products.model.LowestOfferListingType;
import com.amazonservices.mws.products.model.Product;
import com.nykart.aw.connector.client.service.MWSLowestOfferService;
import com.nykart.aw.connector.configs.MWSAsyncProductsClientFactory;
import com.nykart.aw.connector.configs.ProductConfiguration;

@Component("mwsLowestOfferService")
public class MWSLowestOfferServiceImpl implements MWSLowestOfferService{

	private static final Logger logger = Logger.getLogger("aw-mws-connector-logger");

	@Autowired
	private MWSAsyncProductsClientFactory mwsAsyncProductsClientFactory;

	@Autowired
	private ProductConfiguration productConfiguration;

	@Override
	public List<LowestOfferListingType> getLowestOfferListingForASIN(final String... asin) {

		if(asin.length > 20){
			throw new IllegalArgumentException("We support only 20 asins now! sorry baby.");
		}

		final List<LowestOfferListingType> offerings = new ArrayList<LowestOfferListingType>();

		final MWSProductsAsyncClient client = this.mwsAsyncProductsClientFactory.getAsyncClient();
		final GetLowestOfferListingsForASINRequest request = this.createRequest(asin);
		final Future<GetLowestOfferListingsForASINResponse> futureTask = this.getFutureTaskForLowestOfferListings(client, request);
		try {
			final GetLowestOfferListingsForASINResponse lowestOfferListingsForASINResponse = futureTask.get();
			final List<GetLowestOfferListingsForASINResult> results = lowestOfferListingsForASINResponse.getGetLowestOfferListingsForASINResult();
			for(final GetLowestOfferListingsForASINResult result : results){
				final Product product = result.getProduct();
				if(null != product){
					final LowestOfferListingList lowestOfferListings = product.getLowestOfferListings();
					if(null != lowestOfferListings){
						offerings.addAll(lowestOfferListings.getLowestOfferListing());
					}
				}
			}
		} catch (InterruptedException | ExecutionException e) {
			logger.error(e, e);
		}

		return offerings;
	}

	private Future<GetLowestOfferListingsForASINResponse> getFutureTaskForLowestOfferListings(MWSProductsAsyncClient client,
			GetLowestOfferListingsForASINRequest request) {

        if(logger.isDebugEnabled()){
           	logger.debug("Request: "+request.toXML());
        }

       return client.getLowestOfferListingsForASINAsync(request);
	}

	private GetLowestOfferListingsForASINRequest createRequest(final String... asin){

        final GetLowestOfferListingsForASINRequest request = new GetLowestOfferListingsForASINRequest();
        request.setSellerId(this.productConfiguration.getSellerId());
        request.setMWSAuthToken(this.productConfiguration.getMwsAuthToken());
        request.setMarketplaceId(this.productConfiguration.getMarketplaceId());
        final ASINListType asinList = new ASINListType();
        asinList.setASIN(Arrays.asList(asin));
        request.setASINList(asinList);
        request.setItemCondition("new");
        request.setExcludeMe(Boolean.TRUE);

        return request;
	}

}
