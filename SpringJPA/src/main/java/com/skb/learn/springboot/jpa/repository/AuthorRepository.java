package com.skb.learn.springboot.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.skb.learn.springboot.jpa.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
