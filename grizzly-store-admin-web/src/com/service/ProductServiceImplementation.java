package com.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.dao.ProductDaoImplementation;
import com.model.Product;

public class ProductServiceImplementation implements ProductService {

	
	ProductDao product;
	public ProductServiceImplementation() {
		product=new ProductDaoImplementation();
	}
	
	@Override
	public void listProducts(HttpServletRequest request, HttpServletResponse response) {
		
		
		if(request.getSession(false)==null)
		{
			try {
				response.sendRedirect("/grizzly-store-admin-web");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		List<Product> products = product.getProducts();
		request.setAttribute("productlist", products);
		try {
			request.getRequestDispatcher("products.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void addProducts(HttpServletRequest request, HttpServletResponse response) {
		
		String name = request.getParameter("name");
		String category=request.getParameter("category");
		String description=request.getParameter("description");
		int price=(int) Float.parseFloat(request.getParameter("price"));
		
		System.out.println(name);
		
		product.addProduct(new Product(name,category,description,price));
		listProducts(request, response);
		
	}

	@Override
	public void removeProduct(HttpServletRequest request, HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		product.removeProduct(id);
		listProducts(request, response);
		
	}

	

	
}
