package model.users;

import java.io.Serializable;
import java.util.ArrayList;

import model.accounts.Account;


// TODO: Auto-generated Javadoc
/**
 * This class contains all information for a single user.
 */
public class User implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2L;
	
	/** The name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The email. */
	private String email;
	
	/** The password. */
	private String password;
	
	private int userId;
	
	/** The accounts of the user*. */
	private ArrayList<Account> accounts = new ArrayList<Account>();
	
	

	/** The account id. */
	final int accountId;
	
	/**
	 * Instantiates a new user.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param email the email
	 * @param password the password
	 * @param accountId the account id
	 */
	public User(String firstName,String lastName, String email, String password, int accountId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.accountId = accountId;
		this.password = password;
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param email the email
	 * @param password the password
	 */
	public User(String firstName,String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.accountId = -1;
		this.accounts = new ArrayList<Account>();
	}


	/**
	 * Gets the accounts.
	 *
	 * @return the accounts
	 */
	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	/**
	 * Sets the accounts.
	 *
	 * @param accounts the new accounts
	 */
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}



	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return firstName + " " + lastName;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setFirstName(String name) {
		this.firstName = name;
	}

	/**
	 * Sets the last name.
	 *
	 * @param name the new last name
	 */
	public void setLastName(String name) {
		this.lastName = name;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}



	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}



	/**
	 * Gets the account.
	 *
	 * @return the account
	 */
	public int getAccountId() {
		return accountId;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */


	/**
	 * Instantiates a new user.
	 *
	 * @param accountId the account
	 */
	public User(int accountId) {
		this.accountId = accountId;
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", "
				+ "email=" + email + ", password=" + password
				+ ", accountId=" + accountId + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		//System.out.println("comparing these:\n" +this.toString() + "\n" + o);
		//System.out.println("is same class?" + (o instanceof User));
		if(o instanceof User) {
			User compareTo = (User) o;
			if (this.getEmail().equals(compareTo.getEmail())) {
				return true;
			}
			
		}
		return false;
	}
	


}
