package com.skb.learn.springboot.jpa.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.skb.learn.springboot.jpa.entity.Book;
import com.skb.learn.springboot.jpa.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	private BookRepository bookRepository;
	
	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public Set<Book> getBooks() {
		Set<Book> books = new HashSet<>();
		bookRepository.findAll().iterator().forEachRemaining(arg0 -> books.add(arg0));
		return books;
	}

}
