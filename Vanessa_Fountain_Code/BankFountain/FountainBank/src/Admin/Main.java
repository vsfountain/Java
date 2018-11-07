package Admin;
//import Bank;

import java.io.IOException;
import java.util.Scanner;

import Admin.Person;

public class Main extends Bank{
	public Main(String name, int pin, Integer ssn, int accessLevel) {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3963411602450693221L;
	
	

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please select 1 for Customer, 2 for Employee, 3 for Admin, and 4 for New User");
		Integer accessLevel = Integer.parseInt(scanner.nextLine());
		//AdminAccess.AdminAccess(accessLevel);

		System.out.println((char)27 + "[35mEnter User Name");
		String name = scanner.nextLine();
		
		System.out.println((char)27 + "[35mEnter User Pin");
		Integer pin = Integer.parseInt(scanner.nextLine());
		
		System.out.println((char)27 + "[35mEnter the Last Four of Your Social Security Number");
		Integer ssn = Integer.parseInt(scanner.nextLine());
		
		Person person = new Person(name, pin, ssn, accessLevel);
		Bank.Bank(accessLevel, person);

	}

}