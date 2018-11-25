package com.project1.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.project1.objs.Reimbursement;

public class ReimbursementHelper {

	public static Object process(HttpServletRequest req) {
		//System.out.println(req.getRequestURI());
		switch (req.getRequestURI()) {
		case "/project1/show.reimb":
			return ReimbursementController.show(req);
		default:
			return null;
		}

	}

}
