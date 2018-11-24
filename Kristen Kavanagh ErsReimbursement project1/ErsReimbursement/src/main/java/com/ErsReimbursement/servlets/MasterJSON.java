package com.ErsReimbursement.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ErsReimbursement.json.JSONRequestHelper;
import com.ErsReimbursement.model.Reimbursement;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MasterJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

		
	@Override
	protected void doPost(HttpServletRequest req,
				HttpServletResponse resp)
						throws IOException, ServletException
	{
		System.out.println(req.getRequestURI());
		resp.setContentType("application/json");
		//HttpSession session = req.getSession();
//PrintWriter out = resp.getWriter();
		req.getRequestDispatcher(JSONRequestHelper.process(req, resp));
		
		Reimbursement reimburse = new Reimbursement ("reimb_amount", "reimb_description", "reimb_author", "reimb_status_id",
				"reimb_type_id"); 
				resp.getWriter().write(
				new ObjectMapper().writeValueAsString(reimburse));
		System.out.println("we're inside of our  json servlet! POST!");
	}
	
}


