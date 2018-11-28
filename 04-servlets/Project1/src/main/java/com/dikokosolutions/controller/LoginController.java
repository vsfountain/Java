package com.dikokosolutions.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.dikokosolutions.dao.ReimbursementDao;
import com.dikokosolutions.model.Reimbursement;
import com.dikokosolutions.model.User;
import com.dikokosolutions.service.UserServiceImpl;
import org.apache.log4j.Logger;

public class LoginController {

	public static String login(HttpServletRequest req) {

		try {
			System.out.println("Login Controller");
			if (!req.getMethod().equals("POST")) {
				return "index.html";
			}

			String uName = req.getParameter("username");
			String password = req.getParameter("password");
			UserServiceImpl thisGuy = new UserServiceImpl();
			User thatGuy = thisGuy.authenticate(uName, password);// This returns a user

			if (thatGuy.getUserFirstName().equals("Trevin")) {
				req.getSession().setAttribute("loggedUsername", uName);
				req.getSession().setAttribute("loggedPassword", password);
				return "/managerhome.serv";

			}
			if (thatGuy.getUserName().equals(uName)) {
				req.getSession().setAttribute("loggedUsername", uName);
				req.getSession().setAttribute("loggedPassword", password);
				return "/home.serv";
			} else {

				return "resources/html/unsuccessfullogin.html";

			}
		} catch (NullPointerException e) {

		}
		return "resources/html/unsuccessfullogin.html";
	}
}
