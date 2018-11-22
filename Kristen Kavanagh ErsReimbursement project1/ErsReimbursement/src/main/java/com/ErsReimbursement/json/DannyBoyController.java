package com.ErsReimbursement.json;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ErsReimbursement.model.SuperVillain;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DannyBoyController {


	public static void dannyFinder(HttpServletRequest req, HttpServletResponse resp) throws 
	JsonProcessingException, IOException
	{
		SuperVillain danny = new SuperVillain("Danny Boy", "Electromagnetism", 250_000);
		resp.getWriter().write(new ObjectMapper().writeValueAsString(danny));
	}
}
