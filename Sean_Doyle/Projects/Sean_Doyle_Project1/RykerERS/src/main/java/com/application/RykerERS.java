package com.application;

import com.servicelayer.ERSService;
import com.servicelayer.ERSServiceImplementation;

//used to test practical functionality

public class RykerERS {
	public static void main(String[] args) {
		ERSService eserv = new ERSServiceImplementation();
		System.out.println(eserv.getAllUsers());
		System.out.println(eserv.getAllReimbs());
		//System.out.println(eserv.getAllUserReimbs(3));		
		System.out.println(eserv.getAllUserReimbs("seandoyle"));	
		//System.out.println(eserv.getAllUserReimbs(20));
		System.out.println(eserv.checkLoginCreds("seandoyle", "12345"));
		//System.out.println(eserv.updateReimbursement(141, "trevinchester", "DENY".toLowerCase()));
	}
	
}
