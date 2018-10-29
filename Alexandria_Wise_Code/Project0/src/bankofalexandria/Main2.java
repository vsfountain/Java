package bankofalexandria;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main2 {
	
	public static void main(String[] args) {
		
	// attempt at hard coding customers previously in bank data for test cases
	//entries are being overwritten in list?
	Administrator friendsAdmin = new Administrator();
		
	List<Customer> bankCustomers = new ArrayList<>();
	
	/*Customer ross = new Customer("Ross","rgellar", "dinosaurs");
	Customer rachel = new Customer("Rachel","rgreen", "break");
	Customer joey = new Customer("Joey","jtribbianni", "pizza");
	Customer monica = new Customer("Monica","mgellar", "mrclean");
	Customer chandler = new Customer("Chandler","cmbing", "hahaha");
	Customer phoebe = new Customer("Phoebe","rphilange", "smellycat");
	*/
	
	/*.add(new Customer("Ross", "rgellar", "dinosaurs"));
	bankCustomers.add(new Customer("Rachel","rgreen", "break"));
	bankCustomers.add(new Customer("Joey","jtribbianni", "pizza"));
	bankCustomers.add(new Customer("Monica","mgellar", "mrclean"));
	bankCustomers.add(new Customer("Chandler","cmbing", "hahaha"));
	bankCustomers.add(new Customer("Phoebe","rphilange", "smellycat"));*/
	
	/*bankCustomers.add(ross);
	bankCustomers.add(rachel);
	bankCustomers.add(joey);
	bankCustomers.add(monica);
	bankCustomers.add(chandler);
	bankCustomers.add(phoebe);
	*/
	/*List<Account> bankAccounts= new ArrayList<>();
	SoloAccount ross1 = friendsAdmin.createSoloAccount(ross, 75000);
	SoloAccount rachel1 = friendsAdmin.createSoloAccount(rachel, 60000);
	SoloAccount joey1 = friendsAdmin.createSoloAccount(joey, 45000);
	SoloAccount monica1 = friendsAdmin.createSoloAccount(monica, 50000);
	SoloAccount chandler1 = friendsAdmin.createSoloAccount(chandler, 85000);
	SoloAccount phoebe1 = friendsAdmin.createSoloAccount(phoebe, 35000);
	
	bankAccounts.add(ross1);
	bankAccounts.add(rachel1);
	bankAccounts.add(joey1);
	bankAccounts.add(monica1);
	bankAccounts.add(chandler1);
	bankAccounts.add(phoebe1);
	*/
	//preparing to open text file	
	String filename = "./accountData";
	boolean loggedIn = false;
	
	//customer registration
	System.out.println("Please Complete Customer Registraion.");
	System.out.println("Enter your Name.");
	Scanner scan = new Scanner(System.in);
	String name1 = scan.nextLine();
	System.out.println("Enter your userName.");
	String userName1 = scan.nextLine();
	System.out.println("Enter your password.");
	String password1 = scan.nextLine();
	
	Customer customer = new Customer(name1, userName1, password1);
	bankCustomers.add(customer);
	writeObject(filename, customer);
	readObject(filename);
	
	//user input to create account
	System.out.println("Would you like to create a joint or individual account?");
	System.out.println("Enter 1 for individual, or 2 for joint.");
	
	int type = scan.nextInt();
	
	//creating an employee and administrator to create selected account
	Employee emp1 = new Employee();
	Administrator admin1 = new Administrator();
	
	//checking whether to create account
	System.out.println("Enter an initial deposit amount.");
	double initialBalance = scan.nextDouble();
	
	//creating accounts
	boolean create = emp1.approveAccount(initialBalance);
	Account myAccount = new Account();
	if(create == true && type == 1) {	//solo account creation
		SoloAccount account1 = admin1.createSoloAccount(customer, initialBalance);
		myAccount = account1;
		admin1.viewAccountInfo(account1);
	}/*else if(create == true && type == 2) {		//joint account creation
		System.out.println("Please enter the username of another customer.");
		Scanner scanner = new Scanner(System.in);
		String userName2 = scanner.nextLine();
		int found = 0;
		for(int i = 0; i<bankCustomers.size(); i++) {	//searching for customer to join account
			Customer person = bankCustomers.get(i);
			System.out.println(bankCustomers.get(i));
			if(userName2==person.userName) {
				System.out.println(bankCustomers.get(i));
				found++;
				JointAccount account1 = admin1.createJointAccount(customer, bankCustomers.get(i), initialBalance);
				break;
			}
		}
		if (found==0) {
			System.out.println("Customer not found");
		}
	}*/
	
	//below is a while loop to display a transaction menu for customer until they leave the app
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
	
	//switch that calls appropriate function based on case
	switch(next) {
	case 1:
		System.out.println(myAccount.toString());
		break;
	case 2:
		System.out.println("Enter deposit amount");
		double amount = menu.nextDouble();
		myAccount.deposit(amount);
		break;
	case 3:
		System.out.println("Enter withdrawal amount");
		double amount2 = menu.nextDouble();
		myAccount.withdraw(amount2);
		break;
	case 4:
		System.out.println("Enter destination accountID");
		//int amount2 = menu.nextDouble();
		//myAccount.withdraw(amount2);
		break;
	default:
		System.out.println("Goodbye");
		
	};
	
	}while(next != 5);}	//while the user has not chosen to exit

	//i/o
	static void readObject(String filename) {
		try(ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(filename)))
		{
			Object obj = ois.readObject();//de-serialization
			System.out.println(obj);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static void writeObject(String filename, Object obj) {
		try(ObjectOutputStream oos =new ObjectOutputStream(
				new FileOutputStream(filename)))
		{
			oos.writeObject(obj); //serialization - only takes an object that implements serialize 
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
