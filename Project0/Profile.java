package com.project0;

public class Profile {
	String name;
	String password;
	int idNumber = -2;
	int joinedId;
	boolean isApproved;
	boolean isActive;
	boolean isJoined;
	double funds;
	
	public Profile() {//no args constructor
		
	}
	public Profile(String name, String password, int idNumber) {
		super();
		this.name = name;
		this.password = password;
		this.idNumber = idNumber;
	}
	
	public Profile(String name, String password, int idNumber, int joinedAccountNum, boolean isApproved, boolean isActive, boolean isJoined, double funds) {
		super();
		this.name = name;
		this.password = password;
		this.idNumber = idNumber;
		this.joinedId = joinedAccountNum;
		this.isApproved = isApproved;
		this.isActive = isActive;
		this.isJoined = isJoined;
		this.funds = funds;
	}		

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	public int getJoinedId() {
		return joinedId;
	}

	public void setJoinedId(int joinedId) {
		this.joinedId = joinedId;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isJoined() {
		return isJoined;
	}

	public void setJoined(boolean isJoined) {
		this.isJoined = isJoined;
	}

	public double getFunds() {
		return funds;
	}

	public void setFunds(double funds) {
		this.funds = funds;
	}

	@Override
	public String toString() {
		return "\nProfile [name=" + name + ", password=" + password + ", idNumber=" + idNumber + ", joinedId=" + joinedId
				+ ", isApproved=" + isApproved + ", isActive=" + isActive + ", isJoined=" + isJoined + ", funds="
				+ funds + "]";
	}	
}
