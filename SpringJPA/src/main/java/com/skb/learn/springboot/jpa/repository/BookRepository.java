package com.skb.learn.springboot.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.skb.learn.springboot.jpa.entity.Book;

public interface BookRepository extends CrudRepository <Book, Long>{

}
