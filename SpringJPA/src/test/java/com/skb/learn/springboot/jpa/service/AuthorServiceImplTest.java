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
import com.skb.learn.springboot.jpa.repository.AuthorRepository;

public class AuthorServiceImplTest {

	AuthorServiceImpl authorServiceImpl;
	
	// Mock the dependency of AuthorServiceImpl
	@Mock
	AuthorRepository authorRepository;
	
	//@Mock
	//Author author;
	
	@Before
	public void setUp() throws Exception {
		
		// MockitoAnnotations: Initializes objects annotated with Mockito annotations for given testClass
		// MockitoAnnotations.initMocks(this); initializes fields annotated with Mockito annotations in this test class. 
		// It allows shorthand creation of all the objects required for testing.
		MockitoAnnotations.initMocks(this);
		
		
		authorServiceImpl = new AuthorServiceImpl(authorRepository);
	}

	@Test
	public void testGetAuthors() {
		
		Author author = new Author("Sanjay", "Bharatiya");
		Set<Author> authorData = new HashSet<>();
		authorData.add(author);
		
		// You need to use when on the authorServiceImpl.getAuthors because you are testing this function
		when(authorServiceImpl.getAuthors()).thenReturn(authorData);
		
		Set<Author> authors = authorServiceImpl.getAuthors(); 
		assertEquals(1, authors.size());
	
		// Verifies certain behavior happened at least once / exact number of times / never
		// It is a way verify the interactions within the classes are happening as expected
		// It is very important to check the interactions
		verify(authorRepository, times(1)).findAll();
		
		
	}
	
	

}
