package com.bankofdikoko.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component(value="Users")
@Entity
@Table(name="Users")
@SequenceGenerator(name= "userSeq", sequenceName = "SEQ_ID", initialValue=1, allocationSize = 1)
public class User  {

	/**
	 * 
	 */
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSeq")
	private int userId;
	@Column(name="username", unique=true, nullable=false)
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String emailAddress;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;

	
	public User() 
	{
		
	}

	public User(int userID,String userName, String password, String emailAddress, String firstName, String lastName) {
		super();
		this.userId = userID;
		this.userName = userName;
		this.password = password;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public User(String userName, String password, String emailAddress, String firstName, String lastName) {
		super();
		this.userName = userName;
		this.password = password;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", emailAddress="
				+ emailAddress + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}


	
	


}
