package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.servlets.helpers.RequestHelperAction;

//@WebServlet(name = "FileUploadServlet", urlPatterns = {"/upload"})
@MultipartConfig
public class MasterServletAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(MasterServletAction.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*logger.info("@doGet		INFO: Requesting JSONjohnny");
		PrintWriter out = resp.getWriter();
		out.println( req.getSession().getAttribute("JSONjohnny"));*/
		logger.info("@doGet		ERROR: we should not have gotten here");
		logger.info("@doGet		INFO: BACK TO HTML");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Action " + req.getRequestURI());
		logger.info("@doPost		INFO: using URI "+ req.getRequestURI());
		resp.getWriter().println(RequestHelperAction.process(req, resp));
		logger.info("@doPost		INFO: BACK TO HTML");
	}
}











