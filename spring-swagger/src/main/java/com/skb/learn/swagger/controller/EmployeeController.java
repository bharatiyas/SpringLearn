package com.skb.learn.swagger.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skb.learn.swagger.model.Employee;
import com.skb.learn.swagger.model.ResponseStatus;

@RestController
@RequestMapping("/swaggerapp/employees")
public class EmployeeController {

	@GetMapping("/")
	public List<Employee> getEmployees() {
		
		List<Employee> employees = new ArrayList<>();
		Employee emp;
		emp = new Employee(4334343L, "Sandeep", "Khamaru");
		employees.add(emp);
		emp = new Employee(4377943L, "Anindya", "Maji");
		employees.add(emp);
		emp = new Employee(5567943L, "Panjak", "Kumar");
		employees.add(emp);
		return employees;
	}
	
	@GetMapping("/{employeeId}")
	public Employee getEmployee(@PathVariable ("employeeId") final Long employeeId) {
		
		Employee employee = new Employee(employeeId, "Sandeep", "Khamaru");
		return employee;
	}
	
	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee employee) {
		
		return employee;
	}
	
	@PutMapping("/update")
	public ResponseStatus updateEmployee(@RequestBody Employee employee) {
		
		return new ResponseStatus("Success");
	}
}
