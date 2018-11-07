package Customer;

import java.io.IOException;
import java.util.Scanner;

import Admin.Person;

public class CustomerAccess {
	public static Integer main(Person person, Integer val) throws ClassNotFoundException, IOException {
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);
	System.out.println((char)27 + "[35mEnter 1 to Withdraw 2 to Deposit and 3 to Transfer");
	Integer N = Integer.parseInt(scanner.nextLine());
	CustomerAccessBase customer = new CustomerAccessBase();
	
	//public Integer AmountLeft = 300;
	switch(N) {
		case 1:
			System.out.println((char)27 + "[35mEnter Amount to Withdraw");
			Integer WithdrawAmount = Integer.parseInt(scanner.nextLine());
			Integer BalanceW = CustomerAccessBase.Balance(person);
			Integer AmountLeft = CustomerAccessBase.withdraw(WithdrawAmount, BalanceW);
			
			System.out.println(AmountLeft);
			CustomerAccessBase.updateObject(AmountLeft, person);
			break;
	case 2:
			System.out.println((char)27 + "[35mEnter Amount to Deposit");
			Integer DepositAmount = Integer.parseInt(scanner.nextLine());
			Integer BalanceD = CustomerAccessBase.Balance(person);
			Integer AmountAdded = customer.Deposit(DepositAmount, BalanceD);
			
			System.out.println(AmountAdded);
			CustomerAccessBase.updateObject(AmountAdded, person);
			break;
			//return AmountAdded;
		case 3:
			return val ;
		}
	return null;
	}

}
