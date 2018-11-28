
package com.servlets.helpers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;


public class RequestHelperAction {
	final static Logger logger = Logger.getLogger(RequestHelperAction.class);
	
	public static String process(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, IOException, ServletException {
		System.out.println("POST HELPER: " + req.getRequestURI());
		
		logger.info("@process		INFO: using URI: "+ req.getRequestURI());
		switch (req.getRequestURI()) {
		case "/RykerERS/action/addreimb.ryker":
			return ReimbursementController.add(req, resp);
		case "/RykerERS/action/updatereimbs.ryker":
			return ReimbursementController.updateById(req, resp);
		case "/RykerERS/action/logout.ryker":
			return LoginController.logout(req, resp);
		default:
			return "Bad Action";
		}
	}
}
