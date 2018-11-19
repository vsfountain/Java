package com.jwjibilian.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jwjibilian.json.MasterJson;
import com.jwjibilian.model.user.User;
import com.jwjibilian.services.ReimbursementService;
import com.jwjibilian.services.ReimbursementServiceImpl;

public class ReimburseHelper {
	public static String process(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, IOException {
		System.out.println(req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/ReimburseSys/getReimburse":
			System.out.println("I am stuck in a pit of dispare");
			ReimburseController.getReimbursmentForUser(req, resp);
			break;
		case "/ReimburseSys/sendReimburse":
/*			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			Enumeration x = req.getParameterNames();
			while(x.hasMoreElements()) {
				System.out.println("loop" + x.nextElement());
			}*/
			
			ReimburseController.sendReimbursementRequest(req, resp);
			break;
		case "/ReimburseSys/getAll":
			ReimburseController.getAllUsersReimburse(req, resp);
			break;
		default:
			return "/index.html";
		}
		
		return "/index.html";

	}
}

