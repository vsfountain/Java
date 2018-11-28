package com.reimbsys.controller.html;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


public class RequestHelper {
	
	public static String process(HttpServletRequest req) throws IOException, ServletException {
		System.out.println(req.getRequestURI());
		 
		switch(req.getRequestURI()) {
		case "/ExReimbSys/login.serf":
		case "/ExReimbSys/resources/html/login.serf":
			return LoginController.login(req);
		case "/ExReimbSys/home.serf":
		case "/ExReimbSys/resources/html/home.serf":
			return HomeController.home(req);
		case "/ExReimbSys/logout.serf":
		case "/ExReimbSys/resources/html/logout.serf":
			return LogoutController.logout(req);
		default:
			return "resources/html/unseccessfullogin.html";
		}
		
		//return "resources/html/unseccessfullogin.html";
	}
}
