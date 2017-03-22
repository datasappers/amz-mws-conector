package com.nykart.aw.connector.client.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amazonservices.mws.products.model.Product;
import com.nykart.aw.connector.client.service.MWSSearchService;
import com.nykart.common.enums.AWProductIDType;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:aw-mws-connector-context.xml" })
public class TestMWSSearchServiceImpl {

	@Autowired
	private MWSSearchService mwsSearchService;
	
	@Test
	public void shouldInitComponents(){
		assertNotNull(mwsSearchService);
	}
	
	@Test
	public void shouldSearchByASIN(){
		
		final List<Product> products = mwsSearchService.findById(AWProductIDType.ASIN, "B00RBSGHLA");
		for(final Product product : products){
			assertEquals("B00RBSGHLA", product.getIdentifiers().getMarketplaceASIN().getASIN());
		}
		
		
	}
	
	@Test
	public void shouldSearchByUPC(){
		
		final List<Product> products = mwsSearchService.findById(AWProductIDType.UPC, "784672378925");
		for(final Product product : products){
			assertEquals("B00RBSGHLA", product.getIdentifiers().getMarketplaceASIN().getASIN());
		}
	}
	
	
	@Test
	public void shouldSearchByName(){
		
		final List<Product> products = mwsSearchService.search("apple ipad");
		assertEquals("B00746W9F2", products.get(0).getIdentifiers().getMarketplaceASIN().getASIN());
	}
	
}
