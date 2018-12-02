package com.simulate.Kavanagh.bank.model;

/**
 * models administrators values
 * 
 * @author Kristen Kavanagh
 * @version 11/04/2018
 *
 */
public class Administrator {
	private int admin_id;
	private String adminFirstName;
	private String adminLastName;
	private String adminEmail;

	/**
	 * @param admin_id
	 * @param adminFirstName
	 * @param adminLastName
	 * @param adminEmail
	 */
	public Administrator(int admin_id, String adminFirstName, String adminLastName, String adminEmail) {
		super();
		this.admin_id = admin_id;
		this.adminFirstName = adminFirstName;
		this.adminLastName = adminLastName;
		this.adminEmail = adminEmail;
	}

	/**
	 * @return the admin_id
	 */
	public int getAdmin_id() {
		return admin_id;
	}

	/**
	 * @param admin_id the admin_id to set
	 */
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	/**
	 * @return the adminFirstName
	 */
	public String getAdminFirstName() {
		return adminFirstName;
	}

	/**
	 * @param adminFirstName the adminFirstName to set
	 */
	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}

	/**
	 * @return the adminLastName
	 */
	public String getAdminLastName() {
		return adminLastName;
	}

	/**
	 * @param adminLastName the adminLastName to set
	 */
	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}

	/**
	 * @return the adminEmail
	 */
	public String getAdminEmail() {
		return adminEmail;
	}

	/**
	 * @param the adminEmail the adminEmail to set
	 */
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Administrator [admin_id=" + admin_id + ", adminFirstName=" + adminFirstName + ", adminLastName="
				+ adminLastName + ",adminEmail=" + adminEmail + "]";
	}

}
