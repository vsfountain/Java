package com.ErsReimbursement.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;

public class RequestHelper {
	public static String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(req.getRequestURI());
		switch (req.getRequestURI()) {
		case "/ErsReimbursement/resources/html/login.ERSServlet":
			return LoginController.login(req,resp);
		case "/ErsReimbursement/resources/html/InsertReimbursement.ERSServlet":
			System.out.println("Hello");
			return ReimbursementController.InsertReimbursement(req,resp);
//		case "/ErsReimbursement/resources/htm/NewReimbursement.ERSServlet":
			//System.out.println("Hello");
			//return LoginController.Signout(req,resp);
//			return ErsReimbursement/resources/html/pendingrequest.html;
		case "/ErsReimbursement/resources/html/viewReimbursement.ERSServlet":
			System.out.println("Hello");
			return LoginController.Signout(req,resp);
		case "/ErsReimbursement/resources/html/urlForLogoutController.ERSServlet":
			System.out.println("Hello");
			return "Signout.html";			
		case "/ErsReimbursement/resources/html/updateapprovedReimbursement.ERSServlet":
			try {
			return ReimbursementController.updateapprovedReimbursementByStatusIdForManager(req, resp);
			}catch(JsonProcessingException e) {
				
			}catch(IOException e) {
				
			}
		case "/ErsReimbursement/resources/html/updatedeclinedReimbursement.ERSServlet":
			try {
			return ReimbursementController.updatedeclinedReimbursementByStatusIdForManager(req, resp);
			}catch(JsonProcessingException e) {
				
			}catch(IOException e) {
				
			}
			
		default:
			return "/ErsReimbursement/resources/html/ErsReimbursement.html";
	}

}
}
