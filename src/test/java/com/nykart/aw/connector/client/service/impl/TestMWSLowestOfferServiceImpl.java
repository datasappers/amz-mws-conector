package com.nykart.aw.connector.client.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amazonservices.mws.products.model.LowestOfferListingType;
import com.nykart.aw.connector.client.service.MWSLowestOfferService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:aw-mws-connector-context.xml" })
public class TestMWSLowestOfferServiceImpl {

	@Autowired
	private MWSLowestOfferService mwsLowestOfferService;
	
	@Test
	public void shouldGetLowestOfferingPriceForASIN(){
		
		final List<LowestOfferListingType> lowestOfferListingForASIN = mwsLowestOfferService.getLowestOfferListingForASIN("B0073R7TWU");
		assertEquals(13.25, lowestOfferListingForASIN.get(0).getPrice().getLandedPrice().getAmount().doubleValue(), 0);
		
	}
}
