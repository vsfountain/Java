package com.example.controller;

/*import java.util.logging.Logger;*/

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.main.Main;
import com.example.model.ErsUser;
import com.example.service.ErsReimbursementService;
import com.example.service.ErsReimbursementServiceImpl;

import org.apache.log4j.Logger;

public class ApproveController {
	
	final static Logger logger = Logger.getLogger(ApproveController.class);

	public static String approve(HttpServletRequest req) {
		
		String reimbursementId = req.getParameter("recordId");
		
		HttpSession session = req.getSession();
		ErsUser ersUser = (ErsUser) session.getAttribute("adminUser");
		int adminUserId = ersUser.getUserId();
		ErsReimbursementService ersReimbursementService = new ErsReimbursementServiceImpl();
		int result = ersReimbursementService.approveReimbursement(Integer.parseInt(reimbursementId), adminUserId);
		logger.info("Reimbursement: " + reimbursementId + " has been approved.");
		return "resources/html/adminHomeLandingPage.html";
		
		
	}
	
	public static String disapprove(HttpServletRequest req) {
		
		String reimbursementId = req.getParameter("recordId");
		
		HttpSession session = req.getSession();
		ErsUser ersUser = (ErsUser) session.getAttribute("adminUser");
		int adminUserId = ersUser.getUserId();
		ErsReimbursementService ersReimbursementService = new ErsReimbursementServiceImpl();
		int result = ersReimbursementService.disapproveReimbursement(Integer.parseInt(reimbursementId), adminUserId);
		logger.info("Reimbursement: " + reimbursementId + " has been disapproved.");
		return "resources/html/adminHomeLandingPage.html";
		
		
	}
	
}
