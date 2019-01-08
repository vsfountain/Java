package com.minifullstack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class Users {
	@Id
	@Column(name= "user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	@Column (name= "user_role",unique = true, nullable=false)
	private int userRole;
	
	@Column (name= "username", unique = true, nullable= false)
	private String userName;
	
	@Column(name= "passWord", nullable= false)
	private String passWord;
	
	@Column(name= "firstName")
	private String firstName;
	
	@Column(name= "lastName")
	private String lastName;
	
	@Column(name= "email")
	private String email;
	
	public Users() {}

	public Users(int user_id,  String userName, String passWord, String firstName, String lastName, String email, int userRole) {
		super();
		this.userId = user_id;
		this.userRole = userRole;
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Users( String userName, String passWord, String firstName, String lastName, String email, int userRole) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userRole=" + userRole + ", userName=" + userName + ", passWord="
				+ passWord + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
 
}
