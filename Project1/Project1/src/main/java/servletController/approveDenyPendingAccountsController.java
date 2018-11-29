package servletController;

import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import pendingAccounts.PendingAccountsManager;
import reimbursement.ReimbursementManager;

public class approveDenyPendingAccountsController {
	final static Logger logger = Logger.getLogger(approveDenyPendingAccountsController.class);
	public static String approveAccount(HttpServletRequest req, char currAccount) {
		if(!req.getMethod().equals("GET")) {
			logger.warn("approveAccount sent as a POST request");
			req.getSession().invalidate();
			return "index.html";
		}

		PendingAccountsManager createAccount = new PendingAccountsManager();
		
		createAccount.insertNewActualAccount(
				req.getParameterValues("username")[Character.getNumericValue(currAccount)], 
				req.getParameterValues("password")[Character.getNumericValue(currAccount)],
				req.getParameterValues("firstname")[Character.getNumericValue(currAccount)],
				req.getParameterValues("lastname")[Character.getNumericValue(currAccount)],
				req.getParameterValues("email")[Character.getNumericValue(currAccount)],
				req.getParameterValues("role")[Character.getNumericValue(currAccount)]);
		createAccount.removePendingAccount(req.getParameterValues("username")[Character.getNumericValue(currAccount)]);
		logger.info("New account has been approved: " + 
				req.getParameterValues("username")[Character.getNumericValue(currAccount)]);
		return "managerMainMenu.html";
	}
	public static String denyAccount(HttpServletRequest req, char currAccount) {
		if(!req.getMethod().equals("GET")) {
			logger.warn("denyAccount sent as a POST Request");
			req.getSession().invalidate();
			return "index.html";
		}
		PendingAccountsManager removeAccount = new PendingAccountsManager();
		removeAccount.removePendingAccount(req.getParameterValues("username")[Character.getNumericValue(currAccount)]);
		logger.info("Pending account has been denied: " +
				req.getParameterValues("username")[Character.getNumericValue(currAccount)]);
		return "managerMainMenu.html";
	}
}
