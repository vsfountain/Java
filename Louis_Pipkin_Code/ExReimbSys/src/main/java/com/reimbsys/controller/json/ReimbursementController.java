package com.reimbsys.controller.json;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbsys.model.Reimbursement;
import com.reimbsys.model.User;
import com.reimbsys.service.ReimbService;
import com.reimbsys.service.ReimbServiceImpl;
import com.reimbsys.service.UserService;
import com.reimbsys.service.UserServiceImpl;


public class ReimbursementController {
	
	protected static ReimbService reimbService = new ReimbServiceImpl();
	protected static UserService userService = new UserServiceImpl();
	
	public static void reimbFinder(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		String username = (String) req.getSession().getAttribute("loggerusername");
		//User user = userService.getUser(username);
		System.out.println("in Reimb Controler: "+req.getSession().getAttribute("loggerusername"));
		String role = (String) req.getSession().getAttribute("loggerrole");
		
		Map<String, Reimbursement> reimbs = new HashMap<>();
		
		System.out.println("in reimbursement controller, role: "+role);
		
		if (role.equalsIgnoreCase("Admin")) {
			reimbs = reimbService.getAllReimbs();
		} else {
			reimbs = reimbService.getReimbByUserName(username);
		}
		
		System.out.println("Reimbursements: "+reimbs);
		
		resp.getWriter().write(new ObjectMapper().writeValueAsString(reimbs));
	}
	
	public static String addReimb(HttpServletRequest req) throws IOException, ServletException {
		System.out.println("in Reimb Controler, addReimb: "+req.getSession().getAttribute("loggerusername"));
		
		User emp = userService.getUser((String) req.getSession().getAttribute("loggerusername"));
		
		// new Rimb(int amount, String description, int authorId)
		String amount = req.getParameter("amount");
		String desc = req.getParameter("desc");
		String type = req.getParameter("type");
		
		System.out.println(emp);
		System.out.println(amount);
		System.out.println(desc);
		System.out.println(type);
		
		Reimbursement reimb = new Reimbursement(Double.parseDouble(amount), desc, emp.getUsersId());
		
		reimbService.putReimb(reimb, type);
		
		return "/resources/html/viewMyReimb.html";
	}
	
	public static String updateReimb(HttpServletRequest req) throws IOException, ServletException {
		System.out.println("in Reimb Controler, updateReimb: ");

		String[] selectedIds = req.getParameterValues("selectedRow");
		Map<String, Reimbursement> reimbs = reimbService.getReimbsByIds(selectedIds);
				
		User admin = userService.getUser((String) req.getSession().getAttribute("loggerusername"));
		
		String decision = req.getParameter("submit");
		
		System.out.println(admin);
		System.out.println(Arrays.toString(selectedIds));
		System.out.println(decision);
		System.out.println(reimbs);
		
		if (decision.equals("approve")) {
			for (String id: selectedIds) {
				System.out.println("approving: "+id);
				// set the resolved timestamp
				reimbs.get(id).resolve();
				reimbService.approveReimb(reimbs.get(id), admin.getUsersId());
			}
		} else if (decision.equals("deny")) {
			for (String id: selectedIds) {
				System.out.println("denying: "+id);
				reimbs.get(id).resolve();
				reimbService.denyReimb(reimbs.get(id), admin.getUsersId());
			}
		}
		
		return "/resources/html/viewAllReimb.html";
	}

}
