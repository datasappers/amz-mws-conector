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

import com.amazonservices.mws.client.MwsConnection;
import com.amazonservices.mws.client.MwsException;
import com.amazonservices.mws.client.MwsObject;
import com.amazonservices.mws.client.MwsRequestType;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;
import com.amazonservices.mws.client.MwsUtl;
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
import com.amazonservices.mws.products.model.MWSResponse;
import com.amazonservices.mws.products.model.ResponseHeaderMetadata;
import com.nykart.aw.connector.configs.ProductConfiguration;

public class MWSProductsClient implements MWSProducts {

    private static final String libraryName = "MarketplaceWebServiceProducts";

    private static final String libraryVersion = "2015-02-13";

    protected String servicePath;

    protected final MwsConnection connection;

    public MWSProductsClient(
			final ProductConfiguration productConfiguration) {
	this(productConfiguration.getAccessKey(), productConfiguration.getSecretKey(),
				productConfiguration.getAppName(), productConfiguration.getAppVersion(),
				productConfiguration);
    }

    public MWSProductsClient(
            String accessKey,
            String secretKey,
            String applicationName,
            String applicationVersion,
            ProductConfiguration config) {
        this.connection = config.copyConnection();
        this.connection.setAwsAccessKeyId(accessKey);
        this.connection.setAwsSecretKeyId(secretKey);
        this.connection.setApplicationName(applicationName);
        this.connection.setApplicationVersion(applicationVersion);
        this.connection.setLibraryVersion(libraryVersion);
        this.servicePath = config.getServicePath();
    }

    public MWSProductsClient(
            String accessKey,
            String secretKey,
            ProductConfiguration config) {
        this(accessKey, secretKey, libraryName, libraryVersion, config);
    }

    public MWSProductsClient(
            String accessKey,
            String secretKey,
            String applicationName,
            String applicationVersion) {
        this(accessKey, secretKey, applicationName,
                applicationVersion, new ProductConfiguration());
    }



	@Override
	public GetCompetitivePricingForASINResponse getCompetitivePricingForASIN(GetCompetitivePricingForASINRequest request) {
        return this.connection.call(
            new RequestType("GetCompetitivePricingForASIN", GetCompetitivePricingForASINResponse.class, this.servicePath),
            request);
    }

    @Override
	public GetCompetitivePricingForSKUResponse getCompetitivePricingForSKU(GetCompetitivePricingForSKURequest request) {
        return this.connection.call(
            new RequestType("GetCompetitivePricingForSKU", GetCompetitivePricingForSKUResponse.class, this.servicePath),
            request);
    }

    @Override
	public GetLowestOfferListingsForASINResponse getLowestOfferListingsForASIN(GetLowestOfferListingsForASINRequest request) {
        return this.connection.call(
            new RequestType("GetLowestOfferListingsForASIN", GetLowestOfferListingsForASINResponse.class, this.servicePath),
            request);
    }

    @Override
	public GetLowestOfferListingsForSKUResponse getLowestOfferListingsForSKU(GetLowestOfferListingsForSKURequest request) {
        return this.connection.call(
            new RequestType("GetLowestOfferListingsForSKU", GetLowestOfferListingsForSKUResponse.class, this.servicePath),
            request);
    }

    @Override
	public GetMatchingProductResponse getMatchingProduct(GetMatchingProductRequest request) {
        return this.connection.call(
            new RequestType("GetMatchingProduct", GetMatchingProductResponse.class, this.servicePath),
            request);
    }

    @Override
	public GetMatchingProductForIdResponse getMatchingProductForId(GetMatchingProductForIdRequest request) {
        return this.connection.call(
            new RequestType("GetMatchingProductForId", GetMatchingProductForIdResponse.class, this.servicePath),
            request);
    }

    @Override
	public GetMyPriceForASINResponse getMyPriceForASIN(GetMyPriceForASINRequest request) {
        return this.connection.call(
            new RequestType("GetMyPriceForASIN", GetMyPriceForASINResponse.class, this.servicePath),
            request);
    }

    @Override
	public GetMyPriceForSKUResponse getMyPriceForSKU(GetMyPriceForSKURequest request) {
        return this.connection.call(
            new RequestType("GetMyPriceForSKU", GetMyPriceForSKUResponse.class, this.servicePath),
            request);
    }

    @Override
	public GetProductCategoriesForASINResponse getProductCategoriesForASIN(GetProductCategoriesForASINRequest request) {
        return this.connection.call(
            new RequestType("GetProductCategoriesForASIN", GetProductCategoriesForASINResponse.class, this.servicePath),
            request);
    }

    @Override
	public GetProductCategoriesForSKUResponse getProductCategoriesForSKU(GetProductCategoriesForSKURequest request) {
        return this.connection.call(
            new RequestType("GetProductCategoriesForSKU", GetProductCategoriesForSKUResponse.class, this.servicePath),
            request);
    }

    @Override
	public GetServiceStatusResponse getServiceStatus(GetServiceStatusRequest request) {
        return this.connection.call(
            new RequestType("GetServiceStatus", GetServiceStatusResponse.class, this.servicePath),
            request);
    }

    @Override
	public ListMatchingProductsResponse listMatchingProducts(ListMatchingProductsRequest request) {
        return this.connection.call(
            new RequestType("ListMatchingProducts", ListMatchingProductsResponse.class, this.servicePath),
            request);
    }

    public static String quoteAppName(String s) {
        return MwsUtl.escapeAppName(s);
    }

    public static String quoteAppVersion(String s) {
        return MwsUtl.escapeAppVersion(s);
    }

    public static String quoteAttributeName(String s) {
        return MwsUtl.escapeAttributeName(s);
    }

    public static String quoteAttributeValue(String s) {
        return MwsUtl.escapeAttributeValue(s);
    }

    protected static class RequestType implements MwsRequestType {

        private final String operationName;
        private final Class<? extends MWSResponse> responseClass;
        private final String servicePath;

        public RequestType(String operationName, Class<? extends MWSResponse> responseClass, String servicePath) {
            this.operationName = operationName;
            this.responseClass = responseClass;
            this.servicePath = servicePath;
        }

        @Override
        public String getServicePath() {
            return this.servicePath;
        }

        @Override
        public String getOperationName() {
            return this.operationName;
        }

        @Override
        public Class<? extends MwsObject> getResponseClass() {
            return this.responseClass;
        }

        @Override
        public MwsException wrapException(Throwable cause) {
            return new MWSProductsException(cause);
        }

        @Override
        public void setRHMD(MwsObject response, MwsResponseHeaderMetadata rhmd) {
            ((MWSResponse)response).setResponseHeaderMetadata(new ResponseHeaderMetadata(rhmd));
        }
    }

}
