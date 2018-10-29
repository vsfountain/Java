package com.simulate.bank.model;

import java.util.Scanner;

/**
 * This model is to keep track of the Customer's information.
 * 
 * @author Kristen Kavanagh
 * @version 10/27/2018
 *
 */
public class Customer {
	String name;
	String userName;
	String passWord;
	Scanner input = new Scanner(System.in);

	/**
	 * Initialize the customer value
	 */
	public Customer() {
		this.userName = "Moneyiam";
		this.passWord = "MyLoveMoney";
		this.name = "";

	}

	/**
	 * Customer register userName and password.
	 * 
	 */
	public String webRegister(String userName, String passWord) {
		return this.userName + this.passWord;
	}

	/**
	 * Apply to Open and Account
	 */
	public void applyOpenAccount() {
		System.out.println("Create your username:\n + Enter your Password");

		if (this.userName.equals(userName) && (this.userName.equals(passWord))) {
			System.out.println("Welcome to Kavanagh's Bank ");
		} else {
			System.out.println("Sorry, please try again");
		}
	}

}
