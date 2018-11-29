package servletController;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import reimbursement.ReimbursementManager;

public class RequestHelper {
	final static Logger logger = Logger.getLogger(RequestHelper.class);
	public static String process(HttpServletRequest req) {

		String[] currSplit = req.getRequestURI().split("_");

		char currPendingAccount = '0';
		if(!req.getRequestURI().equals(currSplit[0])) { // Imbedded the index inside the URI, so split it twice and get the index
			currPendingAccount = currSplit[1].charAt(0);
		}
		switch(currSplit[0]) {
			case "/Project1/approvePending":
				return approveDenyPendingAccountsController.approveAccount(req, currPendingAccount);
			case "/Project1/denyPending":
				return approveDenyPendingAccountsController.denyAccount(req, currPendingAccount);
			case "/Project1/approveReimbursement":
				return approveDenyReimbursementsController.approveReimbursement(req, currPendingAccount);
			case "/Project1/denyReimbursement":
				return approveDenyReimbursementsController.denyReimbursement(req, currPendingAccount);
		}
		
		switch(req.getRequestURI()) {
		case "/Project1/login.helloRevature":
			return LoginController.login(req);
		case "/Project1/reimbursement.helloRevature":
			return ReimbursementRequestController.sendRequest(req);
		case "/Project1/pendingAccount.helloRevature":
			return PendingAccountRequestsController.sendRequest(req);
		default:
			logger.warn("Request helper called with invalid action name");
			req.getSession().invalidate();
			return "index.html";
		}
	}
}
