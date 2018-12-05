package com.example.controller;

import javax.servlet.http.HttpServletRequest;

public class LoginController {
	public static String login(HttpServletRequest req) {
		if(!req.getMethod().equals("POST")) {
			return "index.html";
		}
		
		String username = req.getParameter("username");
		String password= req.getParameter("password");
		
		if(!(username.equals("mac") && password.equals("cheese"))) {
			return "index.html";
		}else {
			req.getSession().setAttribute("loggedusername", username);
			req.getSession().setAttribute("loggedpassword", password);
			
			return "/home.wumpus";
		}
	}
}
