package com.example.json;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.SuperVillain;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONRequestHelper {
	public static void process(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, IOException {
		System.out.println(req.getRequestURI());

		switch (req.getRequestURI()) {
		case "/HelloFrontController/dannyboy.json":
			DannyBoyController.dannyFinder(req, resp);
			break;
		case "/HelloFrontController/aster.json":
			AsterController.asterFinder(req, resp);
			break;
		default:
			SuperVillain vill = new SuperVillain("?", "?", 0);
			resp.getWriter().write(new ObjectMapper().writeValueAsString(vill));
		}
	}
}
