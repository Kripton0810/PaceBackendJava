package com.paceclasses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paceclasses.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

}
