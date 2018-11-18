package com.kers.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kers.models.User;

public class RequestHelper {
	public static String process(HttpServletRequest req) {
		System.out.println(req.getRequestURI());

		switch(req.getRequestURI()) {
		case "/ExpenseReimbursementSystem/login.kers":
			return LoginController.login(req);
		case "/ExpenseReimbursementSystem/home.kers":
			return HomeController.processReimbursement(req);
		default:
			return "resources/html/badlogin.html";
		}
	}
	
	public static void retrieve(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, IOException {
		User u = (User)req.getSession().getAttribute("user");
		System.out.println("retrieve" + u);
		resp.getWriter().write(new ObjectMapper().writeValueAsString(u));
	}
	
	public static void submitReimb(HttpServletRequest req, HttpServletResponse resp) {
		
	}
}
