package com.infenia.oms.service;

import java.util.List;

import com.infenia.oms.entity.Employee;

import jakarta.validation.Valid;

public interface EmployeeService {

	List<Employee> getEmpByOrgId(Long id);

	Employee addEmp(@Valid Employee employee);

	Employee updateEmpById(Long id, Employee updatedEmp);

}
