package com.skb.learn.spring.di.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.skb.learn.spring.di.datasource.FakeDataSource;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {

	@Value("${database.url}")
	String url;
	
	@Value("${database.username}")
	String username;
	
	@Value("${database.password}")
	String password;
	
	
	@Bean
	public FakeDataSource getFakeDataSource() {
		FakeDataSource fakeDataSource = new FakeDataSource();
		fakeDataSource.setUrl(url);
		fakeDataSource.setUsername(username);
		fakeDataSource.setPassword(password);
		
		return fakeDataSource;
	}
	
	// PropertySourcesPlaceholderConfigurer will read the properties file
	@Bean
	public static PropertySourcesPlaceholderConfigurer  prooerties() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		return propertySourcesPlaceholderConfigurer;
	}
}
