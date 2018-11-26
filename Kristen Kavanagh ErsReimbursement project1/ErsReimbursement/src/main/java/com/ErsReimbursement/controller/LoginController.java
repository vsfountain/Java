package com.ErsReimbursement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ErsReimbursement.dao.UserDao;
import com.ErsReimbursement.dao.UserDaoImpl;
import com.ErsReimbursement.model.User;

public class LoginController {
	private static UserDao staff = new UserDaoImpl();

	public static String login(HttpServletRequest req, HttpServletResponse resp) {

		String username = req.getParameter("Ers_username");
		String password = req.getParameter("Ers_password");
		System.out.println("username and password " + username + "  " + password);
		String checked = req.getParameter("checkbox");
		System.out.println("checkdbox " + checked);
		User logUser = staff.selectUserByLoginInfo(username, password);

		if (logUser == null) {
			System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");

			return "unsuccessfullogin.html";
		} else {
			req.getSession().setAttribute("loggedusername", username);
			req.getSession().setAttribute("loggedpassword", password);
			req.getSession().setAttribute("logUser", logUser);
			if (checked!= null & logUser.getUserRoleId() == 1) {
				return "FinanceERSReimbursement.html";
			} else {
			return "NewReimbursement.html";
			}
		}
	}

}