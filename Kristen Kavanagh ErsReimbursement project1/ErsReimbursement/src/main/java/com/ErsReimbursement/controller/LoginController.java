package com.ErsReimbursement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ErsReimbursement.dao.ReimbursementDao;
import com.ErsReimbursement.dao.ReimbursementDaoImpl;
import com.ErsReimbursement.model.Reimbursement;
import com.ErsReimbursement.model.User;
import com.ErsReimbursement.service.ReimbursementService;
import com.ErsReimbursement.service.ReimbursementServiceImpl;
import com.ErsReimbursement.service.UserService;
import com.ErsReimbursement.service.UserServiceImpl;

public class LoginController {
	private static UserService staff = new UserServiceImpl();
	private static ReimbursementService imbur = new ReimbursementServiceImpl();

	public static String login(HttpServletRequest req) {

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("username and password" + username + "  " + password);

		User logUser = staff.selectUserByLoginInfo(username, password);

		if (logUser == null) {
			System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");

			return "../../unsuccessfullogin.html";
		} else {
			req.getSession().setAttribute("loggedusername", username);
			req.getSession().setAttribute("loggedpassword", password);

			return "NewReimbursement.html";
		}
	}

	public static String InsertReimbursement(HttpServletRequest req) {

		String reimb_amount = req.getParameter("reimb_amount");
		String reimb_description = req.getParameter("reimb_description");
		String reimb_author = req.getParameter("reimb_author");
		String reimb_status_id = req.getParameter("reimb_status_id");
		String reimb_type_id = req.getParameter("reimb_type_id");
		// System.out.println("insertreimb" );

		Reimbursement newReimb = new Reimbursement(reimb_amount, reimb_description, reimb_author, reimb_status_id,
				reimb_type_id);
		imbur.InsertReimbursement(newReimb);

		if (newReimb == null) {

			return " ../../unsuccessfullogin.html";
		} else {
			req.getSession().setAttribute("loggedamount", reimb_amount);
			req.getSession().setAttribute("loggeddescription", reimb_description);
			req.getSession().setAttribute("loggedauthor", reimb_author);
			req.getSession().setAttribute("loggedstatusid", reimb_status_id);
			req.getSession().setAttribute("loggedtypeid", reimb_type_id);

			// resp.getWriter().append(resp.getContentType());
			// resp.getWriter().setAttribute("loggedpassword", password);

			return "NewReimbursement.html";
		}
	}

}
