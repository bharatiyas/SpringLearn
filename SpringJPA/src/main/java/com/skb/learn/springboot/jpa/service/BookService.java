package com.skb.learn.springboot.jpa.service;

import java.util.Set;

import com.skb.learn.springboot.jpa.entity.Book;

public interface BookService {

	public Set<Book> getBooks();
}
