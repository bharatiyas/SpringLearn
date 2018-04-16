package com.skb.learn.spring.di.service;

import org.springframework.stereotype.Service;

@Service // Similar to Component
public class GreetingServiceImpl implements GreetingService {

	public static final String HELLO_ALL = "Hello All!!";

	@Override
	public String greet() {
		// TODO Auto-generated method stub
		return HELLO_ALL;
	}
	
	
}
