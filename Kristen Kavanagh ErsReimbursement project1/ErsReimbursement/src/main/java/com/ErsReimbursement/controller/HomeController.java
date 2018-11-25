package com.ErsReimbursement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ErsReimbursement.model.Reimbursement;
import com.ErsReimbursement.model.User;
import com.ErsReimbursement.service.ReimbursementService;
import com.ErsReimbursement.service.ReimbursementServiceImpl;

public class HomeController {
	private static ReimbursementService imbur = new ReimbursementServiceImpl();

	public static String InsertReimbursement(HttpServletRequest req, HttpServletResponse resp) {

		double reimb_amount = Double.parseDouble(req.getParameter("reimb_amount"));
		String reimb_description = req.getParameter("reimb_description");
		User logUser = (User) req.getSession().getAttribute("logUser");
		int reimb_author = logUser.getUserId();
		int reimb_status_id = 3;
		int reimb_type_id = Integer.parseInt(req.getParameter("reimb_type_id"));
		
		Reimbursement newReimb = new Reimbursement(reimb_amount, reimb_description, reimb_author, reimb_status_id,
				reimb_type_id);
		System.out.println("in HC at IR " + newReimb);
		imbur.InsertReimbursement(newReimb);

		if (newReimb != null) {

			req.getSession().setAttribute("loggedamount", reimb_amount);
			req.getSession().setAttribute("loggeddescription", reimb_description);
			req.getSession().setAttribute("loggedauthor", reimb_author);
			req.getSession().setAttribute("loggedstatusid", reimb_status_id);
			req.getSession().setAttribute("loggedtypeid", reimb_type_id);
		}
		return "pendingrequest.html";

	}
}
