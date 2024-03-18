package com.infenia.oms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infenia.oms.entity.Organization;
import com.infenia.oms.service.OrganizationService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/org")
public class OrganizationController {

	@Autowired
	private OrganizationService organizationService;
	
	// Add Organization
	@PostMapping("/addOrg")
	public ResponseEntity<Organization> addOrganization(@Valid @RequestBody Organization organization) {
        Organization createdOrganization = organizationService.addOrganization(organization);
        return new ResponseEntity<>(createdOrganization, HttpStatus.CREATED);
    }
	
	//Update Organization by Id
	@PutMapping("/updateOrg/{id}")
	public  ResponseEntity<Organization> updateOrgById(@PathVariable Long id,@RequestBody Organization updatedOrg) {
		organizationService.updateOrgById(id, updatedOrg);
		return null;
	}	
	
	//View Org by Id
	@GetMapping("/viewOrgById/{id}")
	public ResponseEntity<Optional<Organization>> viewOrgById(@PathVariable Long id) {
		Optional<Organization> organization = organizationService.getOrgById(id);
		
		if(organization.isPresent()) {
			 return new ResponseEntity<Optional<Organization>>(organization, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}		
	}
	
	
	//View All Org
	@GetMapping("/viewAllOrg")
	public ResponseEntity<List<Organization>> getAllOrganization() {
		List<Organization> organizations = organizationService.getAllOrg();
		return new ResponseEntity<>(organizations,HttpStatus.OK);
	}
	
	
	//Delete Org, if emp = 0
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Void> deleteOrganization(@PathVariable Long id) {
		organizationService.deleteOrg(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
