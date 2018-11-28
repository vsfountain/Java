package com.dikokosolutions.requesthelpers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dikokosolutions.controller.ReimbursementController;
import com.dikokosolutions.controller.UserController;;

public class JSONRequestHelper {
	public static String process(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		System.out.println(req.getRequestURI());
		System.out.println("We are in the JSONRH");
		switch (req.getRequestURI()) {
		case "/Project1/user.json":
			UserController.getUserInfo(req, resp);
		case "/Project1/reimbursement.json":
			ReimbursementController.getUserReimbursementInfo(req, resp);
		default:
			return "resources/html/unsuccessfullogin.html";
		}
	}

}
