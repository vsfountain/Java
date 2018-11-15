package com.profiles;

//Author: Sean Doyle
//Date Created: 2018/10/24

//This class stores personal information about the client of the bank

public class Client {
	private static final String EMPLOYEEACCESSCODE = "Snoflake";
	private static final String ADMINISTRATORACCESSCODE = "Fluffy";
	private int clientID;
	public static int clientCount = 0;
	private String givenName;
	private String familyName;
	private String password = "Giant_Jenga";
	private boolean isActive = false;
	private int myAccountNumber = -1;
	//private BankService bserv = new BankServiceImplementation();

	// For use in the ClientDAO
	public Client(int clientID, String familyName, String givenName, String password, boolean isActive, int myAccountNumber) {
		this.givenName = givenName;
		this.familyName = familyName;
		this.clientID = clientID;
		this.password = password;
		this.isActive = isActive;
		this.myAccountNumber = myAccountNumber;
	}

	//for junit testing only
	public Client() {
		this.clientID = clientCount++;
		this.givenName = "spiderman";
		this.familyName = "peter";
		this.password = "parker";
		this.isActive = false;
		this.myAccountNumber = 10000;
	}
	
	public Client(String given, String family) {
		this.givenName = given;
		this.familyName = family;
		this.clientID = clientCount++;
		System.out.println("Your Client ID number is: " + clientID);
	}

	
	public void addAccount(int accNum) {
		//this.myAccounts.add(accNum);
		this.myAccountNumber = accNum;
	}
	public boolean activateClient(String verify) {
		if (verify.equals(EMPLOYEEACCESSCODE) || verify.equals(ADMINISTRATORACCESSCODE)) {
			this.isActive = true;
			return true;
		} else {
			return false;
		}
	}
	
	public void changePassword(String newPassword) {
		this.password = newPassword;
	}
	
	
	
	@Override
	public String toString() {
		return "\n\tClient [clientID=" + clientID + ", givenName=" + givenName + ", familyName=" + familyName
				+ ", password=" + password + ", isActive=" + isActive
				+ ", myAccountNumber=" + myAccountNumber + "]";
	}

	// Getters/Accessors
	public int getClientID() {
		return clientID;
	}
	protected boolean verifyPassword(String pass) {
		return pass.equals(this.password);
	}

	public int getClientAccount() {
		return this.myAccountNumber;
	}

	public boolean getClientStatus() {
		return this.isActive;
	}

	public String getGivenName() {
		return this.givenName;
	}

	public String getFamilyName() {
		return this.familyName;
	}

	public String getPassword() {
		return this.password;
	}

	
	
	// Setters/Mutators
	public boolean setClientFirstName(String newFirst) {
		this.givenName = newFirst;
		return true;
	}

	public boolean setClientLastName(String newLast) {
		this.familyName = newLast;
		return true;
	}

	public String getName() {
		return "\nGiven/First name: " + this.givenName + "\nFamil/Last name: " + this.familyName;
	}

	
	
	
	public boolean toggleApproval(String verify) {
		if (EMPLOYEEACCESSCODE.equals(verify) || ADMINISTRATORACCESSCODE.equals(verify)) {
			this.isActive = !this.isActive;
			System.out.println("SUCCESS: client status toggled.");
		} else {
			System.out.println("FAIL: Invalid Employee access code");
		}
		return this.isActive;
	}
	/*
	private void changeAccountNumber(Account toReLink, String verify) {
		// this can only be done by admins
		if (ADMINISTRATORACCESSCODE.equals(verify)) {
			this.myAccountNumber = toReLink.getAccountNumber();
			toReLink.setClientID(verify, this.clientID);
			System.out.println("SUCCESS: new account has been linked");
		} else {
			System.out.println("FAIL: Invalid ADMIN access code");
		}
	}
	*/
}