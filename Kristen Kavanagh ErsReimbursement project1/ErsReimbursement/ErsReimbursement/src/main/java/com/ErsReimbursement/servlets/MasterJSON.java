package com.ErsReimbursement.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ErsReimbursement.json.JSONRequestHelper;

public class MasterJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doPost(HttpServletRequest req,
				HttpServletResponse resp)
						throws IOException, ServletException
								
	{
	

		System.out.println("Helloooooooooooo");
		req.getRequestDispatcher(JSONRequestHelper.process(req, resp));
	}
}
		
		
		
		
		
		
		
		

	

