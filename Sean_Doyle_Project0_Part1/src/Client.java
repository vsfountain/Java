import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

//Author: Sean Doyle
//Date Created: 2018/10/24

//This class stores personal information about the client of the bank

public final class Client implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3109361032833950478L;
	private static final String EMPLOYEEACCESSCODE = "Snoflake";
	private static final String ADMINISTRATORACCESSCODE = "Fluffy";
	private int clientID;
	public static int clientCount = 0;
	private String givenName;
	private String familyName;
	private String password = "Giant_Jenga";
	private boolean isActive = false;
	private int jointHolder = -1;
	private int myAccountNumber = -1;

	Client(String given, String family) {
		this.givenName = given;
		this.familyName = family;
		this.clientID = clientCount++;
		System.out.println("Your Client ID number is: " + clientID);
	}

	public static void resetClientCount(int count) {
		clientCount = count;
	}

	@Override
	public String toString() {
		return "Client [clientID=" + clientID + ", givenName=" + givenName + ", familyName=" + familyName
				+ ", password=" + password + ", isActive=" + isActive + ", jointHolder=" + jointHolder
				+ ", myAccountNumber=" + myAccountNumber + "]";
	}

	// Getters/Accessors
	protected int getClientID() {
		return clientID;
	}

	protected boolean verifyName(String first, String last) {
		return (first.equals(this.givenName) && last.equals(this.familyName));
	}

	protected boolean verifyPassword(String pass) {
		return pass.equals(this.password);
	}

	protected int getClientAccount() {
		return this.myAccountNumber;
	}

	protected boolean getClientStatus() {
		return this.isActive;
	}

	public static void clientCreator(Scanner s, ArrayList<Client> clientList) {
		String firstName, lastName;
		boolean correct = false;
		do {
			System.out.println("Enter Your Given/First Name: ");
			firstName = s.next();
			System.out.println("Enter Your Family/Last Name: ");
			lastName = s.next();
			System.out.println("We have your information as: \nGiven/First Name: " + firstName + "\nFamily/Last Name: "
					+ lastName + "\nIs this information correct? (Y/N)");
			if (s.next().toLowerCase().substring(0, 1).equals("y")) {
				correct = true;
			}
		} while (!correct);
		clientList.add(new Client(firstName, lastName));
		if (clientList.get(Client.clientCount - 1).changeClientPassword("Giant_Jenga")) {
			System.out.println("A bank employee will review your Application forthwith.\n\n");
		} else {
			System.out.println(
					"Sorry we are unable to set your account pass phrase at this time. \nA bank employee will contact you ASAP to finish setting up your account.");
		}
	}

	protected void canBank(Scanner s, Account myAcc) {
		if (this.isActive) {
			if (myAcc != null) {
				System.out.println("Please choose from the list of options below:");
				System.out.println("A: Deposit funds.    \nB: Withdraw funds.   \nC: Transfer funds.");
				switch (s.next().toLowerCase().substring(0, 1)) {
				case "a":
					System.out.print("Enter the decimal amount to be Deposited: $");
					myAcc.deposit(s.nextDouble(), this);
					break;
				case "b":
					System.out.print("Enter the decimal amount to Withdraw: $");
					myAcc.withdraw(s.nextDouble(), this);
					break;
				case "c":
					// TODO build transfer logic
				default:
					canBank(s, myAcc);
				}
			} else {
				System.out.println("Sorry no account has been linked.");
			}
		} else {
			System.out.println("Sorry your account is NOT Active.");
		}
	}

	// Setters/Mutators
	private boolean setClientFirstName(String newFirst) {
		this.givenName = newFirst;
		return true;
	}

	private boolean setClientLastName(String newLast) {
		this.familyName = newLast;
		return true;
	}

	private boolean changeClientPassword(String verify) {
		if (verify.equals(this.password) || EMPLOYEEACCESSCODE.equals(verify)
				|| ADMINISTRATORACCESSCODE.equals(verify)) {
			Scanner s = new Scanner(System.in);
			String pass, passVerify;
			boolean correct = false;
			do {
				System.out.println("Enter a pass phrase: ");
				pass = s.next();
				System.out.println("Please re-enter pass phrase: ");
				passVerify = s.next();
				if (pass.equals(passVerify)) {
					correct = true;
					this.password = pass;
					System.out.println("SUCCESS: the password has been saved.");
				} else {
					System.out.println("Sorry the two pass phrases do not match.");
				}
			} while (!correct);
			s.close();
			return true;
		} else {
			System.out.println("FAIL: Invalid challenge password");
			return false;
		}
	}

	protected void activateAccount() {
		this.isActive = true;
		System.out.println(this.givenName + " " + this.familyName + "'s account has been successfully activated.");
	}

	// probably wont add
	protected void addJointHolder(int jointHolder) {
		this.jointHolder = jointHolder;
	}

	protected boolean linkAccount(Account myAccount, String verify) {
		// Auto-Activates account
		if (EMPLOYEEACCESSCODE.equals(verify) || ADMINISTRATORACCESSCODE.equals(verify)) {
			activateAccount();
			System.out.println("Account has been successfully linked.");
			this.myAccountNumber = myAccount.getAccountNumber();
			return true;
		} else {
			System.out.println("FAIL: Sorry this accout cannot be linked, Invalid Credentials.");
			return false;
		}
	}

	protected int getJointID() {
		return this.jointHolder;
	}

	protected void linkClient(Client clientLink, String verify) {
		if (EMPLOYEEACCESSCODE.equals(verify) || ADMINISTRATORACCESSCODE.equals(verify)) {
			if (this.jointHolder == -1 && clientLink.getJointID() == -1) {
				this.jointHolder = clientLink.getClientID();
				clientLink.addJointHolder(this.clientID);
				System.out.println("SUCCESS: clients now filed jointly.");
			} else {
				System.out.println("FAIL: link already established");
			}
		} else {
			System.out.println("FAIL: Sorry this accout cannot be linked, Invalid Credentials.");
		}
	}

	private String getName() {
		return "\nGiven/First name: " + this.givenName + "\nFamil/Last name: " + this.familyName;
	}

	private void toggleApproval() {
		this.isActive = !this.isActive;
	}

	private void mutateName(Scanner s) {
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
			setClientFirstName(firstName);
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
			setClientLastName(lastName);
		} else {
		}
	}// END MUTATENAME

	private void changeAccountNumber(Account toReLink, String verify) {
		// this can only be done by admins
		if (ADMINISTRATORACCESSCODE.equals(verify)) {
			this.myAccountNumber = toReLink.getAccountNumber();
			toReLink.setClientID(verify, this.clientID);
			System.out.println("SUCCESS: new account has been linked");
		} else {
			System.out.println("FAIL: Invalid ADMIN access code");
		}
	}

	protected static void clientEditor(ArrayList<Account> accounts, String verify, ArrayList<Client> clients,
			int clientNum) {
		if (EMPLOYEEACCESSCODE.equals(verify) || ADMINISTRATORACCESSCODE.equals(verify)) {
			Client client = clients.get(clientNum);
			Scanner s = new Scanner(System.in);
			int index = 0;
			boolean toClose = false;
			BoDuke:
			while (!toClose) {
				System.out.println("Please choose from the list of options below:");
				System.out.println("A: Edit client Name.    \nB: Edit client Pass Phrase. ");
				System.out.println("C: Toggle client approval status.     \nD: Add Joint Client. ");
				System.out.println("E: Change account number.    \nF: CANCEL");
				switch (s.next().toLowerCase().substring(0, 1)) {
				case "a":
					System.out.println("Account is held by: " + client.getName());
					System.out.println("Do you wish to modify Name? (Y/N)");
					if (s.next().toLowerCase().substring(0, 1).equals("y")) {
						client.mutateName(s);
					} else {
					}
					break;
				case "b":
					client.changeClientPassword(verify);
					break;
				case "c":
					System.out.println("The client's application is Approved?" + client.getClientStatus());
					System.out.println("Do you wish to toggle the status? (Y/N)");
					if (s.next().toLowerCase().substring(0, 1).equals("y")) {
						client.toggleApproval();
					}
					break;
				case "d":
					System.out.println("Enter the client ID that you wish to link jointly.");
					index = s.nextInt();
					if (index < clients.size() && index != client.getClientID() && index >= 0) {
						client.linkClient(clients.get(index), verify);
					} else {
						System.out.println("FAIL: invalid client ID");
					}
					break;
				case "e":
					System.out.println("Do you want to change the account to which this client is linked? (Y/N)");
					if (s.next().toLowerCase().substring(0, 1).equals("y")) {
						if (client.getClientAccount() != -1) {
							System.out.println(
									"This client already has an account linked, Account will be lost.\nAre you sure you wish to change accounts? (Y/N)");
							if (s.next().toLowerCase().substring(0, 1).equals("n")) {
								break;
							}
						}
						System.out.println("To what account number do you wish to link this client with? ");
						index = s.nextInt();
						if (index < accounts.size() && index >= 0 && index != client.getClientAccount()) {
							client.changeAccountNumber(accounts.get(index), verify);
						} else {
							System.out.println("FAIL: Invalid account number");
						}
					}
					break;
				case "f":
					toClose = true;
					break BoDuke;
				default:
					System.out.println("Invalid selection");
				}
			}
			s.close();
		} else {
			System.out.println("ACCESS DENIED: Invalid Employee / Admin Code");
		}
	}
}
