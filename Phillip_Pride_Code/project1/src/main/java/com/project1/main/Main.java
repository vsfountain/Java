package com.project1.main;

import java.sql.Blob;
import java.util.List;
import java.util.Scanner;

import com.project1.objs.Reimbursement;
import com.project1.objs.User;
import com.project1.service.*;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		UserService userTest = new UserServiceImpl();
		ReimbursementService reimburse = new ReimbursementServiceImpl();
		String name;
		String password;
		int amount;
		String desc;
		Blob receipt = null;
		String reimbType;
		
		
		System.out.print("Enter your username: ");
		name = input.next();
		System.out.print("Enter your password: ");
		password = input.next();
		
		User user = userTest.loginUser(name, password);
				
		System.out.println("Welcome " +user.getFirstName() + " "
							+ user.getLastName() + "!");
		
		/*System.out.println("How much are you seeking reimbursement for?");
		amount = input.nextInt();
		
		System.out.println("What kind of reimbursement is this?");
		reimbType = input.next();
		
		System.out.println("Please write a brief description of what this reimbursement is for:");
		desc = input.next();
		
		reimburse.logReimbursement(amount, desc, receipt, user, reimbType);*/
		List<Reimbursement> reimbs = reimburse.getAllReimbs(user);
		
		reimburse.processReimb(reimbs.get(0), user, 2);
		
		System.out.println(reimburse.getAllReimbs(user));
		
		
		

	}

}
