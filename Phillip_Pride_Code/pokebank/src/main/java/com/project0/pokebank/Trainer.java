package com.project0.pokebank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Trainer {

	

	private String usrname;
	private String pword;
	boolean hasOpenBox;
	int id;

	public Trainer(String usrname, String password) {
		this.usrname = usrname.toLowerCase();
		this.pword = password;
		hasOpenBox = false;
	}
	
	public Trainer(String usrname, String password, int id) {
		this.usrname = usrname.toLowerCase();
		this.pword = password;
		this.id=id;
		hasOpenBox = false;
	}

	public String getUsername() {
		return usrname;
	}

	String getPassword() {
		return pword;
	}

	@Override
	public String toString() {
		return "Trainer [username: " + usrname + " trainer id: " + id+ "]\n";
	}
}
