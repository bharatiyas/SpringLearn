package com.skb.learn.spring.di.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import com.skb.learn.spring.di.datasource.FakeDataSource;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {

	@Autowired
	Environment env;
	
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
		// If you execute it from Eclipse it will not work. This will return null. But if you run it from command prompt it works well
		String envPassword = env.getProperty("DB_PASSWORD");
		System.out.println("envPassword = " + envPassword);
		if(!StringUtils.isEmpty(envPassword))
			fakeDataSource.setPassword(env.getProperty("DB_PASSWORD"));
		else
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
