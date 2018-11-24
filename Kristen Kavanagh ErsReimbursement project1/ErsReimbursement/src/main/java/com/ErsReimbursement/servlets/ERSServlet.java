package com.ErsReimbursement.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ErsReimbursement.controller.RequestHelper;

public class ERSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println(req.getRequestURI());
		String username = req.getParameter("username");
		System.out.println(req.getParameter("password"));

		System.out.println(req.getParameter("reimb_amount"));
		System.out.println(req.getParameter("reimb_description"));
		System.out.println(req.getParameter("reimb_author"));
		System.out.println(req.getParameter("reimb_status_id"));
		System.out.println(req.getParameter("reimb_type_id"));
		resp.setContentType("text/html");
		//RequestHelper.process(req, resp);
		req.getRequestDispatcher(RequestHelper.process(req)).forward(req, resp);


      // ServletOutputStream out = resp.getOutputStream();


		PrintWriter out = resp.getWriter();
	      out.println("<html>");
	      out.println("<head><title>*</title></head>");

	         out.println("<body>");
	         out.println("<h3>ErsReimbursement/resources/html/*</h3>");
	      out.println("</body>");
	   out.println("<html>");
	   
		HttpSession session =req.getSession();
		if (username != null){
 session.setAttribute("loggedusername ", username);
		}
out.println("request parameter has username as " + username);
out.println("session parameter has username as "  + (String) session.getAttribute("loggedusername"));
//out.println("<html><body><h1>The Servlet is working!</h1></body></html>");
		//System.out.println("we're inside of our  httml servlet! POST!");


	}}
