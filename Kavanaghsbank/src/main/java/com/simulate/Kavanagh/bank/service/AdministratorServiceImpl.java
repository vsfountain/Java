/**
 * 
 */
package com.simulate.Kavanagh.bank.service;

import java.util.List;

import com.simulate.Kavanagh.bank.dao.AdministratorDao;
import com.simulate.Kavanagh.bank.dao.AdministratorDaoImpl;
import com.simulate.Kavanagh.bank.model.Administrator;

/**
 * @author Kristen Kavanagh 
 * @version 11/6/2018 
 *
 */
public class AdministratorServiceImpl implements AdministratorService {
	
	private AdministratorDao adminis= new AdministratorDaoImpl();

	@Override
	public List<Administrator>getAllAdministrator() {
		// put any other business logic here
		return adminis.selectAllAdministrator();
	}
	
}
	/**
	 * approve or deny account.
	 * 
	 * @return
	 */
//	public void approveAccount() {
//		if (balance.getBalance()>2100.00) {
//			System.out.println("your account has been approved my a manager");
//		} else {
//			System.out.println("manager was unable to complete your request");
//		}
//
//	}
	/**
	 * Admin capable to deposit
	 * @param amount deposit
	 */
//	public double deposit(double amount) {
//		 return balance.getBalance();
//	}

	/**
	 * Administrator withdraw.
	 */
//	public double withDraw(double amount) {
//		return balance.getBalance();
//
//	}
	/**
	 * Administrator transfer
	 */
//	public void adminTransferTo(Account balance, double amount) {
//		if (amount <= balance.getBalance()) {
//			this.withDraw(amount);
//			balance.deposit(amount);
//			System.out.println("\nTransfer succesful. Tansfered: $" + balance.getBalance());
//		} else if (amount > balance.getBalance()) {
//			System.out.println("\nTransfer failed, insufficient funds!");
//		}
//		
//	}
/**
 * cancel account
 * 
 */
//	public void cancelAccount() {
//		System.exit(0);
	

