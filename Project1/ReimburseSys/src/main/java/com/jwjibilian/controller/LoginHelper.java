package com.jwjibilian.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;

public class LoginHelper {
	public static String process(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, IOException {
		System.out.println(req.getRequestURI());
/*		
		switch(req.getRequestURI()) {
		case "/HelloFrontController/dannyboy.json":
			//DannyBoyController.dannyFinder(req, resp);
			break;
		case "/HelloFrontController/aster.json":
			//AsterController.asterFinder(req, resp);
			break;
			default:*/
		
		switch(req.getRequestURI()) {
		case "/ReimburseSys/logedin":
			return LoginController.login(req, resp);
		case "/ReimburseSys/getUser":
			return LoginController.getUser(req, resp);
		case "/ReimburseSys/logOut":
			return LoginController.logOut(req, resp);
			
		default:
			return "/index.html";
		}
		
		
		
				//SuperVillain vill = new SuperVillain("?","?", 0);

			
	//}
		
	}
}
