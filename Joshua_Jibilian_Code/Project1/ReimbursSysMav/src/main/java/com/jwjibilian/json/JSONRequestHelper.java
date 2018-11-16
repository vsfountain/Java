package com.jwjibilian.json;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jwjibilian.controller.LoginController;
import com.jwjibilian.model.user.User;

public class JSONRequestHelper {
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
		case "/ReimbursSysMav/login.json":
			return LoginController.login(req, resp);
		default:
			return "index.html";
		}

		
		
				//SuperVillain vill = new SuperVillain("?","?", 0);
				//resp.getWriter().write(new ObjectMapper().writeValueAsString(vill));
			
	//}
		
	}
}
