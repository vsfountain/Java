package com.ErsReimbursement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	public static String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(req.getRequestURI());
		switch (req.getRequestURI()) {
		case "/ErsReimbursement/resources/html/login.ERSServlet":
			return LoginController.login(req,resp);
		case "/ErsReimbursement/resources/html/InsertReimbursement.ERSServlet":
		
			return HomeController.InsertReimbursement(req,resp);
default:
			return "/ErsReimbursement/resources/html/ErsReimbursement.html";
	}

}
}