package com.poc.organizationdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.organizationdemo.entity.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long>{

}
