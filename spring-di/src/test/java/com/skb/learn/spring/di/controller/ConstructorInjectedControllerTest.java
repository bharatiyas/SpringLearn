package com.skb.learn.spring.di.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.skb.learn.spring.di.service.GreetingServiceImpl;

public class ConstructorInjectedControllerTest {

	private ConstructorInjectedController constructorInjectedController;
	
	@Before
	public void setUp() throws Exception {
		// Constructor based injection. GreetingServiceImpl is being injected into ConstructorInjectedController using
		// its constructor
		this.constructorInjectedController = new ConstructorInjectedController(new GreetingServiceImpl());
	}
	
	@Test
	public void testGreeting() throws Exception {
		assertEquals(GreetingServiceImpl.HELLO_ALL, constructorInjectedController.sayHello());
	}
}
