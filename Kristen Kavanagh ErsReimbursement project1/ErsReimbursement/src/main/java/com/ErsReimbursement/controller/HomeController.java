package com.ErsReimbursement.controller;

import javax.servlet.http.HttpServletRequest;

import com.ErsReimbursement.model.Reimbursement;
import com.ErsReimbursement.service.ReimbursementService;
import com.ErsReimbursement.service.ReimbursementServiceImpl;

public class HomeController {

	
		private static ReimbursementService imbur = new ReimbursementServiceImpl();
		public static String InsertReimbursement(HttpServletRequest req) {

			String reimb_amount = req.getParameter("reimb_amount");
			String reimb_description = req.getParameter("reimb_description");
			String reimb_author = req.getParameter("reimb_author");
			String reimb_status_id = req.getParameter("reimb_status_id");
			String reimb_type_id = req.getParameter("reimb_type_id");

			Reimbursement newReimb = new Reimbursement(reimb_amount, reimb_description, reimb_author, reimb_status_id,
					reimb_type_id);
			imbur.InsertReimbursement(newReimb);

			if (newReimb != null) {

				req.getSession().setAttribute("loggedamount", reimb_amount);
				req.getSession().setAttribute("loggeddescription", reimb_description);
				req.getSession().setAttribute("loggedauthor", reimb_author);
				req.getSession().setAttribute("loggedstatusid", reimb_status_id);
				req.getSession().setAttribute("loggedtypeid", reimb_type_id);
			}
		


				return "NewReimbursement.html";
			}
	}
		


