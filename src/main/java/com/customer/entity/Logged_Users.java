package com.customer.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_LOGGED_USERS")
public class Logged_Users {
	
	 @Id
	 private String username;
	 private Date datestamp;
	 
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDatestamp() {
		return datestamp;
	}
	public void setDatestamp(Date datestamp) {
		this.datestamp = datestamp;
	}
	@Override
	public String toString() {
		return "Logged_Users [username=" + username + ", datestamp=" + datestamp + "]";
	}
	
	 
	 

}
