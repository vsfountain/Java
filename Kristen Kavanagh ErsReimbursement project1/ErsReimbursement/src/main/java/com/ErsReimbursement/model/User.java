package com.ErsReimbursement.model;


/**
 * Model for user.
 * 
 * @author Kristen Kavanagh
 */
public class User {

	private int userId;
	private String userName;
	private String passWord;
	private String firstName;
	private String lastName;
	private String email;
	public int userRoleId;


	public User(int userId, String userName, String passWord, String firstName, String lastName, String email, int userRoleId) {
		super();

		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRoleId = userRoleId;

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

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
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

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", passWord=" + passWord + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", userRoleId=" + userRoleId + "]";
	}
	

	
}
