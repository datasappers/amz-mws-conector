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

import com.amazonservices.mws.products.model.*;

/**
 * This is the Products API section of the Marketplace Web Service.
 */
public interface MWSProducts {

    /**
     * Get Competitive Pricing For ASIN
     *
     * Gets competitive pricing and related information for a product identified by
     * the MarketplaceId and ASIN.
     *
     * @param request
     *           GetCompetitivePricingForASINRequest request.
     *
     * @return GetCompetitivePricingForASINResponse response.
     *
     * @throws MWSProductsException
     */
    GetCompetitivePricingForASINResponse getCompetitivePricingForASIN(
        GetCompetitivePricingForASINRequest request)
        throws MWSProductsException;

    /**
     * Get Competitive Pricing For SKU
     *
     * Gets competitive pricing and related information for a product identified by
     * the SellerId and SKU.
     *
     * @param request
     *           GetCompetitivePricingForSKURequest request.
     *
     * @return GetCompetitivePricingForSKUResponse response.
     *
     * @throws MWSProductsException
     */
    GetCompetitivePricingForSKUResponse getCompetitivePricingForSKU(
        GetCompetitivePricingForSKURequest request)
        throws MWSProductsException;

    /**
     * Get Lowest Offer Listings For ASIN
     *
     * Gets some of the lowest prices based on the product identified by the given
     * MarketplaceId and ASIN.
     *
     * @param request
     *           GetLowestOfferListingsForASINRequest request.
     *
     * @return GetLowestOfferListingsForASINResponse response.
     *
     * @throws MWSProductsException
     */
    GetLowestOfferListingsForASINResponse getLowestOfferListingsForASIN(
        GetLowestOfferListingsForASINRequest request)
        throws MWSProductsException;

    /**
     * Get Lowest Offer Listings For SKU
     *
     * Gets some of the lowest prices based on the product identified by the given
     * SellerId and SKU.
     *
     * @param request
     *           GetLowestOfferListingsForSKURequest request.
     *
     * @return GetLowestOfferListingsForSKUResponse response.
     *
     * @throws MWSProductsException
     */
    GetLowestOfferListingsForSKUResponse getLowestOfferListingsForSKU(
        GetLowestOfferListingsForSKURequest request)
        throws MWSProductsException;

    /**
     * Get Matching Product
     *
     * GetMatchingProduct will return the details (attributes) for the
     * given ASIN.
     *
     * @param request
     *           GetMatchingProductRequest request.
     *
     * @return GetMatchingProductResponse response.
     *
     * @throws MWSProductsException
     */
    GetMatchingProductResponse getMatchingProduct(
        GetMatchingProductRequest request)
        throws MWSProductsException;

    /**
     * Get Matching Product For Id
     *
     * GetMatchingProduct will return the details (attributes) for the
     * given Identifier list. Identifer type can be one of [SKU|ASIN|UPC|EAN|ISBN|GTIN|JAN]
     *
     * @param request
     *           GetMatchingProductForIdRequest request.
     *
     * @return GetMatchingProductForIdResponse response.
     *
     * @throws MWSProductsException
     */
    GetMatchingProductForIdResponse getMatchingProductForId(
        GetMatchingProductForIdRequest request)
        throws MWSProductsException;

    /**
     * Get My Price For ASIN
     *
     * <!-- Wrong doc in current code -->
     *
     * @param request
     *           GetMyPriceForASINRequest request.
     *
     * @return GetMyPriceForASINResponse response.
     *
     * @throws MWSProductsException
     */
    GetMyPriceForASINResponse getMyPriceForASIN(
        GetMyPriceForASINRequest request)
        throws MWSProductsException;

    /**
     * Get My Price For SKU
     *
     * <!-- Wrong doc in current code -->
     *
     * @param request
     *           GetMyPriceForSKURequest request.
     *
     * @return GetMyPriceForSKUResponse response.
     *
     * @throws MWSProductsException
     */
    GetMyPriceForSKUResponse getMyPriceForSKU(
        GetMyPriceForSKURequest request)
        throws MWSProductsException;

    /**
     * Get Product Categories For ASIN
     *
     * Gets categories information for a product identified by
     * the MarketplaceId and ASIN.
     *
     * @param request
     *           GetProductCategoriesForASINRequest request.
     *
     * @return GetProductCategoriesForASINResponse response.
     *
     * @throws MWSProductsException
     */
    GetProductCategoriesForASINResponse getProductCategoriesForASIN(
        GetProductCategoriesForASINRequest request)
        throws MWSProductsException;

    /**
     * Get Product Categories For SKU
     *
     * Gets categories information for a product identified by
     * the SellerId and SKU.
     *
     * @param request
     *           GetProductCategoriesForSKURequest request.
     *
     * @return GetProductCategoriesForSKUResponse response.
     *
     * @throws MWSProductsException
     */
    GetProductCategoriesForSKUResponse getProductCategoriesForSKU(
        GetProductCategoriesForSKURequest request)
        throws MWSProductsException;

    /**
     * Get Service Status
     *
     * Returns the service status of a particular MWS API section. The operation
     * takes no input.
     * All API sections within the API are required to implement this operation.
     *
     * @param request
     *           GetServiceStatusRequest request.
     *
     * @return GetServiceStatusResponse response.
     *
     * @throws MWSProductsException
     */
    GetServiceStatusResponse getServiceStatus(
        GetServiceStatusRequest request)
        throws MWSProductsException;

    /**
     * List Matching Products
     *
     * ListMatchingProducts can be used to
     * find products that match the given criteria.
     *
     * @param request
     *           ListMatchingProductsRequest request.
     *
     * @return ListMatchingProductsResponse response.
     *
     * @throws MWSProductsException
     */
    ListMatchingProductsResponse listMatchingProducts(
        ListMatchingProductsRequest request)
        throws MWSProductsException;

}
