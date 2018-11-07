package bankofalexandria;

import java.io.FileInputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Bank {
	
	
	final static Logger logger = Logger.getLogger(Bank.class);

			
	static ArrayList<Customer> bankCustomers;
	static ArrayList<Customer> bankAccounts;
	
	static int custid = 0;
	static int accid = 0;

	public static void main(String[] args) {
		BasicConfigurator.configure();

		//PropertyConfigurator.configure("lo4j.properties");
		if(logger.isInfoEnabled()) {
			logger.info("The beginning of the program has begun");
		}
		
		//bankCustomers = new ArrayList<>();
		//String filename = "./accountData";

		// reads in exiting customer information
		//bankCustomers = (ArrayList<Customer>) readObject(filename);

		// System.out.println(bankCustomers);
		// writeObject(filename, bankCustomers);
		// System.exit(0);

		// boolean loggedIn=false;
		Scanner s = new Scanner(System.in);
		Account myAccount = new Account();

		// checking for account info
		System.out.println("Do you already have an account? (Enter 1 for yes or 2 for no.)");
		int acc = s.nextInt();
		Scanner scan = new Scanner(System.in);
		
		CustomerDAOImpl custInfo1 = new CustomerDAOImpl();
		AccountDAOImpl accInfo1 = new AccountDAOImpl();
		Account accountID = new Account();
		Customer customerID = new Customer();
		int custID = 0;


		
		if (acc == 1) {
			System.out.println("Please Login to Existing Account");
			System.out.println("Enter your userName.");
			String name2 = scan.nextLine();
			System.out.println("Enter your password");
			String pass2 = scan.nextLine();
			
			customerID = custInfo1.selectCustomerByCredentials(name2, pass2);
			custID = customerID.userId;
			accountID = accInfo1.selectAccountByID(custID);
			System.out.println("Customer Info:  "+customerID);
			System.out.println("Account Info:  "+accountID);
			
			if(logger.isInfoEnabled()) {
				logger.info("You've successfully logged in.");
			}
			

			/*for (int i = 0; i < bankAccounts.size(); i++) {
				if (name2 == (bankAccounts.get(i).name) && pass2 == (bankAccounts.get(i).password)) {
					System.out.println("Login Successful!");
				} else {
					System.out.println("Login Failed, Goodbye.");
					System.exit(0);
				}
			}*/

		} else {
			// New customers get sent here to register and create accounts
			System.out.println("Please Complete Customer Registraion.");
			System.out.println("Enter your Name.");
			String name1 = scan.nextLine();
			System.out.println("Enter your userName.");
			String userName1 = scan.nextLine();
			System.out.println("Enter your password.");
			String password1 = scan.nextLine();
	
		    //preparedInsertCustomer(name1, userName1, password1);
			custInfo1.preparedInsertCustomer(name1, userName1, password1);
			
			//Customer customer = new Customer(name1, userName1, password1, );
			//System.out.println(customer);
			custInfo1.selectAllCustomers();
			customerID = custInfo1.selectCustomerByCredentials(userName1, password1);
			System.out.println("Customer Info:  "+customerID);
			custID = customerID.userId;
			
			//writeObject(filename, bankCustomers);

			// user input to create account
			//System.out.println("Would you like to create a joint or individual account?");
			//System.out.println("Enter 1 for individual, or 2 for joint.");

			//int type = scan.nextInt();

			// creating an employee and administrator to create selected account
			Employee emp1 = new Employee();
			Administrator admin1 = new Administrator();

			// checking whether to create account
			System.out.println("Enter an initial deposit amount.");
			double initialBalance = scan.nextDouble();

			// creating accounts
			boolean create = emp1.approveAccount(initialBalance);

			if (create == true) { // solo account creation
				//SoloAccount account1 = admin1.createSoloAccount(customer, initialBalance);
				accInfo1.preparedInsertAccount(initialBalance, custID);
				accountID = accInfo1.selectAccountByID(custID);
				System.out.println("Account Info:  "+accountID);
				//myAccount = account1; // this line
				//admin1.viewAccountInfo(account1);
				
				if(logger.isInfoEnabled()) {
					logger.info("You've successfully created an account.");
				}
				
				
			} 
		}/*else if (create == true && type == 2) { // joint account creation
				System.out.println("Please enter the username of another customer.");
				Scanner scanner = new Scanner(System.in);
				String userName2 = scanner.nextLine();
				int found = 0;

				for (int i = 0; i < bankCustomers.size(); i++) { // searching for //customer to join account
					System.out.println(bankCustomers.get(i).userName);
					if (userName2.equals(bankCustomers.get(i).userName)) {
						found++;
						JointAccount account1 = admin1.createJointAccount(customer, bankCustomers.get(i),
								initialBalance);
						break;
					}
				}
				if (found == 0) {
					System.out.println("Customer not found");
				}
			}*/

		
		// below is a while loop to display a transaction menu for customer until they
		// leave the app
	
		int next;

		do {
			System.out.println("\n");
			System.out.println("Choose a transaction.");
			System.out.println("Enter the number of your selection.");
			System.out.println("-----------------------------------");
			System.out.println("1. View Balance");
			System.out.println("2. Deposit Money");
			System.out.println("3. Withdraw Money");
			System.out.println("4. Transfer to Another Account");
			System.out.println("5. Exit Application");

			Scanner menu = new Scanner(System.in);
			next = menu.nextInt();

			// switch that calls appropriate function based on case
			switch (next) {
			case 1:
				System.out.println(accountID);
				break;
			case 2:
				System.out.println("Enter deposit amount");
				double amount = menu.nextDouble();
				double newBalance = accountID.deposit(amount);
				accInfo1.updateBalance(custID, newBalance);
				break;
			case 3:
				System.out.println("Enter withdrawal amount");
				double amount2 = menu.nextDouble();
				double newBalance2 = accountID.withdraw(amount2);
				accInfo1.updateBalance(custID, newBalance2);
				break;
			case 4:
				Scanner menuscan = new Scanner(System.in);
				System.out.println("Enter the userID of the customer you wish to transfer money to");
				int toUser = menuscan.nextInt();
				Account toAccount = new Account();
				toAccount = accInfo1.selectAccountByID(toUser);
				System.out.println("Enter the value that you would like to transfer");
				double amount3 = menuscan.nextDouble();
				double newBalance3 = accountID.withdraw(amount3);
				accInfo1.updateBalance(custID, newBalance3);
				double newBalance4 =  toAccount.deposit(amount3);
				accInfo1.updateBalance(toUser, newBalance4);
				//for(int i = 0; i<bankCustomers.size(); i++) { //searching for customer to
				// join account
				// if(toUser.equals(bankCustomers.get(i).userName)) {
				break;
			default:
				System.out.println("Goodbye");
			}
			;

		} while (next != 5);
	} // while the user has not chosen to exit

	// i/o
	static Object readObject(String filename) {
		Object obj = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			obj = ois.readObject();// de-serialization

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}

	static void writeObject(String filename, ArrayList obj) {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(obj); // serialization - only takes an object that implements serialize

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
