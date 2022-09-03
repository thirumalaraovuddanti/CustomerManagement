package com.customer.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.Logged_Users;
import com.customer.entity.Users;
import com.customer.repository.LoggedUsersRepository;
import com.customer.repository.UsersRepository;

@Service
@Transactional
public class UserService {

	public static final Logger logger = LogManager.getLogger(UserService.class);
	
	@Autowired
	private UsersRepository userRepo;
	
	@Autowired
	private LoggedUsersRepository loggedUsersRepo;

	public String login(Users user) {
		
		JSONObject res = null;
	try {	
		
		Users u = userRepo.getByUsernameAndPassword(user.getUsername(),user.getPassword());
		res = new JSONObject();
		
		if(u==null)
		{
			res.put("status", "false");
			res.put("data","");
			res.put("desc", "Username or Password Incorrect");	
		}else {
		res.put("status", "true");
		res.put("data", u);
		res.put("desc", "Successfully Logged in");
		
		Logged_Users lusr = new Logged_Users();
		lusr.setUsername(u.getUsername());
		lusr.setDatestamp(new Date());
		
		loggedUsersRepo.save(lusr);
		
		}	
	}catch (Exception e) {
		logger.info("Error at user login Service: "+e.getMessage());
		
		res = new JSONObject();
		res.put("status", "false");
		res.put("data","");
		res.put("desc", "Failed to Login");
	}
		logger.info("User Login Api Response : "+res.toString());
		return res.toString();
	}

	public String register(Users user) {
		
		JSONObject res = null;
		try {	
			
			Users exists = userRepo.getByUsernameOrEmail(user.getUsername(),user.getEmail());
			
			if(exists==null)
			{
				Users u = userRepo.save(user);
				res = new JSONObject();
				if(u==null)
				{
					res.put("status", "false");
					res.put("data", "");
					res.put("desc", "Failed to Register");
					
				}else {
					res.put("status", "true");
					res.put("data", u);
					res.put("desc", "User Registered Successfully");
				}
			}else {
				res = new JSONObject();
				res.put("status", "false");
				res.put("data", "");
				res.put("desc", "Username or Email Already Exists");
			}
		
		}catch (Exception e) {
			logger.info("Error at user register Service: "+e.getMessage());
			
			res = new JSONObject();
			res.put("status", "false");
			res.put("data","");
			res.put("desc", "Failed to Register");
		}
		logger.info("User Register Api Response : "+res.toString());
		return res.toString();
	}

	public String logout(String username) {
		
		JSONObject res = null;
	try {	
		
		loggedUsersRepo.deleteByUsername(username);
		res = new JSONObject();
		
		res.put("status", "true");
		res.put("data", "");
		res.put("desc", "Successfully Logged out");
			
	}catch (Exception e) {
		logger.info("Error at user logout Service: "+e.getMessage());
		
		res = new JSONObject();
		res.put("status", "false");
		res.put("data","");
		res.put("desc", "Failed to Logout");
	}
		logger.info("User Logout Api Response : "+res.toString());
		return res.toString();
	}

}
