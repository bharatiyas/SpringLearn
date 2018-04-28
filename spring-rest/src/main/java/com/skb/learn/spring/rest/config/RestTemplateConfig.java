package com.skb.learn.spring.rest.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	@Bean
	public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
		
		// This builder will take into lot of different options (like authentication details) to build a template. 
		// We can populate them here.
		return builder.build();
	}
}
