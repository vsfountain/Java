package com.reimbsys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reimbsys.controller.json.JSONRequestHelper;

public class MasterJSON extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("MasterJSON doGet");
		
		JSONRequestHelper.process(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("MasterJSON doPost");
		
		//doGet(req, resp);
		//req.getRequestDispatcher(JSONRequestHelper.process(req, resp)).forward(req, resp);
		req.getRequestDispatcher(JSONRequestHelper.processForward(req)).forward(req, resp);
	}

}
