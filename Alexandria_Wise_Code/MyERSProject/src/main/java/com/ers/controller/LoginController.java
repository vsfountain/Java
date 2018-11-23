package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.model.User;
import com.ers.model.UserService;
import com.ers.model.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginController {
	private static UserService uServ = new UserServiceImpl();
	
	public static String login(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException { 
	
	    // String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User loggedUser = uServ.checkLogin(username, password);
		System.out.println("in login controller "+loggedUser);
		request.getSession().setAttribute("user", loggedUser);
		response.getWriter().write(new ObjectMapper().writeValueAsString(loggedUser));
		
		if (loggedUser == null) {
			//return "Username or Password incorrect";
			return "index.html";
		} else if (loggedUser.getRoleId() == 0) {
			//return "logged in as finance manager";
			return "manager.html";
		} else {
			//return "logged in as employee";
			return "employee.html";
		}   	
	}
}
