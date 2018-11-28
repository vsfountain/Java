package com.dikokosolutions.controller;

import javax.servlet.http.HttpServletRequest;

public class LogOutController {

	public static String logOut(HttpServletRequest req) {
		System.out.println("invalidate");
		req.getSession().invalidate();
		return "index.html";
	}
}
