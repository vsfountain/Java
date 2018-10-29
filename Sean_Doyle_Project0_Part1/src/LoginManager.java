import java.util.ArrayList;
import java.util.Scanner;

public class LoginManager {

	private static final String EMPLOYEEACCESSCODE = "Snoflake";
	private static final String EMPLOYEEPASSPHRASE = "123Monkey";
	private static final String ADMINISTRATORACCESSCODE = "Fluffy";
	private static final String ADMINISTRATORPASSPHRASE = "CafeBabe";
	
	
	public String clientCreator(Scanner s, ArrayList<Client> clientList) {
		System.out.println("Are you filing Jointly today? (Y/N)");
		if (s.next().toLowerCase().substring(0,1).equals("y")) {
			System.out.println("Account Holder 1, please enter your information: ");
			System.out.println("Do you wish to continue? (Y/N)");
			if (s.next().toLowerCase().substring(0, 1).equals("y")) {
				Client.clientCreator(s, clientList);
				System.out.println("Account Holder 2, please enter your information: ");
				Client.clientCreator(s, clientList);
			}else {
				System.out.println("FAIL: could not create joint account.");
				return "loginScreen";
			}
			clientList.get(Client.clientCount).linkClient(clientList.get(Client.clientCount), ADMINISTRATORACCESSCODE);
		}else {
		System.out.println("To apply for your account we will need a few pieces of information.");
		System.out.println("Do you wish to continue? (Y/N)");
		if (s.next().toLowerCase().substring(0, 1).equals("y")) {
			Client.clientCreator(s, clientList);
		}
		}
		return "loginScreen";
	}

	public String clientLogin(Scanner s, ArrayList<Client> clientList, ArrayList<Account> accountList) {
		String first, last;
		String custPass;
		System.out.println("Please enter your given/first name");
		first = s.next();
		System.out.println("Please enter your family/last name");
		last = s.next();
		System.out.println("What is your Password?");
		custPass = s.next();
		
		int i = 0;
		Client temp;
		boolean found = false;
		while (i < Client.clientCount && !found) {
			temp = clientList.get(i);
			if (temp.verifyName(first, last)) {
				if (temp.verifyPassword(custPass)) {
					found = true;
					System.out.println("Customer Information Accepted.");
					temp.activateAccount();
					int idx = 0;
					boolean foundAcc = false;
					while (idx < accountList.size()) {
						if (temp.getClientAccount() == accountList.get(idx).getAccountNumber()) {
							//accountList.get(idx).setThaw("Good_Day");
							foundAcc = true;
							break;
						}
						idx++;
					}
					if (foundAcc) {
						temp.canBank(s, accountList.get(idx));
					}else { 
						temp.canBank(s, null);
					}
				}else {
					System.out.println("Invalid Pass Phrase, doesn't not match customer information.");
					return "clientLogin";
				}
			}
		}//END wHILE LOOP
		if (!found) {
			System.out.println("Sorry the Client name you have entered does not match our records.");
			System.out.println("If you would like to create an account: enter Y     If not you will be redirected to the customer login screen.");
			if (s.next().toLowerCase().substring(0, 1).equals("y")) {
				return "clientCreate";
			}else {
				return "customerLogin";
			}
		}
		return "loginScreen";
	}//END CLIENTLOGIN

	public String employeeLogin(Scanner s, ArrayList<Client> clients, ArrayList<Account> accounts) {
		System.out.println("Are you a Bank Administrator? (Y/N)");
		if (s.next().toLowerCase().substring(0, 1).equals("y")) {
			return "adminLogin";
		} else {
			System.out.println("Please enter Employee Pass Phrase: ");
			if (s.next().equals(EMPLOYEEPASSPHRASE)) {
				Employee.doWork(s, clients, accounts, EMPLOYEEACCESSCODE);
				return "loginScreen";// need to override
			} else {
				System.out.println("Invalid Employee Pass Phrase. Would you like to re-enter password?");
				if (s.next().toLowerCase().substring(0,1).equals("y")) {
					return "employeeLogin";
				} else {
					return "loginScreen";
				}
			}
		}
	}
	
	public String adminLogin(Scanner s, ArrayList<Client> clients, ArrayList<Account> accounts) {
		System.out.println("Please enter Administrator Pass Phrase: ");
		if (s.next().equals(ADMINISTRATORPASSPHRASE)) {
			Employee.doWork(s, clients, accounts, ADMINISTRATORACCESSCODE);
			return "loginScreen";// need to override
		} else {
			System.out.println("Invalid Administrator Pass Phrase. Would you like to re-enter password?");
			if (s.next().toLowerCase().substring(0, 1).equals("y")) {
				return "adminLogin";
			} else {
				return "loginScreen";
			}
		}
	}
	
	
}
