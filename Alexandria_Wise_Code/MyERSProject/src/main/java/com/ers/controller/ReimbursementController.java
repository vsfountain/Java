package com.ers.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.model.Reimbursement;
import com.ers.model.ReimbursementServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReimbursementController {
	
	private static ReimbursementServiceImpl rServ = new ReimbursementServiceImpl();
	
	public static void insertReimbursement(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {
	
	}
	
	
	public static void selectReimbursementsByStatus(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {
		ArrayList<Reimbursement> myReimbList = rServ.filterByStatus(0);
		
		response.getWriter().write(new ObjectMapper().writeValueAsString(myReimbList));
	}
	
	

}
