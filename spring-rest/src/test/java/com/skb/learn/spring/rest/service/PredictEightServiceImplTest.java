package com.skb.learn.spring.rest.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PredictEightServiceImplTest {

	@Autowired
	private PredictEightService predictEightServiceImpl;

	
	@Before
	public void setUp() throws Exception {
		
	}

	//@Test
	public void testCreateCustomer() {
		
		predictEightServiceImpl.createCustomer();
	}

	//@Test
	public void testUpdateCustomer() {
		
		predictEightServiceImpl.updateCustomer();
	}
	
	@Test(expected = HttpClientErrorException.class)
	public void testDeleteCustomer() {
		
		predictEightServiceImpl.deleteCustomer();
	}
}
