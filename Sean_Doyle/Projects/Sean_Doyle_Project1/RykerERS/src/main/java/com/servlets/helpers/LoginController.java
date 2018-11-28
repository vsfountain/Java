package com.servlets.helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.classes.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.servicelayer.ERSService;
import com.servicelayer.ERSServiceImplementation;

public class LoginController {
	private static ERSService eserv= new ERSServiceImplementation();
	final static Logger logger = Logger.getLogger(LoginController.class);
	
	// Part of JSON
	public static String login(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, IOException, ServletException {
		String JSONjohnny = "{}";
		if (!(req.getMethod().equals("POST"))) {
			logger.info("@login		FAIL: using method GET to access");
		} else {
			String username = (String) req.getParameter("username");
			String password = (String) req.getParameter("password");
			User loggy = eserv.checkLoginCreds(username, password);
			if (loggy == null) {
				logger.info("@login		FAIL: login returned user is null");
			} else {
				JSONjohnny =  new ObjectMapper().writeValueAsString(loggy);
				logger.info("@login		Successful: login returned user is "+ loggy.toString());
				req.getSession().setAttribute("nowUser", loggy);
				req.getSession().setAttribute("JSONjohnny", JSONjohnny);
				req.getSession().setAttribute("username", username);
				req.getSession().setAttribute("password", password);// This may not be a good idea
			}
		}
		return JSONjohnny;
	}
	
	// Part of Action
	public static String logout(HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().invalidate();
		logger.info("@logout		Successful: Session invalidated");
		return "Logout Successful";
	}	
}