package com.skb.learn.spring.di.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.skb.learn.spring.di.service.GreetingService;

@Component
public class MyController {

	public GreetingService greetingService;

	// Even if we have not provided a Qualifier it works fine. It injects and instance of PrimaryGreetingService because it
	// has been marked as Primary bean
	public MyController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	
	public String sayHello() {
		System.out.println("MyController - " + greetingService.greet());
		return "foo";
	}
}
