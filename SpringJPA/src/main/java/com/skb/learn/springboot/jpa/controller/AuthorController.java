package com.skb.learn.springboot.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skb.learn.springboot.jpa.repository.AuthorRepository;

@Controller // This will register this class as a bean in Spring context.  
public class AuthorController {

	// Spring will automatically Autowire it, i.e. inject the instance of BookRepository through the constructor below
	private AuthorRepository authorRepository;
	
	
	public AuthorController(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}


	// Here we pass the Model interface but at run time Spring will pass the implementation class of the model
	// This will get invoked whenever a request comes for /books in our Web App
	@RequestMapping("/authors")
	public String getBooks(Model model) {
		
		// We add an Attribute (to the passed model) which has a Key = books, so that this can be accessed in the View layer
		// Attribute = key,Value pair
		model.addAttribute("authors", authorRepository.findAll());
		
		// This will associate the model with a view (defined using Thymeleaf) called "books" 
		// Basically this is the view name to be used in View layer
		// This is the name of the HTML file inside template folder
		return "authors";
		
	}
}
