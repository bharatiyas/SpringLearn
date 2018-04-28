package com.skb.learn.spring.rest.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Billing implements Serializable {
    
	private Card card;
    
}