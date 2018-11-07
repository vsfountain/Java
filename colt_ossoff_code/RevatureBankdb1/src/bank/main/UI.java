package bank.main;

import java.util.ArrayList;
import java.util.Scanner;

import bank.accounts.Account;
import bank.people.Customer;
import bank.people.Employee;

public class UI {




	static void loginCustomer(Scanner s) {
		String uName, pwd;
		do {
			System.out.print("Username: ");
			uName = s.next();
			System.out.print("Password: ");
			pwd = s.next();
			//if (sesCust == null) {
				for (Customer c : customers)
					if (c.login(uName, pwd)) {
						sesCust = c;
						return;
					}
			//} else {
			//	if (sesCust.login(uName, pwd))
			//		return;
			//}
			//System.out.println("Wrong username or password. Try again.");
		} while (true);
	}

	public static void mainActivity() {
		System.out.println("Hello. Are you a (Customer) or an (Employee)");
		String responce = user.next();
		user.nextLine();
		if(responce.equalsIgnoreCase("customer")) {
			System.out.println("Are you a (new) or (returning) customer");
			responce = user.next();
			user.nextLine();
			if(responce.equalsIgnoreCase("new")) creatUserAccount(user);
			while(true) { //Customer activity loop
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
				} else if(responce.equalsIgnoreCase("accounts")) {
					System.out.println();
					System.out.println(sesCust.viewAccountInfo(accounts, customers, transactions));
				} else if(responce.equalsIgnoreCase("personal")) {
					System.out.println();
					System.out.println(sesCust.view(accounts));
				} else if(responce.equalsIgnoreCase("balance")) {
					System.out.println();
					ArrayList<Integer> accs = sesCust.getAccounts();
					for(int a: accs) System.out.println(a);
					System.out.print("Which account's balance would you like to see?: ");
					System.out.println(sesCust.viewAccountBalance(user.nextInt(), accounts));
				} else if(responce.equalsIgnoreCase("withdraw")) {
					System.out.println();
					ArrayList<Integer> accs = sesCust.getAccounts();
					for(int a: accs) System.out.println(a);
					System.out.print("Which account do you want to withdraw from?: ");
					int ac = user.nextInt();
					System.out.print("How much money do you want?: $");
					double am = user.nextDouble();
					if(transactions.add(sesCust.withdraw(ac, am, accounts))) System.out.println("Here's your $" + am);
				} else if(responce.equalsIgnoreCase("deposit")) {
					System.out.println();
					ArrayList<Integer> accs = sesCust.getAccounts();
					for(int a: accs) System.out.println(a);
					System.out.print("Which account do you want to deposit to?: ");
					int ac = user.nextInt();
					System.out.print("How much money you are depositing?: $");
					double am = user.nextDouble();
					if(transactions.add(sesCust.deposit(ac, am, accounts))) System.out.println("Successfully deposited $" + am);
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
					if(transactions.add(sesCust.transfer(ac1, ac2, am, accounts))) System.out.println("Successfully transferred $" + am);
				} else if(responce.equalsIgnoreCase("exit")) {
					System.out.println("Thank you for your patronage.\nSee you next time.");
					break;
				} else {
					System.out.println("Sorry we didn't understand you.\nPlease Login and try again.");
					continue;
				}
			}
		} else if(responce.equalsIgnoreCase("employee")) {
			System.out.print("Are you new?: ");
			responce = user.next();
			user.nextLine();
			if(responce.equalsIgnoreCase("yes")) createEmployee(user);
			while (true) { //Employee activity loop
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
				if(responce.equalsIgnoreCase("approve")) {
					System.out.print("\nEnter account ID: ");
					int id = user.nextInt();
					if(sesEmpl.approval(id, "approved", accounts)) System.out.println("Approved");;
				} else if(responce.equalsIgnoreCase("account")) {
					System.out.print("\nEnter account ID: ");
					int id = user.nextInt();
					System.out.println(sesEmpl.viewAccountInfo(id, accounts, customers, transactions));
				} else if(responce.equalsIgnoreCase("personal")) {
					System.out.println();
					System.out.println(sesEmpl.toString());
				} else if(responce.equalsIgnoreCase("balance")) {
					System.out.print("\nEnter account ID: ");
					int id = user.nextInt();
					System.out.println(sesEmpl.viewAccountBalance(id, accounts));
				} else if(responce.equalsIgnoreCase("customer")) {
					System.out.print("\nEnter Customer ID: ");
					int id = user.nextInt();
					System.out.println(sesEmpl.viewCustInfo(id, customers, accounts));
				} else if(responce.equalsIgnoreCase("withdraw")) {
					if(sesEmpl.isAdmin()) {
						System.out.print("\nEnter account ID: ");
						int ac = user.nextInt();
						System.out.print("Enter amount: $");
						double am = user.nextDouble();
						if(transactions.add(sesEmpl.withdraw(ac, am, accounts))) System.out.println("Here's your $" + am);
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
						if(transactions.add(sesEmpl.deposit(ac, am, accounts))) System.out.println("Successfully deposited $" + am);
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
						if(transactions.add(sesEmpl.transfer(ac1, ac2, am, accounts))) System.out.println("Successfully transferred $" + am);
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
						sesEmpl.cancelAcc(accId, accounts);
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
