package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Product;

public interface ProductService {
	
	void listProducts(HttpServletRequest request, HttpServletResponse response);
	void removeProduct(HttpServletRequest request, HttpServletResponse response);
	void addProducts(HttpServletRequest request, HttpServletResponse response);
}
