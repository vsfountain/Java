package com.example.main;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.example.model.Account;
import com.example.model.Customer;
import com.example.model.Transaction;
import com.example.service.AccountService;
import com.example.service.AccountServiceImpl;
import com.example.service.CustomerService;
import com.example.service.CustomerServiceImpl;
import com.example.service.TransactionService;
import com.example.service.TransactionServiceImpl;

public class LogIn {

	final static Logger logger = Logger.getLogger(Main.class);
	
	
	
	public static int transferPrompt(Customer c) {
		
		
		int a = promptTransfer(c);
		if(a == 0) {
			return 0;
		} else {
			return 1;
		}
		
		
	}
	
	
	public static int promptTransfer(Customer c) {
		
		System.out.println("Choose Account to Transfer From");
		AccountService accountService = new AccountServiceImpl();
		CustomerService customerService = new CustomerServiceImpl();
		TransactionService transactionService = new TransactionServiceImpl();
		List<Account> accountList = accountService.getAllCustomerAccount(c);
		Account transferFromAccount = null;
		Account transferToAccount = null;
		if(accountList.size() == 0) {
			System.out.println("No Available Accounts");
			return 0;
		}
		System.out.println("List of Accounts:");
		DecimalFormat formatter = new DecimalFormat("#0.00");
		for(int i = 0; i<accountList.size(); i++) {
			if(accountList.get(i).isJointAccount()) {
				Customer jointCustomer = customerService.getCustomerById(accountList.get(i).getJointCustomerNumber());
				System.out.println(accountList.get(i).getAccountNumber() + ") $"
									+ formatter.format(accountList.get(i).getAmount())
									+ " | Joint Owner: " + jointCustomer.getUsername());
			} else {
				System.out.println(accountList.get(i).getAccountNumber() + ") $"
									+ formatter.format(accountList.get(i).getAmount()));
			
			}
		}
		
		boolean lo = true;
		Scanner sc = new Scanner(System.in);
		
		while(lo) {
			String userInput = sc.next();
			if(userInput.equals("b")) {
				return 0;
			}
			
			try {
				for(int i = 0; i<accountList.size(); i++) {
					if(accountList.get(i).getAccountNumber() == Integer.parseInt(userInput)) {
						transferFromAccount = accountList.get(i);
						boolean secondLo = true;
						accountList.remove(transferFromAccount);
						System.out.println("Choose Account to Transfer To");
						if(accountList.size() == 0) {
							System.out.println("No Available Accounts");
							return 0;
						}
						System.out.println("List of Accounts:");
						for(int j = 0; j<accountList.size(); j++) {
							if(accountList.get(j).isJointAccount()) {
								Customer jointCustomer = customerService.getCustomerById(accountList.get(j).getJointCustomerNumber());
								System.out.println(accountList.get(j).getAccountNumber() + ") $"
													+ formatter.format(accountList.get(j).getAmount())
													+ " | Joint Owner: " + jointCustomer.getUsername());
							} else {
								System.out.println(accountList.get(j).getAccountNumber() + ") $"
													+ formatter.format(accountList.get(j).getAmount()));
							
							}
						}
						
						
						
						while(secondLo) {
							String secondUserInput = sc.next();
							if(secondUserInput.equals("b")) {
								return 0;
							}
							
							try {
								
								for(int j = 0; j<accountList.size(); j++) {
									if(accountList.get(j).getAccountNumber() == Integer.parseInt(secondUserInput)) {
										transferToAccount = accountList.get(j);
										boolean thirdLo = true;
										while(thirdLo) {
											try {
												
												System.out.println("How much would you like to Transfer?");
												String transferAmount = sc.next();
												if(transferAmount.equals("b")) {
													return 0;
												} else if (transferAmount.charAt(0) == '-') {
													
												} else {
													double transferAmountDouble = Double.parseDouble(formatter.format(Double.parseDouble(transferAmount)));
													if(transferAmountDouble > transferFromAccount.getAmount()) {
														System.out.println("Amount $" + transferAmountDouble + " is greater than transfer "
																			+ "from account balance: $" + transferFromAccount.getAmount());
													} else {
														transferFromAccount.withdraw(transferAmountDouble);
														transferToAccount.deposit(transferAmountDouble);
														Date date = new Date();
														System.out.println("User " + c.getUsername() + " transferred $" + transferAmountDouble
																			+ " from Account #" + transferFromAccount.getAccountNumber()
																			+ " to Account #" + transferToAccount.getAccountNumber());
														logger.info("User " + c.getUsername() + " transferred $" + transferAmountDouble
																	 + " from Account #" + transferFromAccount.getAccountNumber()
																	 + " to Account #" + transferToAccount.getAccountNumber());
														String description = "User " + c.getUsername() + " transferred $" + transferAmountDouble
																+ " from Account #" + transferFromAccount.getAccountNumber()
																+ " to Account #" + transferToAccount.getAccountNumber() + " on " + date.toString();
														Transaction transaction = new Transaction(transferFromAccount.getAccountNumber(),
																								transferToAccount.getAccountNumber(),
																								description);
														accountService.updateAccount(transferFromAccount);
														accountService.updateAccount(transferToAccount);
														transactionService.createTransaction(transaction);
														return 0;
													}
												}
												
												
												
												
												
												
											} catch (NumberFormatException e) {
												System.out.println("Please enter amount");
											}
										}
									}
								}
								
								
							} catch (NumberFormatException e) {
								System.out.println("Please choose Account");
							}
							
							
							
						}
						
						
						
					}
				}
				System.out.println("The input provided did not match "
									+ "one of the available "
									+ "accounts");


			} catch (NumberFormatException e) {
				System.out.println("Please choose Account");
			}
			
			
		}
		
		return 0;
		
		
	}
	
	
	
	
	
	
	public static int withdrawalPrompt(Customer c) {
		
		
		int a = promptWithdrawal(c);
		if(a == 0) {
			return 0;
		} else {
			return 1;
		}
		
		
		
	}
	
	
	public static int promptWithdrawal(Customer c) {
		
		System.out.println("Choose Account to Withdraw");
		AccountService accountService = new AccountServiceImpl();
		CustomerService customerService = new CustomerServiceImpl();
		TransactionService transactionService = new TransactionServiceImpl();
		List<Account> accountList = accountService.getAllCustomerAccount(c);
		if(accountList.size() == 0) {
			System.out.println("No Available Accounts");
			return 0;
		}
		System.out.println("List of Accounts:");
		DecimalFormat formatter = new DecimalFormat("#0.00");
		for(int i = 0; i<accountList.size(); i++) {
			if(accountList.get(i).isJointAccount()) {
				Customer jointCustomer = customerService.getCustomerById(accountList.get(i).getJointCustomerNumber());
				System.out.println(accountList.get(i).getAccountNumber() + ") $"
									+ formatter.format(accountList.get(i).getAmount())
									+ " | Joint Owner: " + jointCustomer.getUsername());
			} else {
				System.out.println(accountList.get(i).getAccountNumber() + ") $"
									+ formatter.format(accountList.get(i).getAmount()));
			
			}
		}
		
		boolean lo = true;
		Scanner sc = new Scanner(System.in);
		boolean depositAccountHasBeenSelected = false;
		while(lo) {
			String userInput = sc.next();
			if(userInput.equals("b")) {
				return 0;
			}
			
			try {
			
			for(int i = 0; i<accountList.size(); i++) {
				if(accountList.get(i).getAccountNumber() == Integer.parseInt(userInput)) {
					Account withdrawAccount = accountList.get(i);
					boolean secondLo = true;
					while(secondLo) {

						try {

							System.out.println("How much would you like to Withdraw?");
							String withdrawalAmount = sc.next();
							if(withdrawalAmount.equals("b")) {
								return 0;
							} else if (withdrawalAmount.charAt(0) == '-') {
								
							} else {
								double withdrawalAmountDouble = Double.parseDouble(formatter.format(Double.parseDouble(withdrawalAmount)));
								if(withdrawalAmountDouble > withdrawAccount.getAmount()) {
									System.out.println("Amount $" + withdrawalAmountDouble + " is greater than account balance: $" + withdrawAccount.getAmount());
								} else {
								withdrawAccount.withdraw(withdrawalAmountDouble);
								Date date = new Date();
								System.out.println("User " + c.getUsername() + " withdrew $" + withdrawalAmountDouble
													+ " from Account #" + withdrawAccount.getAccountNumber());
								logger.info("User " + c.getUsername() + " withdrew $" + withdrawalAmountDouble
											+ " from Account #" + withdrawAccount.getAccountNumber());
								String description = "User " + c.getUsername() + " withdrew $" + withdrawalAmountDouble
													+ " from Account #" + withdrawAccount.getAccountNumber() + " on " + date.toString();
								Transaction transaction = new Transaction(withdrawAccount.getAccountNumber(), description);
								accountService.updateAccount(withdrawAccount);
								transactionService.createTransaction(transaction);
								return 0;
								}
								
							}

						} catch (NumberFormatException e) {
							System.out.println("Please enter amount");
						}

					}
					
				}
			}
			System.out.println("The input provided did not match "
								+ "one of the available "
								+ "accounts");
			
			
			} catch (NumberFormatException e) {
				System.out.println("Please choose Account");
			}
			
		}
		
		return 0;
		
		
		
	}
	
	
	public static int depositPrompt(Customer c) {
		
		
		int a = promptDeposit(c);
		if(a == 0) {
			return 0;
		} else {
			return 1;
		}
		
		
	}
	
	public static int promptDeposit(Customer c) {
		
		System.out.println("Choose Account to Deposit");
		AccountService accountService = new AccountServiceImpl();
		CustomerService customerService = new CustomerServiceImpl();
		TransactionService transactionService = new TransactionServiceImpl();
		List<Account> accountList = accountService.getAllCustomerAccount(c);
		if(accountList.size() == 0) {
			System.out.println("No Available Accounts");
			return 0;
		}
		System.out.println("List of Accounts:");
		DecimalFormat formatter = new DecimalFormat("#0.00");
		for(int i = 0; i<accountList.size(); i++) {
			if(accountList.get(i).isJointAccount()) {
				Customer jointCustomer = customerService.getCustomerById(accountList.get(i).getJointCustomerNumber());
				System.out.println(accountList.get(i).getAccountNumber() + ") $"
									+ formatter.format(accountList.get(i).getAmount())
									+ " | Joint Owner: " + jointCustomer.getUsername());
			} else {
				System.out.println(accountList.get(i).getAccountNumber() + ") $"
									+ formatter.format(accountList.get(i).getAmount()));
			
			}
		}
		
		boolean lo = true;
		Scanner sc = new Scanner(System.in);
		boolean depositAccountHasBeenSelected = false;
		while(lo) {
			String userInput = sc.next();
			if(userInput.equals("b")) {
				return 0;
			}
			
			try {
			
			for(int i = 0; i<accountList.size(); i++) {
				if(accountList.get(i).getAccountNumber() == Integer.parseInt(userInput)) {
					Account depositAccount = accountList.get(i);
					boolean secondLo = true;
					while(secondLo) {

						try {

							System.out.println("How much would you like to Deposit?");
							String depositAmount = sc.next();
							if(depositAmount.equals("b")) {
								return 0;
							} else if (depositAmount.charAt(0) == '-') {
								
							} else {
								double depositAmountDouble = Double.parseDouble(formatter.format(Double.parseDouble(depositAmount)));
								depositAccount.deposit(depositAmountDouble);
								Date date = new Date();
								System.out.println("User " + c.getUsername() + " deposited $" + depositAmountDouble
													+ " into Account #" + depositAccount.getAccountNumber());
								logger.info("User " + c.getUsername() + " deposited $" + depositAmountDouble
											+ " into Account #" + depositAccount.getAccountNumber());
								String description = "User " + c.getUsername() + " deposited $" + depositAmountDouble
													+ " into Account #" + depositAccount.getAccountNumber() + " on " + date.toString();
								Transaction transaction = new Transaction(depositAccount.getAccountNumber(), description);
								accountService.updateAccount(depositAccount);
								transactionService.createTransaction(transaction);
								return 0;
								
							}

						} catch (NumberFormatException e) {
							System.out.println("Please enter amount");
						}

					}
					
				}
			}
			System.out.println("The input provided did not match "
								+ "one of the available "
								+ "accounts");
			
			
			} catch (NumberFormatException e) {
				System.out.println("Please choose Account");
			}
			
		}
		
		return 0;
	}
	
	
	
	
	public static int registerJointAccount(Customer c) {
		int a = promptJointAccountOwner(c);
		if(a == 0) {
			return 0;
		} else {
			return 1;
		}
		
		//System.out.println("Choose Joint Account Owner");
		
		
		
		
	}
	
	public static int promptJointAccountOwner(Customer c) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose Joint Account Owner");
		CustomerService customerService = new CustomerServiceImpl();
		List<Customer> customerList = customerService.getAllCustomer();
		Iterator<Customer> iter = customerList.iterator();
		while(iter.hasNext()) {
			Customer cc = iter.next();
			if(c.getUsername().equals(cc.getUsername())) {
				/*customerList.remove(cc);*/
				iter.remove();
			}
			
		}
		/*for(Customer cc: customerList) {
			
		}*/
		System.out.println("List of Customers:");
		if(customerList.size() == 0) {
			System.out.println("There are no other available Customers");
			return 0;
		}
		for(int i = 0; i<customerList.size(); i++) {
			System.out.println(1 + i + ") User: \"" + customerList.get(i).getUsername() + "\" "
								+ customerList.get(i).getFirstName() + " " 
								+ customerList.get(i).getLastName());
		}
		
		boolean inputSelected = true;
		while(inputSelected) {
		String userInput = sc.next();
		if(userInput.equals("b")) {
			return 0;
		}
		try {
		for(int i = 0; i < customerList.size(); i++ ) {
			if(Integer.parseInt(userInput) - 1 == i /*userInput.equals(Integer.toString(i))*/) {
				inputSelected = false;
			}
			
		}
		} catch (NumberFormatException e) {
			
		}
		
		
		
		if(!inputSelected) {
			AccountService accountService = new AccountServiceImpl();
			Customer jointCustomer = customerList.get(Integer.parseInt(userInput) - 1);
			int jointAccountCreate = accountService.createJointAccount(c, jointCustomer);
			if(jointAccountCreate == 1) {
				System.out.println("Joint Account application submitted");
				logger.info("Joint Account application for user \"" + c.getUsername()
							+ "\" and \"" + jointCustomer.getUsername() + "\" submitted");
				return 1;
			} else {
				System.out.println("Creating Account application for user \"" + c.getUsername()
									+ "\" and \"" + jointCustomer.getUsername() + "\" unsuccessful");
				return 0;
			}
			
			
			
		} else {
			System.out.println("The input provided did not match"
								+ " one of the available"
								+ " accounts"
								+ "\nPlease choose a Joint Account");
		}
		
		
		
		}
		return 0;
		
	}
	
	
	
	
	public static int registerAccount(Customer c) {
		
		
		AccountService accountService = new AccountServiceImpl();
		int accountCreate = accountService.createAccount(c);
		if(accountCreate == 1) {
			System.out.println("Account application submitted");
			logger.info("Account application for user \"" + c.getUsername() + "\" submitted");
			return 1;
		} else {
			System.out.println("Creating Account application for user \"" + c.getUsername()
								+ "\" unsuccessful");
			return 0;
		}
		
		
	}
	
	
	
	
	
	
	
	public static Customer logInPrompt() {
		String username = LogIn.askUsername();
		if(username.equals("b")) {
			return null;
		}
		String password = LogIn.askPassword(username);
		if(password.equals("b")) {
			return null;
		} else if (password.equals("")) {
			System.out.println("Invalid username/password"
								+ "\nPlease try again");
			
		} else {
			System.out.println("User \"" + username + "\" has logged in");
			CustomerService customerService = new CustomerServiceImpl();
			Customer c = customerService.getCustomer(username);
			return c;
		}
		return null;
	}
	
	
	
	
	
	public static String askUsername() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter username"
							+ "\nb) Exit");
		
		boolean lo = true;
		while(lo) {
			String username = sc.next();
			if(username.equals("b")) {
				return "b";
			} else if (username.equals("")) {
				System.out.println("Please enter username");
			} else {
				CustomerService customerService = new CustomerServiceImpl();
				String dbUsername = customerService.getCustomerName(username);
				if(dbUsername.equals("")) {
					
					System.out.println("Invalid username " + "\"" + username + "\""
										+ "\nPlease try again");
					
					
				} else {
					
					return username;
					
				}
				
				
				
			}
			
			
			
		}
		return null;
		
	}
	
	
	
	public static String askPassword(String username) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter password"
							+ "\nb) Exit");
		
		boolean lo = true;
		while(lo) {
			
			String password = sc.next();
			if(password.equals("b")) {
				return "b";
			} else if (password.equals("")) {
				System.out.println("Please enter password");
			} else {
				CustomerService customerService = new CustomerServiceImpl();
				Customer c = customerService.getCustomer(username);
				if(password.equals(c.getPassword())) {
					return password;
				} else {
					return "";
				}
			}
			
			
			
		}
		return null;
		
		
		
		
		
	}
	
	
	
	
	
	
	
}
