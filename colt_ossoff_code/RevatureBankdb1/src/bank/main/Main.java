package bank.main;

import java.util.ArrayList;
import java.util.Scanner;

import bank.DAO.AccountDAO;
import bank.DAO.CustomerDAO;
import bank.DAO.EmployeeDAO;
import bank.DAO.RelateAccCust;
import bank.DAO.RelateTransAcc;
import bank.DAO.TransactionDAO;
import bank.accounts.Account;
import bank.accounts.Transaction;
import bank.people.Customer;
import bank.people.Employee;

public class Main {

	static Customer sesCust = null;
	static Employee sesEmpl = null;

	static void creatUserAccount(Scanner s) {
		System.out.println("Full Name: ");
		String name = s.nextLine();
		System.out.println("Pick a username: ");
		String uName = s.next();
		s.nextLine();
		String pwd, cpwd;
		do {
			System.out.print("Password: ");
			pwd = s.next();
			System.out.print("Confirm password: ");
			cpwd = s.next();
			if (!pwd.equalsIgnoreCase(cpwd))
				System.out.println("Your passwords do not pass.  Try again.");
		} while (!pwd.equals(cpwd));
		sesCust = new Customer(name, uName, pwd);
		ArrayList<Integer> o = new ArrayList<Integer>();
		o.add(sesCust.getId());
		Account a = new Account(0, o);
		sesCust.addAccount(a.getId());
		System.out.println("Thank you for joining");
	}

	static void createEmployee(Scanner s) {
		System.out.println("Full Name: ");
		String name = s.nextLine();
		System.out.println("Pick a username: ");
		String uName = s.next();
		s.nextLine();
		String pwd, cpwd;
		do {
			System.out.print("Password: ");
			pwd = s.next();
			System.out.print("Confirm password: ");
			cpwd = s.next();
			if (!pwd.equalsIgnoreCase(cpwd))
				System.out.println("Your passwords do not pass.  Try again.");
		} while (!pwd.equals(cpwd));
		System.out.print("Are you an admin?: ");
		String responce = s.next();
		sesEmpl = new Employee(
				((responce.equalsIgnoreCase("yes")) ? true : false), 
				name,
				uName, 
				pwd
				);
	}

	static void loginEmployee(Scanner s) {
		while(true) {
			try {
			System.out.print("Username: ");
			String uName = s.next();
			System.out.print("Password: ");
			String pwd = s.next();
			sesEmpl = Employee.login(uName, pwd);
			if(sesEmpl != null) {
				System.out.println("Welcome back " + sesEmpl.getName());
				return;
			}
			} catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("Wrong username or password, try again.");
		}
	}
	
	static void loginCustomer(Scanner s) {
		String uName, pwd;
		do {
			try {
				System.out.print("Username: ");
				uName = s.next();
				System.out.print("Password: ");
				pwd = s.next();
				sesCust = Customer.login(uName, pwd);
				if (sesCust != null) {
					System.out.println("Welcome back " + sesCust.getName());
					return;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Wrong username or password, try again.");
		} while (true);
	}

	public static void accountApply(Scanner sc) {
		ArrayList<Integer> owners = new ArrayList<Integer>();
		owners.add(sesCust.getId());
		System.out.print("\nAre you applying (jointly)?: ");
		String responce = sc.next();
		ArrayList<Customer> joints = new ArrayList<Customer>();
		if(responce.equalsIgnoreCase("jointly")) {
			System.out.print("Please enter your partner/s bank ID's seperated by commas: ");
			for(String s: sc.nextLine().split(",")) {
				Customer c = CustomerDAO.selectById(Integer.parseInt(s));
				if(c != null) {
					owners.add(Integer.parseInt(s));
					joints.add(c);
					break;
				}
			}
		}
		System.out.println("How much money do you want to create the account with?");
		System.out.print(">: $");
		double am = sc.nextDouble();
		Account acc = new Account(am, owners);
		for(Customer c: joints)
			c.addAccount(acc.getId());
		sesCust.addAccount(acc.getId());
		System.out.println("Thank you for opening an account with us.\nOne of our employees will approve it shortly.");
	}
	
	public static void main(String[] args) {
		
		Scanner user = new Scanner(System.in);
		System.out.println("Hello. Are you a (Customer) or an (Employee)");
		String responce = user.next();
		user.nextLine();
		if(responce.equalsIgnoreCase("customer")) {
			System.out.println("Are you a (new) or (returning) customer");
			responce = user.next();
			user.nextLine();
			if(responce.equalsIgnoreCase("new")) creatUserAccount(user);
			//if(sesCust != null) {
				while(true) {
					loginCustomer(user);
					System.out.println("What do you want to do?");
					System.out.println("(Apply) for an account.");
					System.out.println("View (accounts) information.");
					System.out.println("View (personal) information.");
					System.out.println("Get account (balance) by account number.");
					System.out.println("(Withdraw)");
					System.out.println("(deposit)");
					System.out.println("(Transfer) funds");
					System.out.println("(Exit)");
					responce = user.next();
					user.nextLine();
					
					if(responce.equalsIgnoreCase("apply")) {
						accountApply(user);
					} else if(responce.equalsIgnoreCase("accounts")) {
						System.out.println();
						System.out.println(sesCust.viewAccountInfo());
					} else if(responce.equalsIgnoreCase("personal")) {
						System.out.println();
						System.out.println(sesCust.toString());
					} else if(responce.equalsIgnoreCase("balance")) {
						System.out.println();
						ArrayList<Integer> accs = sesCust.getAccounts();
						for(int a: accs) System.out.println(a);
						System.out.print("Which account's balance would you like to see?: ");
						System.out.println(sesCust.viewAccountBalance(user.nextInt()));
					} else if(responce.equalsIgnoreCase("withdraw")) {
						System.out.println();
						ArrayList<Integer> accs = sesCust.getAccounts();
						for(int a: accs) System.out.println(a);
						System.out.print("Which account do you want to withdraw from?: ");
						int ac = user.nextInt();
						System.out.print("How much money do you want?: $");
						double am = user.nextDouble();
						if(sesCust.withdraw(ac, am)) System.out.println("Here's your $" + am);
					} else if(responce.equalsIgnoreCase("deposit")) {
						System.out.println();
						ArrayList<Integer> accs = sesCust.getAccounts();
						for(int a: accs) System.out.println(a);
						System.out.print("Which account do you want to deposit to?: ");
						int ac = user.nextInt();
						System.out.print("How much money you are depositing?: $");
						double am = user.nextDouble();
						if(sesCust.deposit(ac, am)) System.out.println("Successfully deposited $" + am);
					} else if(responce.equalsIgnoreCase("transfer")) {
						System.out.println();
						ArrayList<Integer> accs = sesCust.getAccounts();
						for(int a: accs) System.out.println(a);
						System.out.print("Which account do you want to transfer from?: ");
						int ac1 = user.nextInt();
						System.out.print("Which account do you want to transfer to?: ");
						int ac2 = user.nextInt();
						System.out.print("How much money you are trasferring?: $");
						double am = user.nextDouble();
						boolean tr = sesCust.transfer(ac1, ac2, am);
						if(tr) System.out.println("Successfully transferred $" + am);
					} else if(responce.equalsIgnoreCase("exit")) {
						System.out.println("Thank you for your patronage.\nSee you next time.");
						break;
					} else {
						System.out.println("Sorry we didn't understand you.\nPlease Login and try again.");
						continue;
					}

					
				}
			//}
		}
		else if(responce.equalsIgnoreCase("employee")) {
			System.out.print("Are you new?: ");
			responce = user.next();
			user.nextLine();
			if(responce.equalsIgnoreCase("yes")) createEmployee(user);
				while(true) {
					loginEmployee(user);
					System.out.println("What do you want to do?");
					System.out.println("(Approve) an account.");
					System.out.println("View (account) information.");
					System.out.println("View (personal) information.");
					System.out.println("View (customer) information.");
					System.out.println("Get account (balance) by account number.");
					System.out.println("(Withdraw)");
					System.out.println("(deposit)");
					System.out.println("(Transfer) funds");
					System.out.println("(Cancel) an account");
					System.out.println("(Exit)");
					responce = user.next();
					user.nextLine();
					
					if(responce.equalsIgnoreCase("approve")) {
						System.out.print("\nEnter account ID: ");
						int id = user.nextInt();
						if(sesEmpl.approval(id, "approved")) System.out.println("Approved");;
					} else if(responce.equalsIgnoreCase("account")) {
						System.out.print("\nEnter account ID: ");
						int id = user.nextInt();
						System.out.println(sesEmpl.viewAccountInfo(id));
					} else if(responce.equalsIgnoreCase("personal")) {
						System.out.println();
						System.out.println(sesEmpl.toString());
					} else if(responce.equalsIgnoreCase("balance")) {
						System.out.print("\nEnter account ID: ");
						int id = user.nextInt();
						System.out.println(sesEmpl.viewAccountBalance(id));
					} else if(responce.equalsIgnoreCase("customer")) {
						System.out.print("\nEnter Customer ID: ");
						int id = user.nextInt();
						System.out.println(sesEmpl.viewCustInfo(id));
					} else if(responce.equalsIgnoreCase("withdraw")) {
						if(sesEmpl.isAdmin()) {
							System.out.print("\nEnter account ID: ");
							int ac = user.nextInt();
							System.out.print("Enter amount: $");
							double am = user.nextDouble();
							if(sesEmpl.withdraw(ac, am)) System.out.println("Here's your $" + am);
						} else {
							System.out.println("You are not an admin.");
							continue;
						}
					} else if(responce.equalsIgnoreCase("deposit")) {
						if(sesEmpl.isAdmin()) {
							System.out.println("\nEnter account ID: ");
							int ac = user.nextInt();
							System.out.print("How much money you are depositing?: $");
							double am = user.nextDouble();
							if(sesEmpl.deposit(ac, am)) System.out.println("Successfully deposited $" + am);
						} else {
							System.out.println("You are not an admin.");
							continue;
						}
					} else if(responce.equalsIgnoreCase("transfer")) {
						if(sesEmpl.isAdmin()) {
							System.out.println();
							System.out.print("Which account do you want to transfer from?: ");
							int ac1 = user.nextInt();
							System.out.print("Which account do you want to transfer to?: ");
							int ac2 = user.nextInt();
							System.out.print("How much money you are trasferring?: $");
							double am = user.nextDouble();
							if(sesEmpl.transfer(ac1, ac2, am)) System.out.println("Successfully transferred $" + am);
						} else {
							System.out.println("You are not an admin.");
							continue;
						}
					} else if(responce.equalsIgnoreCase("exit")) {
						System.out.println("Thank you for your patronage.\nSee you next time.");
						break;
					} else if(responce.equalsIgnoreCase("cancel")){
						if(sesEmpl.isAdmin()) {
							System.out.print("\\nEnter account ID: ");
							int accId = user.nextInt();
							sesEmpl.cancelAcc(accId);
						} else {
							System.out.println("You are not an admin.");
							continue;
						}
					} else {
						System.out.println("Sorry we didn't understand you.\nPlease Login and try again.");
						continue;
					}

					
				}
		} else {
			System.out.println("You're new here ain'cha. Ok then, create an account.");
			creatUserAccount(user);
		}
	}
}
