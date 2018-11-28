package com.dikokosolutions.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dikokosolutions.model.User;
import com.dikokosolutions.service.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

public class UserController {
	static UserServiceImpl userControl = new UserServiceImpl();

	// Translate userObject returned from authenticate() into a JSON object
	public static void getUserInfo(HttpServletRequest req, HttpServletResponse resp)
			throws JsonProcessingException, IOException {
		System.out.println("we are in the UserController");

		String username = (String) req.getSession().getAttribute("loggedUsername");
		String password = (String) req.getSession().getAttribute("loggedPassword");
		User uc = userControl.authenticate(username, password);
		// ArrayList<Reimbursement> r = userControl.getUserReimbursementInfo();
		// System.out.println(uc);
		// Reimbursement rc = userControl.getUserReimbursementInfo();
		// System.out.println(uc);

		String json = new Gson().toJson(uc);
		// resp.getWriter().write(new ObjectMapper().writeValueAsString(uc));
		PrintWriter writer = resp.getWriter();
		writer.write(json);
		writer.close();

	}

}
