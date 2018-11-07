package Customer;

import java.io.IOException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import Admin.Main;
import Admin.Person;

public class CustomerAccess {
	static Logger log = Logger.getLogger(CustomerAccess.class);
	public static Integer main(Person person, Integer val) throws ClassNotFoundException, IOException {
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);
	System.out.println((char)27 + "[35mEnter: \n  1 to Withdraw \n  2 to Deposit \n  3 to View Account \n  4 to Transfer \n  5 to exit");
	Integer N = Integer.parseInt(scanner.nextLine());
	CustomerAccessBase customer = new CustomerAccessBase();
	//PropertyConfigurator.configure("log4j.properties");
	//public Integer AmountLeft = 300;
	switch(N) {

		case 1:
			//PropertyConfigurator.configure("log4j.properties");
			System.out.println((char)27 + "[35mEnter Amount to Withdraw");
			Integer WithdrawAmount = Integer.parseInt(scanner.nextLine());
			Integer BalanceW = CustomerAccessBase.Balance(person);
			Integer AmountLeft = CustomerAccessBase.withdraw(WithdrawAmount, BalanceW);
			
			System.out.println(AmountLeft);
			CustomerAccessBase.updateObject(AmountLeft, person);
			
			//log.info("Withdraw" + person + AmountLeft);
			break;
		case 2:
			//PropertyConfigurator.configure("log4j.properties");
			System.out.println((char)27 + "[35mEnter Amount to Deposit");
			Integer DepositAmount = Integer.parseInt(scanner.nextLine());
			Integer BalanceD = CustomerAccessBase.Balance(person);
			Integer AmountAdded = customer.Deposit(DepositAmount, BalanceD);
			
			System.out.println(AmountAdded);
			CustomerAccessBase.updateObject(AmountAdded, person);
			//log.info("Deposit" +person+ AmountAdded);
			break;
			//return AmountAdded;
		case 3:
			
			Integer bal = CustomerAccessBase.Balance(person);
			//System.out.println(bal);
			break;
		case 4:
			System.out.println("Enter the amount you would like to transfer");
			Integer TransferAmount = Integer.parseInt(scanner.nextLine());
			Integer BalanceT = CustomerAccessBase.Balance(person);
			Integer Transfer = CustomerAccessBase.withdraw(TransferAmount, BalanceT);
			CustomerAccessBase.updateObject(Transfer, person);
			
			System.out.println(Transfer);
			System.out.println("Enter the Information of the Person you would like to tranfer to");
			System.out.println((char)27 + "[35mEnter User Name");
			String name = scanner.nextLine();
			
			System.out.println((char)27 + "[35mEnter User Pin");
			Integer pin = Integer.parseInt(scanner.nextLine());
			
			System.out.println((char)27 + "[35mEnter the Last Four of Your Social Security Number");
			Integer ssn = Integer.parseInt(scanner.nextLine());
			log.info("person");
			Person person2 = new Person(name, pin, ssn, 1);
			log.info("Person" + person + "accessLevel" + 1);
			
			//Integer DepositAmount2 = Integer.parseInt(scanner.nextLine());
			Integer BalanceD2 = CustomerAccessBase.Balance(person2);
			Integer AmountAdded2 = customer.Deposit(TransferAmount, BalanceD2);
			
			System.out.println(AmountAdded2);
			CustomerAccessBase.updateObject(AmountAdded2, person2);
			
			Admin.Main.main(null);
			//Customer.CustomerAccessBase
			break;
			
		case 5:
			System.out.println("Goodbye "+person.getName());
			System.exit(0);
		}
	
	
	return CustomerAccess.main(person, val);
	}

}
