package com.poc.organizationdemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.organizationdemo.entity.Organization;
import com.poc.organizationdemo.repository.OrganizationRepository;

@Service
public class OrganizationService {
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	public Optional<Organization> getOrganizationById(Long org_id) {
		return organizationRepository.findById(org_id);
	}
	
	public void createOrganization(Organization org) {
		organizationRepository.save(org);
	}

}
