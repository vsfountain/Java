package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.dao.AccountDao;
import com.example.dao.AccountDaoImpl;
import com.example.model.Account;
import com.example.model.Customer;

public class AccountServiceImpl implements AccountService {

	AccountDao account = new AccountDaoImpl();
	
	
	@Override
	public int updateAccount(Account a) {
		// TODO Auto-generated method stub
		
		return account.updateAccount(a);
		
		
		//return 0;
	}
	
	
	
	@Override
	public List<Account> getAllCustomerAccount(Customer c) {
		// TODO Auto-generated method stub
		
		List<Account> accountList = account.selectAllAccount();
		List<Account> returnAccount = new ArrayList<>();
		for(Account acc: accountList) {
			if(acc.isApproved() && !acc.isCancelled()) {
				if(acc.getCustomerNumber() == c.getCustomerId()
						|| acc.getJointCustomerNumber() == c.getCustomerId()) {
					returnAccount.add(acc);
				}
				
				
			}
			/*if(acc.getCustomerNumber() == c.getCustomerId()
					|| acc.getJointCustomerNumber() == c.getCustomerId()
					&& acc.isApproved() && !acc.isCancelled()) {
				returnAccount.add(acc);
				
				
			}*/
		}
		return returnAccount;
		
		
		
		//return null;
	}
	
	
	@Override
	public List<Account> getAllAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAccountName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createAccount(Customer c) {
		// TODO Auto-generated method stub
		
		Account a = new Account(c.getCustomerId(), 0, true);
		return account.insertAccount(a);
		
		
		//return 0;
	}

	@Override
	public Account getAccount(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createJointAccount(Customer c, Customer jointCustomer) {
		// TODO Auto-generated method stub
		
		
		
		Account a = new Account(c.getCustomerId(), true, jointCustomer.getCustomerId(),
								0, true);
		return account.insertJointAccount(a);
				
				
		//return 0;
	}


	

	

}
