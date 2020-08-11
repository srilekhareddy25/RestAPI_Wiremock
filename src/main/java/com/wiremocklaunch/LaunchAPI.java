package com.wiremocklaunch;

import org.springframework.boot.SpringApplication;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

public class LaunchAPI {

	
	public static void main(String[] args) {
		SpringApplication.run(LaunchAPI.class, args);
	}

	
	public WireMockServer initWireMockServerInstance() {
		WireMockServer wireMockServer = new WireMockServer(WireMockConfiguration.options().port(5647));
		wireMockServer.start();
		return wireMockServer;
		
	}
}
