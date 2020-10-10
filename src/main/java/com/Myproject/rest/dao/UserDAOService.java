package com.Myproject.rest.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Myproject.rest.entities.User;

@Service
public class UserDAOService {
	
	private static List<User> users=new ArrayList<>();
	
	private static int userCount=3;
	
	
	static {
		
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Bob", new Date()));
		users.add(new User(3, "Cheryl", new Date()));
		users.add(new User(4, "Dipanshu", new Date()));
	}
	
	// get the list of all users
	
	
	public List<User> findAll()
	{
		return users;
	}
	
	
	// find by Id
	
	public User findById(int id)
	{
		for(User user:users)
		{
			if(user.getId()==id)
			{
				return user;
			}
		}
		return null;
	}
	
	//create a new user/saving a new user
	public User save(User user)
	{
		if(user.getId()==0)
		{
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	


}
