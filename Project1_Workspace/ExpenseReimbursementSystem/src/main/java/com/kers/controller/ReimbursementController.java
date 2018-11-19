package com.kers.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kers.daos.ReimbursementDAO;
import com.kers.daos.ReimbursementDAOImpl;
import com.kers.daos.UserDAO;
import com.kers.daos.UserDAOImpl;
import com.kers.models.Reimbursement;
import com.kers.models.User;

public class ReimbursementController {
	private static ReimbursementDAO rdao = new ReimbursementDAOImpl();
	private static UserDAO udao = new UserDAOImpl();

	public static void getUser(HttpServletRequest req, HttpServletResponse resp)
			throws JsonProcessingException, IOException {
		User u = (User) req.getSession().getAttribute("user");
		resp.getWriter().write(new ObjectMapper().writeValueAsString(u));
	}

	public static void getList(HttpServletRequest req, HttpServletResponse resp)
			throws JsonProcessingException, IOException {
		List<Reimbursement> rList = rdao.selectAllReimbursements();
		System.out.println("requesthelper retrieve rLIST: " + rList);
		resp.getWriter().write(new ObjectMapper().writeValueAsString(rList));
	}

	public static String alterReimbursements(HttpServletRequest req) throws JsonProcessingException, IOException {
		String[] checkedValues = req.getParameterValues("selectedRow");
		System.out.println("Arrays toString: " + Arrays.toString(checkedValues));
		String resolver = ((User)req.getSession().getAttribute("user")).getUsername();
		
		System.out.println("RESOLVER: " + resolver);
		//int resolverid = udao.selectUserByUsername(resolver).get;
		String decision = req.getParameter("submit");
		System.out.println();
		// System.out.println("CHECKED VALUES: " + checkedValues[0]);
		for (String values : checkedValues) {
			rdao.updateReimbursementById(Integer.parseInt(values), decision, resolver);
		}
		return "ownreimb.html";
	}
}
