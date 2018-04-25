package com.skb.learn.springboot.jpa.service;

import java.util.Set;

import com.skb.learn.springboot.jpa.entity.Author;

public interface AuthorService {
	
	public Set<Author> getAuthors();
}
