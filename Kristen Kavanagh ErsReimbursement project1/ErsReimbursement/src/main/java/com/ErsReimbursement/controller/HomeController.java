package com.ErsReimbursement.controller;

import javax.servlet.http.HttpServletRequest;

public class HomeController {

	public static String home(HttpServletRequest req) {
		return "resources/html/ERSReimbursement.html";
				
	}
		

}
