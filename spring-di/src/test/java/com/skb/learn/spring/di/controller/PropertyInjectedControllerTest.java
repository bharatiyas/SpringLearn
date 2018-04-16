package com.skb.learn.spring.di.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.skb.learn.spring.di.service.GreetingServiceImpl;

public class PropertyInjectedControllerTest {

	private PropertyInjectedController propertyInjectedController;
	
	@Before
	public void setUp() throws Exception {
		this.propertyInjectedController = new PropertyInjectedController();
		this.propertyInjectedController.greetingService = new GreetingServiceImpl();
	}
	
	@Test
	public void testGreeting() throws Exception {
		assertEquals(GreetingServiceImpl.HELLO_ALL, propertyInjectedController.sayHello());
	}

}
