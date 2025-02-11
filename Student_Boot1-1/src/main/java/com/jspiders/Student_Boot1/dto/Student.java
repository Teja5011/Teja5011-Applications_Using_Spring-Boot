package com.jspiders.Student_Boot1.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student 
{
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int regno;
   private String name,branch,college;
   private long phone;
}
