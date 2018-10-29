package Customer;

import java.util.Scanner;

public class CustomerAccess {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println((char)27 + "[35mEnter 1 to Withdraw 2 to Deposit and 3 to Transfer");
	Integer N = Integer.parseInt(scanner.nextLine());
	CustomerAccessBase customer = new CustomerAccessBase();
	
	Integer AmountLeft = 300;
	switch(N) {
		case 1:
			System.out.println((char)27 + "[35mEnter Amount to Withdraw");
		Integer WithdrawAmount = Integer.parseInt(scanner.nextLine());
		System.out.println(customer.withdraw(WithdrawAmount, AmountLeft));
		break;
	case 2:
		System.out.println((char)27 + "[35mEnter Amount to Deposit");
			Integer DepositAmount = Integer.parseInt(scanner.nextLine());
			System.out.println(customer.Deposit(DepositAmount, AmountLeft));
			break;
		case 3:
			break;
	}
	}

}
