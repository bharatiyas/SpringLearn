package com.skb.learn.spring.rest.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Login implements Serializable {

	private String username;

    private String sha256;

    private String md5;

    private String sha1;

    private String password;

    
}
