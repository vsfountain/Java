package model.users;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import controller.dataio.Serializer;

// TODO: Auto-generated Javadoc
/**
 * The Class AllUsers.
 */
public class AllUsers implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**  Contains all users that have created an account. */
	private ArrayList<User> users = new ArrayList<User>();
	
	/** The next id to be used for a new user. */
	private int nextId = 10000;
	
	/** File for serialization. */
	private final static File f = new File("AllUsers");
	
	/** The single instance. */
	private static AllUsers single_instance = null;

	/**
	 * Gets the file to save object in.
	 *
	 * @return File f, the file to use for serialization
	 */
	public static File getF() {
		return f;
	}

	

	/**
	 * Instantiates a new all users.
	 */
	private AllUsers() {

	}

	
	/**
	 * Gets the single instance of AllUsers.
	 *
	 * @return AllUsers Returns the one instance of the class all users
	 */
	public static AllUsers getInstance() {
		Serializer<AllUsers> s = new Serializer<AllUsers>();
		// single_instance = s.load(f);
		// System.out.println("is null? " + single_instance.getUsers());
		try {
			if (f.createNewFile()) {
				single_instance = new AllUsers();
			} else if (single_instance == null) {
				// System.out.println("Loading");
				single_instance = s.load(f);
			}
		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(single_instance);
		// System.out.println(single_instance.getUsers());
		return single_instance;

	}

	/**
	 * Gets the array list of all registered users.
	 *
	 * @return ArrayList{@literal <User>} All users that have been added
	 */
	public ArrayList<User> getUsers() {
		return users;
	}

	/**
	 * Sets the users array list. used for debug.
	 *
	 * @param users the new users array list
	 */
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	/**
	 * Adds a new user.
	 *
	 * @param u The new user to add to the array list
	 */
	public void addUser(User u) {
		// System.out.println("Instance of User? " + (u instanceof User));
		// System.out.println(users);
		// System.out.println("is email already used" + users.contains(u));
		// PotentialUsers pUsers = PotentialUsers.getInstance();
		if (!users.contains(u)) {
			User toAdd = null;
			if (u instanceof Employee) {
				toAdd = new Employee(u.getFirstName(),u.getLastName(), u.getEmail(), u.getPassword(), nextId++);
			} else {
				toAdd = new ClientUser(u.getFirstName(),u.getLastName(), u.getEmail(), u.getPassword(), nextId++);
			}
			// pUsers.removeUser(u);
			users.add(toAdd);
		} else {
			// System.out.println("Email already in use");
		}
	}

	/**
	 * Removes a user from the array list.
	 *
	 * @param toRemove the to remove
	 * @return true, if successful, otherwise false
	 */
	public boolean removeUser(User toRemove) {
		return users.remove(toRemove);

	}

	/**
	 * Checks if the user entered valid info for log in.
	 *
	 * @param o the user to check for login
	 * @return the user proper information
	 */
	public User loginCorrect(User o) {
		int exsists = users.indexOf(o);
		//System.out.println("AllUsers: " + exsists);
		if (exsists >= 0) {
			User actual = users.get(exsists);
			//System.out.println("AllUsers: " +actual);
			//System.out.println("AllUsers: " +o);
			if (actual.getPassword().equals(o.getPassword())) {
				//System.out.println("AllUsers: User exists");
				return actual;
			}

		}
		System.out.println("\nUser dosn't exsists or wrong password");
		return null;

	}

}
