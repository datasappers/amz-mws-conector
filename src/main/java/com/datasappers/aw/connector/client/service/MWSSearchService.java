package com.datasappers.aw.connector.client.service;

import java.util.List;

import com.amazonservices.mws.products.model.Product;
import com.nykart.common.enums.AWProductIDType;

public interface MWSSearchService {
	
	public List<Product> findById(AWProductIDType awProductIDType, String... id);
	
	public List<Product> search(String toke);
	
}
