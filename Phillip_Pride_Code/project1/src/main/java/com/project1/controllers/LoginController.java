package com.project1.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.project1.objs.User;
import com.project1.service.UserService;
import com.project1.service.UserServiceImpl;

public class LoginController {
	private static UserService userService = new UserServiceImpl();
	final static Logger logger = Logger.getLogger(LoginController.class);

	public static String login(HttpServletRequest req) {
		req.getSession().invalidate();
		if (!req.getMethod().equals("POST")) {
			 return "index.html"; 
		}
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		User user = userService.loginUser(username, password);
		if (user != null) {
			req.getSession().setAttribute("currentuser", user);
			if(user.getUserRoleId() == 2) {
				logger.info(user.getFirstName() + " " + user.getLastName() + " has logged in.");
				return "resources/html/fmaccount.html";
			}
			logger.info(user.getFirstName() + " " + user.getLastName() + " has logged in.");
			return "resources/html/employeeaccount.html";

		} else {
			logger.warn("Login with incorrect credentials occurred");
			return "resources/html/loginfail.html";
		}
	}

	public static String logout(HttpServletRequest req) {
		logger.info("User has logged out.");
		req.getSession().invalidate();
		return "index.html";
	}
}
