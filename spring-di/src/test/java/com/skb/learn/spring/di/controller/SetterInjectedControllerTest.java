package com.skb.learn.spring.di.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.skb.learn.spring.di.service.GreetingServiceImpl;

public class SetterInjectedControllerTest {

	private SetterInjectedController setterInjectedController;
	
	@Before
	public void setUp() throws Exception {
		this.setterInjectedController = new SetterInjectedController();
		// Setter based injection. GreetingServiceImpl is being injected into SetterInjectedController using
		// the setter method.
		// If comment out the following line then required dependency (or property on which the SetterInjectedController depends 
		// on) will not be injected. Thus running this Unit test will fail with NPE. 
		// This is a problem associated with Property based DI
		// But this is not possible in Constructor based DI because as soon you Instantiate the ConstructorInjectedController
		// class you also need to inject its dependency i.e. GreetingService
		this.setterInjectedController.setGreetingService(new GreetingServiceImpl())	;
	}
	
	@Test
	public void testGreeting() throws Exception {
		assertEquals(GreetingServiceImpl.HELLO_ALL, setterInjectedController.sayHello());
	}
}
