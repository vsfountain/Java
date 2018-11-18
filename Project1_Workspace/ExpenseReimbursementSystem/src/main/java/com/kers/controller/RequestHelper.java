package com.kers.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kers.models.Reimbursement;
import com.kers.models.User;

public class RequestHelper {
	public static String process(HttpServletRequest req) {
		System.out.println(req.getRequestURI());

		switch (req.getRequestURI()) {
		case "/ExpenseReimbursementSystem/login.kers":
			return LoginController.login(req);
		case "/ExpenseReimbursementSystem/home.kers":
			return HomeController.processReimbursement(req);
		default:
			return "resources/html/badlogin.html";
		}
	}

	public static void retrieve(HttpServletRequest req, HttpServletResponse resp)
			throws JsonProcessingException, IOException {
		System.out.println(req.getRequestURI());
		switch (req.getRequestURI()) {
		case "/ExpenseReimbursementSystem/home/home.html":
			User u = (User) req.getSession().getAttribute("user");
			resp.getWriter().write(new ObjectMapper().writeValueAsString(u));
			break;
	
		case "/ExpenseReimbursementSystem/home/ownreimb.html":
			@SuppressWarnings("unchecked") 
			List<Reimbursement> rList = (List<Reimbursement>) req.getSession().getAttribute("reimbursementlist");
			System.out.println("requesthelper retrieve rLIST: " + rList);
			resp.getWriter().write(new ObjectMapper().writeValueAsString(rList));
			break;

		default:
			break;
		}
	}

	public static void submitReimb(HttpServletRequest req, HttpServletResponse resp) {

	}
}
