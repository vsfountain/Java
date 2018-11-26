package com.example.json;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.ErsReimbFeModel;
import com.example.service.ErsReimbursementService;
import com.example.service.ErsReimbursementServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReimbursementsController {

	
	public static void getAllReimbursements(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, IOException
	{
		resp.setContentType("application/json");
		ErsReimbursementService ersReimbursementService = new ErsReimbursementServiceImpl();
		
		List<ErsReimbFeModel> ersReimbFeModels = ersReimbursementService.getAllErsReimbursements();
		resp.getWriter().write(new ObjectMapper().writeValueAsString(ersReimbFeModels));
		
		
		
		
	}
	
	
}
