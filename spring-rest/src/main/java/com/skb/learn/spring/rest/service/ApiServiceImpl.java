package com.skb.learn.spring.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.skb.learn.spring.rest.model.User;
import com.skb.learn.spring.rest.model.UserData;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApiServiceImpl implements ApiService {

	private RestTemplate restTemplate;
	
	private final String apiUrl;
	
	public ApiServiceImpl(RestTemplate restTemplate, @Value("${apiFaketory.Url}") String apiUrl) {
		super();
		this.restTemplate = restTemplate;
		this.apiUrl = apiUrl;
	}

	@Override
	public List<User> getUsers(Integer limit) {

		log.info("Api URL: ", apiUrl);
		UriComponentsBuilder uriBuilder = UriComponentsBuilder
				.fromUriString(apiUrl)
				// Very handy way to build the URI when there are multiple query params
				.queryParam("limit", limit);
		log.info("Formed URI");
		UserData userData = restTemplate.getForObject(uriBuilder.toUriString(), UserData.class); 
		log.info("Got Response... returning");		
		return userData.getData();
	}

}
