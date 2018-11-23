package com.ers.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.Reimbursement;
import com.ers.model.ReimbursementService;
import com.ers.model.ReimbursementServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StatusReimbController {
	private static ReimbursementService rServ = new ReimbursementServiceImpl();

	public static String getReimbursementsByStatus(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {
		
		ArrayList<Reimbursement> myReimbList = rServ.filterByStatus(0);
		String rlist = new ObjectMapper().writeValueAsString(myReimbList);
		
		return rlist;
	}
}
