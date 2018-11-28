package com.dikokosolutions.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;

public class HomeController {
	final static Logger logger = Logger.getLogger(HomeController.class);

	public static String home(HttpServletRequest req) throws JsonProcessingException, IOException {

		// ReimbursementController.getUserReimbursementInfo(req);
		return "resources/html/home.html";
	}

	public static String ManagerHome(HttpServletRequest req) {
		logger.info("We are in the Home Controller for Finance Manager");
		return "resources/html/managerhome.html";
	}

}
