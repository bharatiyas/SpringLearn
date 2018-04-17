package com.skb.learn.spring.di.service;

import org.springframework.stereotype.Service;

@Service
public class SetterGreetingService implements GreetingService {

	public static final String HELLO_FROM_SETTER = "Hello from SetterGreetingService!!";

	@Override
	public String greet() {
		// TODO Auto-generated method stub
		return HELLO_FROM_SETTER;
	}
}