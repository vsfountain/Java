package model.accounts;

import java.io.Serializable;
import java.util.ArrayList;

import model.users.User;


// TODO: Auto-generated Javadoc
/**
 * The Class JointAccount. Just like an account accept it has multiple owners
 */
public class JointAccount extends Account implements Serializable{

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4117195480323255192L;
	
	
	/** The with. */
	//**The users who own the account**/
	ArrayList<User> with = new ArrayList<User>();
	
	/**
	 * Instantiates a new joint account.
	 *
	 * @param type the type
	 * @param id the id
	 */
	public JointAccount(String type, int id) {
		super(type, id);
		
	}
	
	/**
	 * Adds a user to the owner list.
	 *
	 * @param user the user
	 */
	public void addUser(User user) {
		with.add(user);
	}
	
	/**
	 * Gets the user list of the people who own the account.
	 *
	 * @return ArrayList{@literal <User>} the list of owners
	 */
	public ArrayList<User> getUsersWith(){
		return with;
	}
	
	/* (non-Javadoc)
	 * @see model.accounts.Account#toString()
	 */
	@Override
	public String toString() {
		return "JointAccount [id=" + this.getId() +", with=" + with + "]" + super.toString();
	}


	

}
