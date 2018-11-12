package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.SuperVillain;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req,
				HttpServletResponse resp)
						throws IOException, ServletException
	{
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body><h1>The Servlet is working!</h1></body></html>");
		System.out.println("we're inside of our servlet! GET!");
	}
	
	@Override
	protected void doPost(HttpServletRequest req,
				HttpServletResponse resp)
						throws IOException, ServletException
	{
		resp.setContentType("application/json");
		
		SuperVillain dannyboy = 
				new SuperVillain("Danny Boy", "Electromagnetism",
							250_000);
		resp.getWriter().write(
				new ObjectMapper().writeValueAsString(dannyboy));
		System.out.println("we're inside of our servlet! POST!");
	}
	
}
