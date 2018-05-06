package com.japca.feignclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Jakub Krhovják on 5/6/18.
 */
@Configuration
public class HttpConfiguration {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}