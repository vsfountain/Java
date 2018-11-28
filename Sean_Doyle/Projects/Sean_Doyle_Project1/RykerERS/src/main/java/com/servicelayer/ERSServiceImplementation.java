package com.servicelayer;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.classes.Reimbursement;
import com.classes.User;
import com.dao.ReimbDAO;
import com.dao.ReimbDAOImplementation;
import com.dao.UsersDAO;
import com.dao.UsersDAOImplementation;

public class ERSServiceImplementation implements ERSService {
	final static Logger logger = Logger.getLogger(ERSServiceImplementation.class);
	private ReimbDAO rdao;
	private UsersDAO udao;
	private ERSService eservMock;
	
	public ERSServiceImplementation() {
		this.rdao = new ReimbDAOImplementation();
		this.udao = new UsersDAOImplementation();
		//this.eservMock = null;
	}
	public ERSServiceImplementation(UsersDAO udao, ReimbDAO rdao, ERSService eserv) {
		this.rdao = rdao;
		this.udao = udao;
		this.eservMock = eserv;
	}
	
	@Override
	public ArrayList<User> getAllUsers() {
		logger.info("@getAllUsers");
		ArrayList<User> users = udao.getUsers();
		if (users.size() >= 1) {
			logger.info("@getUsers		Success:"+ users.size() +" users obtained");
		} else {
			logger.info("@getUsers		FAIL: No users found");
		}
		return users;
	}

	@Override
	public ArrayList<Reimbursement> getAllReimbs() {
		logger.info("@getAllReimbs");
		return rdao.getReimbursements();
	}

	// < > these are chevrons
	
	@Override
	public boolean checkAdmin(User loggy) {
		String role = loggy.getRole();
		if (role.toLowerCase().equals("admin")) {
			logger.info("@checkUserType		Admin " + loggy.getUsername());
			return true;
		} else {
			logger.info("@checkUserType		Employee " + loggy.getUsername());
			return false;
		}
	}

	
	// NOT used
	@Override
	public ArrayList<Reimbursement> getAllUserReimbs(int ers_user_id) {
		logger.info("@getAllUserReimbs(int)		ers_user_id " + ers_user_id);
		return rdao.getReimbursementForUser(ers_user_id);
	}

	@Override
	public ArrayList<Reimbursement> getAllUserReimbs(String ers_username) {
		logger.info("@getAllUserReimbs(String)		ers_username " + ers_username);
		return rdao.getReimbursementForUser(ers_username);
	}

	@Override
	public User checkLoginCreds(String username, String password) {
		logger.info("@checkLoginCreds		username & password(omitted) " + username);
		User tempUser = udao.checkLoginCreds(username, password);
		if (tempUser != null) {
			logger.info("@checkLoginCreds		Success: user "+username+" found");
		} else {	
			logger.info("@checkLoginCreds		FAIL: user at "+username+" with specified password NOT found");
		}
		return tempUser;
	}

	@Override
	public boolean addReimbursement(double amount, String description, String username, String type) {
		logger.info("@addReimbursement		username " + username);
		description = description.substring(0, Math.min(description.length(), 250));
		int rs = rdao.addReimbursement(amount, description, username, type);
		System.out.println(rs + " " + amount + "  " + description  +" " + username +  " "+ type);

		if (rs == 1) {
			logger.info("@addReimbursement		Success: reimbursement ADDED for "+username);
			return true;
		} else if (rs == 400) {
			logger.info("@addReimbursement		Fail: BAD USERNAME reimbursement NOT added for "+username);
			return false;
		} else if (rs == 450) {
			logger.info("@addReimbursement		Fail: BAD TYPE reimbursement NOT added for "+username + " with " + type);
			return false;
		}else if (rs == 500) {
			logger.info("@addReimbursement		Fail: BAD STATUS reimbursement NOT added for "+username + " with pending");
			return false;
		}else if (rs == 0) {
			logger.info("@addReimbursement		Fail: BAD EXECUTE reimbursement NOT added for "+username);
			return false;
		}else {
			logger.info("@addReimbursement		FAIL: BAD CONNECTION reimbursement NOT added "+username);
			return false;
		}
	}

	@Override
	public boolean updateReimbursement(User user, int reimb_id, String decision) {
		//if (eservMock.checkAdmin(user)) {
		if (checkAdmin(user)) {
			if (decision.toLowerCase().equals("approve")) {
				decision = "approved";
			} else if (decision.toLowerCase().equals("deny")) {
				decision = "deny";
			} else {
				logger.info("@updateReimbursement		FAIL: " + decision + " is NOT a valid option");
				return false;
			}
			
			int rs = rdao.updateReimbursement(reimb_id, user.getUsername(), decision);
			
			if (rs == -1) {
				logger.info("@updateReimbursement		FAIL: reimbursement NOT updated because INVALID remibursement ID "+ reimb_id);
				return false;
			} else if (rs == 400) {
				logger.info("@updateReimbursement		FAIL: reimbursement NOT updated because INVALID admin "+ user.getUsername());
				return false;
			} else if (rs == 200) {
				logger.info("@updateReimbursement		Success: reimbursement UPDATED by "+ user.getUsername()+" for "+ reimb_id);
				return true;
			} else if (rs == 500) {
				logger.info("@updateReimbursement		FAIL: reimbursement NOT updated reimbursement already RESOLVED did not" + decision);
				return false;
			} else {
				// expected is 0 if this occurs
				logger.info("@updateReimbursement		FAIL: reimbursement NOT updated SELECT STATEMENT error");
				return false;
			}
		} else {
			logger.info("@updateReimbursement		FAIL: " + user.getUsername() + " is NOT an ADMIN");
			return false;
		}
	}
	@Override
	public boolean addReimbursementReceipt(double amount, String description, String username, String type,
			String filePath) {
		logger.info("@addReimbursement		username " + username);
		description = description.substring(0, Math.min(description.length(), 250));
		int rs = rdao.addReimbursementReceipt(amount, description, username, type, filePath);
		if (rs == 1) {
			logger.info("@addReimbursement		Success: reimbursement ADDED for "+username);
			return true;
		} else if (rs == 400) {
			logger.info("@addReimbursement		Fail: BAD USERNAME reimbursement NOT added for "+username);
			return false;
		} else if (rs == 450) {
			logger.info("@addReimbursement		Fail: BAD TYPE reimbursement NOT added for "+username + " with " + type);
			return false;
		}else if (rs == 500) {
			logger.info("@addReimbursement		Fail: BAD STATUS reimbursement NOT added for "+username + " with pending");
			return false;
		}else if (rs == 0) {
			logger.info("@addReimbursement		Fail: BAD EXECUTE reimbursement NOT added for "+username);
			return false;
		}else {
			logger.info("@addReimbursement		FAIL: BAD CONNECTION reimbursement NOT added "+username);
			return false;
		}
	}

}
