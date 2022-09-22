package com.paceclasses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paceclasses.error.GlobalError;
import com.paceclasses.model.LoginUser;
import com.paceclasses.model.Users;
import com.paceclasses.service.UsersService;
import com.paceclasses.model.LoginUser;

@RequestMapping("/user")
@RestController
public class UsersController {
	@Autowired
	UsersService service;

	@GetMapping("/{id}")
	private Users getUser(@PathVariable long id) {
		return service.getUserById(id);
	}

	@GetMapping("/")
	private List<Users> getUsers() {
		return service.getAllUsers();
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	private Users saveUser(@RequestBody Users user) {
		System.out.println(user.toString());
		return service.saveOrUpdate(user);
		// return user;
	}

	/*
	 * User login
	 */
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	private ResponseEntity<Users> loginUser(@RequestBody LoginUser user) {
		System.out.println(user.toString());
		Users main_user = service.findByEmail(user.getEmail());
		if (main_user != null) {
			if (service.isPassword(main_user.getPassword(), user.getPassword())) {
				return new ResponseEntity<Users>(main_user, HttpStatus.OK);
			} else {

				GlobalError error = new GlobalError();
				error.setStatus(false);
				error.setMessage("Password is incorrect");
				// return new ResponseEntity<GlobalError>(error, HttpStatus.valueOf(404));
			}
		}

		return null;
	}

	// /*
	// * User logout
	// */
	// @RequestMapping(path = "/logout", method = RequestMethod.POST)
	// private Users logoutUser(@RequestBody Users user) {
	// System.out.println(user.toString());
	// return service.findByEmail(user.getEmail());
	// // return user;
	// }

}
