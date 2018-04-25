package com.skb.learn.springboot.jpa.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.skb.learn.springboot.jpa.entity.Book;
import com.skb.learn.springboot.jpa.entity.Publisher;
import com.skb.learn.springboot.jpa.repository.BookRepository;

public class BookServiceImplTest {

	private BookServiceImpl bookServiceImpl;
	
	@Mock
	private BookRepository bookRepository;
	
	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		bookServiceImpl = new BookServiceImpl(bookRepo);

		
	}

	@Test
	public void testGetBooks() {
		String expectedTitle = "SOA Design Patterns";
		String expectedPublisherAddress = "Some Address";
		
		Publisher publisher = new Publisher("Prentice Hall", "Some Address");
		Book book = new Book("Title", "ISBN-1234", publisher);
		Set<Book> bookData = new HashSet<>();
		bookData.add(book);
		
		when(bookServiceImpl.getBooks()).thenReturn(bookData);
		
		assertEquals(1, bookServiceImpl.getBooks().size());
		assertEquals(expectedTitle, bookServiceImpl.getBooks().iterator().next().getTitle());
		assertEquals(expectedPublisherAddress, bookServiceImpl.getBooks().iterator().next().getPublisher().getAddress());
		
		verify(bookRepo, times(3)).findAll();
	}

}
