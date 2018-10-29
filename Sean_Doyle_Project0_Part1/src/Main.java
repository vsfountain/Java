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

	public static void main(String[] args) {
		// Ryker International Banking
		Scanner scan = new Scanner(System.in);
		ArrayList<Client> clientList = new ArrayList<>();
		ArrayList<Account> accountList = new ArrayList<>();
		repopulate(clientList, accountList);
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
				howTo = newClientCheck(scan);
				break;
			case "clientCreate":
				howTo = loginManager.clientCreator(scan, clientList);
				howTo = continueBanking(scan, howTo);
				break;
			case "clientOrEmployee":
				howTo = clientOrEmployee(scan);
				break;
			case "clientLogin":
				howTo = loginManager.clientLogin(scan, clientList, accountList);
				howTo = continueBanking(scan, howTo);
				break;
			case "employeeLogin":
				howTo = loginManager.employeeLogin(scan, clientList, accountList);
				if (!howTo .equals("adminLogin")){
						howTo = continueBanking(scan, howTo);
				}
				break;
			case "adminLogin":
				howTo = loginManager.adminLogin(scan, clientList, accountList);
				howTo = continueBanking(scan, howTo);
				break;
			case "loginScreen":
				howTo = loginScreen();
				break;
			default:
				howTo = "quit";
			}
		}
		finalScreen(clientList, accountList);

	}

	public static String continueBanking(Scanner s, String oldHowTo) {
		System.out.println("Do you wish to continue banking? (Y/N)");
		if (!s.next().toLowerCase().substring(0,1).equals("y")) {
			return "quit";
		}else {
			return oldHowTo;
		}
	}

	public static void repopulate(ArrayList<Client> clients, ArrayList<Account> accounts) {
		String fileInCli = "./myClients.txt";
		try {
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileInCli));
			boolean found = false;
			while (!found) {
				try {
					clients.add((Client) in.readObject());// de-serialization
				} catch (FileNotFoundException e) {
					found = true;
					e.printStackTrace();
				} catch (EOFException e) {
					found = true;
					e.printStackTrace();//WE WANT TO BE SEEING THIS
				} catch (IOException e) {
					found = true;
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					found = true;
					e.printStackTrace();
				}
			}
			Client.resetClientCount(clients.size());
			in.close();
		}catch (IOException e) {
			
		}finally {
		}
		String fileInAcc = "./myAccounts.txt";
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileInAcc));
			boolean found = false;
			while (!found) {
				try {
					accounts.add((Account) in.readObject());// de-serialization
				} catch (FileNotFoundException e) {
					found = true;
					e.printStackTrace();
				} catch (EOFException e) {
					found = true;
					e.printStackTrace();//WE WANT TO BE SEEING THIS
				} catch (IOException e) {
					found = true;
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					found = true;
					e.printStackTrace();
				}
			}
			in.close();
		}catch (IOException e) {
			
		}finally {
		}
	}
	
	static void saveBank(ArrayList<Client> clients, ArrayList<Account> accounts) {
		String fileOutCli = "./myClients.txt";
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileOutCli));
			int index = 0;
			while (index < clients.size()) {
				try {
					out.writeObject(clients.get(index));// de-serialization
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				index++;
			}
			out.close();
		}catch (IOException e) {
			
		}finally {
			
		}
		String fileOutAcc = "./myAccounts.txt";
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileOutAcc));
			int index = 0;
			while (index < accounts.size()) {
				try {
					out.writeObject(accounts.get(index));// de-serialization
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} 
				index++;
			}
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
	public static String newClientCheck(Scanner s) {
		System.out.println("Are you a NEW client? (Y/N)");
		if (s.next().toLowerCase().substring(0, 1).equals("y")) {
			return "clientCreate";
		} else {
			return "clientOrEmployee";
		}
	}
	public static String clientOrEmployee(Scanner s) {
		System.out.println("Are you a returning client? (Y/N)");
		String response = s.next().toLowerCase().substring(0, 1);
		if (response.equals("y")) {
			return "clientLogin";
		} else {
			return "employeeLogin";
		}
	}
}