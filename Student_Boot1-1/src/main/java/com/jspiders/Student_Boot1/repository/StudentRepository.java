package com.jspiders.Student_Boot1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jspiders.Student_Boot1.dto.Student;



public interface StudentRepository extends JpaRepository<Student,Integer>
{
	@Query("select a from Student a where a.name=?")
	List<Student> findByBranch(String branch);

	List<Student> findByName(String name);

}
