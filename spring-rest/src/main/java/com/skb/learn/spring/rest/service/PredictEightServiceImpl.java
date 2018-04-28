package com.skb.learn.spring.rest.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PredictEightServiceImpl implements PredictEightService {

	private RestTemplate restTemplate;
	
	private final String predict8Url;
	
	public PredictEightServiceImpl(RestTemplate restTemplate, @Value("${predict8.url}") String predict8Url) {
		super();
		this.restTemplate = restTemplate;
		this.predict8Url = predict8Url;
	}


	/* (non-Javadoc)
	 * @see com.skb.learn.spring.rest.service.PredictEightService#createCustomer()
	 */
	@Override
	public void createCustomer() {
	
		String createCustomerUrl = predict8Url.concat("/customers/");
		
		// Map is a convinient way of producing simple JSON object
		Map<String, String> customerData = new HashMap<>();
		customerData.put("firstname", "Peter");
		customerData.put("lastname", "Rabbit");
		
		// JsonNode is a convenient way to represent way to bind the JSON response coming back from the service
		JsonNode jsonNode = restTemplate.postForObject(createCustomerUrl, customerData, JsonNode.class);
		
		log.info("Response: " + jsonNode.toString());
		
	}
	
	/* (non-Javadoc)
	 * @see com.skb.learn.spring.rest.service.PredictEightService#updateCustomer()
	 */
	@Override
	public void updateCustomer() {
		
		String customerUrl = predict8Url.concat("/customers/");
		
		// Map is a convinient way of producing simple JSON object
		Map<String, String> customerData = new HashMap<>();
		customerData.put("firstname", "Cotton");
		customerData.put("lastname", "Tail");
		
		// JsonNode is a convenient way to represent way to bind the JSON response coming back from the service
		JsonNode createResponse = restTemplate.postForObject(customerUrl, customerData, JsonNode.class);
		
		log.info("Response: " + createResponse.toString());
		
		String customer = createResponse.get("customer_url").textValue();
		
		String customerId = customer.toString().split("/")[3];
		String updateUrl = customerUrl + customerId;
		log.info("Custoner Id: " + customerId);
		customerData.put("firstname", "Moxy");
		customerData.put("lastname", "Rabbit");
		
		restTemplate.put(updateUrl, customerData);
		
		JsonNode updateResponse = restTemplate.getForObject(updateUrl, JsonNode.class);
		
		log.info("Updated Customer: " + updateResponse.toString());
		
	}
	
	
	/* (non-Javadoc)
	 * @see com.skb.learn.spring.rest.service.PredictEightService#deleteCustomer()
	 */
	@Override
	public void deleteCustomer() {
		
		String customerUrl = predict8Url.concat("/customers/");
		
		Map<String, String> customerData = new HashMap<>();
		customerData.put("firstname", "Sammy");
		customerData.put("lastname", "Whiskers");
		
		JsonNode createResponse = restTemplate.postForObject(customerUrl, customerData, JsonNode.class);
		
		String customerId = createResponse.get("customer_url").textValue().split("/")[3];
		log.info("Created Customer: " + customerId);
		
		restTemplate.delete(customerUrl + customerId);
		
		log.info("Customer deleted");
		
		JsonNode customerAfterDeleteResponse = restTemplate.getForObject(customerUrl + customerId, JsonNode.class);
		
	}
}
