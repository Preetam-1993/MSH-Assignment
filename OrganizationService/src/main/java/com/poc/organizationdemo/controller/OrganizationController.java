package com.poc.organizationdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poc.organizationdemo.entity.Organization;
import com.poc.organizationdemo.service.OrganizationService;

@Controller
@RequestMapping("/organization")
public class OrganizationController {
	
	@Autowired 
	private OrganizationService organizationService;
	
	
	@PostMapping("/create")
	public void createEmployee(@RequestBody Organization org) {
		
		organizationService.createOrganization(org);
		
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Organization getOrganization(@PathVariable("id") Long id) {
		
		return organizationService.getOrganizationById(id).get();
		
	}

}
