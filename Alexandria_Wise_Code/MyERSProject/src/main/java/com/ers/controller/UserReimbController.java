package com.ers.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.Reimbursement;
import com.ers.model.ReimbursementService;
import com.ers.model.ReimbursementServiceImpl;
import com.ers.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserReimbController {
	private static ReimbursementService rServ = new ReimbursementServiceImpl();

	public static String getUserReimbursements(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {

		String userId = request.getParameter("ID");
		int result = Integer.parseInt(userId);
		
		//User myUser = (User) request.getSession().getAttribute("user");
		
		ArrayList<Reimbursement> myReimbList = rServ.filterByEmployee(result);
		String rlist = new ObjectMapper().writeValueAsString(myReimbList);
		
		return rlist;
	}
}
