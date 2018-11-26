package com.ers.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.Reimbursement;
import com.ers.model.ReimbursementService;
import com.ers.model.ReimbursementServiceImpl;
import com.ers.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ApproveController {
	
private static ReimbursementService rServ = new ReimbursementServiceImpl();
	
	public static String approve(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException, ServletException {

		User myUser = (User) request.getSession().getAttribute("user");
		Reimbursement myReimbursement = (Reimbursement) request.getSession().getAttribute("reimb");
		
		rServ.approveOrDeny(myReimbursement.getrId(), myUser.getUserId(), 1);
		request.getRequestDispatcher("manager.html").forward(request, response);

		return "manager.html";

	}
}
