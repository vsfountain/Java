package com.reimbsys.controller.html;

import javax.servlet.http.HttpServletRequest;

public class LogoutController {
	
	public static String logout(HttpServletRequest req) {
		System.out.println("in logoutController");
		
		System.out.println(req.getRequestURI());
		
		req.getSession().invalidate();
		
		//try checking the request URI
		if (req.getRequestURI().contains("resources")) {
			return "../../index.html";
		} else {
			return "index.html";
		}
	}
	
}
