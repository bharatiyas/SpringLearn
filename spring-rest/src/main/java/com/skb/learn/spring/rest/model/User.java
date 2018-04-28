package com.skb.learn.spring.rest.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable {
    private Billing billing;

    private String phone;

    private String email;

    private Location location;

    private Name name;

    private Job job;

    private String gender;

    private Login login;

    private String language;

    private String currency;
    
}	
