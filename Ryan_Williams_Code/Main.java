package com.project0.part1;

//import java.util.Scanner;
//import java.lang.*;
import java.util.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Main{
	public static void main(String[] args) {
		ArrayList <Profile> accounts = new ArrayList<>();//holds the data for all profiles					
		Profile sampleProfile1 = new Profile("Profile1", "Testing", 0, 0, true, true, false, 172.39);
		Profile sampleProfile2 = new Profile("Profile2", "Testing2",1,1, true, false, false, 39.21);
		accounts.add(sampleProfile1);//
		accounts.add(sampleProfile2);
		Scanner sc = new Scanner(System.in);		
		 try
	        { 			 
	            FileInputStream fis = new FileInputStream("bankData");	            
	            ObjectInputStream ois = new ObjectInputStream(fis); 	            
	            accounts =   (ArrayList<Profile>) ois.readObject();//retrieves the data from a file
	 
	            ois.close();
	            fis.close();	            
	        }
		    catch (EOFException eof)
	        {
	            eof.printStackTrace();
	        }
	        catch (IOException ioe)
	        {
	            ioe.printStackTrace();
	        }catch (ClassNotFoundException cnfe)
	        {
	            cnfe.printStackTrace();
	        }

			start(accounts, sc);  
		 try
	        { 			 
	            FileOutputStream fos = new FileOutputStream("bankData");
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.writeObject(accounts);	            
	          
	            oos.close();
	            fos.close();	        
	        }
		    catch (EOFException eof)
	        {
	            eof.printStackTrace();
	        }
	        catch (IOException ioe)
	        {
	            ioe.printStackTrace();
	        }		   
	}
	
	static void start(ArrayList<Profile> accounts, Scanner sc) {		
		System.out.println("Type the corresponding letter please\n Are you a Bank Admin (A)\n A Bank Employee (E)\n, A new customer (N)\n"
				+ "or A Current Customer (C)");		
		char firstInput = sc.next().charAt(0);
		firstInput = Character.toUpperCase(firstInput);		
		boolean inputting = true;
		while (inputting) {
			System.out.println(firstInput);
			if(firstInput != 'N' && firstInput != 'C' && firstInput != 'A' && firstInput != 'E') {
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
				id = (accounts.size());//keeps track of next index
				if(accountJoined == 'N') {//if an account isn't linked it will only have 1 id number associated with it
					accounts.add(new Profile(name, password, id, id, false, false, false, 0));
				}
				else {//join accounts
					System.out.println("Please enter the joined account id number \n");
					transferAccountId = sc2.nextInt();				
					Profile newCustomer = new Profile(name, password, id, transferAccountId, false, false, true, 0);
					Profile updateJointAccount = accounts.get(transferAccountId);
					updateJointAccount.setJoinedId(id);//sets the joined account's linked account number
					accounts.add((id), newCustomer);
					accounts.set(transferAccountId, updateJointAccount);
				}				
				break;
			case 'C':
				System.out.println("Please enter the id number of the your account");
				id = sc.nextInt();				
				currentAccount = (Profile) accounts.get(id);
				System.out.println(currentAccount);
				isAccountActive = currentAccount.isActive;
				isAccountApproved = currentAccount.isApproved;
				if(isAccountActive && isAccountApproved) {
					editFunds(currentAccount,sc, accounts);
				}
				else {
					System.out.println("That account is not currently active");
				}				
				break;
			case 'A' :
				System.out.println("Current Account List is\n" + accounts);
				System.out.println("\nWhich account would you like to edit,please input the id integer");
				id = sc.nextInt();				
				boolean testingInput = true;
				while(testingInput) {
					if(id < 0 || id > accounts.size() - 1) {						
						System.out.println("Please enter a valid id number\n" + accounts);
						id = sc.nextInt();
					}
					else {
						currentAccount = (Profile) accounts.get(id);
						System.out.println(currentAccount);						
						testingInput = false;
						System.out.println("What would you like to do, Approve the account (0), deactivate the account (1), "
								+ "activate account (2) or edit an account (3)");
						id = sc.nextInt();						
						switch (id) {
							case 0: 
							currentAccount.setApproved(true);	
								break;
							case 1:
							currentAccount.setActive(false);
								break;
							case 2:
								currentAccount.setActive(true);
								break;
							case 3:
								editFunds(currentAccount, sc, accounts);
								break;
							default:
								break;
							}							
						}					
				}	
						break;
			case 'E' :
				System.out.println("Current Account List is\n" + accounts + "\n\nWould you like to approve a pending account (Y) or (N) ?");
				char employeeInput = sc.next().charAt(0);
				employeeInput = Character.toUpperCase(employeeInput);		
				if(employeeInput == 'Y') {
					System.out.println("Please enter account number");
					if(sc.hasNextInt()) {
						id = sc.nextInt();
						currentAccount = accounts.get(id);
						currentAccount.setApproved(true);
						System.out.println(currentAccount);
						accounts.set(id,currentAccount);
					}
				}
				break;
			default :
				break;
		}		
	}//ends start()	
	static void editFunds(Profile account, Scanner scanner, ArrayList al) {
		boolean inputting = true;
		Profile transferProfile;
		int id;
		int transferAccountId;
		double amount;
		double updatedAmount;
		double currentFunds = account.getFunds();		
		while(inputting) {//turns false when input is valid
			System.out.println("Please choose Withdraw (0), deposit (1), or transfer (2)");				
			if(scanner.hasNextInt()) {
				id = scanner.nextInt();
				if(id >=0 && id<=2) {
					inputting = false;							
					Transactions transaction = new Transactions(currentFunds);
					System.out.println("Current funds is " + transaction.getFunds());
					switch (id) {
						case 0:
							System.out.println("Please enter withdraw amount");
							amount = scanner.nextDouble();
							transaction.withdraw(amount);
							updatedAmount = transaction.getFunds();
							account.setFunds(updatedAmount);
							System.out.println(account);
							break;
						case 1:
							System.out.println("Please enter deposit amount");
							amount = scanner.nextDouble();
							transaction.deposit(amount);
							updatedAmount = transaction.getFunds();
							account.setFunds(updatedAmount);
							System.out.println(account);
							break;
						case 2:
							System.out.println("Please enter transfer amount");							
							amount = scanner.nextDouble();
							transaction.withdraw(amount);
							updatedAmount = transaction.getFunds();
							account.setFunds(updatedAmount);
							System.out.println(account);
							System.out.println("Please enter the account number of the account you'd like to transfer to");
							transferAccountId = scanner.nextInt();
							transferProfile = (Profile) al.get(transferAccountId);
							updatedAmount = transferProfile.getFunds();
							updatedAmount = updatedAmount + amount;						
							transferProfile.setFunds(updatedAmount);
							System.out.println(al);
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
