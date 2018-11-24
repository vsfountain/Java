package com.project1.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.project1.objs.Reimbursement;
import com.project1.objs.User;
import com.project1.service.ReimbursementService;
import com.project1.service.ReimbursementServiceImpl;

public class ReimbursementController {

	private static ReimbursementService reimbService = new ReimbursementServiceImpl();

	public static List<Reimbursement> show(HttpServletRequest req) {
		User user = (User) req.getSession().getAttribute("currentuser");
		return reimbService.getAllReimbs(user);
	}

	public static String insert(HttpServletRequest req) {
		User user = (User) req.getSession().getAttribute("currentuser");
		double amount = Double.parseDouble(req.getParameter("reimbAmount"));
		String desc = req.getParameter("reimbDesc");
		String type = req.getParameter("reimbType");


		reimbService.logReimbursement(amount, desc, user, type);
		return "reimbursementform.html";

	}

	public static String process(HttpServletRequest req) {
		User user = (User) req.getSession().getAttribute("currentuser");
		int id = Integer.parseInt(req.getParameter("reimbId"));
		String process = req.getParameter("reimbProcess");
		Reimbursement r = reimbService.getReimb(id);

		if (r != null) {
			reimbService.processReimb(r, user, process);
			return "processreimbursement.html";
		} else {
			return "./processerror.html";
		}
	}
}
