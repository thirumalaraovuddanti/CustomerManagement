package com.customer.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entity.Users;
import com.customer.service.UserService;

@RestController
@RequestMapping(path = "/v1/user")
@CrossOrigin
public class LoginController {
	
	public static final Logger logger = LogManager.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService; 
	

	
	@PostMapping(path = "/login")
	public ResponseEntity<?> login(@RequestBody Users user){
		logger.info("User Login Api Request : "+user.toString());
	    return new ResponseEntity<>(userService.login(user), HttpStatus.OK);
    }
	
	@PostMapping(path = "/register")
	public ResponseEntity<?> register(@RequestBody Users user){
		logger.info("User Register Api Request : "+user.toString());
	    return new ResponseEntity<>(userService.register(user), HttpStatus.OK);
    }
	
	@GetMapping(path = "/logout")
	public ResponseEntity<?> logout(@RequestHeader("username") String username){
		logger.info("User logout Api Request : "+username.toString());
	    return new ResponseEntity<>(userService.logout(username), HttpStatus.OK);
    }


}
