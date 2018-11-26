package com.ers.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.ReimbursementService;
import com.ers.model.ReimbursementServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ReviewReimbController {

private static ReimbursementService rServ = new ReimbursementServiceImpl();
	
	public static String reviewReimb(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException, ServletException {
		
		
		
		
		return "manager.html";
	}
}