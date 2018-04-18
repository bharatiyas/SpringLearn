package com.skb.learn.spring.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by jt on 5/24/17.
 */
//@Service
//@Primary
//@Profile("de")
public class PrimaryGermanGreetingService implements GreetingService {

	private GreetingRepository greetingRepository;

	public PrimaryGermanGreetingService(GreetingRepository greetingRepository) {
		super();
		this.greetingRepository = greetingRepository;
	}

	@Override
    public String greet() {
        return greetingRepository.getGermanGreeting();
    }
}
