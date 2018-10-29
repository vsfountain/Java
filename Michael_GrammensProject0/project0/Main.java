/*
 * Michael Grammens, 10/29/2018 Banking application
 * Not optimized at all. Only have pending and approved accounts as objects, while the rest was all crammed into 1 method
 * Lots of redundent code, should have planned much better before actually coding, but it wor
 * 
 */

package com.homework.project0;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import com.homework.appliedAccounts.PendingAccounts;
import com.homework.customerAccounts.ApprovedAccounts;

public class Main {
	private static ArrayList<PendingAccounts> customerAccountRequests = new ArrayList<>();
	private static ArrayList<ApprovedAccounts> approvedAccounts = new ArrayList<>();
	private static boolean passWordChecker = false;
	private static String filename = "./objectFile.txt";
	private static ObjectOutputStream oos;
	public static void main(String[] args) {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
			newAccount(); //Allowing us to re-ask for Customer, employee or employeer without closing application.
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally{
			try {
				oos.close();
			}catch(Exception e) {
				System.out.println("WOOWOWOWOWOWO, I caught an exception.");
			}
		}
	}
	
	static void readObject(String filename) {
		try {
			oos.wait(1);
		}
		catch(Exception e) {
		}
		try(ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(filename)))
		{
			Object obj = ois.readObject();//de-serialization
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	//Everything is in this 1 method, anywhere a while(true) is present, is to keep prompting the user for correct input
	public static void newAccount() {
		System.out.println("Are you a Customer, Employee, or Admin?");
		Scanner currString = new Scanner(System.in);
		try {
			while(true) {
				String personStatus = currString.nextLine();
				if(personStatus.equals("Customer") || personStatus.equals("customer")) {
					System.out.println("Do you have an existing account? Yes or No.");
					String accountY = currString.nextLine();
					if(accountY.equals("Yes") || accountY.equals("yes")) {
						//Login info
						String associatedName = "";
						ApprovedAccounts currentAccount = new ApprovedAccounts();
						
						while(true){
							boolean checkName = false;
							System.out.println("Enter name associated with account or joint account or type \"Cancel\": ");
							associatedName = currString.nextLine();
							if(associatedName.equals("cancel") || associatedName.equals("Cancel")) {
								System.out.println("Are you a Customer, Employee, or Admin?");
								passWordChecker = true;
								break;
							}
							for(int i = 0; i < approvedAccounts.size(); i++) {

								if(approvedAccounts.get(i).getUserName().equals(associatedName) || approvedAccounts.get(i).getUserNameJoint().equals(associatedName)) {
									checkName = true;
									currentAccount = approvedAccounts.get(i);
									break;
								}
							}
							if(checkName == false) {
								System.out.println("Name was not found in our system, try again.");
							}
							else if(checkName == true){
								while(true) {
									System.out.println("Enter password associated with the account " + associatedName+ ", or type \"Cancel\": ");
									String getPassword = currString.nextLine();
									String usersPassword = currentAccount.getUserPW();
									if(getPassword.equals("Cancel") || getPassword.equals("cancel")){
										passWordChecker = true;
										System.out.println("Are you a Customer, Employee, or Admin?");
										break;
									}
									if(getPassword.equals(usersPassword)) {
										break;
									}
									else {
										System.out.println("Password incorrect, please try again.");
									}
								}
								break;
							}
						}
						if(passWordChecker==false) {
							System.out.println("Welcome: " + associatedName);
							while(true) {
								System.out.println("Would you like to withdraw, deposit or transfer funds? Withdraw, Deposit, or Transfer. Type \"Cancel\" to return to home page.");
								String userAction = currString.nextLine();
								if(userAction.equals("withdraw") || userAction.equals("Withdraw")) {
									double moneyAmount = 0.0;
									while(true) {
										System.out.print("Total Balance: ");
										System.out.println(currentAccount.getMoney());
										System.out.println("How much would you like to withdraw today? $$.$$");
										try {
											moneyAmount = Double.parseDouble(currString.nextLine());
											double moneyWithdrew = currentAccount.withdraw(moneyAmount);
											if(moneyWithdrew == -1.0) {
												System.out.println("Stop trying to break the system, no negative withdrawls. Try again.");
												break;
											}
											else if(moneyWithdrew == 0.0) {
												System.out.println("Not enough funds. Cancelling Transaction.");
												break;
											}
											else if(moneyWithdrew > 0.0) {
												System.out.println("Money has been withdrawn. New available balance: " + currentAccount.getMoney() + " Have a great Day!");
												break;
											}
										}catch(Exception E) {
											System.out.println("Wrong input, try again.");
										}
									}
								}
								else if(userAction.equals("Deposit") || userAction.equals("deposit")) {
									double moneyAmount = 0.0;
									while(true) {
										System.out.print("Total Balance: ");
										System.out.println(currentAccount.getMoney());
										System.out.println("How much would you like to Deposit today? $$.$$");
										
										try {
											moneyAmount = Double.parseDouble(currString.nextLine());
											if(moneyAmount<0.0) {
												System.out.println("You cannot subtract from a Deposit, try again. Exiting.....");
											}
											else {
												currentAccount.setMoney(moneyAmount);
												System.out.println("Money added to account, Total Balance: " + currentAccount.getMoney());
												break;
											}
										}catch(Exception E) {
											System.out.println("Wrong input, try again.");
										}
									}
								}
								else if(userAction.equals("Transfer") || userAction.equals("transfer")) {
									double moneyAmount = 0.0;
									while(true) {
										System.out.print("Total Balance: ");
										System.out.println(currentAccount.getMoney());
										System.out.println("How much would you like to Transfer today and to which account? $$.$$ Name");
										String check = currString.nextLine();
										if(check.equals("cancel")||check.equals("Cancel")) {
											break;
										}
										try {
											String[] transferMoney = check.split(" ");
											moneyAmount = Double.parseDouble(transferMoney[0]);
											if(moneyAmount <= 0.0) {
												System.out.println("You cannot transfer zero or negative funds, try again.");
												break;
											}
											else if(moneyAmount > currentAccount.getMoney()) {
												System.out.println("Insufficient funds, try again.");
												break;
											}
											String nameOfTransfer = transferMoney[1];
											ApprovedAccounts getOtherAccount = new ApprovedAccounts();
											boolean checkName = false;
											for(int i = 0; i < approvedAccounts.size(); i++) {
												if(approvedAccounts.get(i).getUserName().equals(nameOfTransfer) || approvedAccounts.get(i).getUserNameJoint().equals(nameOfTransfer)){
													checkName = true;
													getOtherAccount = approvedAccounts.get(i);
													break;
												}
											}
											if(checkName == true) {
												System.out.println("Transferring funds now, from account: " + currentAccount.getUserName() + " to the account " + getOtherAccount.getUserName());
												currentAccount.withdraw(moneyAmount);
												getOtherAccount.setMoney(moneyAmount);
												System.out.println("Transfer completed.");
											}
											else {
												System.out.println("Name was not found on another account, please try again or type \"Cancel\".");
											}
										}catch(Exception E) {
											System.out.println("Wrong input, try again.");
										}
									}
								}
								else if(userAction.equals("cancel") || userAction.equals("Cancel")) {
									System.out.println("User interface cancelled, returning to home page.");
									System.out.println("Are you a Customer, Employee, or Admin?");
									break;
								}
								else {
									System.out.println("Input not valid, please try again, or type \"cancel\".");
								}
							}
						}
						passWordChecker = false;
					}
					else if(accountY.equals("No")||accountY.equals("no")) {
						//Apply for an account
						while(true) {
							System.out.println("Would you like to create an account or a joint account? Account or Joint.");
							String accountX = currString.nextLine();
							if(accountX.equals("Account") || accountX.equals("account")) {
								System.out.println("Please enter your name specified name for the account.");
								String accountName = currString.nextLine();
								String accountPWHolder = "";
								String accountPWConfirm = "";
								while(true) {
									System.out.println("Please enter your desired password.");
									accountPWHolder = currString.nextLine();
									System.out.println("Please re-enter your desired password.");
									accountPWConfirm = currString.nextLine();
									if(accountPWHolder.equals(accountPWConfirm)) {
										break;
									}
									else {
										System.out.println("Passwords do not match, please try again.");
									}
									
								}
								PendingAccounts currAccount = new PendingAccounts(accountX, accountName, "N/A", accountPWConfirm);
								oos.writeObject(currAccount); //Serialization
								customerAccountRequests.add(currAccount);
								System.out.println("Account has been recieved, give our Admin's sometime to approve or deny the request.");
								newAccount();
								break;
							}
							else if(accountX.equals("Joint") || accountX.equals("joint")) {
								System.out.println("Please enter the first specified name for the account.");
								String accountName = currString.nextLine();
								System.out.println("Please enter the second specified name for the account.");
								String accountNameJoint = currString.nextLine();
								String accountPWHolder = "";
								String accountPWConfirm = "";
								while(true) {
									System.out.println("Please enter your desired password.");
									accountPWHolder = currString.nextLine();
									System.out.println("Please re-enter your desired password.");
									accountPWConfirm = currString.nextLine();
									if(accountPWHolder.equals(accountPWConfirm)) {
										break;
									}
									else {
										System.out.println("Passwords do not match, please try again.");
									}
									
								}
								PendingAccounts currAccount = new PendingAccounts(accountX, accountName, accountNameJoint, accountPWConfirm);
								oos.writeObject(currAccount);
								customerAccountRequests.add(currAccount);
								System.out.println("Joint Account has been recieved, give our Admin's sometime to approve or deny the request.");
								newAccount();
								break;
							}
							else if(accountX.equals("No") || accountX.equals("no")) {
								break;
							}
							else {
								System.out.println("Input was entered incorrectly, try again.");
							}
						}
					}
					else {
						newAccount();
						break;
					}
				}
				else if(personStatus.equals("Employee") || personStatus.equals("employee")) {
					while(true) {
						System.out.println("Welcome employee, would you like to view account information, account balances, personal information, or view pending accouns? Info, Balance, Personal, Pending.");
						String employeeController = currString.nextLine();
						if(employeeController.equals("info") || employeeController.equals("Info")) {
							System.out.print("Account informations: ");
							for(int i = 0; i < approvedAccounts.size(); i++) {
								System.out.print(approvedAccounts.get(i) + " ");
							}
							System.out.println();
						}
						else if(employeeController.equals("Balance") || employeeController.equals("balance")) {
							System.out.println("Account Balances: ");
							for(int i = 0; i < approvedAccounts.size(); i++) {
								System.out.print(approvedAccounts.get(i).getUserName() + " has this balance: " + approvedAccounts.get(i).getMoney());
							}
							System.out.println();
						}
						else if(employeeController.equals("Personal") || employeeController.equals("personal")) {
							System.out.println("Personal Information: ");
							for(int i = 0; i < approvedAccounts.size(); i++) {
								System.out.print(approvedAccounts.get(i).getUserName() + " has this password: " + approvedAccounts.get(i).getUserPW());
							}
							System.out.println();
						}
						else if(employeeController.equals("Pending") || employeeController.equals("pending")) {
							System.out.println(customerAccountRequests);
							System.out.println("Is there an account you would like to handle? Yes or No.");
							String employee = currString.nextLine();
							if(employee.equals("Yes") || employee.equals("yes")) {
								while(true) {
									System.out.println("Would you like to approve or deny an account? Approve or Deny.");
									String approveOrDeny = currString.nextLine();
									if(approveOrDeny.equals("Approve") || approveOrDeny.equals("approve")) {
										System.out.println("Which account would you like to approve? Name of account holder.");
										for(int i = 0; i < customerAccountRequests.size(); i++) {
											System.out.println(customerAccountRequests.get(i));
										}
										boolean checkString = false;
										while(checkString==false) {
											String currAccount = currString.nextLine();
											currAccount = currAccount.toLowerCase();
											if(currAccount.equals("no")) {
												break;
											}
											for(int i = 0; i < customerAccountRequests.size(); i++) {
												String currName = customerAccountRequests.get(i).getUserName();
												currName=currName.toLowerCase();
												if(currName.equals(currAccount)) {
													ApprovedAccounts recentlyApproved = new ApprovedAccounts(customerAccountRequests.get(i).getUserPW(), customerAccountRequests.get(i).getUserName(), customerAccountRequests.get(i).getAccountType(), customerAccountRequests.get(i).getUserNameJoint());
													oos.writeObject(recentlyApproved); //SerialLization
													approvedAccounts.add(recentlyApproved);
													customerAccountRequests.remove(i);
													readObject(filename);
													checkString = true;
													break;
												}
											}
											if(checkString==false) {
												System.out.println("The name of that person was not found, please try again.");
												System.out.println("Type \"no\" to exit.");
											}
											else {
												System.out.println("Account: " + currAccount + " has been Approved.");
												break;
											}
										}
										break;
									}
									else if(approveOrDeny.equals("Deny") || approveOrDeny.equals("deny")) {
										System.out.println("Which account would you like to deny? Name of account holder.");
										for(int i = 0; i < customerAccountRequests.size(); i++) {
											System.out.println(customerAccountRequests.get(i));
										}
										boolean checkString = false;
										while(checkString==false) {
											String currAccount = currString.nextLine();
											currAccount = currAccount.toLowerCase();
											if(currAccount.equals("no")) {
												break;
											}
											for(int i = 0; i < customerAccountRequests.size(); i++) {
												String currName = customerAccountRequests.get(i).getUserName();
												currName=currName.toLowerCase();
												if(currName.equals(currAccount)) {
													customerAccountRequests.remove(i);
													readObject(filename);
													checkString = true;
													break;
												}
											}
											if(checkString==false) {
												System.out.println("The name of that person was not found, please try again.");
												System.out.println("Type \"no\" to exit.");
											}
											else {
												System.out.println("Account: " + currAccount + " has been Denied.");
												break;
											}
										}
										break;
									}
									else{
										System.out.println("Incorrect input, please try again.");
									}
								}
							}
							else if(employee.equals("No") || employee.equals("no")) {
								System.out.println("Are you a customer, Employee, or Admin?");
								break;
							}
						}
					}
						
				}
				else if(personStatus.equals("Admin") || personStatus.equals("admin")) {
					while(true){
						System.out.println("Welcome admin, would you like to view pending accounts, change money in accounts, or cancel an account? Pending, Change or Cancel.");
						String adminControl = currString.nextLine();
						if(adminControl.equals("Pending") || adminControl.equals("pending")) {
							System.out.println(customerAccountRequests);
							System.out.println("Is there an account you would like to handle? Yes or No.");
							String adminChoiceOne = currString.nextLine();
							if(adminChoiceOne.equals("Yes") || adminChoiceOne.equals("yes")) {
								while(true) {
									System.out.println("Would you like to approve or deny an account? Approve or Deny.");
									String approveOrDeny = currString.nextLine();
									if(approveOrDeny.equals("Approve") || approveOrDeny.equals("approve")) {
										System.out.println("Which account would you like to approve? Name of account holder.");
										for(int i = 0; i < customerAccountRequests.size(); i++) {
											System.out.println(customerAccountRequests.get(i));
										}
										boolean checkString = false;
										while(checkString==false) {
											String currAccount = currString.nextLine();
											currAccount = currAccount.toLowerCase();
											if(currAccount.equals("no")) {
												break;
											}
											for(int i = 0; i < customerAccountRequests.size(); i++) {
												String currName = customerAccountRequests.get(i).getUserName();
												currName=currName.toLowerCase();
												if(currName.equals(currAccount)) {
													ApprovedAccounts recentlyApproved = new ApprovedAccounts(customerAccountRequests.get(i).getUserPW(), customerAccountRequests.get(i).getUserName(), customerAccountRequests.get(i).getAccountType(), customerAccountRequests.get(i).getUserNameJoint());
													approvedAccounts.add(recentlyApproved);
													customerAccountRequests.remove(i);
													readObject(filename);
													checkString = true;
													break;
												}
											}
											if(checkString==false) {
												System.out.println("The name of that person was not found, please try again.");
												System.out.println("Type \"no\" to exit.");
											}
											else {
												System.out.println("Account: " + currAccount + " has been Approved.");
												break;
											}
										}
										break;
									}
									else if(approveOrDeny.equals("Deny") || approveOrDeny.equals("deny")) {
										System.out.println("Which account would you like to deny? Name of account holder.");
										for(int i = 0; i < customerAccountRequests.size(); i++) {
											System.out.println(customerAccountRequests.get(i));
										}
										boolean checkString = false;
										while(checkString==false) {
											String currAccount = currString.nextLine();
											currAccount = currAccount.toLowerCase();
											if(currAccount.equals("no")) {
												break;
											}
											for(int i = 0; i < customerAccountRequests.size(); i++) {
												String currName = customerAccountRequests.get(i).getUserName();
												currName=currName.toLowerCase();
												if(currName.equals(currAccount)) {
													customerAccountRequests.remove(i);
													readObject(filename);
													checkString = true;
													break;
												}
											}
											if(checkString==false) {
												System.out.println("The name of that person was not found, please try again.");
												System.out.println("Type \"no\" to exit.");
											}
											else {
												System.out.println("Account: " + currAccount + " has been Denied.");
												break;
											}
										}
										break;
									}
									else{
										System.out.println("Incorrect input, please try again.");
									}
								}
							}
							else if(adminChoiceOne.equals("No") || adminChoiceOne.equals("no")) {
								System.out.println("Are you a customer, Employee, or Admin?");
								break;
							}
						}
						else if(adminControl.equals("Change") || adminControl.equals("change")) {
							ApprovedAccounts currentAccount = new ApprovedAccounts();
							while(true) {
								System.out.println("Would you like to withdraw, deposit or transfer funds? Withdraw, Deposit, or Transfer. Type \"Cancel\" to return to home page.");
								String adminAction = currString.nextLine();
								if(adminAction.equals("withdraw") || adminAction.equals("Withdraw")) {
									while(true) {
										boolean checker = false;
										System.out.print("Which account would you like to withdraw from: ");
										for(int i = 0; i < approvedAccounts.size(); i++) {
											System.out.print(approvedAccounts.get(i).getUserName());
										}
										String adminInput = currString.nextLine();
										ApprovedAccounts currAccount = new ApprovedAccounts();
										for(int i = 0; i < approvedAccounts.size(); i++) {
											if(adminInput.equals(approvedAccounts.get(i).getUserName())) {
												checker = true;
												currAccount = approvedAccounts.get(i);
												break;
											}
										}
										if(checker == true) {
											double moneyAmount = 0.0;
											while(true) {
												System.out.println("That account currently has: " + currAccount.getMoney());
												System.out.println("How much would you like to withdraw from that account? $$.$$");
												try {
													moneyAmount = Double.parseDouble(currString.nextLine());
													double moneyWithdrew = currAccount.withdraw(moneyAmount);
													if(moneyWithdrew == -1.0) {
														System.out.println("Stop trying to break the system, no negative withdrawls. Try again.");
														break;
													}
													else if(moneyWithdrew == 0.0) {
														System.out.println("Not enough funds. Cancelling Transaction.");
														break;
													}
													else if(moneyWithdrew > 0.0) {
														System.out.println("Money has been withdrawn. New available balance: " + currentAccount.getMoney() + " Have a great Day!");
														break;
													}
												}catch(Exception E) {
													System.out.println("Wrong input, try again.");
												}
											}
										}
										if(checker == false) {
											System.out.println("Account does not exist, please try again.");
										}
										else {
											break;
										}
									}
								}
								else if(adminAction.equals("Deposit") || adminAction.equals("deposit")) {
									boolean checker = false;
									ApprovedAccounts currAccount = new ApprovedAccounts();
									while(true) {
										System.out.print("Which account would you like to deposit to: ");
										for(int i = 0; i < approvedAccounts.size(); i++) {
											System.out.print(approvedAccounts.get(i).getUserName() + ", ");
										}
										System.out.println();
										String adminInput = currString.nextLine();
										for(int i = 0; i < approvedAccounts.size(); i++) {
											if(adminInput.equals(approvedAccounts.get(i).getUserName())) {
												checker = true;
												currAccount = approvedAccounts.get(i);
												break;
											}
										}
										if(checker==true) {
											break;
										}
										if(checker==false) {
											System.out.println("Account was not found, try again.");
										}
									}
									double moneyAmount = 0.0;
									while(true) {
										System.out.println("Account has: " + currAccount.getMoney());
										System.out.println("How much would you like to Deposit today? $$.$$");
										
										try {
											moneyAmount = Double.parseDouble(currString.nextLine());
											if(moneyAmount<0.0) {
												System.out.println("You cannot subtract from a Deposit, try again. Exiting.....");
											}
											else {
												currAccount.setMoney(moneyAmount);
												System.out.println("Money added to account, " + currAccount.getUserName() + " Total Balance: " + currAccount.getMoney());
												break;
											}
										}catch(Exception E) {
											System.out.println("Wrong input, try again.");
										}
									}
								}
								else if(adminAction.equals("Transfer") || adminAction.equals("transfer")) {
									double moneyAmount = 0.0;
									while(true) {
										System.out.println("How much would you like to Transfer today and to which accounts? Name $$.$$ Name or type \"Cancel\"");
										String check = currString.nextLine();
										if(check.equals("cancel")||check.equals("Cancel")) {
											break;
										}
										try {
											String[] transferMoney = check.split(" ");
											moneyAmount = Double.parseDouble(transferMoney[1]);
											if(moneyAmount <= 0.0) {
												System.out.println("You cannot transfer zero or negative funds, try again.");
												break;
											}
											String nameOne = transferMoney[0];
											String nameTwo = transferMoney[2];
											ApprovedAccounts getAccountOne = new ApprovedAccounts();
											ApprovedAccounts getAccountTwo = new ApprovedAccounts();
											boolean checkNames = false;
											while(true) {
												for(int i = 0; i < approvedAccounts.size(); i++) {
													if(approvedAccounts.get(i).getUserName().equals(nameOne) || approvedAccounts.get(i).getUserNameJoint().equals(nameOne)){
														checkNames = true;
														getAccountOne = approvedAccounts.get(i);
														break;
													}
												}
												if(moneyAmount > getAccountOne.getMoney()) {
													System.out.println("Insufficient funds, try again.");
												}
												else if(checkNames==true) {
													break;
												}
											}
											checkNames = false;
											for(int i = 0; i < approvedAccounts.size(); i++) {
												if(approvedAccounts.get(i).getUserName().equals(nameTwo) || approvedAccounts.get(i).getUserNameJoint().equals(nameTwo)){
													checkNames = true;
													getAccountTwo = approvedAccounts.get(i);
													break;
												}
											}
											if(checkNames == true) {
												System.out.println("Transferring funds now, from account: " + getAccountOne.getUserName() + " to the account " + getAccountTwo.getUserName());
												getAccountOne.withdraw(moneyAmount);
												getAccountTwo.setMoney(moneyAmount);
												System.out.println("Transfer completed.");
											}
										}catch(Exception E) {
											System.out.println("Wrong input, try again.");
										}
									}
								}
								else if(adminAction.equals("cancel") || adminAction.equals("Cancel")) {
									System.out.println("Admin interface cancelled, returning to home page.");
									System.out.println("Are you a Customer, Employee, or Admin?");
									break;
								}
								else {
									System.out.println("Input not valid, please try again, or type \"cancel\".");
								}
							}
						}
						else if(adminControl.equals("Cancel") || adminControl.equals("cancel")) {
							while(true) {
								System.out.print("Accounts currently listed: ");
								for(int i = 0; i < approvedAccounts.size(); i++) {
									System.out.print(approvedAccounts.get(i).getUserName() + " ");
								}
								System.out.println();
								System.out.println("Enter account you wish to cancel or type \"cancel\":");
								String closeAccount = currString.nextLine();
								if(closeAccount.equals("cancel") || closeAccount.equals("Cancel")) {
									break;
								}
								boolean checker = false;
								for(int i = 0; i < approvedAccounts.size(); i++) {
									if(closeAccount.equals(approvedAccounts.get(i).getUserName()) || closeAccount.equals(approvedAccounts.get(i).getUserNameJoint())) {
										System.out.println("Closing account: " + closeAccount);
										approvedAccounts.remove(i);
										readObject(filename);
										checker = true;
									}
								}
								if(checker==false) {
									System.out.println("Wrong account, try again.");
								}
							}
						}
					}
				}
				else {
					System.out.println("Input recieved was incorrect, try again.");
					System.out.println("Are you a Customer, Employee, or Admin?");
				}
			}
			
		}
		catch(Exception e){
			System.out.println("Thats the wrong input, try again.");
			newAccount();
			System.exit(1);
		}
		currString.close();
	}
}
