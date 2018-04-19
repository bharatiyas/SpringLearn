package com.skb.learn.spring.di.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
//@Profile("hi")
public class ConstructorGreetingService implements GreetingService {

	public static final String HELLO_FROM_CONSTRUCTOR = "Hello from ConstructorGreetingService!!";

	@Override
	public String greet() {
		// TODO Auto-generated method stub
		return HELLO_FROM_CONSTRUCTOR;
	}
}
