package com.kers.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.kers.models.User;
import com.kers.services.UserService;
import com.kers.services.UserServiceImpl;

public class LoginController {

	final static Logger logger = Logger.getLogger(LoginController.class);
	private static UserService uService = new UserServiceImpl();

	public static String login(HttpServletRequest req) {
		if (!req.getMethod().equals("POST")) {
			return "index.html";
		}
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		logger.info("User tried to log in with: " + username + " " + password);
		
		User u = uService.getUserbyUsernameAndPassword(username, password);

		if (u == null) {
			return "index.html";
		} else if (u.getRole().equals("Admin")) {
			logger.info("Admin " + u.getUsername() + " logged in.");
			req.getSession().setAttribute("user", u);
			System.out.println("user in logincontroller: " + u);
			return "adminhome.html";
		} else {
			logger.info("Employee " + u.getUsername() + " logged in.");
			req.getSession().setAttribute("user", u);
			return "employeehome.html";
		}
	}
}
