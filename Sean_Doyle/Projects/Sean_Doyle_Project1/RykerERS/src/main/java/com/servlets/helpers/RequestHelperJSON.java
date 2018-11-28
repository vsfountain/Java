package com.servlets.helpers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;

public class RequestHelperJSON {
	final static Logger logger = Logger.getLogger(RequestHelperJSON.class);
	public static String process(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, IOException, ServletException {
		//System.out.println("GET helper " + req.getRequestURI());
		
		logger.info("@process		INFO: using URI: "+ req.getRequestURI());
		switch (req.getRequestURI()) {
		case "/RykerERS/json/login.ryker":
			return LoginController.login(req, resp);
		case "/RykerERS/json/adminReimb.ryker":
			return ReimbursementController.getAll(req, resp);
		case "/RykerERS/json/adminReimbBlob.ryker":
			return ReimbursementController.getAllBlob(req, resp);
		case "/RykerERS/json/employeeReimb.ryker":
			return ReimbursementController.getByName(req, resp);
			default: 
				return "bad";
		}
		
	}
}
