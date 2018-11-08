package com.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.profiles.Account;
import com.profiles.Client;
import com.profiles.Transaction;

public class EmployeeServiceImplementation implements EmployeeService {
	private static final String EMPLOYEEACCESSCODE = "Snoflake";
	private static final String ADMINISTRATORACCESSCODE = "Fluffy";
	//private static final String CHALLENGECODE = "Sp00d3rMan";// Used for deleting accounts and clients
	private BankService bserv = new BankServiceImplementation();
	private ClientService cserv = new ClientServiceImplementation();
	private AccountService aserv = new AccountServiceImplementation();
	static Scanner s = new Scanner(System.in);

	@Override
	public void doWork(String verify) {
		ArrayList<Client> clients = bserv.repopulateClients();
		ArrayList<Account> accounts = bserv.repopulateAccounts();
		if (verify.equals(EMPLOYEEACCESSCODE) || verify.equals(ADMINISTRATORACCESSCODE)) {
			int index = 0;
			s.reset();
			boolean toClose = false;
			LukeDuke: while (!toClose) {
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
					approveAllPending(clients, accounts, verify);
					break;
				case "d":
					System.out.println("Which client ID would you like to approve? ");
					viewPendingClients(clients);
					ArrayList<Integer> cids = bserv.getClients("p");
					index = Integer.parseInt(s.next());
					if (cids.contains(index)) {
						approveSinglePending(getClientByID(clients, index), accounts, clients, verify);
					} else {
						System.out.println("FAIL: Invalid ClientID.");
					}
					break;
				case "e":
					viewAllAccounts(accounts);
					break;
				case "f":
					System.out.println("\n\nThese are the frozen accounts....");
					viewFrozenAccounts(accounts);
					break;
				case "g":
					System.out.println("Which client ID would you like to edit? ");
					viewAllClients(clients);
					index = Integer.parseInt(s.next());
					if (index < clients.size() && index >= 0) {
						clientEditor(accounts, verify, clients, index);
					} else {
						System.out.println("FAIL: Invalid ClientID.");
					}
					break;
				case "h":
					System.out.println("Which account number would you like to edit? ");
					viewAllAccounts(accounts);
					index = Integer.parseInt(s.next());
					if (index < accounts.size() && index >= 0) {
						accountEditor(accounts, verify, clients, index);
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

	public Client getClientByID(ArrayList<Client> clients, int id) {
		for (Client c : clients) {
			if (c.getClientID() == id) {
				return c;
			}
		}
		return null;
	}

	@Override
	public void viewAllClients(ArrayList<Client> clients) {
		for (Client c : clients) {
			System.out.println(c.toString());
		}
	}

	@Override
	public void viewPendingClients(ArrayList<Client> clients) {
		for (Client c : clients) {
			if (!c.getClientStatus()) {
				System.out.println(c.toString());
			}
		}
	}

	@Override
	public void approveSinglePending(Client client, ArrayList<Account> accounts, ArrayList<Client> clients,
			String verify) {
		if (client.getClientAccount() == -1) {
			Account temp = new Account(client);
			client.addAccount(temp.getAccountNumber());
			if (client.activateClient(verify)) {
				System.out.println("Success: Client " + client.getClientID() + " given Permissions.");
			} else {
				System.out.println("Fail: Client " + client.getClientID() + " not activated.");
			}
			bserv.storeAccount(temp);
			accounts.add(temp);
			bserv.updateClient(client);
		}
	}

	@Override
	public void approveAllPending(ArrayList<Client> clients, ArrayList<Account> accounts, String verify) {
		for (Client c : clients) {
			approveSinglePending(c, accounts, clients, verify);
		}
	}

	@Override
	public void viewAllAccounts(ArrayList<Account> accounts) {
		for (Account a : accounts) {
			System.out.println(a.toString());
		}
	}

	@Override
	public void viewFrozenAccounts(ArrayList<Account> accounts) {
		for (Account a : accounts) {
			if (!a.getAccountStatus()) {
				System.out.println(a.toString());
			}
		}
	}

	@Override
	public void clientEditor(ArrayList<Account> accounts, String verify, ArrayList<Client> clients, int clientNum) {
		if (EMPLOYEEACCESSCODE.equals(verify) || ADMINISTRATORACCESSCODE.equals(verify)) {
			Client client = clients.get(clientNum);
			s.reset();
			boolean toClose = false;
			BoDuke: while (!toClose) {
				System.out.println("Please choose from the list of options below:");
				System.out.println("A: Edit client Name.    \nB: Edit client Pass Phrase. ");
				System.out.println(
						"C: Toggle client approval status.     \nD: Add an additional account.    \nF: CANCEL");
				switch (s.next().toLowerCase().substring(0, 1)) {
				case "a":
					System.out.println("Client is: " + client.getName());
					System.out.println("Do you wish to modify Client's Name? (Y/N)");
					if (s.next().toLowerCase().substring(0, 1).equals("y")) {
						mutateName(client);
					}
					break;
				case "b":
					System.out.println("Do you wish to modify Client's Pass Phrase? (Y/N)");
					if (s.next().toLowerCase().substring(0, 1).equals("y")) {
						cserv.changeClientPassword(client, verify);
					}
					break;
				case "c":
					System.out.println("The client's application is Approved?" + client.getClientStatus());
					System.out.println("Do you wish to toggle the status? (Y/N)");
					if (s.next().toLowerCase().substring(0, 1).equals("y")) {
						toggleApproval(client, verify);
					}
					break;
				case "d":
					System.out.println("Sorry this functionality will come with further updates...");
					/*
					 * System.out.
					 * println("Do you want to link a supplemental account to this client? (Y/N)");
					 * if (s.next().toLowerCase().substring(0, 1).equals("y")) { System.out.
					 * println("Enter the account number that you wish to link to client: " +
					 * client.toString()); index = Integer.parseInt(s.next()); if (index <
					 * clients.size() && index != client.getClientID() && index >= 0) {
					 * client.linkClient(clients.get(index), verify); } else {
					 * System.out.println("FAIL: invalid client ID"); } }
					 */
					break;
				case "e":
					toClose = true;
					break BoDuke;
				default:
					System.out.println("Invalid selection");
				}
				bserv.updateClient(client);
			} // END WHILE

		} else {
			System.out.println("ACCESS DENIED: Invalid Employee / Admin Code");
		}
	}

	@Override
	public boolean toggleApproval(Client c, String verify) {
		return c.toggleApproval(verify);
	}

	@Override
	public void mutateName(Client c) {
		System.out.println("Do you want to change the given/first name? (Y/N)");
		if (s.next().toLowerCase().substring(0, 1).equals("y")) {
			String firstName;
			boolean correct = false;
			do {
				System.out.println("Enter the Given/First Name: ");
				firstName = s.next();
				System.out.println(
						"We have the given/first name as: " + firstName + "\nIs this information correct? (Y/N)");
				if (s.next().toLowerCase().substring(0, 1).equals("y")) {
					correct = true;
				}
			} while (!correct);
			c.setClientFirstName(firstName);
		} else {
		}

		System.out.println("Do you want to change the family/last name? (Y/N)");
		if (s.next().toLowerCase().substring(0, 1).equals("y")) {
			String lastName;
			boolean correct = false;
			do {
				System.out.println("Enter the Family/Last Name: ");
				lastName = s.next();
				System.out.println(
						"We have the family/last name as: " + lastName + "\nIs this information correct? (Y/N)");
				if (s.next().toLowerCase().substring(0, 1).equals("y")) {
					correct = true;
				}
			} while (!correct);
			c.setClientLastName(lastName);
		} else {
		}
	}// END MUTATENAME

	@Override
	public void accountEditor(ArrayList<Account> accounts, String verify, ArrayList<Client> clients, int accountNum) {
		if (EMPLOYEEACCESSCODE.equals(verify) || ADMINISTRATORACCESSCODE.equals(verify)) {
			Account account = accounts.get(accountNum);
			s.reset();
			//int index = 0;
			boolean toClose = false;
			UncleJesse: while (!toClose) {
				System.out.println("Please choose from the list of options below:");
				System.out.println("A: Edit client(s).    \nB: Edit account Balance. ");
				System.out.println(
						"C: Add a Joint Client.    \nD: Get Transaction History.    \nE: Check/Edit frozen status.    \nF: CANCEL");
				switch (s.next().toLowerCase().substring(0, 1)) {
				case "a":
					// int[] ids = account.getClientID();
					/*
					int ids = account.getClientID();
					System.out.println("Choose which client to modify: ");
					index = Integer.parseInt(s.next());
					 * if (index == ids[0] || (ids.length > 1 && ids.length > 1 && index == ids[1]))
					 * { toClose = true; } else { System.out.println("Invalid client ID"); }
					 */
					System.out.println("Sorry this functionality is not enabled.");
					break;
				case "b":
					aserv.mutateBalance(account, accounts);
					break;
				case "c":
					System.out.println("Sorry. Functionality to come soon.");

					System.out.println("Are you sure you wish to add a Co-signator? (Y/N)");
					// Auto-Activates account
					if (ADMINISTRATORACCESSCODE.equals(verify)) {
						account.setThaw(verify);

						System.out.println("Account has been successfully linked.");
						account.addHistory(new Transaction(0, -55, account.getAccountNumber(),
								"FAIL:Add Co-signator, Employee credentials"));
					} else {
						System.out.println("FAIL: Sorry this accout cannot be linked, Invalid Credentials.");
						account.addHistory(new Transaction(0, -55, account.getAccountNumber(),
								"FAIL:Add Co-signator, Employee credentials"));
					}

					// account.addJointHolder(s, clients);
					break;
				case "d":
					System.out.println("Transaction History: \n" + account.getHistory());
					break;
				case "e": // Frozen Account = Cancelled Account
					System.out.println(account.getAccountStatus());
					System.out.println("Would you like to change Cancelled Status? (Y/N)");
					if (s.next().toLowerCase().substring(0, 1).equals("y")) {
						account.toggleFreeze(verify);
					}
					break;
				case "f":
					toClose = true;
					break UncleJesse;
				default:
					System.out.println("Invalid selection");
				}
			}
		} else {
			System.out.println("ACCESS DENIED: Invalid Employee / Admin Code");
		}
	}
}
