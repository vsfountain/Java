package servletJSONController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import objects.ReimbursementObj;
import reimbursement.ReimbursementManager;

public class HomeJSONController {
	public static void reimbRequests(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		String currName = (String)(req.getSession().getAttribute("loggedusername"));
		resp.setContentType("application/json");
		ReimbursementManager getRequests = new ReimbursementManager();
		ArrayList<ReimbursementObj> allReimbursements = getRequests.getReimbursement(getRequests.getUsersId(currName));

		resp.getWriter().write(new ObjectMapper().writeValueAsString(allReimbursements));

	}
}
