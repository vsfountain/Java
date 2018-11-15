package com.example.indirectservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws IOException, ServletException
	{
		System.out.println("     We're in the INdirect doGet");
		
		//resp.sendRedirect("http://localhost:9005/HelloServlets/resources/html/secondpage.html");
		
		resp.sendRedirect("http://localhost:9005/HelloServlets/dirserv");
		
		//resp.sendRedirect("https://www.google.com/");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws IOException, ServletException
	{
		System.out.println("     We're in the INdirect doPost");
		
		/*RequestDispatcher rdis = req.getRequestDispatcher(
				"/resources/html/secondpage.html");*/
		
		RequestDispatcher rdis = req.getRequestDispatcher(
				"/dirserv");
		
		/*RequestDispatcher rdis = req.getRequestDispatcher(
				"https://www.google.com/");*/
		rdis.forward(req, resp);
	}

}
