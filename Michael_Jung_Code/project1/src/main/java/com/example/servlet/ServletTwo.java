package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controller.RequestHelper;
import com.example.model.ErsUser;
import com.example.service.ErsUsersService;
import com.example.service.ErsUsersServiceImpl;

public class ServletTwo extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
					throws ServletException, IOException {
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
					throws ServletException, IOException {
		
		
		/*ErsUser ersUser = null;
		ErsUsersService ersUsersService = new ErsUsersServiceImpl();
		ersUser = ersUsersService.getFinanceManager(req.getParameter("username"), req.getParameter("password"));
		System.out.println(ersUser);
		if(ersUser != null) {
			System.out.println("Login success!");
		} else {
			System.out.println("Wrong username and password");
		}*/
		try {
			req.getRequestDispatcher(RequestHelper.process(req, resp))
			.forward(req, resp);
		} catch(IllegalStateException e) {
			
		}
		
		/*System.out.println(req.getParameter("username"));
		System.out.println(req.getParameter("password"));*/
		
	}

}

