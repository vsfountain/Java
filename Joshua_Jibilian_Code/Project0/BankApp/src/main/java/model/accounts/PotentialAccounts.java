package model.accounts;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import controller.dataio.Serializer;
import model.users.User;


// TODO: Auto-generated Javadoc
/**
 * This is where all account requests are stored for approval by admin. It is a singleton.
 */
public class PotentialAccounts implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 99L;
	
	/** The users stored in ArrayList. */
	private ArrayList<User> users = new ArrayList<User>();
	
	/** File to store info in. */
	private final static File f = new File("PotentialAccounts");
	
	/** The single instance of this class. */
	private static PotentialAccounts single_instance = null;

	
	/** The unique id start point, changed when file is loaded. */
	private int nextId = 20000;

	
	/**
	 * Gets the single instance of PotentialUsers.
	 *
	 * @return single instance of PotentialUsers
	 */
	// static method to create instance of Singleton class
	public static PotentialAccounts getInstance() {
		Serializer<PotentialAccounts> s = new Serializer<PotentialAccounts>();
		// single_instance = s.load(f);
		// System.out.println("is null? " + single_instance.getUsers());
		
		
		
		try {
			if (f.createNewFile()) {
				System.out.println("New called");
				single_instance = new PotentialAccounts();
			} else if (single_instance == null) {
				System.out.println("Loading called");
				//System.out.println("Loading");
				single_instance = s.load(f);
			}
		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(single_instance);
		//System.out.println(single_instance.getUsers());
		System.out.println("none called");
		return single_instance;

	}
	/**
	 * Gets the file to store info in.
	 *
	 * @return File f
	 */
	public static File getF() {
		return f;
	}

	
	/**
	 * Private constructor for singleton use.
	 */
	// Creates the singleton
	private PotentialAccounts() {

	}

	

	/**
	 * Gets the users list.
	 *
	 * @return ArrayList{@literal <User>}
	 */
	public ArrayList<User> getUsers() {
		return users;
	}

	/**
	 * Sets the users list to a new one.
	 *
	 * @param users the new users
	 */
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	/**
	 * Adds a new user to list.
	 *
	 * @param u the u
	 */
	public void addUser(User u) {
		//System.out.println("is email already used" + users.contains(u));
		//AllUsers all = AllUsers.getInstance();

		users.add(u);

	}
	
	/**
	 * Removes the specified user from the list user.
	 *
	 * @param toRemove the to remove
	 * @return true, if successful
	 */
	public boolean removeUser(User toRemove) {
		return users.remove(toRemove);
		
	}
	
	/**
	 * Gets the unique account id.
	 *
	 * @return int, the unique id
	 */
	public int getAccountId() {
		
		return nextId++;
	}

}
