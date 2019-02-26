package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private final String username="root";
	private final String password="root";
	private final String driver="com.mysql.jdbc.Driver";
	private final String url="jdbc:mysql://localhost:3306/grizzlystore?useSSL=false" ;
	
	private Connection connection;

	public java.sql.Connection connect() throws SQLException {
		
		if(connection==null||connection.isClosed())
		{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
		}
		connection= DriverManager.getConnection(url,username,password);
		}
		return connection;
	}
	
	public void disconnect() throws SQLException
	{
		if(connection!=null||!connection.isClosed())
		{
			connection.close();
		}
	}
	
	
	
}
