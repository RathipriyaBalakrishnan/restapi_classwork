package com.portal.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.portal.exercise.model.StudentModel;
import com.portal.exercise.repository.StudentRepo;

@RestController
@RequestMapping("/")
public class StudentController {
	
	@Autowired
	public StudentRepo srepo;
	
	@PostMapping()
	public StudentModel saveDetails(@RequestBody StudentModel sm)
	{
		return srepo.save(sm);
	}
	
	@GetMapping()
	public List<StudentModel> getDetails()
	{
		return srepo.findAll();
	}
	
	@PutMapping()
	public  StudentModel updateStudentInfo(@RequestBody StudentModel sm)
	{
		return srepo.saveAndFlush(sm);
	}
	
	@PutMapping("/{id}")
	public String updateStudent(@PathVariable("id") int id,StudentModel sm)
	{
		if(srepo.existsById(id))
		{
			srepo.save(sm);
			return "The Id "+id+" is updated";
		}
		return "The Id "+id+ " is not found";
	}
	
	
	@GetMapping("/{id}")
	public Optional<StudentModel> getDetailsByID(@PathVariable("id") int  id)
	{
		Optional<StudentModel> student = srepo.findById(id);
		if(student.isPresent())
		{
			return student;
		}
		return null;
	}
	
	
	@DeleteMapping("/{id}")
	public String  deleteStudent(@PathVariable("id") int id)
	{
		if(srepo.existsById(id)) 
		{
		 srepo.deleteById(id);
		 return "The Id "+ id +" is deleted.";
		}
		return "The Id "+id+" is not present";
	}	
	
	 
}

