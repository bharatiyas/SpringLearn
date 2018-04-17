package com.skb.learn.spring.jokesapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skb.learn.spring.jokesapp.service.JokesService;

@Controller
public class JokesController {

	private JokesService jokesService;
	
	public JokesController(JokesService jokesService) {
		super();
		this.jokesService = jokesService;
	}

	@RequestMapping("/jokes")
	public String getJokes(Model model) {
		model.addAttribute("todayJoke", jokesService.getJoke());
		return "jokes";
	}
}
