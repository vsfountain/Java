package com.ers.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.Reimbursement;
import com.ers.model.ReimbursementService;
import com.ers.model.ReimbursementServiceImpl;
import com.ers.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;

public class NewReimbController {
	private static ReimbursementService rServ = new ReimbursementServiceImpl();
	
	public static void createNewReimb(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {

		String type = request.getParameter("type");
		String amount = request.getParameter("amount");
		String desc = request.getParameter("desc");
		
		int typeId = Integer.parseInt(type);
		int numAmount = Integer.parseInt(amount);
	
		User myUser = (User) request.getSession().getAttribute("user");

		rServ.createReimbursement(numAmount, new Timestamp(System.currentTimeMillis()), myUser.getUserId(),
															0, typeId);
	}
}
