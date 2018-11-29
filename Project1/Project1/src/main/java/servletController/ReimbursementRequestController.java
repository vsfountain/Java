package servletController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import reimbursement.ReimbursementManager;

public class ReimbursementRequestController{
	final static Logger logger = Logger.getLogger(ReimbursementRequestController.class);
	public static String sendRequest(HttpServletRequest req) {
		if(!req.getMethod().equals("GET")) {
			logger.warn("New reimbursement request sent as a POST Method");
			req.getSession().invalidate();
			return "index.html";
		}
		ReimbursementManager getDBInfo = new ReimbursementManager();
		String amount = req.getParameter("amount");
		String description = req.getParameter("description");

		String type = req.getParameter("type");
		String currUser = (String) req.getSession().getAttribute("loggedusername");
		
		int currUserId = Integer.parseInt(getDBInfo.getUsersId(currUser));
		double currAmount = 0.0;
		try {
			currAmount = Double.parseDouble(amount);
			getDBInfo.addReimbursementRequest(currAmount, description, type, currUserId);
		}catch(Exception e) {
			return "reimbursementRequestPage.html";
		}
		if(currAmount <= 0.0) {
			return "reimbursementRequestPage.html";
		}

		logger.info("Reimbursement request recieved by: " + 
				(String) req.getSession().getAttribute("loggedusername"));
		return "MainMenu.html";
	}
}
