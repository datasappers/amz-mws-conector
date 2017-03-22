package com.nykart.aw.connector.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Configuration {
	
	private @Value("${serviceURL}") String serviceURL;
	
    private @Value("${accessKey}") String accessKey;

    private @Value("${secretKey}") String secretKey;

    private @Value("${appName}") String appName;

    private @Value("${appVersion}") String appVersion;
    
    private @Value("${sellerId}") String sellerId;
    
    private @Value("${mwsAuthToken}") String mwsAuthToken;
    
    private  @Value("${marketplaceId}") String marketplaceId;
    
    
    
	public String getSellerId() {
		return sellerId;
	}

	public String getMwsAuthToken() {
		return mwsAuthToken;
	}

	public String getMarketplaceId() {
		return marketplaceId;
	}

	public String getServiceURL() {
		return serviceURL;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public String getAppName() {
		return appName;
	}

	public String getAppVersion() {
		return appVersion;
	}

}
