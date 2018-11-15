package com.kers.controller;

import javax.servlet.http.HttpServletRequest;

public class RequestHelper {
	public static String process(HttpServletRequest req) {
		System.out.println(req.getRequestURI());

		switch(req.getRequestURI()) {
		case "/ExpenseReimbursementSystem/login.kers":
			return LoginController.login(req);
		case "/ExpenseReimbursementSystem/home.kers":
			return HomeController.home(req);
		default:
			return "resources/html/badlogin.html";
		}
	}
}
