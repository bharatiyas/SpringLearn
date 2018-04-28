package com.skb.learn.spring.rest.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Card implements Serializable {
    private ExpirationDate expirationDate;

    private String number;

    private String type;

    private String swift;

    private String iban;
    
}