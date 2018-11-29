package jasonServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import reimbursement.ReimbursementManager;
import servletJSONController.JSONRequestHelper;

public class MasterJSONServlet extends HttpServlet{
	final static Logger logger = Logger.getLogger(MasterJSONServlet.class);
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("JSON GET Request Recieved.");
		JSONRequestHelper.process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("JSON POST Request Recieved.");
		doGet(request, response);
	}
}
