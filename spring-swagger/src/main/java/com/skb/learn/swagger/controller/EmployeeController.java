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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/swaggerapp/employees")

// Swagger Annotation to customize the API Documentation generation at class level
@Api(value = "Employee API", tags = {"Employee API"})
public class EmployeeController {

	// URL for Swagger UI is: http://<host>:<port>/swagger-ui.html
	// To get the Swagger JSON file use the link: http://<host>:<port>/v2/api-docs
	
	// Swagger Annotations are only processed at Compile Time, not at Run Time
	// ApiOperation tag is for modifying the Operation names displayed on the swagger-ui.html
	@ApiOperation(value="Returns List of all employees")
	
	// ApiResponses is to customize the display of information about the HTTP Status codes returned by the API  
	@ApiResponses(
			value = {
					@ApiResponse(code = 200, message = "Employees Returned"),
					@ApiResponse(code = 400, message = "No Employees exist")
			}
	)
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
	
	@ApiOperation(value="Returns the details of an employee")
	@ApiResponses(
			value = {
				@ApiResponse(code = 200, message = "Employee Found"),
				@ApiResponse(code = 404, message = "Employee Not Found")
			}
	)
	
	@GetMapping("/{employeeId}")
	public Employee getEmployee(@PathVariable ("employeeId") final Long employeeId) {
		
		Employee employee = new Employee(employeeId, "Sandeep", "Khamaru");
		return employee;
	}
	
	@ApiResponses(
			value = {
					@ApiResponse(code = 201, message = "Employee record created"),
					@ApiResponse(code = 400, message = "Not well formed body")
			}
	)
	@ApiOperation(value="Creates new employee")
	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee employee) {
		
		Employee emp = new Employee(employee.getEmployeeId(), employee.getFirstName(), employee.getLastName());
		return emp;
	}
	
	@ApiOperation(value = "Modifies employee details with new ones")
	@ApiResponses(
			value = {
					@ApiResponse(code = 201, message = "Employee record created"),
					@ApiResponse(code = 400, message = "Not well formed body"),
					@ApiResponse(code = 404, message = "Employee Not Found")
			}
	)
	@PutMapping("/update")
	public ResponseStatus updateEmployee(@RequestBody Employee employee) {
		
		return new ResponseStatus("Success");
	}
}
