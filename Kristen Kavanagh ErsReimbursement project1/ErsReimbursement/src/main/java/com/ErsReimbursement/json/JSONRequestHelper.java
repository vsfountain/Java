package com.ErsReimbursement.json;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ErsReimbursement.controller.LoginController;
import com.ErsReimbursement.controller.ReimbursementController;
import com.fasterxml.jackson.core.JsonProcessingException;

public class JSONRequestHelper {
public static String process(HttpServletRequest req, HttpServletResponse resp)
throws JsonProcessingException,IOException{
	System.out.println(req.getRequestURI());
	
	switch(req.getRequestURI()) {
	case "/ErsReimbursement/MasterJSON.json":
		return LoginController.login(req,resp);
	//case "/ErsReimbursement/resources/html/viewReimbursement.MasterJSON":
	case "/ErsReimbursement/resources/html/viewReimbursement.json":
		System.out.println("Hello222");
		return	ReimbursementController.viewReimbursement(req,resp);
	case "/ErsReimbursement/resources/html/approvedpastemployeeReimbursement.json":
	ReimbursementController.updateapprovedReimbursementByStatusId(req,resp);
	case "/ErsReimbursement/resources/html/deniedpastEmployeeReimbursement.json":
		ReimbursementController.updateDeniedReimbursementByStatusId(req,resp);
	case "/ErsReimbursement/resources/html/pendingEmployeeReimbursement.json":
			ReimbursementController.updateReimbursementByStatusId(req,resp);
		default:
			
			return "/ErsReimbursement/resources/html/viewReimbursement.json";
	}}}
