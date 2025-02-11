package com.jspiders.Student_Boot1.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.jspiders.Student_Boot1.dto.Student;
import com.jspiders.Student_Boot1.repository.StudentRepository;

@Repository
public class StudentDao
{
	StudentRepository repository;
	
	
	public Student saveStudentData(Student student)
	{
		return repository.save(student);
		
	}
	
	public Student fetchStudentByRegno(int regno)
	{
		Optional<Student> op=repository.findById(regno);
		if (op.isPresent()) 
		{
			return op.get();
		} 
		else 
		{
			return null;
		}
		
	}
	
	public Student updateStudentByRegno(Student student)
	{
		Optional<Student> op=repository.findById(student.getRegno());
		if (op.isPresent()) 
		{
			return repository.save(student);
		}
		else
		{
			return null;
		}		
	}
	
	public List<Student> fetchAll()
	{
		return repository.findAll();	
	}
	
	public List<Student> findByName(String name)
	{
		return repository.findByName(name);
	}
	
}
