package com.kers.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.kers.models.User;

public class InvalidateSessionController {
	
	final static Logger logger = Logger.getLogger(InvalidateSessionController.class);
	
	public static String logout(HttpServletRequest req) {
		User u = (User)req.getSession().getAttribute("user");
		logger.info("User " + u.getUsername() + " is logging out.");
		req.getSession().invalidate();
		return "index.html";
	}
}
