package servletJSONController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import reimbursement.ReimbursementManager;

public class HomeJSONNameController {
	public static void nameRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		String currName = (String)(req.getSession().getAttribute("loggedusername"));
		resp.setContentType("application/json");
		ReimbursementManager getRequests = new ReimbursementManager();
		String dbName = getRequests.getCurrFullName(currName);

		resp.getWriter().write(new ObjectMapper().writeValueAsString(dbName));
		System.out.println(resp);
	}
}
