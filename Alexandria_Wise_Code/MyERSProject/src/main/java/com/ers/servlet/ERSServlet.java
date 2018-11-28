package com.ers.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.helper.RequestHelper;
import com.ers.model.Reimbursement;
import com.ers.model.ReimbursementDAO;
import com.ers.model.ReimbursementDAOImpl;
import com.ers.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ERSServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getRequestURI());
		HttpSession session = request.getSession();
		User myUser = (User) session.getAttribute("user");
		System.out.println("user" +myUser);
		//ArrayList<Reimbursement> list = new ArrayList<Reimbursement>();
		PrintWriter out = response.getWriter();
		/*ReimbursementDAO reimb = new ReimbursementDAOImpl();
		list  = reimb.selectAllReimbursements();
		out.println(new ObjectMapper().writeValueAsString(list));*/
		out.println(new ObjectMapper().writeValueAsString(myUser));
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		request.getRequestDispatcher(RequestHelper.process(request, response)).forward(request, response);
		
		/*PrintWriter out = response.getWriter();
		out.println(RequestHelper.process(request, response));*/
	}
}

