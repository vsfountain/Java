package com.reimbsys.controller.html;

import javax.servlet.http.HttpServletRequest;

public class HomeController {
	

	public static String home(HttpServletRequest req) {
		
		//String username = (String) req.getSession().getAttribute("loggerusername");
		//User user = service.getUser(req.getSession().getAttribute("loggerusername"));
		
		System.out.println("in HomeController Controler: "+req.getSession().getAttribute("loggerusername"));
		String role = (String) req.getSession().getAttribute("loggerrole");
		
		//Map<String, Reimbursement> reimbs = new HashMap<>();
		
		System.out.println("in HomeController controller, role: "+role);
		
		if (role.equalsIgnoreCase("Admin")) {
			return "/resources/html/adminHome.html";
		} else {
			return "/resources/html/userHome.html";
		}
		
		//return "/resources/html/home.html";
	}
}
