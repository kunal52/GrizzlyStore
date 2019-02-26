package com.model;

public class User {
	
	String username;
	String password;
	String status;
	
	public User(){}
	
	public User(String username, String password) {
		
		this.username = username;
		this.password = password;
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
