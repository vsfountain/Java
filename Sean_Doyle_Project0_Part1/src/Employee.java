import java.util.ArrayList;
import java.util.Scanner;

//Author: Sean Doyle
//Date Created: 2018/10/24

//This class stores information about an employee of the bank

public final class Employee {
	private static final String EMPLOYEEACCESSCODE = "Snoflake";
	private static final String ADMINISTRATORACCESSCODE = "Fluffy";
	static Scanner s = new Scanner(System.in);
	private Employee() {
	}

	protected static void doWork(ArrayList<Client> clients, ArrayList<Account> accounts, String verify) {
		if (verify.equals(EMPLOYEEACCESSCODE) || verify.equals(ADMINISTRATORACCESSCODE)) {
			int index = 0;
			s.reset();
			boolean toClose = false;
			LukeDuke:
			while (!toClose) {
				System.out.println("Please choose from the list of options below:");
				System.out.println("A: View ALL Clients.    \nB: View Clients with Pending Applications. ");
				System.out.println(
						"C: Approve ALL Pending Applications.     \nD: Approve Individual Pending Application. ");
				System.out.println("E: View ALL Accounts.    \nF: View Frozen Accounts.");
				System.out.println("G: Edit Client.    \nH: Edit Account.    \nI: Logout");
				switch (s.next().toLowerCase().substring(0, 1)) {
				case "a":
					viewAllClients(clients);
					break;
				case "b":
					viewPendingClients(clients);
					break;
				case "c":
					approveAllPending(clients, accounts);
					break;
				case "d":
					System.out.println("Which client ID would you like to approve? ");
					index = s.nextInt();
					if (index < clients.size()) {
						approveSinglePending(clients.get(index), accounts, clients);
					} else {
						System.out.println("FAIL: Invalid ClientID.");
					}
					break;
				case "e":
					viewAllAccounts(accounts);
					break;
				case "f":
					viewFrozenAccounts(accounts);
					break;
				case "g":
					System.out.println("Which client ID would you like to edit? ");
					index = s.nextInt();
					if (index < clients.size() && index >= 0) {
						Client.clientEditor(accounts, verify, clients, index);
					} else {
						System.out.println("FAIL: Invalid ClientID.");
					}
					break;
				case "h":
					System.out.println("Which account number would you like to edit? ");
					index = s.nextInt();
					if (index < accounts.size() && index >= 0) {
						Account.accountEditor(accounts, verify, clients, index);
					} else {
						System.out.println("FAIL: Invalid Account Number.");
					}
					break;
				case "i":
					toClose = true;
					break LukeDuke;
				default:
					System.out.println("FAIL: Invalid selection");
				}
			}
		} else {
			System.out.println("FAIL: Invalid Employee access code");
		}
	}

	protected void freezeAccount(Account toFreeze) {
		toFreeze.setFreeze(EMPLOYEEACCESSCODE);
	}

	protected static void approveSinglePending(Client client, ArrayList<Account> accounts, ArrayList<Client> clients) {
		// client.activateAccount();
		if (client.getJointID() == -1 && client.getClientAccount() == -1) {
			accounts.add(new Account(client));
		} else {
			if (client.getJointID() != -1 && client.getClientAccount() == -1) {
				accounts.add(new Account(client, clients.get(client.getJointID())));
			} else {
				client.activateAccount();
			}
		}
		
	}

	protected static void approveAllPending(ArrayList<Client> clients, ArrayList<Account> accounts) {
		for (Client c : clients) {
			approveSinglePending(c, accounts, clients);
		}
	}

	protected static void viewAllClients(ArrayList<Client> clients) {
		for (Client c : clients) {
			System.out.println(c.toString());
		}
	}

	protected static void viewPendingClients(ArrayList<Client> clients) {
		for (Client c : clients) {
			if (!c.getClientStatus()) {
				System.out.println(c.toString());
			}
		}
	}

	protected static void viewAllAccounts(ArrayList<Account> accounts) {
		for (Account a : accounts) {
			System.out.println(a.toString());
		}
	}

	protected static void viewFrozenAccounts(ArrayList<Account> accounts) {
		for (Account a : accounts) {
			if (!a.getAccountStatus()) {
				System.out.println(a.toString());
			}
		}
	}
}
