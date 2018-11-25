package com.kers.controller;

import javax.servlet.http.HttpServletRequest;

public class InvalidateSessionController {
	
	public static String logout(HttpServletRequest req) {
		System.out.println("Logout here");
		req.getSession().invalidate();
		System.out.println("session invalidated");
		return "index.html";
	}
}
