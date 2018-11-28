package com.example.controller;

import javax.servlet.http.HttpServletRequest;

public class RequestHelper {
	public static String process(HttpServletRequest req) {
		System.out.println(req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/HelloFrontController/login.wumpus":
			return LoginController.login(req);
		case "/HelloFrontController/home.wumpus":
			return HomeController.home(req);
		default:
			return "resources/html/unsuccessfullogin.html";
		}
	}
}
