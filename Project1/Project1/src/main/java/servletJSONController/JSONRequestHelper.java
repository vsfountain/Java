package servletJSONController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import servletJSONController.HomeJSONController;
import com.fasterxml.jackson.databind.ObjectMapper;

import reimbursement.ReimbursementManager;

public class JSONRequestHelper {
	final static Logger logger = Logger.getLogger(JSONRequestHelper.class);
	
	public static void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		System.out.println(req.getRequestURI());
		switch(req.getRequestURI()) {
			case "/Project1/home.json":
				HomeJSONController.reimbRequests(req, resp);
				break;
			case "/Project1/name.json":
				HomeJSONNameController.nameRequest(req, resp);
				break;
			case "/Project1/managerHome.json":
				ManagerHomeJSONController.pendingAccounts(req, resp);
				break;
			case "/Project1/managerReimbRequests.json":
				ManagerReimbRequestsController.handleRequests(req, resp);
				break;
			default:
				logger.warn("Invalid json action name");

		}
	}
}
