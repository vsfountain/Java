package controller.services;

import java.util.ArrayList;

import controller.dao.UserDao;
import controller.dao.UserDaoImpl;
import model.accounts.Account;
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


	@Override
	public boolean approveAccount(int accountId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean withdraw(int account, int ammount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deposit(int account, int ammount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean transfer(int fromAccount, int toAccount, int ammount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Account> getAccounts(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean applyForAccount(int userId, int accountType) {
		UserDao dao = new UserDaoImpl();
		
		return dao.applyForAccount(userId, accountType);
	}

}
