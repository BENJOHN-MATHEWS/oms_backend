package com.infenia.oms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infenia.oms.entity.Employee;
import com.infenia.oms.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@ Autowired
	EmployeeService employeeService;
	
	
	//Add emp with org id
	@PostMapping("/addEmp")
	public ResponseEntity<Employee> addEmp(@Valid @RequestBody Employee employee) {
		Employee emp = employeeService.addEmp(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}
	
	//View all emp, find by Org Id
	@GetMapping("/findByOrgId/{id}")
	public ResponseEntity<List<Employee>> getEmpByOrgId(@PathVariable Long id) {		
		List<Employee> emp = employeeService.getEmpByOrgId(id);		
		return new ResponseEntity<List<Employee>> (emp, HttpStatus.FOUND);
	}
	
	//Update other fields, Except id and name
	@PutMapping("/updateEmpById/{id}")
	public ResponseEntity<Employee> updateEmpById(@PathVariable Long id, @RequestBody Employee updatedEmp) {
		
		Employee employee = employeeService.updateEmpById(id, updatedEmp);
		
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
}
