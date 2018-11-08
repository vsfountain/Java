import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

//Author: Sean Doyle
//Date Created: 2018/10/24
//Date Published: ???
//Name: Banking App Part 1


//Abstract: This application is designed to recreate a banking interface. 

/* Functionality shall include, but is not limited to:
 * 
 * Console input from the user
 * Creation of a Bank Account (solo or jointly)
 * Include basic functionality of a Bank Account (withdraw, deposit, and transfer funds)
 * Checks for invalid user input
 * 
 * Creation of an Employee class to allow for viewing of Bank Account information
 * Bank Account information shall include, but is not limited to:
 * 	account balances, account transaction history, and personal information of account holder
 * 
 * Creation of an Administrative class to allow for editing of Bank Account information.
 * Admin privileges include but are not limited to:
 *	o	Approving/denying accounts
 *	o	withdrawing, depositing, transferring from all accounts
 *	o	canceling accounts
 *
 * All information is stored using text files and serialization
 * ALL methods will be tested using J-Unit tests in compliance with TDD (Test Driven Development)
 * User login is accomplished using Log4J
 */

public class Main {
	//private final static String EMPLOYEEPASSPHRASE = "123Monkey";
	//private final static String ADMINPASSPHRASE = "CafeBabe";

	//static Scanner s;
	
	public static void main(String[] args) {
		// Ryker International Banking
		ArrayList<Client> clientList = new ArrayList<>();
		/*
		clientList.add(new Client("sean", "doyle"));
		System.out.println(clientList.get(0).toString());
		clientList.add(new Client("ross", "geller"));
		System.out.println(clientList.get(1).toString());
		clientList.add(new Client("jacob", "smith"));
		System.out.println(clientList.get(2).toString());
		clientList.add(new Client("maxwell", "smart"));
		System.out.println(clientList.get(3).toString());
		clientList.add(new Client("ruby", "slippers"));
		System.out.println(clientList.get(4).toString());
		*/
		
		
		
		ArrayList<Account> accountList = new ArrayList<>();
		clientList = repopulateClients(clientList);
		accountList = repopulateAccounts(accountList);
		String howTo = loginScreen();
		
		LoginManager loginManager = new LoginManager();
		// using this switch statement prevent recursion effects (like stack overflow)
		while (!howTo.equals("quit")) {
			saveBank(clientList, accountList);
			switch (howTo) {
			case "newLogin":
				howTo = loginScreen();
				break;
			case "newClient":
				howTo = newClientCheck();
				break;
			case "clientCreate":
				howTo = loginManager.clientCreator(clientList);
				if (!(howTo.equals("jointClientCreate"))) {
					howTo = loginManager.continueBanking(howTo);
				}
				break;
			case "clientOrEmployee":
				howTo = clientOrEmployee();
				break;
			case "clientLogin":
				howTo = loginManager.clientLogin(clientList, accountList);
				howTo = loginManager.continueBanking(howTo);
				break;
			case "employeeLogin":
				howTo = loginManager.employeeLogin(clientList, accountList);
				if (!howTo .equals("adminLogin")){
						howTo = loginManager.continueBanking(howTo);
				}
				break;
			case "adminLogin":
				howTo = loginManager.adminLogin(clientList, accountList);
				howTo = loginManager.continueBanking(howTo);
				break;
			case "loginScreen":
				howTo = loginScreen();
				break;
			case "jointClientCreate":
				howTo = loginManager.jointClientCreator(clientList);
				howTo = loginManager.continueBanking(howTo);
				break;
			default:
				howTo = "quit";
			}
		}
		finalScreen(clientList, accountList);

	}

	public static ArrayList<Client>  repopulateClients(ArrayList<Client> clients) {
		String fileInCli = "./myClients.txt";
		try{ 			 	            
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileInCli)); 	            
            clients =   (ArrayList<Client>) in.readObject();//retrieves the data from a file
            Client.resetClientCount(clients.size());
            in.close();	            
        } catch (EOFException eof) {
        	
        } catch (IOException ioe) {
        	
        } catch (ClassNotFoundException cnfe) {
        	
        }
		return clients;
	}

	public static ArrayList<Account>  repopulateAccounts(ArrayList<Account> accounts) {
		String fileInAcc = "./myAccounts.txt";
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileInAcc));
			accounts = (ArrayList<Account>) in.readObject();// de-serialization
			in.close();
		} catch (ClassNotFoundException e) {
			
		} catch (IOException e) {
			
		} finally {
			
		}
		return accounts;
	}
	public static void saveBank(ArrayList<Client> clients, ArrayList<Account> accounts) {
		String fileOutCli = "./myClients.txt";
		try { 			 
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileOutCli));
            out.writeObject(clients);	            
            out.close();
        }catch (IOException ioe) {
        
        }
		
		
		String fileOutAcc = "./myAccounts.txt";
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileOutAcc));
			out.writeObject(accounts);// de-serialization
			out.close();
		}catch (IOException e) {
			
		}finally {
			
		}
	}
	
	public static String loginScreen() {
		System.out.println("Welcome to Ryker International Banking!");
		return "newClient";
	}

	public static void finalScreen(ArrayList<Client> clientList, ArrayList<Account> accountList) {
		saveBank(clientList, accountList);
		System.out.println("Thank You for choosing Ryker International Banking!");
		System.exit(0);
	}
	public static String newClientCheck() {
		Scanner s = new Scanner(System.in);
		System.out.println("Are you a NEW client? (Y/N)");
		if (s.next().toLowerCase().substring(0, 1).equals("y")) {
			return "clientCreate";
		} else {
			return "clientOrEmployee";
		}
	}
	public static String clientOrEmployee() {
		Scanner s = new Scanner(System.in);
		System.out.println("Are you a returning client? (Y/N)");
		String response = s.next().toLowerCase().substring(0, 1);
		if (response.equals("y")) {
			return "clientLogin";
		} else {
			return "employeeLogin";
		}
	}
}