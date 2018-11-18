package com.kers.controller;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kers.daos.ReimbursementDAO;
import com.kers.daos.ReimbursementDAOImpl;
import com.kers.models.Reimbursement;
import com.kers.models.User;

public class HomeController {
	public static String home(HttpServletRequest req) {
		return "home.html";
	}

	public static String processReimbursement(HttpServletRequest req) {
		System.out.println("-------------REIMBURSEMENT-------------");
		
		String type = req.getParameter("reimb-type");	
		double amount = Double.parseDouble(req.getParameter("amount"));
		Blob receipt = null; //req.getParameter("receipt-file");
		String description = req.getParameter("description");
		/*User u = (User)req.getSession().getAttribute("user");
		String username = u.getUsername();*/
		//LocalDateTime dateSubmitted = LocalDateTime.now();
		Timestamp dateSubmitted = new Timestamp(System.currentTimeMillis());
		User u = (User)req.getSession().getAttribute("user");
		String author = u.getUsername();
		System.out.println(type + " " + amount + " " + receipt + " " + description + " " + dateSubmitted);
		
		Reimbursement r = new Reimbursement(amount, description, receipt, author, type);
		ReimbursementDAO rdao = new ReimbursementDAOImpl();
		rdao.insertReimbursement(r);
		List<Reimbursement> temp = rdao.selectAllReimbursements();
		System.out.println("process reimbursements: " + temp);
		req.getSession().setAttribute("reimbursementlist", temp);
		return "home.html";
	}
}
