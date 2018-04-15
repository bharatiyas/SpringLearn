package com.skb.learn.springboot.jpa.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.skb.learn.springboot.jpa.entity.Author;
import com.skb.learn.springboot.jpa.entity.Book;
import com.skb.learn.springboot.jpa.entity.Publisher;
import com.skb.learn.springboot.jpa.repository.AuthorRepository;
import com.skb.learn.springboot.jpa.repository.BookRepository;
import com.skb.learn.springboot.jpa.repository.PublisherRepository;

@Component // Makes it a Spring Bean and get added to Spring Context
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	// SpringBoot will Autowire these objects
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	// AuthorRepository and BookRepository will get Autowired here.
	public DevBootstrap(AuthorRepository authorRepository, PublisherRepository publisherRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.publisherRepository = publisherRepository;
		this.bookRepository = bookRepository;
	}

	private void initData() {
		
		// Sanjay
		Author sanjay = new Author("Sanjay", "Bharatiya");
		Publisher prenticeHall = new Publisher("Prentice Hall", "25 Paisley Blvd West");
		Book soaConcepts = new Book("SOA Concepts", "isbn: 1234", prenticeHall);
		sanjay.getBooks().add(soaConcepts);
		soaConcepts.getAuthors().add(sanjay);
		
		authorRepository.save(sanjay);
		publisherRepository.save(prenticeHall);
		bookRepository.save(soaConcepts);
		
		// Idhant
		Author idhant = new Author("Idhant", "Bharatiya");
		Publisher magicBooks = new Publisher("Magic Books", "1 North Road");
		Book wheelsOnBus = new Book("Wheels On The Bussss", "isbn: 2345", magicBooks);
		idhant.getBooks().add(wheelsOnBus);
		wheelsOnBus.getAuthors().add(idhant);
		
		authorRepository.save(idhant);
		publisherRepository.save(magicBooks);
		bookRepository.save(wheelsOnBus);
		
		// Bandana
		Author bandana = new Author("Bandana", "Bharatiya");
		Publisher kathaSagar = new Publisher("Katha Sagar", "231 Nayi Kotwaali");
		Book hindiSahitya = new Book("Hindi Sahitya", "isbn: 3456", kathaSagar);
		bandana.getBooks().add(hindiSahitya);
		hindiSahitya.getAuthors().add(bandana);
		
		authorRepository.save(bandana);
		publisherRepository.save(kathaSagar);
		bookRepository.save(hindiSahitya);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();
		
	}
}
