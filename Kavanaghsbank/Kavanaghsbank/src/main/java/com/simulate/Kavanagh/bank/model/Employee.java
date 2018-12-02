package com.simulate.Kavanagh.bank.model;

/**
 * Creates the employee model
 * 
 * @author Kristen Kavanagh
 * @version 11/4/2018
 *
 */

public class Employee {
//initialize
	private int employee_id;
	private String empFirstName;
	private String empLastName;
	private String jobTitle;

	public Employee(int employee_id, String empFirstName, String empLastName, String jobTitle) {
		super();
		this.employee_id = employee_id;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.jobTitle = jobTitle;
	}

	/**
	 * @return the employee_id
	 */
	public int getEmployee_id() {
		return employee_id;
	}

	/**
	 * @param employee_id the employee_id to set
	 */
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	/**
	 * @return the empFirstName
	 */
	public String getEmpFirstName() {
		return empFirstName;
	}

	/**
	 * @param empFirstName the empFirstName to set
	 */
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	/**
	 * @return the empLastName
	 */
	public String getEmpLastName() {
		return empLastName;
	}

	/**
	 * @param empLastName the empLastName to set
	 */
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	/**
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", empFirstName=" + empFirstName
				+ ", empLastName=" + empLastName + ", jobTitle=" + jobTitle + "]";
	}
}
