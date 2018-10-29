package com.app.account;

import java.io.Serializable;
import java.util.ArrayList;

public class RegistrationList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4668059490990768449L;

	private static RegistrationList instance;

	public ArrayList<Registration> registrationList = new ArrayList<>();

	public void addRegistration(Registration registration) {
		registrationList.add(registration);
		System.out.println(registrationList.toString());
	}

	private RegistrationList() {

	}

	public static RegistrationList getInstance() {
		if (instance == null) {
			instance = new RegistrationList();
		}
		return instance;
	}
	

	@Override
	public String toString() {
		return "RegistrationList [registrationList=" + registrationList + "]";
	}

	
}
