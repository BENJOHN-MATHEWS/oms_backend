package com.infenia.oms.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infenia.oms.entity.Employee;
import com.infenia.oms.repository.EmployeeRepository;
import com.infenia.oms.service.EmployeeService;

import jakarta.validation.Valid;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getEmpByOrgId(Long id) {
		
		return employeeRepository.findByOrgId(id);
	}

	@Override
	public Employee addEmp(@Valid Employee employee) {
		return employeeRepository.save(employee);		
	}

	@Override
	public Employee updateEmpById(Long id, Employee updatedEmp) {
		
		Employee eEmp= null;
		
		Optional<Employee> existingEmp = employeeRepository.findById(id);
		
		if(existingEmp.isPresent()) {
			
			eEmp = existingEmp.get();
			
			eEmp.setAddress(updatedEmp.getAddress());
			eEmp.setOrganization(updatedEmp.getOrganization());
			eEmp.setPhoneNo(updatedEmp.getPhoneNo());
			
			employeeRepository.save(eEmp);
			
		}
		return eEmp;
		
	}
	
	
}
