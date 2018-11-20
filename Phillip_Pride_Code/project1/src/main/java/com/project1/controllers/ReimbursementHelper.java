package com.project1.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.project1.objs.Reimbursement;

public class ReimbursementHelper {
	public static List<Reimbursement> process(HttpServletRequest req) {
		System.out.println(req.getRequestURI());

		return ReimbursementController.show(req);

	}

}
