package com.jspiders.Employee_Boot1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.Employee_Boot1.dao.EmployeeDao;
import com.jspiders.Employee_Boot1.dto.Employee;

@CrossOrigin(origins="*",methods= {RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
@RestController
public class EmployeeComtroller {
//	local host: http://localhost:8080/save
	@Autowired
	EmployeeDao dao;

	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee e) {
		System.out.println(e);
		return new ResponseEntity<Employee>(dao.saveEmployeeData(e), HttpStatus.CREATED);
	}

//	local host: http://localhost:8080/update
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee e) {
		System.out.println(e);
		return null;
	}

//	local host:http://localhost:8080/delete?employeeID=10
	@DeleteMapping("/delete")
	public ResponseEntity<Employee> deleteEmployee(@RequestParam("employeeID") int id) {
		Employee employee=dao.deleteEmployee(id);
		if(dao.deleteEmployee(id)!=null)
		{
			return new ResponseEntity<Employee>(employee, HttpStatus.FOUND);
		}
		else
		{
			return new ResponseEntity<Employee>(employee, HttpStatus.NOT_FOUND);
		}
	}

//	local host: http://localhost:8080/fetchById
	@GetMapping("/fetchById")
	public Employee fetchEmployeeById(int id) {
		System.out.println(id);
		return null;
	}

//	local host: http://localhost:8080/fetchByEmail/teja623@gmail.com/7675964378
	@GetMapping("/fetchByEmail/{email}/{mobile}")
	public List<Employee> fetchEmployeeByEmail(@PathVariable String email, @PathVariable long mobile) {
		System.out.println(email);
		return dao.findByEmail(email);
	}

//	local host: http://localhost:8080/fetchByEmail1/teja623@gmail.com/7675964378
	@GetMapping("/fetchByEmail/{empEmail}/{mobile}")
	public List<Employee> fetchEmployeeByEmail1(@PathVariable String empemail, @PathVariable long mobile) {
		System.out.println(empemail + " " + mobile);
		return null;
	}

//	local host: http://locahost:8080/fetchAll
	@GetMapping("/fetchAll")
	public ResponseEntity<List<Employee>> fetchAllEmployee() 
	{
		List<Employee>list=dao.fetchAll();
		if(!list.isEmpty())
		{
			return new ResponseEntity<List<Employee>>(list,HttpStatus.FOUND);
		}
		else
		{
			return new ResponseEntity<List<Employee>>(list,HttpStatus.NOT_FOUND);
		}
	}
}
