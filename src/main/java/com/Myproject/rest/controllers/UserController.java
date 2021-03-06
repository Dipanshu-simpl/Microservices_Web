package com.Myproject.rest.controllers;



//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Myproject.rest.dao.UserDAOService;
import com.Myproject.rest.entities.User;
import com.Myproject.rest.exception.UserNotFoundException;

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
	public User retrieveUser(@PathVariable int id) throws UserNotFoundException
	{
		
		User user=userDAOservice.findById(id);
		if(user==null)
		{
			throw new UserNotFoundException("id ---"+id);
		}		
		
		EntityModel<User> coll=new EntityModel<User> (user);
		
		/*ControllerLinkBuilder link=ControllerLinkBuilder.methodOn(this.getClass()).retriveAllUsers();
		
		coll.add(link.withRel("al-users"));*/
		return user;
	
	}
	
	
	// Post function for creating new user
	
	@PostMapping("/users")
	public ResponseEntity createUser(@Valid @RequestBody User user)
	{
		User userd=userDAOservice.save(user);
		
		URI location=ServletUriComponentsBuilder
				     .fromCurrentRequest()
				     .path("/{id}")
				     .buildAndExpand(userd.getId())
				     .toUri();
				     
		return ResponseEntity.created(location).build();
		
	}
	
	// Deleting an user
	
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) throws UserNotFoundException
	{
		User user=userDAOservice.deleteById(id);
		if(user ==null)
		{
			throw new UserNotFoundException("id--"+id);
			
		}
		
	}
}
