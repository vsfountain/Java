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

public class UpdateController {
	
private static ReimbursementService rServ = new ReimbursementServiceImpl();
	
	public static String approve(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException, ServletException {
		System.out.println("inside controller approve function");
		User myUser = (User) request.getSession().getAttribute("user");
		
		String statusId = request.getParameter("statusId");
		String reimbId = request.getParameter("reimbId");
		//String chooser = (String) request.getSession().getAttribute("chooser");
		int chooserId = Integer.parseInt(statusId);
		int reimbID = Integer.parseInt(reimbId);
		
		System.out.println("myUser = "+myUser);
		System.out.println("mychooserId = "+chooserId);
		
		rServ.approveOrDeny(reimbID, myUser.getUserId(), chooserId);
		request.getRequestDispatcher("manager.html").forward(request, response);

		return "manager.html";

	}
}
