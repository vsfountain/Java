package com.project1.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.project1.objs.Reimbursement;
import com.project1.objs.User;
import com.project1.service.ReimbursementService;
import com.project1.service.ReimbursementServiceImpl;
import com.project1.service.UserService;
import com.project1.service.UserServiceImpl;

public class ReimbursementController {
	private static UserService userService = new UserServiceImpl();
	private static ReimbursementService reimbService = new ReimbursementServiceImpl();
	
	public static List<Reimbursement> show(HttpServletRequest req) {
		
		User user = (User) req.getSession().getAttribute("currentuser");
		
		return reimbService.getAllReimbs(user);
		
	}

}
