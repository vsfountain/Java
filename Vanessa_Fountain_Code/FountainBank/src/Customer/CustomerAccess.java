package Customer;

import java.util.Iterator;
import java.util.Scanner;

import Admin.Bank;
import Admin.Person;

public class CustomerAccess {
	public static Integer main(Person person, Integer val) {
	Scanner scanner = new Scanner(System.in);
	System.out.println((char)27 + "[35mEnter 1 to Withdraw 2 to Deposit and 3 to Transfer");
	Integer N = Integer.parseInt(scanner.nextLine());
	CustomerAccessBase customer = new CustomerAccessBase();
	
	//public Integer AmountLeft = 300;
	switch(N) {
		case 1:
			System.out.println((char)27 + "[35mEnter Amount to Withdraw");
			Integer WithdrawAmount = Integer.parseInt(scanner.nextLine());
			Integer AmountLeft = customer.withdraw(WithdrawAmount, val);
			System.out.println(AmountLeft);
			return AmountLeft;
		case 2:
			System.out.println((char)27 + "[35mEnter Amount to Deposit");
			Integer DepositAmount = Integer.parseInt(scanner.nextLine());
			Integer AmountAdded = customer.Deposit(DepositAmount, val);
			System.out.println(AmountAdded);
			return AmountAdded;
		case 3:
			return val ;
		}
	return null;
	}

}
