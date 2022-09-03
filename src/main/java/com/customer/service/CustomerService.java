package com.customer.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.Customers;
import com.customer.entity.Logged_Users;
import com.customer.entity.Users;
import com.customer.repository.CustomersRepository;
import com.customer.repository.LoggedUsersRepository;
import com.customer.repository.UsersRepository;

@Service
@Transactional
public class CustomerService {

	public static final Logger logger = LogManager.getLogger(CustomerService.class);
	
	@Autowired
	private CustomersRepository custRepo;
	
	@Autowired
	private LoggedUsersRepository loggedUsersRepo;
	
	@Autowired
	private UsersRepository userRepo;

	public String list(String username) {
	
		JSONObject res = null;
		try {	
			res = new JSONObject();
			
			Logged_Users Luser = loggedUsersRepo.findByUsername(username);
			if(Luser!=null)
			{
				List<Customers> listCust = custRepo.findAll();
				
				if(listCust.size()==0)
				{
					res.put("status", "false");
					res.put("data", "");
					res.put("desc", "No Customers to Fetch");
				}else {
					res.put("status", "true");
					res.put("data", listCust);
					res.put("desc", "Customers List Fetched Successfully");
				}
			}
			else
			{
				res.put("status", "false");
				res.put("data","");
				res.put("desc", "Login Again");
			}
		
		}catch (Exception e) {
			logger.info("Error at Customers list Service: "+e.getMessage());
			
			res = new JSONObject();
			res.put("status", "false");
			res.put("data","");
			res.put("desc", "Failed to Fetch Customers");
		}
		logger.info("Customer list Api Response : "+res.toString());
		return res.toString();
	}

	public String add(Customers customers,String username) {

		JSONObject res = null;
		try {	
			res = new JSONObject();
			
			Logged_Users Luser = loggedUsersRepo.findByUsername(username);
			if(Luser!=null)
			{
				Customers c = custRepo.save(customers);
				if(c==null)
				{
					res.put("status", "false");
					res.put("data", "");
					res.put("desc", "Failed to Add Customer");
				}else {
					res.put("status", "true");
					res.put("data", c);
					res.put("desc", "Customer Added Successfully");
				}
			}
			else
			{
				res.put("status", "false");
				res.put("data","");
				res.put("desc", "Login Again");
			}
		}catch (Exception e) {
			logger.info("Error at Customer Add Service: "+e.getMessage());
			
			res = new JSONObject();
			res.put("status", "false");
			res.put("data","");
			res.put("desc", "Failed to Add Customer");
		}
		logger.info("Customer Add Api Response : "+res.toString());
		return res.toString();
	}

	public String edit(Customers customers,String username) {
		JSONObject res = null;
		try {
			res = new JSONObject();
			
			Logged_Users Luser = loggedUsersRepo.findByUsername(username);
			if(Luser!=null)
			{
				//Customers c1 = custRepo.findByEmail(customers.getEmail());
				//customers.setId(c1.getId()); 
				
				Customers c = custRepo.save(customers);
				
				if(c==null)
				{
					res.put("status", "false");
					res.put("data", "");
					res.put("desc", "Failed to Edit Customer");
				}else {
					res.put("status", "true");
					res.put("data", c);
					res.put("desc", "Customer Details Edited Successfully");
				}
			}else
			{
				res.put("status", "false");
				res.put("data","");
				res.put("desc", "Login Again");
			}
		}catch (Exception e) {
			logger.info("Error at Customer Edit Service: "+e.getMessage());
			
			res = new JSONObject();
			res.put("status", "false");
			res.put("data","");
			res.put("desc", "Failed to Edit Customer");
		}
		logger.info("Customer Edit Api Response : "+res.toString());
		return res.toString();
	}

	public String delete(String request,String username) {

		BigDecimal id =null;
		JSONObject res = null;
		String password= "";
		try {	
			JSONObject req = new JSONObject(request);
			id = new BigDecimal(req.get("id").toString());
			password = req.get("password").toString();
			
			
			
			res = new JSONObject();
			Logged_Users Luser = loggedUsersRepo.findByUsername(username);
			
			Users u = userRepo.getByUsernameAndPassword(username,password);
			
			if(Luser!=null && u!=null)
			{
				custRepo.deleteById(id);
				res.put("status", "true");
				res.put("data", "");
				res.put("desc", "Customer Deleted Successfully");
			}
			else if(u==null)
			{
				res.put("status", "false");
				res.put("data","");
				res.put("desc", "Password Wrong");
			}
			else
			{
				res.put("status", "false");
				res.put("data","");
				res.put("desc", "Login Again");
			}
		}catch (Exception e) {
			logger.info("Error at Customer Delete Service: "+e.getMessage());
			
			res = new JSONObject();
			res.put("status", "false");
			res.put("data","");
			res.put("desc", "Failed to Delete Customer");
		}
		logger.info("Customer Delete Api Response : "+res.toString());
		return res.toString();
	}

}
