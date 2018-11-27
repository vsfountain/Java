package revERS.tests;

import java.util.ArrayList;

import revERS.DAO.ReImbDAO;
import revERS.DAO.UserDAO;
import revERS.model.Reimbursement;
import revERS.model.User;
import revERS.services.UserService;

public class DAOtest {

	private void oldTests() {
		// TODO Auto-generated method stub

		//User u = UserService.login("coltossoff","12345");
		//System.out.println(u.toString());
		//User u = UserDAO.selectId(15);
		User u = UserService.getById(15);
		System.out.println(u.toString());
		
		
		//ReImbDAO.insert(120.00, "This covers the office party's catering.", 2, "FOOD");
		//ReImbDAO.updateStatus(2, 15, "Approved");
		//ArrayList<Reimbursement> r = ReImbDAO.selectByUser(1); //ReImbDAO.selectAll();
		//System.out.println(r.toString());
		
		UserService.newReimbursement(555.55, "Plane ticket to client meeting", 2, "TRAVEL");
		UserService.newReimbursement(22.12, "Lunch", 3, "FOOD");
		UserService.approve(4, 15);
		UserService.deny(5, 15);
		System.out.println(UserService.getReimbursements());
		System.out.println(UserService.getUserReimbursements(1));

	}
	public static void main(String[] args) {
		H2service serv = new H2service();
		
		serv.h2Init();
		
		System.out.println(serv.login("coltossoff", "12345"));
		
		System.out.println(serv.byId(1));
		
		serv.h2Destroy();
	}

}
