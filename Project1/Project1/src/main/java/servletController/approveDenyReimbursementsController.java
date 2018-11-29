package servletController;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import pendingAccounts.PendingAccountsManager;
import reimbursement.ReimbursementManager;

public class approveDenyReimbursementsController {
	final static Logger logger = Logger.getLogger(approveDenyReimbursementsController.class);
	public static String approveReimbursement(HttpServletRequest req, char currReimbursement) {
		if(!req.getMethod().equals("GET")) {
			logger.warn("approveDenyReimbursements sent as a POST request");
			req.getSession().invalidate();
			return "index.html";
		}

		ReimbursementManager approveReimbursement = new ReimbursementManager();

		String currAdminID = approveReimbursement.getUsersId((String)(req.getSession().getAttribute("loggedusername")));
		
		approveReimbursement.approveDenyReimbursement("2", currAdminID, 
				req.getParameterValues("reimbID")[Character.getNumericValue(currReimbursement)]);
		logger.info("Reimbursement approved. ID: " + 
				req.getParameterValues("reimbID")[Character.getNumericValue(currReimbursement)]);
		return "viewPendingReimbursements.html";
	}
	public static String denyReimbursement(HttpServletRequest req, char currReimbursement) {
		if(!req.getMethod().equals("GET")) {
			logger.warn("denyReimbursment sent as a POST Request.");
			req.getSession().invalidate();
			return "index.html";
		}
		ReimbursementManager approveReimbursement = new ReimbursementManager();
		String currAdminID = approveReimbursement.getUsersId((String)(req.getSession().getAttribute("loggedusername")));
		approveReimbursement.approveDenyReimbursement("3", currAdminID, 
				req.getParameterValues("reimbID")[Character.getNumericValue(currReimbursement)]);
		logger.info("Reimbursement denied. ID: " +
				req.getParameterValues("reimbID")[Character.getNumericValue(currReimbursement)]);
		return "viewPendingReimbursements.html";
	}
}
