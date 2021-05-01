package com.poc.organizationdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.poc.organizationdemo.entity.Organization;
import com.poc.organizationdemo.repository.OrganizationRepository;
import com.poc.organizationdemo.service.OrganizationService;

@RunWith(SpringRunner.class)
public class OrganizationTest {

	@Mock
	private OrganizationRepository organizationRepository;

	@InjectMocks
	private OrganizationService organizationService;

	private Organization organization;

	@Before
	public void setUp() {
		organization = new Organization();
		organization.setAddress("Kolkata");
		organization.setId(Long.valueOf(0));
		organization.setName("BFS");

	}

	@Test
	public void test_getOrganizationById_returnsorganization_when_successful() {

		Mockito.when(organizationRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(organization));

		Optional<Organization> result = organizationService.getOrganizationById(Long.valueOf(0));
		assertEquals("Kolkata", result.get().getAddress());

	}

	@Test
	public void test_createOrganization() {

		organizationService.createOrganization(organization);
		verify(organizationRepository, atMostOnce()).save(organization);
		

	}

}
