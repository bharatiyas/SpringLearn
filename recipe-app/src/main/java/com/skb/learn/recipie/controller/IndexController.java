package com.skb.learn.recipie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping({"", "/", "/index"})
	public String serveIndex(Model model) {
		
		
		return "index";
	}
}