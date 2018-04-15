package com.skb.learn.springboot.jpa.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn; 

@Entity
public class Book {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	private String title;
	private String isbn;
	
	@OneToOne
	private Publisher publisher = new Publisher();
	
	@ManyToMany
	// This will create only 1 mapping table named: AUTHOR_BOOK having 2 columns = BOOK_ID, AUTHOR_ID
	@JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> authors = new HashSet<>();
	
	public Book() {
		
	}
	
	public Book(String title, String isbn, Publisher publisher, Set<Author> authors) {
		super();
		this.title = title;
		this.publisher = publisher;
		this.isbn = isbn;
		this.authors = authors;
	}

	public Book(String title, String isbn, Publisher publisher) {
		super();
		this.title = title;
		this.publisher = publisher;
		this.isbn = isbn;
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [Id=" + Id + ", title=" + title + ", publisher=" + publisher + ", isbn=" + isbn + ", authors="
				+ authors + "]";
	}
	
	
}
