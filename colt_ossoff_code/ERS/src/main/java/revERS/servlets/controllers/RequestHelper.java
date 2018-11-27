package revERS.servlets.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;

public class RequestHelper {
	public static Logger logger = Logger.getLogger(RequestHelper.class);
	public static String process(HttpServletRequest req, HttpServletResponse resp) {
		logger.info(req.getRequestURI());

		switch (req.getRequestURI()) {
		case "/ERS/login.ers":
			try {
				logger.info("In login.ers");
				return LoginController.login(req);
			} catch (JsonProcessingException e) {
				logger.error("JsonProcessingException in login.ers", e);
			}
		case "/ERS/allreimb.json":
			logger.info("In allreimb.json");
			return ReimbursementController.reimbursements();
		case "/ERS/userreimb.json":
			logger.info("In userreimb.json");
			return ReimbursementController.reimbursements(Integer.parseInt(req.getParameter("id")));
		case "/ERS/approve.json":
			logger.info("approve.json");
			return "{ \"return\": " + ReimbursementController.approve(Integer.parseInt(req.getParameter("rid")), Integer.parseInt(req.getParameter("uid")), req.getParameter("role")) + " }";
		case "/ERS/deny.json":
			logger.info("In deny.json");
			return "{ \"return\": " + ReimbursementController.deny(Integer.parseInt(req.getParameter("rid")), Integer.parseInt(req.getParameter("uid")), req.getParameter("role")) + " }";
		case "/ERS/add.json":
			try {
				logger.info("In add.json");
				return "{ \"return\": " + ReimbursementController.add(req) + " }";
			} catch (JsonProcessingException e) {
				logger.error("JsonProcessingException in add.json", e);
			}
		case "/ERS/logout.ers":
			logger.info("In logout.ers");
			req.getSession().invalidate();
			logger.warn("Session invalidated");
			try {
				resp.sendRedirect("index.html");
				logger.info("Redirecting to the home page");
			} catch (IOException e) {
				logger.error("IOException in logout", e);
			}
			return "{ \"return\": 1 }";
		default:
			logger.error("You\'re a special kind of genius to get the default case, aint\'cha.");
			return "{ \"return\": 0 }";
		}
	}
}
