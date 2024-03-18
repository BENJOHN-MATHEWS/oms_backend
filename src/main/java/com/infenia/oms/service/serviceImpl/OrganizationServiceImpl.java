package com.infenia.oms.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infenia.oms.entity.Employee;
import com.infenia.oms.entity.Organization;
import com.infenia.oms.repository.EmployeeRepository;
import com.infenia.oms.repository.OrganizationRepository;
import com.infenia.oms.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService{

	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Organization addOrganization(Organization organization) {
		
		return organizationRepository.save(organization);
	}

	@Override
	public List<Organization> getAllOrg() {
		
		return organizationRepository.findAll();
	}

	
	@Override
	public void deleteOrg(Long id) {	
		
		List<Employee> emp = employeeRepository.findByOrgId(id);
		
		if(emp.isEmpty()) {
			organizationRepository.deleteById(id);
		}		
			
			
		
	}
	
	
}
