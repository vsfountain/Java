package com.ers.helper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.controller.AllReimbController;
import com.ers.controller.ApproveController;
import com.ers.controller.IdReimbController;
import com.ers.controller.NewReimbController;
import com.ers.controller.StatusReimbController;
import com.ers.controller.UserReimbController;
import com.fasterxml.jackson.core.JsonProcessingException;

public class JSONRequestHelper {
	public static void process(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException, ServletException {
		System.out.println("PRocess"+request.getRequestURI());

		switch (request.getRequestURI()) {
		case "/MyERSProject/getAllReimbursements.json":
			AllReimbController.selectAllReimbursements(request, response);
			break;
		case "/MyERSProject/getReimbursementsById.json":
			IdReimbController.getReimbursementsById(request, response);
			break;
		case "/MyERSProject/getReimbursementsByStatus.json":
			StatusReimbController.getReimbursementsByStatus(request, response);
			break;
		case "/MyERSProject/getUserReimbursements.json":
			UserReimbController.getUserReimbursements(request, response);
			break;
		case "/MyERSProject/createReimbursement.json":
			System.out.println("JSON Request Helper");
			NewReimbController.createNewReimb(request, response);
			break;
		
		default:
			//figure out what to put here
		}
		
	}
}


