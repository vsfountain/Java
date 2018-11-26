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

public class StatusReimbController {
	private static ReimbursementService rServ = new ReimbursementServiceImpl();

	public static void getReimbursementsByStatus(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {
		
		String status = request.getParameter("status");
		
		int statusId = Integer.parseInt(status);
		
		ArrayList<Reimbursement> myReimbList = rServ.filterByStatus(statusId);
		
		response.getWriter().write(new ObjectMapper().writeValueAsString(myReimbList));
	
	}
	
}
