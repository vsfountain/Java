package com.bank.views;

public class MenuPrinter {

	public static void welcome() {
		System.out.println( "*************************************\n"+
						  	"*                                   *\n"+
						  	"*  Welcome to Pipkin National Bank  *\n"+
						  	"*                                   *\n"+
						  	"*************************************");
	}
	
	public static void initial() {
		System.out.println("Please select an option\n"+
			  				"*  1. Login\n"+
			  				"*  2. Register\n"+
			  				"* 90. Exit");
	}
	
	public static void register() {
		
	}
	
	public static void login() {
		
	}

	public static void openAccount() {
		System.out.println("Please select an option\n"+
  				"*  1. Create a Personal Account\n"+
  				"*  2. Create a Joint Account\n"+
  				"* 80. Back");
	}
	
	public static void openJointAccount() {
		System.out.println("Please select an option\n"+
  				"*  1. Open Account with Existing User\n"+
  				"*  2. Open Account with New User\n"+
  				"* 80. Back");
	}
	
	public static void viewAccount() {
		
	}
	
	public static void viewUser() {
		
	}
	
	public static void adminMenu() {
		System.out.println("Please select an option\n"+
  				"*  1. Create an Account\n"+
  				"*  2. View All Accounts\n"+
  				"*  3. Approve/Deny Accounts\n"+
  				"*  4. Cancel Account\n"+
  				"*  5. View Customer Information\n"+
  				"*  6. Create User\n"+
  				"* 90. Exit");
	}
	
	public static void associateMenu() {
		//view all accounts, view all customer info
		System.out.println("Please select an option\n"+
  				"*  1. View All Accounts\n"+
  				"*  2. Approve/Deny Accounts\n"+
  				"*  3. View Customer Information\n"+
  				"* 90. Exit");
	}
	
	public static void clientMenu() {
		//view accounts, create account, view info, update info
		//transfer, withdraw, deposit
		System.out.println("Please select an option\n"+
  				"*  1. Open an Account\n"+
  				"*  2. View Accounts\n"+
  				"*  3. View Personal Infomation\n"+
  				"* 90. Exit");
	}
}
