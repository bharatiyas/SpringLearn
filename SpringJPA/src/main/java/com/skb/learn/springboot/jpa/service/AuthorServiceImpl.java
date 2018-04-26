package com.skb.learn.springboot.jpa.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.skb.learn.springboot.jpa.entity.Author;
import com.skb.learn.springboot.jpa.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

	private AuthorRepository authorRepository;
	
	public AuthorServiceImpl(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}


	@Override
	public Set<Author> getAuthors() {
		Set<Author> authors = new HashSet<>();
		authorRepository.findAll().iterator().forEachRemaining(arg0 -> authors.add(arg0));
		return authors;
	}

}
