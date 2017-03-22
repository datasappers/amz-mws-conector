/*******************************************************************************
 * Copyright 2009-2015 Amazon Services. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 *
 * You may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at: http://aws.amazon.com/apache2.0
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR 
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations under the License.
 *******************************************************************************
 * Marketplace Web Service Products
 * API Version: 2011-10-01
 * Library Version: 2015-02-13
 * Generated: Tue Feb 10 14:34:49 PST 2015
 */
package com.amazonservices.mws.products;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import com.amazonservices.mws.products.model.GetCompetitivePricingForASINRequest;
import com.amazonservices.mws.products.model.GetCompetitivePricingForASINResponse;
import com.amazonservices.mws.products.model.GetCompetitivePricingForSKURequest;
import com.amazonservices.mws.products.model.GetCompetitivePricingForSKUResponse;
import com.amazonservices.mws.products.model.GetLowestOfferListingsForASINRequest;
import com.amazonservices.mws.products.model.GetLowestOfferListingsForASINResponse;
import com.amazonservices.mws.products.model.GetLowestOfferListingsForSKURequest;
import com.amazonservices.mws.products.model.GetLowestOfferListingsForSKUResponse;
import com.amazonservices.mws.products.model.GetMatchingProductForIdRequest;
import com.amazonservices.mws.products.model.GetMatchingProductForIdResponse;
import com.amazonservices.mws.products.model.GetMatchingProductRequest;
import com.amazonservices.mws.products.model.GetMatchingProductResponse;
import com.amazonservices.mws.products.model.GetMyPriceForASINRequest;
import com.amazonservices.mws.products.model.GetMyPriceForASINResponse;
import com.amazonservices.mws.products.model.GetMyPriceForSKURequest;
import com.amazonservices.mws.products.model.GetMyPriceForSKUResponse;
import com.amazonservices.mws.products.model.GetProductCategoriesForASINRequest;
import com.amazonservices.mws.products.model.GetProductCategoriesForASINResponse;
import com.amazonservices.mws.products.model.GetProductCategoriesForSKURequest;
import com.amazonservices.mws.products.model.GetProductCategoriesForSKUResponse;
import com.amazonservices.mws.products.model.GetServiceStatusRequest;
import com.amazonservices.mws.products.model.GetServiceStatusResponse;
import com.amazonservices.mws.products.model.ListMatchingProductsRequest;
import com.amazonservices.mws.products.model.ListMatchingProductsResponse;
import com.nykart.aw.connector.configs.ProductConfiguration;

public class MWSProductsAsyncClient extends MWSProductsClient implements MWSProductsAsync {
	
	 public MWSProductsAsyncClient(
				final ProductConfiguration productConfiguration) {
		this(productConfiguration.getAccessKey(), productConfiguration.getSecretKey(),
					productConfiguration.getAppName(), productConfiguration.getAppVersion(), 
					productConfiguration);
	}

    public MWSProductsAsyncClient(
            String accessKey,
            String secretKey,
            String applicationName,
            String applicationVersion,
            ProductConfiguration config,
            ExecutorService executor) {
        super(accessKey, secretKey, applicationName, applicationVersion, config);
        connection.setExecutorService(executor);
    }

    public MWSProductsAsyncClient(
            String accessKey,
            String secretKey,
            String applicationName,
            String applicationVersion,
            ProductConfiguration config) {
        super(accessKey, secretKey, applicationName, applicationVersion, config);
    }

    public MWSProductsAsyncClient(
            String accessKey,
            String secretKey,
            ProductConfiguration config) {
        super(accessKey, secretKey, config);
    }

    public MWSProductsAsyncClient(
            String accessKey,
            String secretKey,
            String applicationName,
            String applicationVersion) {
        super(accessKey, secretKey, applicationName, applicationVersion);
    }

    public Future<GetCompetitivePricingForASINResponse> getCompetitivePricingForASINAsync(
        GetCompetitivePricingForASINRequest request) {
        return connection.callAsync(
            new RequestType("GetCompetitivePricingForASIN", GetCompetitivePricingForASINResponse.class, servicePath),
            request);
    }

    public Future<GetCompetitivePricingForSKUResponse> getCompetitivePricingForSKUAsync(
        GetCompetitivePricingForSKURequest request) {
        return connection.callAsync(
            new RequestType("GetCompetitivePricingForSKU", GetCompetitivePricingForSKUResponse.class, servicePath),
            request);
    }

    public Future<GetLowestOfferListingsForASINResponse> getLowestOfferListingsForASINAsync(
        GetLowestOfferListingsForASINRequest request) {
        return connection.callAsync(
            new RequestType("GetLowestOfferListingsForASIN", GetLowestOfferListingsForASINResponse.class, servicePath),
            request);
    }

    public Future<GetLowestOfferListingsForSKUResponse> getLowestOfferListingsForSKUAsync(
        GetLowestOfferListingsForSKURequest request) {
        return connection.callAsync(
            new RequestType("GetLowestOfferListingsForSKU", GetLowestOfferListingsForSKUResponse.class, servicePath),
            request);
    }

    public Future<GetMatchingProductResponse> getMatchingProductAsync(
        GetMatchingProductRequest request) {
        return connection.callAsync(
            new RequestType("GetMatchingProduct", GetMatchingProductResponse.class, servicePath),
            request);
    }

    public Future<GetMatchingProductForIdResponse> getMatchingProductForIdAsync(
        GetMatchingProductForIdRequest request) {
        return connection.callAsync(
            new RequestType("GetMatchingProductForId", GetMatchingProductForIdResponse.class, servicePath),
            request);
    }

    public Future<GetMyPriceForASINResponse> getMyPriceForASINAsync(
        GetMyPriceForASINRequest request) {
        return connection.callAsync(
            new RequestType("GetMyPriceForASIN", GetMyPriceForASINResponse.class, servicePath),
            request);
    }

    public Future<GetMyPriceForSKUResponse> getMyPriceForSKUAsync(
        GetMyPriceForSKURequest request) {
        return connection.callAsync(
            new RequestType("GetMyPriceForSKU", GetMyPriceForSKUResponse.class, servicePath),
            request);
    }

    public Future<GetProductCategoriesForASINResponse> getProductCategoriesForASINAsync(
        GetProductCategoriesForASINRequest request) {
        return connection.callAsync(
            new RequestType("GetProductCategoriesForASIN", GetProductCategoriesForASINResponse.class, servicePath),
            request);
    }

    public Future<GetProductCategoriesForSKUResponse> getProductCategoriesForSKUAsync(
        GetProductCategoriesForSKURequest request) {
        return connection.callAsync(
            new RequestType("GetProductCategoriesForSKU", GetProductCategoriesForSKUResponse.class, servicePath),
            request);
    }

    public Future<GetServiceStatusResponse> getServiceStatusAsync(
        GetServiceStatusRequest request) {
        return connection.callAsync(
            new RequestType("GetServiceStatus", GetServiceStatusResponse.class, servicePath),
            request);
    }

    public Future<ListMatchingProductsResponse> listMatchingProductsAsync(
        ListMatchingProductsRequest request) {
        return connection.callAsync(
            new RequestType("ListMatchingProducts", ListMatchingProductsResponse.class, servicePath),
            request);
    }


}
