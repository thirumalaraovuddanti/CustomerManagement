package com.customer.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.entity.Customers;


public interface CustomersRepository extends JpaRepository<Customers, BigDecimal>{

	Customers findByEmail(String email);

}
