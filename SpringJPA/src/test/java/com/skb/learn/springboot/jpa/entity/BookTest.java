package com.skb.learn.springboot.jpa.entity;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BookTest {

	private Book book;
	
	@Mock
	private Publisher publisher;
	
	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
		when(publisher.getAddress()).thenReturn("Some Address");
		when(publisher.getName()).thenReturn("Prentice Hall");
		when(publisher.getId()).thenReturn(1234L);
		book = new Book("SOA Design Patterns", "ISBN-3444", publisher);
		book.setId(5344L);
	}

	@Test
	public void testGetId() {
		Long expectedBookId = 5344L;
		assertEquals(expectedBookId, book.getId());
	}

	@Test
	public void testGetTitle() {
		String expectedTitle = "SOA Design Patterns";
		assertEquals(expectedTitle, book.getTitle());
	}

	@Test
	public void testGetPublisher() {
		String expectedName = "Prentice Hall";
		String expectedAddress = "Some Address";
		assertEquals(expectedName, book.getPublisher().getName());
		assertEquals(expectedAddress, book.getPublisher().getAddress());
		verify(publisher, times(1)).getAddress();
		verify(publisher, times(1)).getName();
	}

	@Test
	public void testGetIsbn() {
		String expectedIsbn = "ISBN-3444";
		assertEquals(expectedIsbn, book.getIsbn());
	}

}
