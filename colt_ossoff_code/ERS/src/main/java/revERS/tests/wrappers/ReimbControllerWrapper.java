package revERS.tests.wrappers;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;

import revERS.servlets.controllers.ReimbursementController;

public class ReimbControllerWrapper {
	public int add(HttpServletRequest req) {
		try {
			return ReimbursementController.add(req);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public int approve(int id, int uid, String role) {
		return ReimbursementController.approve(id, uid, role);
	}
	public int deny(int id, int uid, String role) {
		return ReimbursementController.deny(id, uid, role);
	}
	public String reimbursements() {
		return ReimbursementController.reimbursements();
	}
	public String reimbursements(int id) {
		return ReimbursementController.reimbursements(id);
	}
}
