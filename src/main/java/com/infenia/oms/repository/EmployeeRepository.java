package com.infenia.oms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.infenia.oms.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(value = "SELECT * FROM employee e WHERE e.organization_id = :orgId", nativeQuery = true)
    List<Employee> findByOrgId(@Param("orgId") Long orgId);
	

}
