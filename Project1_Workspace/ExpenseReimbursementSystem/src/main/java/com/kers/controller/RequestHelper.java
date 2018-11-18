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
	public static String process(HttpServletRequest req) throws JsonProcessingException, IOException {
		System.out.println(req.getRequestURI());

		switch (req.getRequestURI()) {
		case "/ExpenseReimbursementSystem/login.kers":
			return LoginController.login(req);
		case "/ExpenseReimbursementSystem/home.kers":
			return HomeController.processReimbursement(req);
		case "/ExpenseReimbursementSystem/update.kers":
			return ReimbursementController.alterReimbursements(req);
		default:
			return "resources/html/badlogin.html";
		}
	}

	public static void retrieve(HttpServletRequest req, HttpServletResponse resp)
			throws JsonProcessingException, IOException {
		System.out.println(req.getRequestURI());
		switch (req.getRequestURI()) {
		case "/ExpenseReimbursementSystem/home/home.html":
			ReimbursementController.getUser(req, resp);
			break;
	
		case "/ExpenseReimbursementSystem/home/ownreimb.html":
			ReimbursementController.getList(req, resp);
			break;

		default:
			break;
		}
	}

	public static void submitReimb(HttpServletRequest req, HttpServletResponse resp) {

	}
}
