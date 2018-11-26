package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public static String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/Project1/login.servletTwo":
				return LoginController.login(req, resp);
		case "/Project1/approve.servletTwo":
				return ApproveController.approve(req);
		case "/Project1/decline.servletTwo":
				return ApproveController.disapprove(req);
		case "/Project1/logout.servletTwo":
				return LoginController.logout(req);
		case "/Project1/reimbursementApplication.servletTwo":
				return ApplicationController.land(req);
		case "/Project1/employeeLogout.servletTwo":
				return LoginController.employeeLogout(req);
		case "/Project1/backToLand.servletTwo":
				return ApplicationController.backToLand(req, resp);
		case "/Project1/submitApplication.servletTwo":
				return ApplicationController.submitApplication(req);
		default:
				return "resources/html/unsuccessfullogin.html";
		
		
		}
	}
	
}
