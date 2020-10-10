package com.Myproject.rest.entities;

import java.util.Date;

public class User {
	
	
	private int id;
	
	private String name;
	
	private Date birthdate;
	
	
	public User()
	{
		
	}
	
	// Paramterized constructor
	
	public User(int id, String name, Date birthdate)
	{
		this.id=id;
		this.name=name;
		this.birthdate=birthdate;
	}
	
	//  generating getters-setters
	
	public int getId()
	{
		return id;
	}
	
	public void setId(Integer id)
	{
		this.id=id;
	}
	
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	
	{
		this.name=name;
	}

	public Date getBirthDate()
	{
		return birthdate;
	}
	
	public void setBirthDate(Date birthdate)
	{
		this.birthdate=birthdate;
		
	}

	
	// generating toString method
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
	}	
	
}
