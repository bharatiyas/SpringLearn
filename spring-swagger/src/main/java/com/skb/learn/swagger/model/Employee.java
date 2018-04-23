package com.skb.learn.swagger.model;

import io.swagger.annotations.ApiModelProperty;

public class Employee {

	@ApiModelProperty(notes = "Employee Id")
	private Long employeeId;
	
	@ApiModelProperty(notes = "Employee First Name")
	private String firstName;
	
	@ApiModelProperty(notes = "Employee Last Name")
	private String lastName;
	
	public Employee() {
		super();
	}

	public Employee(Long employeeId, String firstName, String lastName) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
}
