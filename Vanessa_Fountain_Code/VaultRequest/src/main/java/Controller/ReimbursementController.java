 package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ModelLayer.RequestDisplay;
import ServiceLayer.VaultService;
import ServiceLayer.VaultServiceImplementation;

public class ReimbursementController {

	public static void viewRequests(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, IOException {
		VaultService dweller = new VaultServiceImplementation();
		//CONTROLLER TO DISPLAY ALL REQUESTS
		ArrayList<RequestDisplay> requests = dweller.displayAllRequests();
		System.out.println(requests);
		resp.getWriter().write(new ObjectMapper().writeValueAsString(requests));
	}

}
