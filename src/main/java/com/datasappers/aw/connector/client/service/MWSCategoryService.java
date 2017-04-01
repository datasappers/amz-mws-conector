package com.datasappers.aw.connector.client.service;

import java.util.List;

import com.amazonservices.mws.products.model.Categories;

public interface MWSCategoryService {
	
	
	List<Categories> getCategoriesForASIN(final String asin);

}
