package com.simulate.Kavanagh.bank.model;

/**
 * This model is to keep track of the Customer's information.
 * 
 * @author Kristen Kavanagh
 * @version 11/4/2018
 *
 */
public class Customer {
	// initialize
	private int client_id;
	private String firstName;
	private String lastName;
	private double income;
	private int creditScore;
	private char address;
	private String city;
	private String state;
	private char postalCode;
	private char telePhoneNumber;
	private char customerEmail;
	private char userName;
	private char passWord;
	// Scanner input = new Scanner(System.in);

	// instantiate
	public Customer(int client_id, String firstName, String lastName, double income, int creditScore, char address,
			String city, String state, char postalCode, char telePhoneNumber, char customerEmail, char userName,
			char passWord) {
		super();
		// data = input.nextLine();
		this.client_id = client_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.income = income;
		this.creditScore = creditScore;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.telePhoneNumber = telePhoneNumber;
		this.customerEmail = customerEmail;
		this.userName = userName;
		this.passWord = passWord;
	}

	/**
	 * @return the client_id
	 */
	public int getClient_id() {
		return client_id;
	}

	/**
	 * @param client_id the client_id to set
	 */
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the income
	 */
	public double getIncome() {
		return income;
	}

	/**
	 * @param income the income to set
	 */
	public void setIncome(double income) {
		this.income = income;
	}

	/**
	 * @return the creditScore
	 */
	public int getCreditScore() {
		return creditScore;
	}

	/**
	 * @param creditScore the creditScore to set
	 */
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	/**
	 * @return the address
	 */
	public char getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(char address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the postalCode
	 */
	public char getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(char postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the telePhoneNumber
	 */
	public char getTelePhoneNumber() {
		return telePhoneNumber;
	}

	/**
	 * @param telePhoneNumber the telePhoneNumber to set
	 */
	public void setTelePhoneNumber(char telePhoneNumber) {
		this.telePhoneNumber = telePhoneNumber;
	}

	/**
	 * @return userName
	 */
	public char getuserName() {
		return userName;

	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(char userName) {
		this.userName = userName;
	}

	/**
	 * @return passWord
	 */
	public char getpassWord() {
		return passWord;

	}

	/**
	 * @param passWord the passWord to set
	 */
	public void setPassWord(char passWord) {
		this.passWord = passWord;
	}

	/**
	 * @return customerEmail
	 */
	public char getCustomerEmail() {
		return customerEmail;
	}

	/**
	 * @param customerEmail the customerEmail to set
	 */
	public void setCustomerEmail(char customerEmail) {
		this.customerEmail = customerEmail;
	}

	@Override
	public String toString() {
		return "Customer [client_id =" + client_id + ",firstName =" + firstName + ",lastName =" + lastName + ",income ="
				+ income + ",creditScore =" + creditScore + ", address =" + address + ",City=" + city + ",State="
				+ state + ",postalCode=" + postalCode + ",telePhoneNumber=" + telePhoneNumber + ",customerEmail"
				+ customerEmail + ",userName=" + userName + ",passWord=" + passWord + "]";
	}

}