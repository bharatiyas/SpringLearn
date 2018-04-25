package com.skb.learn.springboot.jpa.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AuthorTest {

	private Author author;
	
	@Before
	public void setUp() throws Exception {
		author = new Author("Sanjay", "Bharatiya");
		author.setId(45L);
	}

	@Test
	public void testGetFirstName() {
		String expectedFirstName = "Sanjay";
		assertEquals(expectedFirstName, author.getFirstName());
	}

	@Test
	public void testGetLastName() {
		String expectedLastName = "Bharatiya";
		assertEquals(expectedLastName, author.getLastName());
	}

	@Test
	public void testGetId() {
		Long expectedId = 45L;
		assertEquals(expectedId, author.getId());
	}

}
