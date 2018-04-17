package com.skb.learn.spring.jokesapp.service;

import org.springframework.stereotype.Service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;

@Service
public class ChuckNorrisJokes implements JokesService {

	// Marked as final so that a new instance is not created for every request because we do not need one as nothing is 
	// changing about ChuckNorrisQuotes class. Therefore, this class will be created once and Spring will be reusing that 
	// object.
	private final ChuckNorrisQuotes chuckNorrisQuotes;
	
	public ChuckNorrisJokes() {
		super();
		this.chuckNorrisQuotes = new ChuckNorrisQuotes();
	}

	@Override
	public String getJoke() {
		return this.chuckNorrisQuotes.getRandomQuote();
	}

}
