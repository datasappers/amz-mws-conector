package com.datasappers.aw.connector.client.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonservices.mws.products.MWSProductsAsyncClient;
import com.amazonservices.mws.products.model.GetMatchingProductForIdRequest;
import com.amazonservices.mws.products.model.GetMatchingProductForIdResponse;
import com.amazonservices.mws.products.model.GetMatchingProductForIdResult;
import com.amazonservices.mws.products.model.IdListType;
import com.amazonservices.mws.products.model.ListMatchingProductsRequest;
import com.amazonservices.mws.products.model.ListMatchingProductsResponse;
import com.amazonservices.mws.products.model.ListMatchingProductsResult;
import com.amazonservices.mws.products.model.Product;
import com.amazonservices.mws.products.model.ProductList;
import com.amazonservices.mws.products.model.ResponseHeaderMetadata;
import com.datasappers.aw.connector.client.service.MWSSearchService;
import com.datasappers.aw.connector.configs.MWSAsyncProductsClientFactory;
import com.datasappers.aw.connector.configs.ProductConfiguration;
import com.nykart.common.enums.AWProductIDType;

@Component("mwsSearchService")
public class MWSSearchServiceImpl implements MWSSearchService{
	
	private static final Logger logger = Logger.getLogger("aw-mws-connector-logger");
	
	@Autowired
	private MWSAsyncProductsClientFactory mwsAsyncProductsClientFactory;
	
	@Autowired
	private ProductConfiguration productConfiguration;
	

	@Override
	public List<Product> findById(final AWProductIDType awProductIDType, final String... id) {
		
		if(id.length > 5){
			throw new IllegalArgumentException("You can't ask more than five now!. sorry baby.");
		}
		
		final List<GetMatchingProductForIdRequest> matchingProductForIdRequest = getGetMatchingProductForIdRequest(awProductIDType, id);
		final MWSProductsAsyncClient client = mwsAsyncProductsClientFactory.getAsyncClient();
		final List<GetMatchingProductForIdResponse> response = invokeMatchingProductForIdRequest(client, matchingProductForIdRequest);
		return getProducts(response);
	}
	
	
	@Override
	public List<Product> search(final String token) {
		
		final List<ListMatchingProductsRequest> listMatchingProductsRequest = getListMatchingProductsRequest(token);
		final MWSProductsAsyncClient client = mwsAsyncProductsClientFactory.getAsyncClient();
		final List<ListMatchingProductsResponse> response = invokeMatchingProductsRequest(client, listMatchingProductsRequest);
		return getMatchingProducts(response);
	}
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////
	
	private List<Product> getMatchingProducts(final List<ListMatchingProductsResponse> xresponse){
    	
    	final List<Product> products = new ArrayList<Product>();
    	for(final ListMatchingProductsResponse response : xresponse){
			final ListMatchingProductsResult listMatchingProductsResult = response.getListMatchingProductsResult();
			final ProductList productList = listMatchingProductsResult.getProducts();
			products.addAll(productList.getProduct());
    	}
    	
    	if(logger.isInfoEnabled()){
    		logger.debug("Number for products :"+products.size());
    	}
    	
    	return products;
    }
	
	private List<ListMatchingProductsResponse> invokeMatchingProductsRequest(MWSProductsAsyncClient client, List<ListMatchingProductsRequest> requestList) {
    	
	   	final List<ListMatchingProductsResponse> responses = new ArrayList<ListMatchingProductsResponse>();
        final List<Future<ListMatchingProductsResponse>> futureList = getFutureTasksForMatchingProductsRequest(client, requestList);
		for (final Future<ListMatchingProductsResponse> future : futureList) {
			try {
				final ListMatchingProductsResponse response = future.get();
				final ResponseHeaderMetadata header = response.getResponseHeaderMetadata();
				if (logger.isInfoEnabled()) {
					logger.debug("RequestId: " + header.getRequestId());
					logger.debug("Timestamp: " + header.getTimestamp());
				}
				if (logger.isDebugEnabled()) {
					logger.debug("Reponse: " + response.toXML());
				}
				responses.add(response);
			} catch (Exception e) {
				logger.error(e, e);
			}
		}
        return responses;
    }
	
	private List<Future<ListMatchingProductsResponse>> getFutureTasksForMatchingProductsRequest(
			MWSProductsAsyncClient client,
			List<ListMatchingProductsRequest> requestList) {
		final List<Future<ListMatchingProductsResponse>> futureList = new ArrayList<Future<ListMatchingProductsResponse>>();
        
        for (ListMatchingProductsRequest request : requestList) {
        	if(logger.isDebugEnabled()){
            	logger.debug("Request: "+request.toXML());
            }
            final Future<ListMatchingProductsResponse> future = client.listMatchingProductsAsync(request);
            futureList.add(future);
        }
		return futureList;
	}
	
	
	
	private List<ListMatchingProductsRequest> getListMatchingProductsRequest(final String token){
		
		final List<ListMatchingProductsRequest> requestList = new ArrayList<ListMatchingProductsRequest>();
	    final ListMatchingProductsRequest request = new ListMatchingProductsRequest();
	    request.setSellerId(productConfiguration.getSellerId());
	    request.setMWSAuthToken(productConfiguration.getMwsAuthToken());
	    request.setMarketplaceId(productConfiguration.getMarketplaceId());
	    request.setQuery(token);
	    requestList.add(request);
	    return requestList;
	}
	

	private List<GetMatchingProductForIdResponse> invokeMatchingProductForIdRequest(MWSProductsAsyncClient client, List<GetMatchingProductForIdRequest> requestList) {
    	
	   	final List<GetMatchingProductForIdResponse> responses = new ArrayList<GetMatchingProductForIdResponse>();
        final List<Future<GetMatchingProductForIdResponse>> futureList = getFutureTasksForMatchingProductForId(client, requestList);
		for (final Future<GetMatchingProductForIdResponse> future : futureList) {
			try {
				final GetMatchingProductForIdResponse response = future.get();
				final ResponseHeaderMetadata header = response.getResponseHeaderMetadata();
				if (logger.isInfoEnabled()) {
					logger.debug("RequestId: " + header.getRequestId());
					logger.debug("Timestamp: " + header.getTimestamp());
				}
				if (logger.isDebugEnabled()) {
					logger.debug("Reponse: " + response.toXML());
				}
				responses.add(response);
			} catch (Exception ee) {
				logger.error(ee, ee);
			}
		}
        return responses;
    }


	private List<Future<GetMatchingProductForIdResponse>> getFutureTasksForMatchingProductForId(MWSProductsAsyncClient client, List<GetMatchingProductForIdRequest> requestList) {
		
		final List<Future<GetMatchingProductForIdResponse>> futureList = new ArrayList<Future<GetMatchingProductForIdResponse>>();
        
        for (GetMatchingProductForIdRequest request : requestList) {
        	if(logger.isDebugEnabled()){
            	logger.debug("Request: "+request.toXML());
            }
            final Future<GetMatchingProductForIdResponse> future = client.getMatchingProductForIdAsync(request);
            futureList.add(future);
        }
		return futureList;
	}
    
    private List<Product> getProducts(final List<GetMatchingProductForIdResponse> xresponse){
    	
    	final List<Product> products = new ArrayList<Product>();
    	for(final GetMatchingProductForIdResponse response : xresponse){
			final List<GetMatchingProductForIdResult> getMatchingProductForIdResult = response.getGetMatchingProductForIdResult();
			for(final GetMatchingProductForIdResult result : getMatchingProductForIdResult){
				final ProductList productList = result.getProducts();
				if(null != productList){
					products.addAll(productList.getProduct());
				}
			}
    	}
    	
    	if(logger.isInfoEnabled()){
    		logger.debug("Number for products :"+products.size());
    	}
    	
    	return products;
    }

	
	private List<GetMatchingProductForIdRequest> getGetMatchingProductForIdRequest(final AWProductIDType awProductIDType, final String... id){
		
		final List<GetMatchingProductForIdRequest> requestList = new ArrayList<GetMatchingProductForIdRequest>();
	    final  GetMatchingProductForIdRequest request = new GetMatchingProductForIdRequest();
	    request.setSellerId(productConfiguration.getSellerId()); 
	    request.setMWSAuthToken(productConfiguration.getMwsAuthToken());
	    request.setMarketplaceId(productConfiguration.getMarketplaceId());
	    request.setIdType(awProductIDType.name());
	    final IdListType idList = new IdListType();
	    idList.setId(Arrays.asList(id));
	    request.setIdList(idList);
	    requestList.add(request);
	    
	    return requestList;
	}

}
