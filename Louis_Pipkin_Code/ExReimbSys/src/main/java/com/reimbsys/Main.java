package com.reimbsys;

import java.util.Map;

import com.reimbsys.model.Reimbursement;
import com.reimbsys.model.User;
import com.reimbsys.service.ReimbService;
import com.reimbsys.service.ReimbServiceImpl;
import com.reimbsys.service.UserService;
import com.reimbsys.service.UserServiceImpl;

public class Main {

	public static void main(String[] args) {
		//do you even need a main? 
		
		
	
		//testing User DAO
		UserService userService = new UserServiceImpl();
		
		User me = userService.getUser("louispipkin");
		System.out.println("get user for louispipkin:");
		System.out.println(me);
		
		//testing get all users
		Map<String, User> allUsers = userService.getAllUsers();
		System.out.println("get all users map");
		System.out.println(allUsers);
		
		//test get hash and hash check
		String hash = userService.getHash("louispipkin", "12345");
		System.out.println("get user for louispipkin: ");
		System.out.println(me);
		System.out.println("get hash: "+hash);
		System.out.println("Authenticated: ");
		if (hash.equals(me.getPassword())) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	
		
		//testing Reimbursement DAO
		ReimbService reimbService = new ReimbServiceImpl();
		
		System.out.println("testing getAllReimbs: ");
		Map<String, Reimbursement> allReimbs = reimbService.getAllReimbs();
		System.out.println(allReimbs.size());
		System.out.println(allReimbs);
		
//		System.out.println("testing getReimbById: ");
//		Map<String, Reimbursement> reimbId = reimbService.getReimbByUserId(10);
//		System.out.println(reimbId.size());
//		System.out.println(reimbId);
		
		System.out.println("testing getReimbByUserId: ");
		Map<String, Reimbursement> myIdReimbs = reimbService.getReimbByUserId(10);
		System.out.println(myIdReimbs.size());
		System.out.println(myIdReimbs);
		
		System.out.println("testing gSetReimbByUserId: ");
		Map<String, Reimbursement> myNameReimbs = reimbService.getReimbByUserName("louispipkin");
		System.out.println(myNameReimbs.size());
		System.out.println(myNameReimbs);
		
		System.out.println("testing getReimbsByIds: ");
		String[] ids = {"1", "6", "7"};
		Map<String, Reimbursement> selectedReimbs = reimbService.getReimbsByIds(ids);
		System.out.println(selectedReimbs);
		
	}
}
