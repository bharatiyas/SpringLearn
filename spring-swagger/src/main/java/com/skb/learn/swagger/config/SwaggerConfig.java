package com.skb.learn.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

// Instead of using XML configuration we are going to use Java configuration.
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	// We create a Swagger Docket
	// Customizing configuration: In order to have some custom configuration we have to override the meta information by using apiInfo()
	//
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.skb.learn.swagger.controller"))
				.paths(regex("/swaggerapp.*"))
				.build()
				.apiInfo(metaInformation());
	}

	private ApiInfo metaInformation() {
		
		@SuppressWarnings("deprecation")
		ApiInfo apiInfo = new ApiInfo("API Title", "API Desc", "v1", "Terms of Service", new Contact("Sanjay", "http://amazeit.tech", "sanjayfromgomia@gmail.com"), "License Version 1.0", "https://www.apache.org/license.html");
		
		return apiInfo;
	}
}
