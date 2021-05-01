package com.poc.employeedemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.poc.employeedemo.dto.DepartmentDTO;
import com.poc.employeedemo.dto.OrganizationDTO;
import com.poc.employeedemo.entity.Employee;
import com.poc.employeedemo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
		
//	@Value("${organization.details.uri}")
//	private String organizationDetailsURI;
//	
//	
//	@Value("${department.details.uri}")
//	private String departmentDetailsURI;
	
	public void createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		employeeRepository.save(emp);
	}
	
	
	public Optional<Employee> getEmployee(long id) {
		return employeeRepository.findById(id);
	}
	
	public Employee getEmployeeDetails(Long id) {
		
		Employee employee = employeeRepository.findById(id).get();
		OrganizationDTO organization = restTemplate.getForObject("http://localhost:8081/organization"+"/"+id, OrganizationDTO.class);
		DepartmentDTO department = restTemplate.getForObject("http://localhost:8080/department"+"/"+id, DepartmentDTO.class);
		employee.setDepartmentName(department.getName());
		employee.setOrganizationAddress(organization.getAddress());
		return employee;
		
	}
	

}
