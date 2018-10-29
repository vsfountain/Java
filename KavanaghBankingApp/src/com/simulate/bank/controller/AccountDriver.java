package com.simulate.bank.controller;

public class AccountDriver {

	public AccountDriver() {
		// TODO Auto-generated constructor stub
		/**
		 * the program creates AccountDemo
		 * instances and calls their test methods.
		 * 
		 * @param args
		 *            
		 */
		public static void main(String[] args){
			System.out.println("<------ Account test ------>");
			System.out.println();
			AccountDemo demo1 = new AccountDemo();
			demo1.testBankingApp();
		}
	}
	

}
