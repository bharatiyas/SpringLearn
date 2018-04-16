package com.skb.learn.spring.di.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.skb.learn.spring.di.service.GreetingService;

@Component
public class ConstructorInjectedController {

	
	private GreetingService greetingService;

	public String sayHello() {
		return greetingService.greet();
	}

	// Incase of Constructor based DI we did not had to do Autowiring because In Spring 4.2 they automated Autowiring of 
	// Constructor based components. If Spring sees a Constructor with some parameters then it tries to satisfy that
	// dependency. BUT for better READABILITY you could also use the @Autowired here
	// @Autowired
	//Qualifier takes the name of the bean
	public ConstructorInjectedController(@Qualifier("constructorGreetingService") GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
}
