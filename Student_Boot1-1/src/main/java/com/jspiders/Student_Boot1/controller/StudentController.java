package com.jspiders.Student_Boot1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.Student_Boot1.dao.StudentDao;
import com.jspiders.Student_Boot1.dto.Student;

@RestController
public class StudentController 
{
	StudentDao dao;
	
//	local host: http://localhost:8080/save
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student s)
	{
		return dao.saveStudentData(s);
		
	}
	
// local host: http://localhost:8080/update
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student s)
	{
		System.out.println(s);
		return null;
	}
	
// local host: http://localhost:8080/delete
	@DeleteMapping("/delete")
	public Student deleteStudent(@RequestParam ("studentRegno") int regno)
	{
		System.out.println(regno);
		return null;
	}
	
// local host: http://localhost:8080/fetchByRegno
	@GetMapping("/fethByRegno")
	public Student fetchByRegno(int regno)
	{
		System.out.println(regno);
		return null;
	}
	
// local host: http://localhost:8080/fetchByName/ECE/7675964378
	@GetMapping("fetchByBranch/{Branch}/{Phone}")
	public List<Student> fetchByBranch(@PathVariable String branch,@PathVariable long phone)
	{
		System.out.println(branch+" "+phone);
		return null;
	}
	
// local host: http://localhost:8080/fetchAll
	@GetMapping("/fetchAll")
	public List<Student> fetchAllStudent()
	{
		return dao.fetchAll();
		
	}
	
	
	
}
