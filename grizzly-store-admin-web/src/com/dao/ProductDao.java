package com.dao;

import java.util.List;

import com.model.Product;

public interface ProductDao {
	
	List<Product>getProducts();
	int addProduct(Product product);
	void removeProduct(int id);
	
}
