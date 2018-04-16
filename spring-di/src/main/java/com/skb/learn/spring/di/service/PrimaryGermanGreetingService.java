package com.skb.learn.spring.di.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("de")
// Having two Primary beans will not result in conflict here because this one has been also marked with Profile=es
// Therefore when Spring sees that this profile is not active then it will ignore this one.
@Primary
public class PrimaryGermanGreetingService implements GreetingService {

	public static final String HELLO_FROM_PRIMARY = "Hello from PrimaryGermanGreetingService!!";

	@Override
	public String greet() {
		// TODO Auto-generated method stub
		return HELLO_FROM_PRIMARY;
	}
	
}
