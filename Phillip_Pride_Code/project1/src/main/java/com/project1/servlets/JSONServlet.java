package com.project1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.controllers.ReimbursementHelper;
import com.project1.objs.Reimbursement;
import com.project1.objs.User;


public class JSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("currentuser");
		resp.getWriter().write(new ObjectMapper().writeValueAsString(user));
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println(ReimbursementHelper.process(req));
		resp.getWriter().write(new ObjectMapper().writeValueAsString(ReimbursementHelper.process(req)));
		
	}

}
