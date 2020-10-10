package com.Myproject.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Myproject.rest.dao.UserDAOService;
import com.Myproject.rest.entities.User;

@RestController
public class UserController {

	
	@Autowired
	private UserDAOService userDAOservice;
	
	
	
	@GetMapping("/users")
	public List<User> retriveAllUsers()
	{
		return userDAOservice.findAll();
	}
	
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id)
	{
		return userDAOservice.findById(id);
	}
}
