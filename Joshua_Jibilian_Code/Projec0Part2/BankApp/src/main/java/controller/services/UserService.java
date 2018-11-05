package controller.services;

import java.util.ArrayList;

import controller.dao.UserDao;
import model.accounts.Account;
import model.users.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserService.
 */
public interface UserService {

	/**
	 * Login user.
	 *
	 * @param email    the email
	 * @param password the password
	 * @return the user
	 */
	public User loginUser(String email, String password);

	/**
	 * Register user.
	 *
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @param password  the password
	 * @param email     the email
	 * @return true, if successful
	 */
	public boolean registerUser(String firstName, String lastName, String password, String email);

	public boolean applyForAccount(int userId, int accountType);

	public boolean approveAccount(int accountId);

	public boolean withdraw(int account, int ammount);

	public boolean deposit(int account, int ammount);

	public boolean transfer(int fromAccount, int toAccount, int ammount);
	
	public ArrayList<Account> getAccounts(int userid);
}
