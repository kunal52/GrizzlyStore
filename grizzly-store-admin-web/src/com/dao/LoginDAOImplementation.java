package com.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.mysql.jdbc.Connection;
import com.util.ConnectionManager;

public class LoginDAOImplementation implements LoginDAO {

	ConnectionManager connectionManager;
	java.sql.Connection connection;
	
	
	public LoginDAOImplementation() {
		connectionManager=new ConnectionManager();
	}


	@Override
	public boolean verifyUser(User user) {
		try {
			connection=connectionManager.connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		boolean isValidate=false;
		
		try {
			PreparedStatement prepareStatement = connection.prepareStatement("select * from users where username=? and password=?");
			prepareStatement.setString(1, user.getUsername());
			prepareStatement.setString(2, user.getPassword());
			
			ResultSet executeQuery = prepareStatement.executeQuery();
			if(executeQuery.next())
			{
				isValidate=true;
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			connectionManager.disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return isValidate;
	}


	@Override
	public void showLoginForm(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void logOut(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getSession().invalidate();
			response.sendRedirect("/grizzly-store-admin-web");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
