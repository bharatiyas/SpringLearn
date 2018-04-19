package com.skb.learn.spring.di.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import com.skb.learn.spring.di.property.CustomPropsInApplicationProperties;
import com.skb.learn.spring.di.property.CustomPropsInApplicationYaml;
import com.skb.learn.spring.di.property.FakeDataSource;
import com.skb.learn.spring.di.property.FakeJmsBroker;

@Configuration
// Do not let 
//@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
// @PropertySources was introduced in Spring 4
@PropertySources({
		@PropertySource("classpath:datasource.properties"),
		@PropertySource("classpath:jms.properties")
})

public class PropertyConfig {

	@Autowired
	Environment env;
	
	@Value("${database.url}")
	String dbUrl;
	
	@Value("${database.username}")
	String dbUsername;
	
	@Value("${database.password}")
	String dbPassword;
	
	@Value("${jms.url}")
	String jmsUrl;
	
	@Value("${jms.username}")
	String jmsUsername;
	
	@Value("${jms.password}")
	String jmsPassword;
	
	@Value("${custom.properties.firstName}")
	String firstName;
	
	@Value("${custom.properties.lastName}")
	String lastName;
	
	@Value("${custom.properties.yaml.firstName}")
	String firstNameYaml;
	
	@Value("${custom.properties.yaml.lastName}")
	String lastNameYaml;
	
	@Bean
	public FakeDataSource getFakeDataSource() {
		FakeDataSource fakeDataSource = new FakeDataSource();
		fakeDataSource.setUrl(dbUrl);
		fakeDataSource.setUsername(dbUsername);
		// If you execute it from Eclipse it will not work. This will return null. This will run either it:
		// Restart Eclipse so that Eclipse can get the latest Environment properties
		// If you run it from command prompt it works well
		String envPassword = env.getProperty("DB_PASSWORD");
		System.out.println("envPassword = " + envPassword);
		if(!StringUtils.isEmpty(envPassword))
			fakeDataSource.setPassword(env.getProperty("DB_PASSWORD"));
		else
			fakeDataSource.setPassword(dbPassword);
		
		return fakeDataSource;
	}
	
	@Bean
	public FakeJmsBroker getFakeJmsBroker() {
		FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
		fakeJmsBroker.setUrl(jmsUrl);
		fakeJmsBroker.setUsername(jmsUsername);
		fakeJmsBroker.setPassword(jmsPassword);
		
		return fakeJmsBroker;
	}
	
	@Bean
	public CustomPropsInApplicationProperties getCustomPropsInApplicationProperties() {
		CustomPropsInApplicationProperties customProps = new CustomPropsInApplicationProperties();
		customProps.setFirstName(firstName);
		customProps.setLastName(lastName);
				
		return customProps;
	}
	
	@Bean
	public CustomPropsInApplicationYaml getCustomPropsInApplicationYaml() {
		CustomPropsInApplicationYaml customPropsYaml = new CustomPropsInApplicationYaml();
		customPropsYaml.setFirstName(firstNameYaml);
		customPropsYaml.setLastName(lastNameYaml);
				
		return customPropsYaml;
	}
	
	// PropertySourcesPlaceholderConfigurer will read the properties file
	@Bean
	public static PropertySourcesPlaceholderConfigurer  prooerties() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		return propertySourcesPlaceholderConfigurer;
	}
}
