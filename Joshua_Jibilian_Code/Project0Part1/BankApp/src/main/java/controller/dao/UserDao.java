package controller.dao;

import java.util.ArrayList;

import model.accounts.Account;
import model.accounts.JointAccount;
import model.users.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserDao.
 */
public interface UserDao {
	
	/**
	 * User login.
	 *
	 * @param email    the email
	 * @param password the password
	 * @return the user
	 */
	public User userLogin(String email, String password);

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
	
	
	/**
	 * Apply for account.
	 *
	 * @param userId the user id
	 * @param type the type
	 * @return true, if successful
	 */
	public boolean applyForAccount(int userId, int type);
	
	
	public boolean batchApplyForAccount(ArrayList<User> users);
	
	/**
	 * Approve account.
	 *
	 * @param user the user
	 * @param account the account
	 * @return true, if successful
	 */
	public boolean approveAccount(User user, Account account);
	
	/**
	 * Withdraw.
	 *
	 * @param account the account
	 * @param ammount the ammount
	 * @return true, if successful
	 */
	public boolean withdraw(int account, int ammount);
	
	/**
	 * Deposit.
	 *
	 * @param account the account
	 * @param ammount the ammount
	 * @return true, if successful
	 */
	public boolean deposit(int account, int ammount);
	
	/**
	 * Transfer.
	 *
	 * @param fromAccount the from account
	 * @param toAccount the to account
	 * @param ammount the ammount
	 * @return true, if successful
	 */
	public boolean transfer(int fromAccount, int toAccount, int ammount);
	
	/**
	 * Gets the accounts.
	 *
	 * @param userid the userid
	 * @return the accounts
	 */
	public ArrayList<Account> getAccounts(int userid);
	
	/**
	 * Gets the accounts for aproval.
	 *
	 * @return the accounts for aproval
	 */
	public ArrayList<User> getAccountsForAproval();
	
	public ArrayList<User> getAccountsForAll();
	public ArrayList<User> getAllUsers();
	
	public boolean cancelAccount(int accountid);
	
	public boolean approveJointAccount(JointAccount accountid);
	
}