package com.customer.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.entity.Users;


public interface UsersRepository extends JpaRepository<Users, BigDecimal>{

	Users getByUsernameAndPassword(String username, String password);

	Users getByUsername(String username);

	Users getByEmail(String email);

	Users getByUsernameOrEmail(String username, String email);

}
