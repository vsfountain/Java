import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginManager {

	private static final String EMPLOYEEACCESSCODE = "Snoflake";
	private static final String EMPLOYEEPASSPHRASE = "123Monkey";
	private static final String ADMINISTRATORACCESSCODE = "Fluffy";
	private static final String ADMINISTRATORPASSPHRASE = "CafeBabe";
	
	static Scanner s = new Scanner(System.in);
	
	public String continueBanking(String oldHowTo) {
		s.reset();
		System.out.println("Do you wish to continue banking? (Y/N)");
		if(s.next().toLowerCase().substring(0,1).equals("y")) {
			return oldHowTo;
		}else {
			s.close();
			return "quit";
		}
	}
	
	
	public String clientCreator(ArrayList<Client> clientList) {
		s.reset();
		System.out.println("Are you filing Jointly today? (Y/N)");
		boolean choice = s.next().toLowerCase().substring(0,1).equals("y");
		System.out.println("Choice " + choice);
		System.out.println("Account Holder, please enter your information: ");
		clientList.add(Client.clientCreator(clientList));	
		if (choice) {
			return "jointClientCreate";
		}else {
			return "loginScreen";
		}
	}
	public String jointClientCreator(ArrayList<Client> clientList) {
		System.out.println("Alternate Account Holder, please enter your information: ");
		clientList.add(Client.clientCreator(clientList));
		clientList.get(clientList.size()-2).linkClient(clientList.get(clientList.size()-1), ADMINISTRATORACCESSCODE);
		return "loginScreen";
	}

	public String clientLogin(ArrayList<Client> clientList, ArrayList<Account> accountList) {
		s.reset();
		String first, last;
		String custPass;
		System.out.println("Please enter your given/first name");
		first = s.next();
		System.out.println("Please enter your family/last name");
		last = s.next();
		System.out.println("What is your Password?");
		custPass = s.next();
		System.out.println("We have your information as: \nFrist: "+ first + "\nLast: " + last + "\nPassword: ******");
		int i = 0;
		Client temp;
		boolean found = false;
		Wolverine:
		while (i < Client.clientCount && !found) {
			temp = clientList.get(i);
			//System.out.println(temp.toString());
			if (temp.verifyName(first, last)) {
				if (temp.verifyPassword(custPass)) {
					found = true;
					System.out.println("Customer Information Accepted.");
					System.out.println("Client Account Activated?: "+temp.getClientStatus());
					//System.out.println(accountList.toString());
					if(temp.getClientStatus()) {
						int idx = 0;
						boolean foundAcc = false;
						while (idx < accountList.size()) {
							//System.out.println(accountList.get(idx).toString());
							if (temp.getClientAccount() == accountList.get(idx).getAccountNumber()) {
								foundAcc = true;
								break;
							} else {
								idx++;
							}
						}
					if (foundAcc) {
						temp.canBank(accountList.get(idx));
						break Wolverine;
					}else { 
						temp.canBank(null);
					}
					}
				}else {
					System.out.println("Invalid Pass Phrase, doesn't not match customer information.");
					break Wolverine;
				}
			}
			i++;
		}//END wHILE LOOP
		if (!found) {
			System.out.println("Sorry the Client Information you have entered does not match our records.");
		}
		return "loginScreen";
	}//END CLIENTLOGIN

	public String employeeLogin(ArrayList<Client> clients, ArrayList<Account> accounts) {
		s.reset();
		System.out.println("Are you a Bank Administrator? (Y/N)");
		if (s.next().toLowerCase().substring(0, 1).equals("y")) {
			
			return "adminLogin";
		} else {
			System.out.println("Please enter Employee Pass Phrase: ");
			if (s.next().equals(EMPLOYEEPASSPHRASE)) {
				Employee.doWork(clients, accounts, EMPLOYEEACCESSCODE);
				
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
	
	public String adminLogin(ArrayList<Client> clients, ArrayList<Account> accounts) {
		s.reset();
		System.out.println("Please enter Administrator Pass Phrase: ");
		if (s.next().equals(ADMINISTRATORPASSPHRASE)) {
			Employee.doWork(clients, accounts, ADMINISTRATORACCESSCODE);
			
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
