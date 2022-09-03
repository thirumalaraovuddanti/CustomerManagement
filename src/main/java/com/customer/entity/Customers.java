package com.customer.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CUSTOMER_DETAILS")
public class Customers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigDecimal id;
	private String customer_full_name;
	private String email;
	private String mobileno;
	private Date date_of_birth;
	private String address;
	private String zipcode;
	private String maker_username;
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	
	public String getCustomer_full_name() {
		return customer_full_name;
	}
	public void setCustomer_full_name(String customer_full_name) {
		this.customer_full_name = customer_full_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public String getMaker_username() {
		return maker_username;
	}
	public void setMaker_username(String maker_username) {
		this.maker_username = maker_username;
	}
	@Override
	public String toString() {
		return "Customers [id=" + id + ", customer_full_name=" + customer_full_name + ", email=" + email + ", mobileno="
				+ mobileno + ", date_of_birth=" + date_of_birth + ", address=" + address + ", zipcode=" + zipcode
				+ ", maker_username=" + maker_username + "]";
	}
	
	
    
	
	

}
