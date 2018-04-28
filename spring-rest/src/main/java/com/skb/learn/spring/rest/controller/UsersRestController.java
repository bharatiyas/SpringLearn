package com.skb.learn.spring.rest.controller;

import java.util.List;

import com.skb.learn.spring.rest.model.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skb.learn.spring.rest.service.ApiService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

public class UsersRestController {

	private ApiService apiService;
	
	public UsersRestController(ApiService apiService) {
		super();
		this.apiService = apiService;
	}

	@GetMapping("/users/rest")
	public <T> ResponseEntity<T> getUsers(@RequestParam ("limit") Integer limit) {
		log.info("Got request for user limit = " , limit.intValue());
		List<User> users = apiService.getUsers(limit);
		ResponseEntity<List<User>> response = new ResponseEntity<>(users, HttpStatus.OK);
		
		log.info("User 1 = " + users.get(0).toString());
		log.debug("User1.email = " + users.get(1).getEmail());
		return (ResponseEntity<T>) response;
	}
}
