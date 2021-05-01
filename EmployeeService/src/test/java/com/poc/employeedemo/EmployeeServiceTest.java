package com.poc.employeedemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.poc.employeedemo.dto.DepartmentDTO;
import com.poc.employeedemo.dto.OrganizationDTO;
import com.poc.employeedemo.entity.Employee;
import com.poc.employeedemo.repository.EmployeeRepository;
import com.poc.employeedemo.service.EmployeeService;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest {
	
	@Mock
	private EmployeeRepository employeeRepository;
	
	@Mock
	private RestTemplate restTemplate;
	
	@InjectMocks
	private EmployeeService employeeService;
	
	private Employee emp;
	
	private OrganizationDTO organization;
	
	private DepartmentDTO department;
	
	@Before
	public void setUp() {
		
		emp =  new Employee();
		emp.setId(Long.valueOf(0));
		emp.setName("Pritam");
		emp.setDepartmentName("BFS");
		emp.setOrganizationAddress("kolkata");
		
		organization = new OrganizationDTO();
		organization.setId(Long.valueOf(0));
		organization.setAddress("Kolkata");
		
		department = new DepartmentDTO();
		department.setName("BFS");
		department.setId(Long.valueOf(0));
				
	}
	
	@Test
	public void test_createEmployee() {
		
		employeeService.createEmployee(emp);
		verify(employeeRepository, atMost(1)).save(emp);
		
		
	}
	
	@Test
	public void test_getEmployee_when_successful_then_return_employee() {
		
		Mockito.when(employeeRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(emp));
		
		Optional<Employee> result = employeeService.getEmployee(Long.valueOf(0));
		assertEquals("BFS", result.get().getDepartmentName());
		assertEquals("Pritam", result.get().getName());
		assertEquals("kolkata", result.get().getOrganizationAddress());
		
		
	}
	
	@Test
	public void test_getEmployeeDetails_when_successful_then_return_employee() {
		
		Mockito.when(restTemplate.getForObject("http://localhost:8081/organization/0",OrganizationDTO.class)).thenReturn(organization);
		Mockito.when(restTemplate.getForObject("http://localhost:8080/department/0",DepartmentDTO.class)).thenReturn(department);
		Mockito.when(employeeRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(emp));
		
		Employee result = employeeService.getEmployeeDetails(Long.valueOf(0));
		assertEquals("BFS", result.getDepartmentName());
		assertEquals("Pritam", result.getName());
		assertEquals("Kolkata", result.getOrganizationAddress());
		
		
	}

}
