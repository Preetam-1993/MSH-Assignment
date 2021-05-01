package com.poc.departmentdemo;

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
import org.springframework.test.context.junit4.SpringRunner;

import com.poc.departmentdemo.entity.Department;
import com.poc.departmentdemo.repository.DepartmentRepository;
import com.poc.departmentdemo.service.DepartmentService;

@RunWith(SpringRunner.class)
public class DepartmentServiceTest {
	
	@Mock
	private DepartmentRepository departmentRepository;
	
	@InjectMocks
	private DepartmentService departmentService;
	
	private Department dept;
	
	@Before
	public void setUp() {
		dept = new Department();
		dept.setId(Long.valueOf(1));
		dept.setName("BFS");
	}

	
	@Test
	public void test_getdepartmentById_when_successful_then_return_Department() {
		Mockito.when(departmentRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(dept));
		Optional<Department> result = departmentService.getdepartmentById(Long.valueOf(0));
		assertEquals("BFS", result.get().getName());
	}
	
	@Test
	public void test_createDepartment() {
		departmentService.createDepartment(dept);
		verify(departmentRepository, atMost(1)).save(dept);
	}
}
