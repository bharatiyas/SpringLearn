package com.skb.learn.spring.di.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.skb.learn.spring.di.service.GreetingService;

@Component
public class SetterInjectedController {
	
	private GreetingService greetingService;
	
	public String sayHello() {
		return greetingService.greet();
	}

	// Autowiring the setter method incase of the bean supports Setter based DI
	@Autowired
	public void setGreetingService(@Qualifier("setterGreetingService") GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	
}
