package com.ErsReimbursement.controller;

import javax.servlet.http.HttpServletRequest;

public class RequestHelper {
	public static String process(HttpServletRequest req) {
		System.out.println(req.getRequestURI());
		switch (req.getRequestURI()) {
		case "ErsReimbursement/resources/html/ERSReimbursement.html":
			return LoginController.login(req);
		case "ErsReimbursement/resources/html/NEWReimbursement.html":
		}
		return LoginController.login(req);
		// default:
		// return "resources/html/unsuccessfullogin.html"; }

	}
}
