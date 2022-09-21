package com.paceclasses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paceclasses.model.Users;
import com.paceclasses.service.UsersService;

@RequestMapping("/user")
@RestController
public class UsersController {
	@Autowired
	UsersService service;
	
	@GetMapping("/{id}")
	private Users getUser(@PathVariable long id)
	{
		return service.getUserById(id);		
	}
	@GetMapping("/")
	private List<Users> getUsers()
	{
		return service.getAllUsers();
	}
	@RequestMapping(path = "/",method = RequestMethod.POST)
	private Users saveUser(@RequestBody Users user)
	{
		System.out.println(user.toString());
		return service.saveOrUpdate(user);
//		return user;
	}
	
}
