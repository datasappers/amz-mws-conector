package com.amazonservices.mws.products.custom;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nykart.aw.connector.configs.MWSAsyncProductsClientFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:aw-mws-connector-context.xml" })
public class TestMWSAsyncProductsClientFactory {
	
	@Autowired
	private MWSAsyncProductsClientFactory mwsAsyncProductsClientFactory;
	
	@Test
	public void shouldInitBeans(){
		assertNotNull(mwsAsyncProductsClientFactory);
	}

}
