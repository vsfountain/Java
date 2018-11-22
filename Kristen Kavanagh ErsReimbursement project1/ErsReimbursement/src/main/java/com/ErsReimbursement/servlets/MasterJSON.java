package com.ErsReimbursement.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ErsReimbursement.json.JSONRequestHelper;
import com.ErsReimbursement.model.SuperVillain;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MasterJSON extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		
	@Override
	protected void doPost(HttpServletRequest req,
				HttpServletResponse resp)
						throws IOException, ServletException
	{
		resp.setContentType("application/json");
		JSONRequestHelper.process(req, resp);
		
		SuperVillain dannyboy = 
				new SuperVillain("Danny Boy", "Electromagnetism",
							250_000);
		resp.getWriter().write(
				new ObjectMapper().writeValueAsString(dannyboy));
		System.out.println("we're inside of our servlet! POST!");
	}
	
}


