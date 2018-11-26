package com.ers.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.helper.RequestHelper;
import com.ers.model.Reimbursement;
import com.ers.model.ReimbursementService;
import com.ers.model.ReimbursementServiceImpl;
import com.ers.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;

public class NewReimbController {
	private static ReimbursementService rServ = new ReimbursementServiceImpl();
	
	public static String createNewReimb(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException, ServletException {
		System.out.println("In NewReimbController " +request.getRequestURI());
		String type = request.getParameter("type");
		String amount = request.getParameter("amount");
		String desc = request.getParameter("desc");
		
		System.out.println("Paramters gotten: "+type+" "+amount+" "+desc);
		
		int typeId = Integer.parseInt(type);
		Double numAmount = Double.parseDouble(amount);
	
		System.out.println("Paramters after parse: "+typeId+" "+numAmount+" "+desc);
		
		User myUser = (User) request.getSession().getAttribute("user");
		System.out.println(request.getRequestURI());
		rServ.createReimbursement(numAmount, desc, new Timestamp(System.currentTimeMillis()), myUser.getUserId(),
															0, typeId);
		System.out.println(request.getRequestURI());
		request.getRequestDispatcher("employee.html").forward(request, response);
		return "employee.html";
	}
}
