package com.kers.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kers.daos.ReimbursementDAO;
import com.kers.daos.ReimbursementDAOImpl;
import com.kers.daos.UserDAO;
import com.kers.daos.UserDAOImpl;
import com.kers.models.Reimbursement;
import com.kers.models.User;
import com.kers.services.ReimbursementService;
import com.kers.services.ReimbursementServiceImpl;
import com.kers.services.UserService;
import com.kers.services.UserServiceImpl;

public class ReimbursementController {
	
	final static Logger logger = Logger.getLogger(ReimbursementController.class);
	
	private static ReimbursementService rService = new ReimbursementServiceImpl();
	private static UserService uService = new UserServiceImpl();

	public static void getUser(HttpServletRequest req, HttpServletResponse resp)
			throws JsonProcessingException, IOException {
		logger.info("GetUser");
		User u = (User) req.getSession().getAttribute("user");
		resp.getWriter().write(new ObjectMapper().writeValueAsString(u));
	}

	public static void getList(HttpServletRequest req, HttpServletResponse resp)
			throws JsonProcessingException, IOException {
		User u = (User) req.getSession().getAttribute("user");

		logger.info("GetList for " + u.getUsername());
		
		List<Reimbursement> rList = rService.getAllReimbursements();
		System.out.println("RLIST: " + rList);
		// System.out.println("requesthelper retrieve rLIST: " + rList);
		if (u.getRole().equals("Admin")) {
			resp.getWriter().write(new ObjectMapper().writeValueAsString(rList));
		} else {
			List<Reimbursement> uRList = new ArrayList<Reimbursement>();
			for (Reimbursement r : rList) {
				if (r.getAuthor().equals(u.getUsername())) {
					uRList.add(r);
				}
			}
			resp.getWriter().write(new ObjectMapper().writeValueAsString(uRList));
		}
	}

	public static String alterReimbursements(HttpServletRequest req) throws JsonProcessingException, IOException {
		
		
		
		String[] checkedValues = req.getParameterValues("selectedRow");
		System.out.println("Arrays toString: " + Arrays.toString(checkedValues));
		String resolver = ((User) req.getSession().getAttribute("user")).getUsername();

		logger.info("AlterReimbursement done by: " + resolver);
		
		String decision = req.getParameter("submit");
		for (String values : checkedValues) {
			rService.updateReimbursementById(Integer.parseInt(values), decision, resolver);
		}
		return "adminviewpending.html";
	}
}
