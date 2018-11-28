package com.dikokosolutions.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dikokosolutions.dao.ReimbursementDao;
import com.dikokosolutions.model.Reimbursement;
import com.dikokosolutions.model.User;
import com.dikokosolutions.service.ReimbursementServiceImpl;
import com.dikokosolutions.service.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

public class ReimbursementController {
	public static ReimbursementServiceImpl reimControl = new ReimbursementServiceImpl();
	public static UserServiceImpl userControl = new UserServiceImpl();

	public static void getUserReimbursementInfo(HttpServletRequest req, HttpServletResponse resp)
			throws JsonProcessingException, IOException {
		ArrayList<Reimbursement> rc = new ArrayList<>();
		String username = (String) req.getSession().getAttribute("loggedUsername");
		System.out.println(username);
		System.out.println("We are in the user Reimbursement Controller");
		if (username.equals("trevinchester")) {
			rc = reimControl.getAllReimbursements();
			System.out.println("we are in the manager RC");
			System.out.println(rc);
			resp.setContentType("application/json");
			String json = new Gson().toJson(rc);
			PrintWriter writer = resp.getWriter();
			writer.write(json);
			writer.close();
		} else {
			rc = reimControl.getUserReimbursement(username);
			resp.setContentType("application/json");
			String json = new Gson().toJson(rc);
			PrintWriter writer = resp.getWriter();
			writer.write(json);
			writer.close();
		}

		// if(rc.containsValue("41")))System.out.println(rc.keySet());

	}

	public static String submitReimbursement(HttpServletRequest req) throws SQLException {
		try {
			Double amount = Double.parseDouble(req.getParameter("amount"));
			String description = req.getParameter("description");
			String type = req.getParameter("type");
			int type_id = 0;
			if (type.equals("Lodging")) {
				type_id = 1;
			}
			if (type.equals("Travel")) {
				type_id = 2;
			}
			if (type.equals("Food")) {
				type_id = 3;
			}
			if (type.equals("Other")) {
				type_id = 4;
			}

			String username = (String) req.getSession().getAttribute("loggedUsername");
			String password = (String) req.getSession().getAttribute("loggedPassword");
			ReimbursementDao rd = new ReimbursementDao();
			User createReimbUser = userControl.authenticate(username, password);
			rd.createReimbursement(amount, createReimbUser.userId, 1, type_id, description);
			return "resources/html/home.html";
		} catch (NullPointerException n) {
			System.out.println("There were no values in dat");
		}
		return "home.serv";
	}

	public static String approveReimbursement(HttpServletRequest req) throws SQLException {
		System.out.println("we are in the approve");
		ReimbursementDao rd = new ReimbursementDao();
		int reim_id = Integer.parseInt(req.getParameter("reim_id"));
		System.out.println(reim_id);
		String username = (String) req.getSession().getAttribute("loggedUsername");
		String password = (String) req.getSession().getAttribute("loggedPassword");

		User updateReimbUser = userControl.authenticate(username, password);
		rd.approveReimBursement(reim_id, 2, updateReimbUser.getUserId());
		return "resources/html/managerhome.html";
	}

	public static String denyReimbursement(HttpServletRequest req) {
		System.out.println("we are in the deny");
		ReimbursementDao rd = new ReimbursementDao();
		int reim_id = Integer.parseInt(req.getParameter("reim_id"));
		String username = (String) req.getSession().getAttribute("loggedUsername");
		String password = (String) req.getSession().getAttribute("loggedPassword");

		User updateReimbUser = userControl.authenticate(username, password);
		rd.approveReimBursement(reim_id, 3, updateReimbUser.getUserId());
		return "resources/html/managerhome.html";
	}
}
