package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dao.LoginDAO;
import com.dao.LoginDAOImplementation;
import com.model.User;


@WebFilter("/ProductController")
public class LoginFilter implements Filter {

    public LoginFilter() {
        
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		LoginDAO loginDAO=new LoginDAOImplementation();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		boolean verifyUser = loginDAO.verifyUser(new User(username,password));
		
		HttpServletRequest http=(HttpServletRequest) request;
		HttpSession session = http.getSession();
		
		if(verifyUser)
		{
			chain.doFilter(request, response);
		}
			
		else
		{
			int i=session.getAttribute("login_attempt")==null?1:(int)session.getAttribute("login_attempt");
			System.out.println(i);
			session.setAttribute("login_attempt",++i);
			if(i==3)
			{
				System.out.println("Account Blocked");
				session.invalidate();
			}
			
			request.getRequestDispatcher("/").forward(request, response);
		}
			
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
