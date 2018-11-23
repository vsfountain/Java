package com.ers.helper;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.controller.AllReimbController;
import com.ers.controller.IdReimbController;
import com.ers.controller.StatusReimbController;
import com.ers.controller.UserReimbController;
import com.fasterxml.jackson.core.JsonProcessingException;

public class JSONRequestHelper {
	public static String process(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {
		System.out.println(request.getRequestURI());

		switch (request.getRequestURI()) {
		case "/MyERSProject/getAllReimbursements.MasterJSON":
			return AllReimbController.selectAllReimbursements(request, response);
		case "/MyERSProject/getReimbursementsById.MasterJSON":
			return IdReimbController.getReimbursementsById(request, response);
		case "/MyERSProject/getReimbursementsByStatus.MasterJSON":
			return StatusReimbController.getReimbursementsByStatus(request, response);
		case "MyERSProject/getUserReimbursements.MasterJSON":
			return UserReimbController.getUserReimbursements(request, response);
		default:
			return null;
		}
		
	}
}


