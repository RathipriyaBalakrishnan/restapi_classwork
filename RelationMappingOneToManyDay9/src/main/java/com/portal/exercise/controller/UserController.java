package com.portal.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import com.portal.exercise.model.User;
import com.portal.exercise.repository.UserRepo;

@RestController
@RequestMapping("/")
public class UserController {
	
	@Autowired
	public UserRepo urepo;
	
	@PostMapping()
	public User saveDetails(@RequestBody User u)
	{
		return urepo.save(u);
	}
	
	@GetMapping()
	public List<User> getDetails()
	{
		return urepo.findAll();
	}
	

}
