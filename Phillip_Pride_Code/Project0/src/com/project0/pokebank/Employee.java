package com.project0.pokebank;

import java.util.ArrayList;

public class Employee {
	
	private String usrname;
	private String password;
	private boolean isAdmin;
	private ArrayList<Trainer> clients = new ArrayList<>();
	
	public Employee() {
		
	}

	public Employee(String usrname, String password) {
		super();
		this.usrname = usrname;
		this.password = password;
		isAdmin = false;
	}
	
	public Employee(String usrname, String password, boolean isAdmin) {
		super();
		this.usrname = usrname;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public void getClients() {
		for(int i =0; i<clients.size();i++) {
			System.out.println(clients.get(i).toString());
		}
	}

	public void addClient(Trainer client) {
		this.clients.add(client);
	}

	public String getUsrname() {
		return usrname;
	}

	public String getPassword() {
		return password;
	}
	public void approveOrDeny(Trainer tr, boolean pass) {
		tr.hasOpenBox = pass;
		tr.application = "no";
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	

}
