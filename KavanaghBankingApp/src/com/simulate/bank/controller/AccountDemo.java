package com.simulate.bank.controller;
import java.util.Scanner;

import com.simulate.bank.model.*;

public class AccountDemo {
	private Account balance;
	private Employee staff;
	private Administrator manager;
	private Customer client;
	/**
	 *  Creates  account simulation
	 */

	public AccountDemo() {
		/*Account balance = new Account();
		Employee staff  = new Employee();
		Administrator manager = new Administrator();
		Customer client = new Customer();
		*/
		

	}

	/**
	 * Tests the functionality of the  bank 
	 */
	public void testBankingApp () {
		System.out.println("Welcome to the Light Board");
		System.out.println();
	      manager.withDraw(6.56);
	      client.webRegister("Moneyiam", "myLoveMoney");
	      System.out.println();
			
			System.out.println("After running the simulation, the board status is:");
			staff.personalInformation();
			client.applyOpenAccount();
		
				//Scanner input = new Scanner (System.in);
				//System.out.println("Please Log in:");
				//System.out.println ("Enter username:");
				//keyboard = input.next();
				 
				//System.out.println("password");
				//passWord = input.next();
				
				//check = new user
				//if (userName.equals(userName) && passWord.equals (passWord)) {
					//System.out.println("welcome" + this.name);
				}
				
}

		

		
		

