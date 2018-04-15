package com.skb.learn.springboot.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.skb.learn.springboot.jpa.entity.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
