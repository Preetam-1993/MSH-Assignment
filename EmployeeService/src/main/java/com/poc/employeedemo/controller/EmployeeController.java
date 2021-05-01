package com.poc.employeedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.employeedemo.entity.Employee;
import com.poc.employeedemo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/create")
	public void createEmployee(@RequestBody Employee emp) {
		
		empService.createEmployee(emp);
		
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Employee getEmployee(@PathVariable("id") Long id) {
		
		return empService.getEmployee(id).get();
				
	}
	
	@GetMapping("/details/{id}")
	public @ResponseBody Employee getEmployeeDetails(@PathVariable("id") Long id) {
		
		return empService.getEmployeeDetails(id);
				
	}
	

}
