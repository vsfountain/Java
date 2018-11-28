package com.classes;

import org.apache.log4j.Logger;

public class User {
	final static Logger logger = Logger.getLogger(User.class);
	private String ers_username;
	private String user_first_name;
	private String user_last_name; 
	private String user_email;
	private String user_role;
	
	
	
	
	
	
	public User(String ers_username, String user_first_name, String user_last_name, String user_email, String user_role) {
		super();
		this.ers_username = ers_username;
		this.user_first_name = user_first_name;
		this.user_last_name = user_last_name;
		this.user_email = user_email;
		this.user_role = user_role;
	}

	public String getUsername() {
		return ers_username;
	}

	public void setUsername(String ers_username) {
		this.ers_username = ers_username;
	}
	
	public String getFirstName() {
		return user_first_name;
	}

	public void setFirstName(String user_first_name) {
		this.user_first_name = user_first_name;
	}

	public String getLastName() {
		return user_last_name;
	}

	public void setLastName(String user_last_name) {
		this.user_last_name = user_last_name;
	}

	public String getEmail() {
		return user_email;
	}

	public void setEmail(String user_email) {
		this.user_email = user_email;
	}
	
	public String getRole() {
		return user_role;
	}

	public void setRole(String usr_role) {
		this.user_role = usr_role;
	}

	@Override
	public String toString() {
		return "\n\tUser [username=" + ers_username + ", firstName=" + user_first_name + ", lastName="
				+ user_last_name + ", email=" + user_email + ", role=" + user_role + "]";
	}
}
