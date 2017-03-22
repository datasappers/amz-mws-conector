package com.nykart.az.connector.configs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nykart.aw.connector.configs.Configuration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:aw-mws-connector-context.xml" })
public class TestConfiguration {
	
	@Autowired
	private Configuration configuration;
	
	@Test
	public void servicePropertiesShouldBeInitialized(){
		assertEquals("https://mws.amazonservices.com", configuration.getServiceURL());
		assertEquals("AKIAJJI2T75KRFCQTMLA", configuration.getAccessKey());
		assertEquals("RtG9toHOjIDwqziZOZnSLzXZPUnBynb+OV/4JyN8", configuration.getSecretKey());
		assertEquals("NYKart", configuration.getAppName());
		assertEquals(".01", configuration.getAppVersion());
	}
}




