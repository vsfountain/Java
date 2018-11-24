package com.ErsReimbursement.json;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ErsReimbursement.controller.HomeController;
import com.ErsReimbursement.controller.LoginController;
import com.fasterxml.jackson.core.JsonProcessingException;

public class JSONRequestHelper {
public static String process(HttpServletRequest req, HttpServletResponse resp)
throws JsonProcessingException,IOException{
	System.out.println(req.getRequestURI());
	
	switch(req.getRequestURI()) {
	case "/ErsReimbursement/masterJSON.json":
		LoginController.login(req,resp);
	case "/ErsReimbursement/master.json":
		HomeController.InsertReimbursement(req,resp);
		default:
			
			return null;
	}}}
