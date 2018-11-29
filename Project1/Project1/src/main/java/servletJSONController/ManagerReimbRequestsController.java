package servletJSONController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import objects.ReimbursementObj;
import objects.UserObj;
import pendingAccounts.PendingAccountsManager;
import reimbursement.ReimbursementManager;

public class ManagerReimbRequestsController {
	public static void handleRequests(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		resp.setContentType("application/json");
		ReimbursementManager getReimbursements = new ReimbursementManager();
		ArrayList<ReimbursementObj> allReimbursements = getReimbursements.getReimbursement();
		resp.getWriter().write(new ObjectMapper().writeValueAsString(allReimbursements));
	}
}
