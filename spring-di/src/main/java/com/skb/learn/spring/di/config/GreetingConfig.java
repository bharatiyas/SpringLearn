package com.skb.learn.spring.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.skb.learn.spring.di.service.GreetingRepository;
import com.skb.learn.spring.di.service.GreetingService;
import com.skb.learn.spring.di.service.GreetingServiceFactory;

@Configuration
public class GreetingConfig {

	@Bean
	public GreetingServiceFactory getGreetingServiceFactory(GreetingRepository greetingRepository) {
		return new GreetingServiceFactory(greetingRepository);
	}
	
	@Primary
	@Profile({"en", "default"})
	@Bean
	public GreetingService getPrimaryGreetingService(GreetingServiceFactory greetingServiceFactory) {
		return greetingServiceFactory.createGreetingService("en");
	}
	
	@Primary
	@Profile({"es"})
	@Bean
	public GreetingService getPrimarySpanishGreetingService(GreetingServiceFactory greetingServiceFactory) {
		return greetingServiceFactory.createGreetingService("es");
	}
	
	@Primary
	@Profile({"de"})
	@Bean
	public GreetingService getPrimaryGermanGreetingService(GreetingServiceFactory greetingServiceFactory) {
		return greetingServiceFactory.createGreetingService("de");
	}
}
