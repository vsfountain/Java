package com.practice.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practice.model.Account;

@Repository("AccountDAO")
@Transactional
public class AccountDao {
		
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Autowired
	private SessionFactory ses;
	
	public void registerAccount(Account account) {
		ses.getCurrentSession().save(account);
	}
	
	public List <Account> getAllAccounts(){
		return ses.getCurrentSession().createQuery("From Account" , Account.class).list();
	}
	
}
