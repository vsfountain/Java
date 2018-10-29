package Admin;
//import Bank;

import java.io.FileNotFoundException;
import java.util.Scanner;

import Admin.Person;

public class Main extends Bank{
	public Main(String name, int pin, Integer ssn, int accessLevel) {
		super(name, pin, ssn, accessLevel);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3963411602450693221L;
	

	public static void main(String[] args) throws FileNotFoundException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println((char)27 + "[35mEnter User Name");
		String name = scanner.nextLine();
		
		System.out.println((char)27 + "[35mEnter User Pin");
		Integer pin = Integer.parseInt(scanner.nextLine());
		
		System.out.println((char)27 + "[35mEnter User the Last Four of Your Social Security Number");
		Integer ssn = Integer.parseInt(scanner.nextLine());
		
		
		
		Person person = new Person(name, pin, ssn, accessLevel);
		
		Bank customer = new Bank(name, pin, ssn, accessLevel);
		
		String filename = "./CustomerInformation";

		
		if(customer.checkAccountInfo(person) == true) {
			System.out.println("Hello "+ person.getName());
		}
		else {	
			writeObject(filename, person);
			System.out.println("Writing new customer info to" + CustomersOfBank);
			customer.addNewCustomer(person);
			System.out.println(CustomersOfBank);
		}

	}

}