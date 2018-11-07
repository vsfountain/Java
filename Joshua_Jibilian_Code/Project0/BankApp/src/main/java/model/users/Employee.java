package model.users;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Employee.
 */
public class Employee extends User implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7756326227857543923L;

	/**
	 * Instantiates a new employee.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param email the email
	 * @param password the password
	 * @param account the account
	 */
	public Employee(String firstName,String lastName, String email,String password, int account) {
		super(firstName, lastName, email, password, account);
		
	}
	
	/**
	 * Instantiates a new employee.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param email the email
	 * @param password the password
	 */
	public Employee(String firstName,String lastName, String email,String password) {
		super(firstName,lastName, email, password);
		
	}

	/**
	 * Instantiates a new employee.
	 *
	 * @param account the account
	 */
	// int permissions = 1;
	public Employee(int account) {
		super(account);
		
	}

}
