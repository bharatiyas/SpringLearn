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

import com.skb.learn.swagger.model.Department;
import com.skb.learn.swagger.model.ResponseStatus;

@RestController
@RequestMapping("/swaggerapp/department")
public class DepartmentController {

	@GetMapping("/")
	public List<Department> getDepartment() {
		
		List<Department> department = new ArrayList<>();
		Department dept;
		dept = new Department(190290L, "Finance");
		department.add(dept);
		dept = new Department(232344L, "Information Technology");
		department.add(dept);
		dept = new Department(453943L, "Sales");
		department.add(dept);
		return department;
	}
	
	@GetMapping("/{departmentId}")
	public Department getDepartment(@PathVariable ("departmentId") final Long departmentId) {
		
		Department department = new Department(departmentId, "Sandeep");
		return department;
	}
	
	@PostMapping("/create")
	public Department createDepartment(@RequestBody Department department) {
		
		return department;
	}
	
	@PutMapping("/update")
	public ResponseStatus updateDepartment(@RequestBody Department department) {
		
		return new ResponseStatus("Success");
	}
	
}
