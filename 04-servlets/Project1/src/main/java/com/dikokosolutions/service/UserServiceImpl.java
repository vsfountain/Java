package com.dikokosolutions.service;

import java.util.ArrayList;

import com.dikokosolutions.dao.ReimbursementDao;
import com.dikokosolutions.dao.UserDao;
import com.dikokosolutions.model.Reimbursement;
import com.dikokosolutions.model.User;

public class UserServiceImpl implements UserService {
	// the service is an interface for my dao
	private UserDao u = new UserDao();
	private User user = new User();
	private ReimbursementDao rd = new ReimbursementDao();

	@Override
	public ArrayList<User> getAllUsers() {
		return u.getUserInformation();
	}

	// Here i take in the returned arrayList from my userDao getUserInformation()
	// method
	// the user is stored in tempUser which I use to verify whet her the passed in
	// username and password from
	// the login page matches the username and password in my database USERS
	// table...need to hash the password and
	// then compare using a sql storedprocedure
	public User authenticate(String username, String password) {
		ArrayList<User> temp = u.getUserInformation();
		User tempUser = new User();
		for (User u : temp) {
			if (u.getUserName().equals(username) && u.getUserPassword().equals(password)) {
				System.out.println("Authenticating...");
				tempUser = u;
			} else {
				// System.out.println("Invalid User Name");
			}
		}

		return tempUser;
	}

	public ArrayList<Reimbursement> getUserReimbursementInfo() {
		ArrayList<Reimbursement> tempReimb = new ArrayList<Reimbursement>();
		// HashMap<User, Reimbursement> test = new HashMap<>();
		for (Reimbursement r : rd.getAllReimbursementsFromDB()) {
			tempReimb.add(r);
		}
		System.out.println(tempReimb);
		return tempReimb;
	}
}
