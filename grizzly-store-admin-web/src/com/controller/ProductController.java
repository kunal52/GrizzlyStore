package com.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDAO;
import com.dao.LoginDAOImplementation;
import com.dao.ProductDao;
import com.dao.ProductDaoImplementation;
import com.model.Product;
import com.model.User;
import com.service.ProductService;
import com.service.ProductServiceImplementation;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	ProductService productService;
	
    public ProductController() {
       
        // TODO Auto-generated constructor stub
    }

   @Override
public void init() throws ServletException {
	// TODO Auto-generated method stub
	super.init();
	productService=new ProductServiceImplementation();
}
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("LoginServlet");
		String s=request.getServletPath();
		System.out.println(s);
		switch (s) {
		case "/ProductController":
			productService.listProducts(request,response);
			break;
		case "/remove":
			productService.removeProduct(request, response);
			break;
		case "/add":
			productService.addProducts(request, response);
			break;
		
		default:
			break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*HttpSession session = request.getSession();
		session.setAttribute("username", request.getParameter("username"));
		System.out.println(request.getSession().getId());*/
		
		doGet(request, response);
		
		
		
	}

}
