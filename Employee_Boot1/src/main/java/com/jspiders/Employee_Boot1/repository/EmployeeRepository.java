package com.jspiders.Employee_Boot1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jspiders.Employee_Boot1.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
	
	@Query("select a from Employee a where a.email=?1")
	List<Employee> findByEmail(String email);

}
