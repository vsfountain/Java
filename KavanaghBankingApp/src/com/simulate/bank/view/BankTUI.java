package com.simulate.bank.view;
import java.util.Scanner;

import com.simulate.bank.model.Account;
import com.simulate.bank.controller.*;

/**
 * model accepts user's input
 * 
 * @author Kristen Kavanagh
 * @version 10/22/2018
 *
 */

public class BankTUI {
	 Account balance;
	private Scanner input = new Scanner(System.in);

	/**
	 * the constructor
	 */
	public BankTUI() {
		String scan = this.input.nextLine();
		Double temp  = Double.parseDouble(scan);
			this.balance = new Account();
	}

	/**
	 * get an account balance, then run the full simulation and
	 * display the resulting board at the end
	 */
	public void run() {
		this.balance.getBalance();
		//this.lites.runSimulation();
		//this.lites.describeBoard();

	}

}

