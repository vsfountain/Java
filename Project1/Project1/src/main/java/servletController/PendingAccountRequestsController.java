package servletController;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import pendingAccounts.PendingAccountsManager;
import reimbursement.ReimbursementManager;

public class PendingAccountRequestsController {
	final static Logger logger = Logger.getLogger(PendingAccountRequestsController.class);
	
	public static String sendRequest(HttpServletRequest req) {
		if(!req.getMethod().equals("POST")) {
			logger.warn("Signing up for new account sent as GET Method");
			req.getSession().invalidate();
			return "index.html";
		}
		//System.out.println("Hello?");
		String currUsername = req.getParameter("username");
		String currPassword = req.getParameter("password");
		String currFirstname = req.getParameter("firstname");
		String currLastname = req.getParameter("lastname");
		String currEmail = req.getParameter("email");
		
		String currRole = "on";
		if(!currRole.equals(req.getParameter("role"))) {
			currRole = "off";
		}
		int role = 1;
		if(currRole.equals("on")) {
			role = 2;
		}
		PendingAccountsManager newPendingAccount = new PendingAccountsManager();
		newPendingAccount.addPendingAccount(currUsername, currPassword, currFirstname, currLastname, currEmail, role);
		
		logger.info("New account request recieved: " +
				req.getParameter("username"));
		req.getSession().invalidate();
		return "index.html";
	}
}
