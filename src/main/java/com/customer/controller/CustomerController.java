package com.customer.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entity.Customers;
import com.customer.service.CustomerService;

@RestController
@RequestMapping(path = "/v1/customer")
@CrossOrigin
public class CustomerController {

	
	public static final Logger logger = LogManager.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService custService; 
	
	@GetMapping(path = "/list")
	public ResponseEntity<?> list(@RequestHeader("username") String username){
		logger.info("Customer list Api ");
	    return new ResponseEntity<>(custService.list(username), HttpStatus.OK);
    }
	
	@PostMapping(path = "/add")
	public ResponseEntity<?> add(@RequestBody Customers customers,@RequestHeader("username") String username){
		logger.info("Customer Add Api Request : "+customers.toString());
	    return new ResponseEntity<>(custService.add(customers,username), HttpStatus.OK);
    }
	
	@PutMapping(path = "/edit")
	public ResponseEntity<?> edit(@RequestBody Customers customers,@RequestHeader("username") String username){
		logger.info("Customer Edit Api Request : "+customers.toString());
	    return new ResponseEntity<>(custService.edit(customers,username), HttpStatus.OK);
    }
	
	@DeleteMapping(path = "/delete")
	public ResponseEntity<?> delete(@RequestBody String request,@RequestHeader("username") String username){
		
		logger.info("Customer Delete Api Request : "+request);
	    return new ResponseEntity<>(custService.delete(request,username), HttpStatus.OK);
    }
}
