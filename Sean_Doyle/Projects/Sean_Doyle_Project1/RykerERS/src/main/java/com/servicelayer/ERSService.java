package com.servicelayer;

import java.util.ArrayList;

import com.classes.Reimbursement;
import com.classes.User;

public interface ERSService {
	public ArrayList<User> getAllUsers();
	public User checkLoginCreds(String username, String password);
	
	public boolean checkAdmin(User loggy);
	
	public ArrayList<Reimbursement> getAllReimbs();
	public ArrayList<Reimbursement> getAllUserReimbs(int ers_user_id);
	public ArrayList<Reimbursement> getAllUserReimbs(String ers_username);
	public boolean addReimbursement(double amount, String description, String username, String type);
	public boolean updateReimbursement(User user, int reimb_id, String decision);
	public boolean addReimbursementReceipt(double amount, String description, String username, String type,
			String filePath);
}
