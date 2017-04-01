package com.datasappers.aw.connector.client.service;

import java.util.List;

import com.amazonservices.mws.products.model.LowestOfferListingType;

public interface MWSLowestOfferService {
	
	List<LowestOfferListingType> getLowestOfferListingForASIN(final String... asin);

}
