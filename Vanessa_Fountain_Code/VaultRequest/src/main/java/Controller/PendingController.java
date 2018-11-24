package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ModelLayer.RequestDisplay;
import ServiceLayer.VaultService;
import ServiceLayer.VaultServiceImplementation;

public class PendingController {
	public static void viewRequests(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, IOException {
		VaultService dweller = new VaultServiceImplementation();
		//CONTROLLER FOR SENDING ONLY PENDING REQUESTS TO THE DISPLAY
		HashMap<String, Integer> requests = dweller.displayAllPending();
		System.out.println(requests);
		resp.getWriter().write(new ObjectMapper().writeValueAsString(requests));
	}

}
