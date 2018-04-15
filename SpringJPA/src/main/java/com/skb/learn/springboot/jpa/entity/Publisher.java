package com.skb.learn.springboot.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Publisher {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	private String name;
	private String address;
	
	public Publisher() {
		
	}
	
	public Publisher(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
	
}
