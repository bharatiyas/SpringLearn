package com.skb.learn.spring.rest.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Name implements Serializable {

	private String title;

    private String last;

    private String first;
    
}
