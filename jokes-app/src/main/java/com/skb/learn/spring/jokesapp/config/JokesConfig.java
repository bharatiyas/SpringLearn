package com.skb.learn.spring.jokesapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;

// Use @Configuration to define beans for classed defined in external libraries
//@Configuration
public class JokesConfig {

	@Bean
	public ChuckNorrisQuotes getChuckNorrisQuotes() {
		return new ChuckNorrisQuotes();
	}
}
