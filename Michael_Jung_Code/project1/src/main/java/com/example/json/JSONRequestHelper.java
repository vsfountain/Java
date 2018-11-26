package com.example.json;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;

public class JSONRequestHelper {

	
	public static void process(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, IOException {
		
		System.out.println(req.getRequestURI());
		
		switch(req.getRequestURI()) {
		
		case "/Project1/adminHomeLandingPage/reimbursements.json.servletThree":
			System.out.println("SDFADSJIFOI");
			ReimbursementsController.getAllReimbursements(req, resp);
			break;
		
		default:
		}
		
	}
	
	
	
}
