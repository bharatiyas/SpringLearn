package com.skb.learn.spring.rest.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Location implements Serializable {

	private String street;

    private String state;

    private String postcode;

    private String city;
    
}
