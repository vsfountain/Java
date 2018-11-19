package com.project1.controllers;

import javax.servlet.http.HttpServletRequest;

public class RequestHelper {
	public static String process(HttpServletRequest req) {
		//System.out.println(req.getRequestURI());
		return LoginController.login(req);
	}

}
