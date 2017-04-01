package com.datasappers.aw.connector.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonservices.mws.products.MWSProductsAsyncClient;
import com.amazonservices.mws.products.MWSProductsClient;

@Component("mwsAsyncProductsClientFactory")
public class MWSAsyncProductsClientFactory {

	@Autowired
	private ProductConfiguration productConfiguration;

	private MWSProductsAsyncClient asyncClient = null;

	private MWSProductsClient client = null;

	public synchronized MWSProductsAsyncClient getAsyncClient(){

		if(null == this.asyncClient){
			this.asyncClient = new MWSProductsAsyncClient(this.productConfiguration);
		}
		return this.asyncClient;
	}

	public synchronized MWSProductsClient getClient(){

		if(null == this.client){
			this.client = new MWSProductsClient(this.productConfiguration);
		}
		return this.client;
	}

}
