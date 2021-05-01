package com.poc.departmentdemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.departmentdemo.entity.Department;
import com.poc.departmentdemo.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Optional<Department> getdepartmentById(Long dept_id) {

		return departmentRepository.findById(dept_id);
	}

	public void createDepartment(Department dept) {
		
		departmentRepository.save(dept);
		
	}
}
