package com.simulate.Kavanagh.bank.model;


/**
 * This model is to keep track of the Customer's information.
 * 
 * @author Kristen Kavanagh
 * @version 11/4/2018
 *
 */
public class Customer  {
	// initialize
	private int client_id;
	private String firstName;
	private String lastName;
	private double income;
	private int creditScore;
	private  String address;
	private String city;
	private String state;
	private int postalCode;
	private int telePhoneNumber;
	private String customerEmail;
	private String userName;
	private String passWord;


	// instantiate
	public Customer(int client_id, String firstName, String lastName, double income, int creditScore, String address,
			String city, String state, int postalCode, int telePhoneNumber, String customerEmail, String userName,
			String passWord) {
		super();
		
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

	
//	
//	public Customer(String firstName, String lastName, double income, int creditScore, String address, String city,
//			String state, int postalCode, int telePhoneNumber, String customerEmail) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.income = income;
//		this.creditScore = creditScore;
//		this.address = address;
//		this.city = city;
//		this.state = state;
//		this.postalCode = postalCode;
//		this.telePhoneNumber = telePhoneNumber;
//		this.customerEmail = customerEmail;
//		this.userName = userName;
//		this.passWord = passWord;
//	}



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
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
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
	public int getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the telePhoneNumber
	 */
	public int getTelePhoneNumber() {
		return telePhoneNumber;
	}

	/**
	 * @param telePhoneNumber the telePhoneNumber to set
	 */
	public void setTelePhoneNumber(int telePhoneNumber) {
		this.telePhoneNumber = telePhoneNumber;
	}

	/**
	 * @return userName
	 */
	public String getuserName() {
		return userName;

	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return passWord
	 */
	public String getpassWord() {
		return passWord;

	}

	/**
	 * @param passWord the passWord to set
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	/**
	 * @return customerEmail
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}

	/**
	 * @param customerEmail the customerEmail to set
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	@Override
	public String toString() {
		return "Customer [client_id =" + client_id + ",firstName =" + firstName + ",lastName =" + lastName + ",income ="
				+ income + ",creditScore =" + creditScore + ", address =" + address + ",City=" + city + ",State="
				+ state + ",postalCode=" + postalCode + ",telePhoneNumber=" + telePhoneNumber + ",customerEmail"
				+ customerEmail + ",userName=" + userName + ",passWord=" + passWord + "]";
	}


	public Object selectAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

}