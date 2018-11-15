package controller.services;

import java.util.ArrayList;

import controller.dao.UserDao;
import controller.dao.UserDaoImpl;
import model.accounts.Account;
import model.accounts.JointAccount;
import model.users.User;

// TODO: Auto-generated Javadoc
/**
 * The Class UserServicesImpl.
 */
public class UserServicesImpl implements UserService {

	/* (non-Javadoc)
	 * @see controller.services.UserService#loginUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User loginUser(String email, String password) {
		UserDao dao = new UserDaoImpl();
		User toReturn = dao.userLogin(email, password);
		//System.out.println("TO RET : " + toReturn);
		return toReturn;
	}

	/* (non-Javadoc)
	 * @see controller.services.UserService#registerUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean registerUser(String firstName, String lastName, String password, String email) {
		UserDao dao = new UserDaoImpl();
		return dao.registerUser(firstName, lastName, password, email);
	}


	/* (non-Javadoc)
	 * @see controller.services.UserService#approveAccount(model.users.User, model.accounts.Account)
	 */
	@Override
	public boolean approveAccount(User user, Account account) {
		UserDao dao = new UserDaoImpl();
		
		return dao.approveAccount(user, account);
	}

	/* (non-Javadoc)
	 * @see controller.services.UserService#withdraw(int, int)
	 */
	@Override
	public boolean withdraw(int account, int ammount) {
		UserDao dao = new UserDaoImpl();
		return dao.withdraw(account, ammount);
	}

	/* (non-Javadoc)
	 * @see controller.services.UserService#deposit(int, int)
	 */
	@Override
	public boolean deposit(int account, int ammount) {
		UserDao dao = new UserDaoImpl();
		return dao.deposit(account, ammount);
	}

	/* (non-Javadoc)
	 * @see controller.services.UserService#transfer(int, int, int)
	 */
	@Override
	public boolean transfer(int fromAccount, int toAccount, int ammount) {
		UserDao dao = new UserDaoImpl();
		return dao.transfer(fromAccount, toAccount, ammount);
	}

	/* (non-Javadoc)
	 * @see controller.services.UserService#getAccounts(int)
	 */
	@Override
	public ArrayList<Account> getAccounts(int userid) {
		UserDao dao = new UserDaoImpl();
		return dao.getAccounts(userid);
	}

	/* (non-Javadoc)
	 * @see controller.services.UserService#applyForAccount(int, int)
	 */
	@Override
	public boolean applyForAccount(int userId, int accountType) {
		UserDao dao = new UserDaoImpl();
		
		return dao.applyForAccount(userId, accountType);
	}

	/* (non-Javadoc)
	 * @see controller.services.UserService#getAccountsForAproval()
	 */
	@Override
	public ArrayList<User> getAccountsForAproval() {
		UserDao dao = new UserDaoImpl();
		
		return dao.getAccountsForAproval();
	}

	@Override
	public ArrayList<User> getAccountsForAll() {
		UserDao dao = new UserDaoImpl();
		return dao.getAccountsForAll();
	}

	@Override
	public boolean cancelAccount(int accountid) {
		UserDao dao = new UserDaoImpl();
		return dao.cancelAccount(accountid);
	}

	@Override
	public ArrayList<User> getAllUsers() {
		UserDao dao = new UserDaoImpl();
		return dao.getAllUsers();
	}

	@Override
	public boolean batchApplyForAccount(ArrayList<User> users) {
		UserDao dao = new UserDaoImpl();
		return dao.batchApplyForAccount(users);
	}

	@Override
	public boolean approveJointAccount(JointAccount accountid) {
		UserDao dao = new UserDaoImpl();
		return dao.approveJointAccount(accountid);
	}

}
