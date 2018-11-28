package com.reimbsys.controller.html;

import javax.servlet.http.HttpServletRequest;

import com.reimbsys.service.UserService;
import com.reimbsys.service.UserServiceImpl;

public class LoginController {

	protected static UserService service = new UserServiceImpl();
	
	public static String login(HttpServletRequest req) {
		System.out.println("in loginController");
		
		if (!req.getMethod().equals("POST")) {
			return "index.html";
		} 
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username+", "+password);
		
		//if (!(username.equals("mac") && password.equals("cheese"))) {
		if (!service.authenticate(username, password)) {
			return "index.html";
		} else {
			//we need to set the role in the session so that for the home controller call
			String role = service.getRole(username);
			req.getSession().setAttribute("loggerusername", username);
			req.getSession().setAttribute("loggerpassword", password);
			req.getSession().setAttribute("loggerrole", role);
			//req.getSession().setAttribute"user", 
			return "/home.serf";
		}
	}
}
