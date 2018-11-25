package com.project1.controllers;

import javax.servlet.http.HttpServletRequest;

import com.project1.objs.User;
import com.project1.service.UserService;
import com.project1.service.UserServiceImpl;

public class LoginController {
	private static UserService userService = new UserServiceImpl();

	public static String login(HttpServletRequest req) {
		if (!req.getMethod().equals("POST")) {
			 return "index.html"; 
		}
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		User user = userService.loginUser(username, password);
		if (user != null) {
			req.getSession().setAttribute("currentuser", user);
			if(user.getUserRoleId() == 2) {
				return "resources/html/fmaccount.html";
			}
			return "resources/html/employeeaccount.html";

		} else {
			return "resources/html/loginfail.html";
		}
	}

	public static String logout(HttpServletRequest req) {
		req.getSession().invalidate();
		System.out.println("in logout method");
		return "index.html";
	}
}
