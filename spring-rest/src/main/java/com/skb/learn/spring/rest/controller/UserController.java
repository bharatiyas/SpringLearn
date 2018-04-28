package com.skb.learn.spring.rest.controller;

import java.util.List;

import com.skb.learn.spring.rest.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skb.learn.spring.rest.service.ApiService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {

	private ApiService apiService;

	public UserController(ApiService apiService) {
		super();
		this.apiService = apiService;
	}
	
	@GetMapping({"","/","/index"})
	public String getIndex() {
		return "index";
	}
	
	//@RequestMapping("/users")
	public String getUsers(Model model) {
		
		log.info("Fetching users from apiService");
		List<User> users = apiService.getUsers(5);
		log.info("Number of users returned: " + users.size());
		model.addAttribute("users", users);
		
		return "usersPage";
	}
	
	
}
