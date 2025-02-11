package com.jspiders.Employee_Boot1.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspiders.Employee_Boot1.dto.Employee;
import com.jspiders.Employee_Boot1.repository.EmployeeRepository;

@Repository
public class EmployeeDao 
{

	@Autowired
	EmployeeRepository repository;

	
	public Employee saveEmployeeData(Employee employee) {
		return repository.save(employee);
	}

	public Employee fetchEmployeeById(int id) {
		Optional<Employee> op = repository.findById(id);
		if (op.isPresent()) {
			return op.get();
		} else {
			return null;
		}
	}

	public Employee updateEmployeeById(Employee employee) {
		Optional<Employee> op = repository.findById(employee.getId());
		if (op.isPresent()) {
			return repository.save(employee);
		} else {
			return null;
		}
	}

	public List<Employee> fetchAll() {
		return repository.findAll();
	}

	public List<Employee> findByEmail(String email) {
		return repository.findByEmail(email);
	}

	public Employee deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
