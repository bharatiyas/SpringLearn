package com.skb.learn.spring.rest.service;

import java.util.List;

import com.skb.learn.spring.rest.model.User;

public interface ApiService {

	List<User> getUsers(Integer limit);
	
	//Flux<User> getUser(Mono<User> limit);
}
