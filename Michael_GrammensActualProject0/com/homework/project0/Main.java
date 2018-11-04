/*
 * Michael Grammens, 10/29/2018 Banking application
 * Not optimized at all. Only have pending and approved accounts as objects, while the rest was all crammed into 1 method
 * Lots of redundent code, should have planned much better before actually coding, but it wor
 * 
 */

package com.homework.project0;

import java.util.Scanner;

import adminPanel.AdminsUI;
import customerPanel.CustomersUI;
import employeePanel.EmployeeUI;

public class Main {
	public static void main(String[] args) {
		newAccount(); //Allowing us to re-ask for Customer, employee or admin without closing application.
	}
	
	//Everything is in this 1 method, anywhere a while(true) is present, is to keep prompting the user for correct input
	public static void newAccount(){
		Scanner consoleInput = new Scanner(System.in);
		try {
			while(true) {
				System.out.println("Are you a Customer, Employee, or Admin?");
				String currentInput = consoleInput.nextLine();
				if(currentInput.toLowerCase().equals("customer")) {
					CustomersUI.customerMain(consoleInput);
				}
				else if(currentInput.toLowerCase().equals("employee")) {
					EmployeeUI.employeeMain(consoleInput);
				}
				else if(currentInput.toLowerCase().equals("admin")) {
					AdminsUI.adminMain(consoleInput);
				}
				else {
					System.out.println("Incorrect input, try again.");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			consoleInput.close();
		}
	}
}
