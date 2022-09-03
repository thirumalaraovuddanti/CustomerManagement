package com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.entity.Logged_Users;

public interface LoggedUsersRepository extends JpaRepository<Logged_Users, String>{

	 void deleteByUsername(String username);

	Logged_Users findByUsername(String username);

}
