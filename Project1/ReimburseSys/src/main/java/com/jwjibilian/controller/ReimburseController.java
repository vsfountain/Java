package com.jwjibilian.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jwjibilian.json.MasterJson;
import com.jwjibilian.model.reimbursement.Reimbursement;
import com.jwjibilian.model.user.User;
import com.jwjibilian.services.ReimbursementService;
import com.jwjibilian.services.ReimbursementServiceImpl;
import com.jwjibilian.services.UserService;
import com.jwjibilian.services.UserServiceImpl;

public class ReimburseController {

	static public void getReimbursmentForUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		User user = (User) req.getSession().getAttribute("user");
		System.out.println("This is the doGet in ReimburseServlet \n" + user);
		ReimbursementService service = new ReimbursementServiceImpl();
		ArrayList<Reimbursement> items = service.getUserReimbursments(user);
		System.out.println(items);
		MasterJson json = new MasterJson();
		json.writeJsonToResp(resp, items);
		
	}
	
	static public boolean sendReimbursementRequest(HttpServletRequest req, HttpServletResponse resp) {
		ReimbursementService service = new ReimbursementServiceImpl();
		User user = (User) req.getSession().getAttribute("user");
		System.out.println(user);
		System.out.println(req.getParameter("ammount") + " "+  req.getParameter("type") + " " + req.getParameter("desc"));
		service.addReimbursement(user.getId(), Double.parseDouble(req.getParameter("ammount")), req.getParameter("type")
				, req.getParameter("desc"));
		return false;
		
	}
	static public void getAllUsersReimburse(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ArrayList<User> allThem = new ArrayList<User>();
		UserService service = new UserServiceImpl();
		allThem = service.getAllUserReimbursements();
		MasterJson json = new MasterJson();
		json.writeJsonToResp(resp, allThem);
		
	}

	public static void approveRequest(HttpServletRequest req, HttpServletResponse resp) {
		ReimbursementServiceImpl service = new ReimbursementServiceImpl();
		int adminId= (int) req.getSession().getAttribute("adminId");
		System.out.println("The ID: " + req.getParameter("requestId")+ " "+ adminId);
		service.approve(Integer.parseInt(req.getParameter("requestId")), adminId);
	}

	public static void denyRequest(HttpServletRequest req, HttpServletResponse resp) {
		ReimbursementServiceImpl service = new ReimbursementServiceImpl();
		int adminId= (int) req.getSession().getAttribute("adminId");
		System.out.println("The ID: " + req.getParameter("requestId") + " "+ adminId);
		service.deny(Integer.parseInt(req.getParameter("requestId")), adminId);
		
	}
}
