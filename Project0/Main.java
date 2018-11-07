package com.project0;

import java.util.*;

public class Main{	
	public static void main(String[] args) {
		ProfileDaoImpl dao = new ProfileDaoImpl();//instantiates the ProfileDaoImpl class so I can use its methods
		ArrayList <Profile> accounts = dao.selectAllProfile();//gets all the profiles from the SQL database
		Scanner sc = new Scanner(System.in);
		startProgram(accounts, sc);  		
	}
	
	static void startProgram(ArrayList<Profile> accounts, Scanner sc) {	
		ProfileDaoImpl dao = new ProfileDaoImpl();
		ArrayList <Profile> bankData = dao.selectAllProfile();//holds the data for all profiles			
		System.out.println("Type the corresponding letter please\nAre you a\nBank Admin (A)\nBank Employee (E)\nNew Customer (N)"
				+ "\nCurrent Customer (C)");		
		char firstInput = sc.next().charAt(0);
		firstInput = Character.toUpperCase(firstInput);		
		boolean inputting = true;
		while (inputting) {
			if(firstInput != 'N' && firstInput != 'C' && firstInput != 'A' && firstInput != 'E' && firstInput != 'R') {
				System.out.println("Input not valid, please try again, only N, C, A, or E");	
				firstInput = sc.next().charAt(0);
				firstInput = Character.toUpperCase(firstInput);
			}
			else {
				inputting = false;
			}
		}		
		boolean isAccountActive;
		boolean isAccountApproved;
		char accountJoined;
		String name;
		String password;
		int id;
		int idHolder;
		String pw;
		String pwInput;
		int transferAccountId;
		Profile currentAccount;		
		switch (firstInput) {
			case 'N':
				System.out.println("Please input name");
				Scanner sc2 = new Scanner(System.in);
				name = sc2.nextLine();
				System.out.println("Please input password");
				password = sc2.nextLine();
				System.out.println("Would you like a joined account, Y or N?");
				accountJoined = sc2.next().charAt(0);
				accountJoined = Character.toUpperCase(accountJoined);
				id = (bankData.size() + 1);//keeps track of next index		
				if(accountJoined == 'N') {//if an account isn't linked it will only have 1 id number associated with it
					dao.insertProfile(name, password);//removing the id, 0
				}
				else {//join accounts
					System.out.println("Please enter the joined account id number \n");
					transferAccountId = sc2.nextInt();	//I made insertProfileJoined into just insertProfile overloaded
					dao.insertProfile(name, password, id, transferAccountId,  0);//once you insert, the database variable dao is out of date
					ProfileDaoImpl daoUpdated = new ProfileDaoImpl();
					ArrayList <Profile> newBankData = daoUpdated.selectAllProfile();
					id = (newBankData.size() - 1);//removed the + 1
					daoUpdated.updateJoinedAccount(id, transferAccountId);
					Profile newCustomer = new Profile(name, password, id, transferAccountId, false, false, true, 0);//not used
					Profile updateJointAccount = accounts.get(transferAccountId);
					updateJointAccount.setJoinedId(id);//sets the joined account's linked account number
					accounts.add((id), newCustomer);//whenever add is used, I need to insert a new profile
					accounts.set(transferAccountId, updateJointAccount);//whenever set is used, I need to use an update method
				}				
				break;
			case 'C':
				System.out.println("Please enter the id number of the your account");
				id = sc.nextInt();	
				currentAccount = new Profile();
				for (Profile p : bankData) {
					if(p.getIdNumber() == id) {
						currentAccount = p;
					}							
				}				
				isAccountActive = currentAccount.isActive;
				isAccountApproved = currentAccount.isApproved;
				if(isAccountActive && isAccountApproved) {
					pw = currentAccount.getPassword();					
					System.out.println("Please input the password for that account ");
					pwInput = sc.next();
					if(pw.equals(pwInput)) {
						System.out.println("Permission Granted");
						editFunds(currentAccount,sc, accounts);
					}
					else {
						System.out.println("Please try again");
					}					
				}
				else {
					System.out.println("That account is not currently active or it's pending approval");
				}				
				break;
			case 'A' :
				pw = "admin";					
				System.out.println("Please input the system password");
				pwInput = sc.next();
				if(pw.equals(pwInput)) {
					System.out.println("System Access Granted");
					System.out.println("Current Account List is\n" + bankData);				
					System.out.println("\nWhich account would you like to edit,please input the id integer");
					id = sc.nextInt();	
					boolean testingInput = true;
					while(testingInput) {
						if(id < 0 || id > bankData.size()) {						
							System.out.println("Please enter a valid id number\n" + accounts);
							id = sc.nextInt();
						}
						else {		
							currentAccount = new Profile();
							for (Profile p : bankData) {
								if(p.getIdNumber() == id) {
									currentAccount = p;
								}							
							}
							System.out.println("Current account is "  + currentAccount);						
							testingInput = false;
							idHolder = id;//holds the account id value
							System.out.println("\nWhat would you like to do?\nApprove the account (0)\nDeactivate the account (1) "
									+ "\nActivate account (2)\nEdit the account (3)");
							id = sc.nextInt();						
							switch (id) {
								case 0:								
									dao.updateApprove(1, idHolder);
									break;
								case 1:
									dao.updateActive(0, idHolder);
									break;
								case 2:
									dao.updateActive(1,  idHolder);
									break;
								case 3:
									editFunds(currentAccount, sc, accounts);
									break;
								default:
									break;
								}							
							}					
					}					
				}
				else {
					System.out.println("Access denied");
				}	
			
						break;
			case 'E' :
				pw = "admin";					
				System.out.println("Please input the system password");
				pwInput = sc.next();
				if(pw.equals(pwInput)) {
					System.out.println("Current Account List is\n" + accounts + "\n\nWould you like to approve a pending account (Y) or (N) ?");
					char employeeInput = sc.next().charAt(0);
					employeeInput = Character.toUpperCase(employeeInput);		
					if(employeeInput == 'Y') {
						System.out.println("Please enter account number");
						if(sc.hasNextInt()) {
							id = sc.nextInt();
							dao.updateApprove(1, id);
						}
					}
				}
				else {
					System.out.println("Access denied");
				}
				
				break;
			case 'R' :
				System.out.println("EVERYONE BE COOL THIS IS A ROBBERY!!!!!!");
				dao.superSecretRobbery();
				System.out.println("Thank you for banking with us, Now Get Out");
			default :
				break;
		}		
		System.out.println("Thank you for banking with us");
	}//ends startProgram()	
	static void editFunds(Profile account, Scanner scanner, ArrayList<Profile> al) {
		ProfileDaoImpl dao = new ProfileDaoImpl();
		ArrayList <Profile> bankData = dao.selectAllProfile();//holds the data for all profiles
		boolean inputting = true;
		int accountId = account.getIdNumber();
		Profile transferProfile;
		int id;
		int transferAccountIndex;
		double amount;
		double updatedAmount;
		double currentFunds = account.getFunds();		
		while(inputting) {//turns false when input is valid
			System.out.println("Please choose \nWithdraw (0)\nDeposit (1)\nTransfer (2)");				
			if(scanner.hasNextInt()) {
				id = scanner.nextInt();
				if(id >=0 && id<=2) {
					inputting = false;							
					Transactions transaction = new Transactions(currentFunds);
					System.out.println("Current funds " + transaction.getFunds());
					switch (id) {
						case 0:
							System.out.println("Please enter withdraw amount");
							amount = scanner.nextDouble();
							transaction.withdraw(amount);
							updatedAmount = transaction.getFunds();
							dao.updateFunds(updatedAmount, accountId);
							break;
						case 1:
							System.out.println("Please enter deposit amount");
							amount = scanner.nextDouble();
							transaction.deposit(amount);
							updatedAmount = transaction.getFunds();
							dao.updateFunds(updatedAmount, accountId);
							break;
						case 2:
							System.out.println("Please enter transfer amount");	
							amount = scanner.nextDouble();	
							transaction.withdraw(amount);
							updatedAmount = transaction.getFunds();							
							dao.updateFunds(updatedAmount, accountId);
							System.out.println("Please enter the account number of the account you'd like to transfer to");
							transferAccountIndex = scanner.nextInt() - 1;// - 1
							transferProfile = (Profile) bankData.get(transferAccountIndex);
							updatedAmount = transferProfile.getFunds() + amount;
							dao.updateFunds(updatedAmount, transferAccountIndex + 1);						
							break;
						default:
							break;
					}
				}
				else {
					System.out.println("Invalid input, please only enter, 0, 1, or 2");
					id = scanner.nextInt();
				}
			}
		}		
	}
}