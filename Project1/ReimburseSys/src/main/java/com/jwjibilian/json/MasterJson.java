package com.jwjibilian.json;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class MasterJson
 */
public class MasterJson{
	private static final long serialVersionUID = 1L;
    Object o;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterJson() {
        super();

    }

	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	public void writeJsonToResp(HttpServletResponse response,
			Object o) throws IOException {
		String newJson = new ObjectMapper().writeValueAsString(o);
		System.out.println("this is the json string" + newJson);
		response.getWriter().write(newJson);

	}

}
