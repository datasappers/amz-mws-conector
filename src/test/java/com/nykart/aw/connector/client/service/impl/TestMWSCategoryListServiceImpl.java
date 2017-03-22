package com.nykart.aw.connector.client.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amazonservices.mws.products.model.Categories;
import com.nykart.aw.connector.client.service.MWSCategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:aw-mws-connector-context.xml" })
public class TestMWSCategoryListServiceImpl {
	
	@Autowired
	private MWSCategoryService mwsCategoryListService;
	
	@Test
	public void shouldGetCategoiesByASIN(){
		
		final List<Categories> categoriesForASIN = mwsCategoryListService.getCategoriesForASIN("B00IGJP9N0");
		for(final Categories c : categoriesForASIN){
			
			assertEquals("490624011", c.getProductCategoryId());
			assertEquals("Monitor Arms & Stands", c.getProductCategoryName());
			
			assertEquals("490597011", c.getParent().getProductCategoryId());
			assertEquals("Platforms, Stands & Shelves", c.getParent().getProductCategoryName());
		}
		
	}

}
