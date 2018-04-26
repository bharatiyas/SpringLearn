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

import com.skb.learn.springboot.jpa.entity.Author;
import com.skb.learn.springboot.jpa.entity.Book;
import com.skb.learn.springboot.jpa.entity.Publisher;
import com.skb.learn.springboot.jpa.repository.BookRepository;
import com.skb.learn.springboot.jpa.repository.BookRepository;

public class BookServiceImplTest {

	private BookServiceImpl bookServiceImpl;
	
	// Mock the dependency of BookServiceImpl
	@Mock
	private BookRepository bookRepository;
	
	@Mock
	private Book book;
	
	@Mock
	private Publisher publisher;
	
	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		bookServiceImpl = new BookServiceImpl(bookRepository);
		
		when(publisher.getName()).thenReturn("Prentice Hall");
		when(book.getPublisher()).thenReturn(publisher);
		when(book.getTitle()).thenReturn("SOA Design Patterns");
		
		
		Set<Book> bookData = new HashSet<>();
		bookData.add(book);
		when(bookRepository.findAll()).thenReturn(bookData);
	}

	@Test
	public void testGetAuthors() {
		
		Set<Book> books = bookServiceImpl.getBooks(); 
		Book returnedBook = books.iterator().next();
		
		assertEquals(1, books.size());
		assertEquals("SOA Design Patterns", returnedBook.getTitle());
		assertEquals("Prentice Hall", returnedBook.getPublisher().getName());
		verify(bookRepository, times(1)).findAll();
		
		
	}

}
