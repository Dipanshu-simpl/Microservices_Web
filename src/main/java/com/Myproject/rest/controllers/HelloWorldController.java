package com.Myproject.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@RequestMapping(method=RequestMethod.GET,path="/hello-world")
	public String helloWorld()
	{
		return "Hello world";
	}

	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloworldBean()
	{
		return new HelloWorldBean("Hello World Bean");
	}
	
	
	@GetMapping(path="hello-world/path-variable/{name}")
	public HelloWorldBean helloworldPathVariable(@PathVariable String name)
	{
		return new HelloWorldBean(String.format("HelloWorld %s",name));
	}
}
