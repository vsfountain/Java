 package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ServiceLayer.VaultService;
import ServiceLayer.VaultServiceImplementation;

public class ReimbursementController {

	public static void viewRequests(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, IOException {
		VaultService dweller = new VaultServiceImplementation();
		//System.out.println(dweller.getUserInfo(username, password));
		ArrayList<Object> requests = dweller.displayAllRequests();
		
		resp.getWriter().write(new ObjectMapper().writeValueAsString(requests));
	}

}
