package com.paceclasses.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.paceclasses.model.Users;
import com.paceclasses.repository.UserRepository;

@Service
public class UsersService {
	@Autowired
	UserRepository repo;

	public List<Users> getAllUsers() {
		List<Users> list = new ArrayList<>();
		repo.findAll().forEach(item -> list.add(item));
		return list;
	}

	public Users getUserById(long id) {
		return repo.findById(id).get();
	}

	public Users saveOrUpdate(Users user) {
		// System.out.println(user.toString());
		return repo.save(user);
	}

	public void deleteById(long id) {
		repo.deleteById(id);
	}

	public Users update(Users user, long id) {
		return repo.save(user);
	}

	public Users findByEmail(String email) {
		Users user = null;
		List<Users> list = new ArrayList<>();
		repo.findAll().forEach(item -> list.add(item));
		user = list.stream().filter(filterUser -> filterUser.getEmail().equalsIgnoreCase(email)).findFirst()
				.orElse(null);
		return user;
	}

	public boolean isPassword(String hash, String password) {
		boolean isEqual = false;
		int strength = 10;
		BCryptPasswordEncoder pass = new BCryptPasswordEncoder(strength, new SecureRandom());
		isEqual = pass.matches(password, hash);
		return isEqual;
	}
}
