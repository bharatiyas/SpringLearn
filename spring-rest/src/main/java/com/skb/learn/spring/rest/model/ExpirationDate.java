package com.skb.learn.spring.rest.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class ExpirationDate implements Serializable  {

	private String timezone;

    private String timezone_type;

    private String date;
    
}
