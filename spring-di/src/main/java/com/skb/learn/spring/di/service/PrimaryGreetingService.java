package com.skb.learn.spring.di.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
// We define an array with two profiles en and default. “default” profile is active when other profiles are not active.
@Profile({"en", "default"})
public class PrimaryGreetingService implements GreetingService {

	public static final String HELLO_FROM_PRIMARY = "Hello from PrimaryGreetingService!!";

	@Override
	public String greet() {
		// TODO Auto-generated method stub
		return HELLO_FROM_PRIMARY;
	}
}
