package com.ErsReimbursement.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ErsReimbursement.controller.RequestHelper;

public class ERSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println(req.getRequestURI());
		System.out.println(req.getParameter("username"));
		System.out.println(req.getParameter("password"));
		resp.setContentType("text/html");
		//RequestHelper.process(req, resp);
		req.getRequestDispatcher(RequestHelper.process(req)).forward(req, resp);


//        ServletOutputStream out = resp.getOutputStream();
// 
//        out.println("<html>");
//        out.println("<head><title>Asterisk</title></head>");
// 
//        out.println("<body>");
// 
//        out.println("<h3>Hi, your URL match /any/*</h3>");
// 
//        out.println("</body>");
//        out.println("<html>");
    

		PrintWriter out = resp.getWriter();
		out.println("<html><body><h1>The Servlet is working!</h1></body></html>");
		System.out.println("we're inside of our  httml servlet! POST!");

		//req.getRequestDispatcher(RequestHelper.process(req)).forward(req, resp);

	}}
