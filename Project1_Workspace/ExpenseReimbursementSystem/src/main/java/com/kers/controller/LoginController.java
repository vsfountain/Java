package com.kers.controller;

import javax.servlet.http.HttpServletRequest;

import com.kers.daos.UserDAO;
import com.kers.daos.UserDAOImpl;
import com.kers.models.User;

public class LoginController {

	static UserDAO userD = new UserDAOImpl();

	public static String login(HttpServletRequest req) {
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		if (!req.getMethod().equals("POST")) {
			return "index.html";
		}
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User u = userD.selectUserByUsernameAndPassword(username, password);

		if (u == null) {
			return "index.html";
			//return "badlogin.html";
		} else {
			//req.getSession().setAttribute("loggedusername", username);
			//req.getSession().setAttribute("loggedpassword", password);
			req.getSession().setAttribute("user", u);
			System.out.println("user in logincontroller: " + u);
			return "home.html";
			// return "badlogin.html";
		}
	}
}
