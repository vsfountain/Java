package model.users;

import java.io.Serializable;


// TODO: Auto-generated Javadoc
/**
 * The Class ClientUser. This is a child of User. Its a marker class?
 */
public class ClientUser extends User implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5310659693113852987L;
	
	

	/**
	 * Instantiates a new client user.
	 *
	 * @param account the account
	 */
	public ClientUser(int account) {
		super(account);
		
	}

	/**
	 * Instantiates a new client user.
	 *
	 * @param name the name
	 * @param email the email
	 * @param password the password
	 * @param account the account
	 */
	public ClientUser(String name, String email,String password, int account) {
		super(name, email, password, account);
		
	}
	
	/**
	 * Instantiates a new client user.
	 *
	 * @param name the name
	 * @param email the email
	 * @param password the password
	 */
	public ClientUser(String name, String email,String password) {
		super(name, email, password);
		
	}

}
