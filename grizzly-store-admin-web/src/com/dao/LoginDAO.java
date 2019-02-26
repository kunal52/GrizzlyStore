package com.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;

public interface LoginDAO {
	
	boolean verifyUser(User user);
	void showLoginForm(HttpServletRequest request, HttpServletResponse response);
	void logOut(HttpServletRequest request, HttpServletResponse response);
	
}
