package com.jwjibilian.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;

public class ReimburseHelper {
	public static String process(HttpServletRequest req, HttpServletResponse resp)
			throws JsonProcessingException, IOException {
		System.out.println(req.getRequestURI() + " " + req.getSession().getAttribute("user")  );
		if (req.getSession().getAttribute("user") != null) {
			switch (req.getRequestURI()) {
			case "/ReimburseSys/getReimburse":
				System.out.println("getReimburse called here");
				ReimburseController.getReimbursmentForUser(req, resp);
				return "/client.html";
			case "/ReimburseSys/sendReimburse":
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				Enumeration x = req.getParameterNames();
				while (x.hasMoreElements()) {
					System.out.println("loop: " + x.nextElement());
				}
				ReimburseController.sendReimbursementRequest(req, resp);
				return "client.html";
			case "/ReimburseSys/getAll":
				ReimburseController.getAllUsersReimburse(req, resp);
				break;
			case "/ReimburseSys/approve":
				ReimburseController.approveRequest(req, resp);
				return "/resources/html/admin.html";

			case "/ReimburseSys/deny":
				ReimburseController.denyRequest(req, resp);
				return "/resources/html/admin.html";
			default:
				return "/index.html";
			}
		}
		return "/index.html";

	}

}
