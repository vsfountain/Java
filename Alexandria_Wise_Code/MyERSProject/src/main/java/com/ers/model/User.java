package com.ers.model;

import java.sql.Timestamp;
import java.util.Date;

public class User {
	
	int userId;
	String userName;
	String password;
	String firstName;
	String lastName;
	String email;
	int roleId;
	
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/*public User userLogin() {
		UserDAOImpl newUser =` new UserDAOImpl();
		
		User myUser = newUser.login(this.userName, this.password);
		return myUser;
	}
*/	
	/*Timestamp getCurrentTime() {
		Date date = new Date();
		long time = date.getTime();
		
		Timestamp ts = new Timestamp(time);
		
		return ts;
	}
	*/
	/*void viewTickets() {
		ReimbursementDAOImpl myReimbursement = new ReimbursementDAOImpl();
		myReimbursement.selectAllReimbursements();
	}*/
	
	/*void viewTicketsById() {
		ReimbursementDAOImpl myReimbursement = new ReimbursementDAOImpl();
		myReimbursement.selectReimbursementsByID(this.userId);
	}
*/	
	public User(int userId, String userName, String password, String firstName, String lastName, String email, int roleId) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleId = roleId;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String userName, String password) {
		this.password = password;
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", roleId=" + roleId + "]";
	}
	
}
