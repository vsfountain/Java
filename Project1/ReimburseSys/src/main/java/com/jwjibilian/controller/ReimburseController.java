package com.jwjibilian.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jwjibilian.daos.ReimbursementDAO;
import com.jwjibilian.json.MasterJson;
import com.jwjibilian.model.reimbursement.Reimbursement;
import com.jwjibilian.model.user.User;
import com.jwjibilian.services.ReimbursementService;
import com.jwjibilian.services.ReimbursementServiceImpl;

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
}
