package com.project1.controllers;

import javax.servlet.http.HttpServletRequest;

public class RequestHelper {
	public static String process(HttpServletRequest req) {
		//System.out.println(req.getRequestURI());
		switch (req.getRequestURI()) {
		case "/project1/resources/html/reimb.insert":
			return ReimbursementController.insert(req);
		case "/project1/resources/html/process.insert":
			return ReimbursementController.process(req);
		case "/project1/user.login":
		return LoginController.login(req);
		case "/project1/exit.login":
			return LoginController.logout(req);
		default:
			return "";
		}
	}

}
