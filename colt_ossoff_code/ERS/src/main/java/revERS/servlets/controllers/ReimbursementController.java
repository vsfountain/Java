package revERS.servlets.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;

import revERS.services.UserService;

public class ReimbursementController {
	public static Logger logger = Logger.getLogger(ReimbursementController.class);

	public static int add(HttpServletRequest req) throws JsonProcessingException {
		logger.info("In ReimbursementController.add()");
		return UserService.newReimbursement(Double.parseDouble(req.getParameter("amount")), req.getParameter("description"), Integer.parseInt(req.getParameter("id")), req.getParameter("type"));
	}
	public static int approve(int id, int uid, String role) {
		logger.info("In ReimbursementController.approve()");
		if (role.equalsIgnoreCase("Admin")) {
			logger.info("In Admin if");
			return UserService.approve(id, uid);
		}
		logger.warn("Not an Admin");
		return 0;
	}
	public static int deny(int id, int uid, String role) {
		logger.info("In ReimbursementController.deny()");
		if (role.equalsIgnoreCase("Admin")) {
			logger.info("In Admin if");
			return UserService.deny(id, uid);
		}
		logger.warn("Not an Admin");
		return 0;
	}
	public static String reimbursements() {
		logger.info("In ReimbursementController.reimbursements()");
		return UserService.getReimbursements();
	}
	public static String reimbursements(int id) {
		logger.info("In ReimbursementController.reimbursements(id)");
		return UserService.getUserReimbursements(id);
	}
}
