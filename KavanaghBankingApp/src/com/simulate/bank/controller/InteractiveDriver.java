package com.simulate.bank.controller;

import com.simulate.bank.view.BankTUI;

/**
 * 
 * @author Kristen Kavanagh
 * @version 10/27/2018
 *
 */
public class InteractiveDriver {


	public InteractiveDriver() {
		/*
		 * Creates  simulation for the BankTUI
		 */
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Kavanagh Simulator\n");
		System.out.println("What would you like to do?\n");
		
		BankTUI accts = new BankTUI();
		
		System.out.println("Here is the information you requested:\n");
		accts.run();
		
	}

}
