package com.service;

import java.util.ArrayList;

import com.dao.account.AccountDAOImplementation;
import com.dao.client.ClientDAOImplementation;
import com.dao.transaction.TransactionDAOImplementation;
import com.profiles.Account;
import com.profiles.Client;
import com.profiles.Transaction;

public class BankServiceImplementation implements BankService {
	private ClientDAOImplementation cdao= new ClientDAOImplementation();
	private AccountDAOImplementation adao = new AccountDAOImplementation();
	private TransactionDAOImplementation tdao = new TransactionDAOImplementation();
	
	//private ClientService cserv = new ClientService();
	private AccountService aserv = new AccountServiceImplementation();
	//private EmployeeService eserv = new EmployeeService();
	
	@Override
	public ArrayList<Client> repopulateClients() {
		return cdao.selectAllClients();
	}

	@Override
	public ArrayList<Account> repopulateAccounts() {
		return adao.selectAllAccounts();
	}

	@Override
	public int storeClient(Client c) {
		return cdao.insertClient(c);
	}


	@Override
	public int storeAccount(Account a) {
		return adao.insertAccount(a);
	}

	@Override
	public int storeTransaction(Transaction t) {
		return tdao.insertTransaction(t);
	}

	@Override
	public int deposit(Account a) {
		return adao.deposit(a);
	}

	@Override
	public int withdraw(Account a) {
		return adao.deposit(a);
	}

	@Override
	public Client checkClientLogin(String first, String last, String password) {
		return cdao.checkClientLogin(first, last, password);
	}

	@Override
	public Account lookUpAccount(int accountNumber) {
		return adao.lookUpAccount(accountNumber);
	}

	@Override
	public boolean deposit(Client c, Account a) {
		 if (aserv.deposit(c, a)) {
			 adao.deposit(a);
			 return true;
		 }
		 else {
			 return false;
		 }
	}

	@Override
	public boolean withdraw(Client c, Account a) {
		return aserv.withdraw(c, a);
	}

	@Override
	public boolean transfer(Client c, Account a) {
		//not yet implemented
		//return aserv.transfer(c, a);
		return false;
	}
	
	@Override
	public void updateClient(Client c) {
		cdao.updateCLient(c);
	}
	@Override
	public Account getAccount(int accNum) {
		return adao.getAccount(accNum);
	}

	@Override
	public void updateAccount(Account a) {
		adao.updateAccount(a);
	}

	@Override
	public ArrayList<Integer> getAccountNums() {
		return adao.getAccountNums();
	}

	@Override
	public ArrayList<Integer> getClients(String p) {
		return cdao.getClients(p);
	}

	@Override
	public void wipeDB(String verify) {
		tdao.wipeDB(verify);
	}
	
}
