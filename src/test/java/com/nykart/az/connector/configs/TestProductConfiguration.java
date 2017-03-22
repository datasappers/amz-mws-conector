package com.nykart.az.connector.configs;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nykart.aw.connector.configs.ProductConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:aw-mws-connector-context.xml" })
public class TestProductConfiguration {
	
	@Autowired
	private ProductConfiguration productConfiguration;
	
	@Test
	public void shouldInitComponents(){
		assertNotNull(productConfiguration);
	}

}
