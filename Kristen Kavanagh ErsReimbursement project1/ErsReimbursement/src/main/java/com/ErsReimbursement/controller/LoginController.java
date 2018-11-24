package com.ErsReimbursement.controller;

import javax.servlet.http.HttpServletRequest;

import com.ErsReimbursement.model.User;
import com.ErsReimbursement.service.UserService;
import com.ErsReimbursement.service.UserServiceImpl;

public class LoginController {
	private static UserService staff = new UserServiceImpl();

	public static String login(HttpServletRequest req) {

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("username and password" + username + "  " + password);

		User logUser = staff.selectUserByLoginInfo(username, password);

		if (logUser == null) {
			System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");

			return "unsuccessfullogin.html";
		} else {
			req.getSession().setAttribute("loggedusername", username);
			req.getSession().setAttribute("loggedpassword", password);

			return "NewReimbursement.html";
		}
	}

}