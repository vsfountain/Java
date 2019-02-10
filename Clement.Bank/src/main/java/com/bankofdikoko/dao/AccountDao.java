package com.bankofdikoko.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bankofdikoko.model.Account;

@Repository("accountDao")
@Transactional
public class AccountDao  {

	@Autowired
	private SessionFactory sesFact;
	
	
	public List <Account> viewAccounts(Account account) {
		return sesFact.getCurrentSession().createQuery("from account", Account.class).list();

	}

	public void registerAccount(String name, int balance) {
	
	}

	public int checkBalance(String name) {
		return 0;
	
	}

	public void updateBalance(int transaction, String accountName) {

	}

	public void removeAccount(String edit) {
	
	}
	@Transactional
	public void insertAccount(Account one) {
		// TODO Auto-generated method stub
		sesFact.getCurrentSession().save(one);
		
	}

}
