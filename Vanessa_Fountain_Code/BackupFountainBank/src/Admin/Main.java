package Admin;
//import Bank;

import java.io.IOException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import Admin.Person;
import Customer.CustomerAccess;

public class Main extends Bank{
	//static Logger log = Logger.getLogger(Main.class);
	public Main(String name, int pin, Integer ssn, int accessLevel) {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3963411602450693221L;
	
	
	static Logger log = Logger.getLogger(Main.class);
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		PropertyConfigurator.configure("log4j.properties");
		//log.debug("Sample debug message");
        //log.info("Sample info message");
        //log.error("Sample error message");
        //log.fatal("Sample fatal message");
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please select: \n  1 for Customer \n  2 for Employee \n  3 for Admin \n  4 for New User");
		Integer accessLevel = Integer.parseInt(scanner.nextLine());
		//AdminAccess.AdminAccess(accessLevel);

		System.out.println((char)27 + "[35mEnter User Name");
		String name = scanner.nextLine();
		
		System.out.println((char)27 + "[35mEnter User Pin");
		Integer pin = Integer.parseInt(scanner.nextLine());
		
		System.out.println((char)27 + "[35mEnter the Last Four of Your Social Security Number");
		Integer ssn = Integer.parseInt(scanner.nextLine());
		log.info("person");
		Person person = new Person(name, pin, ssn, accessLevel);
		log.info("Person" + person + "accessLevel" + accessLevel);
		Bank.Bank(accessLevel, person);

	}

}