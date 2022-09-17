package com.paceclasses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paceclasses.model.Users;
import com.paceclasses.service.UsersService;

@RequestMapping("/user")
@RestController
public class UsersController {
	@Autowired
	UsersService service;
	
	@GetMapping("/{id}")
	private Users getUser(@PathVariable("id") long id)
	{
		return service.getUserById(id);		
	}
	@GetMapping("/")
	private List<Users> getUsers()
	{
		return service.getAllUsers();
	}
	
}
