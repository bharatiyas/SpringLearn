package com.skb.learn.spring.di.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skb.learn.spring.di.service.GreetingServiceImpl;

// This is just to demonstrate that this is not the way it should be done
@Component
public class PropertyInjectedController {

	@Autowired
	public GreetingServiceImpl greetingService;
	
	public String sayHello() {
		return greetingService.greet();
	}
	
	/*public GreetingServiceImpl getGreetingService() {
		return greetingService;
	}*/
}
