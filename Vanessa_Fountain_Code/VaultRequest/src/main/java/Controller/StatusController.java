package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServiceLayer.VaultService;
import ServiceLayer.VaultServiceImplementation;

public class StatusController {

	public static void approveReimb(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("in post uri is: "+req.getRequestURI());
		String reimbKey = req.getParameter("reimbKey");
		System.out.println("Our reimbKey is: "+reimbKey);
		int reimbID = Integer.parseInt(reimbKey);
		System.out.println("Our integer reimbKey is: "+ reimbID);
		VaultService dweller = new VaultServiceImplementation();
		dweller.approveReimb(reimbID);
		
	}
	
	public static void denyReimb(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("in post uri is: "+req.getRequestURI());
		String reimbKey = req.getParameter("reimbKey");
		System.out.println("Our reimbKey is: "+reimbKey);
		int reimbID = Integer.parseInt(reimbKey);
		System.out.println("Our integer reimbKey is: "+ reimbID);
		VaultService dweller = new VaultServiceImplementation();
		dweller.denyReimb(reimbID);
		
	}
	
	
}
