package com.poc.departmentdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poc.departmentdemo.entity.Department;
import com.poc.departmentdemo.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired 
	private DepartmentService departmentService;
	
	@PostMapping("/create")
	public void createDepartment(@RequestBody Department department) {
		
		departmentService.createDepartment(department);
		
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Department getDepartment(@PathVariable("id") Long id) {
		
		return departmentService.getdepartmentById(id).get();
		
	}

}
