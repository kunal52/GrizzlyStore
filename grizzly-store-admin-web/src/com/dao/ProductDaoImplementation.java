package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Product;
import com.util.ConnectionManager;

public class ProductDaoImplementation implements ProductDao {

	ConnectionManager connectionManager;
	Connection connection;
	
	
	public ProductDaoImplementation() {
		connectionManager=new ConnectionManager();
	}

	@Override
	public List<Product> getProducts() {
		List<Product>products=new ArrayList<>();
		String sql="select * from products";
		try {
			connection=connectionManager.connect();
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet executeQuery = prepareStatement.executeQuery();
			
			while(executeQuery.next())
			{
				Product product=new Product();
				product.setId(executeQuery.getInt(1));
				product.setName(executeQuery.getString(2));
				product.setCategory(executeQuery.getString(3));
				product.setDescription(executeQuery.getString(4));
				product.setPrice(executeQuery.getInt(5));
				products.add(product);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connectionManager.disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public int addProduct(Product product) {
		System.out.println(product.toString());
		int executeUpdate=0;
		try {
			connection=connectionManager.connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="INSERT INTO `products` (`name`, `category`, `description`, `price`) VALUES (?,?,?,?)";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getCategory());
			preparedStatement.setString(3, product.getDescription());
			preparedStatement.setInt(4, product.getPrice());
			
		    executeUpdate = preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connectionManager.disconnect();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return executeUpdate;
	}

	@Override
	public void removeProduct(int id) {
		try {
			connection=connectionManager.connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="delete from products where id = ?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
