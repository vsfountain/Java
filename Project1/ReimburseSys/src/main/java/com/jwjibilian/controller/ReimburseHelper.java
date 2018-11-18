package com.jwjibilian.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jwjibilian.json.MasterJson;
import com.jwjibilian.model.user.User;

public class ReimburseHelper {
	public static String process(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, IOException {
		System.out.println(req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/ReimburseSys/getReimburse":
			System.out.println("I am stuck in a pit of dispare");
			ReimburseController.getReimbursmentForUser(req, resp);
			
			
			
			
		default:
			return "/index.html";
		}
		

	}
}

