package Customer;

import java.util.Scanner;

public class CustomerAccessBase {
	
	Integer withdraw(Integer WithdrawAmount, Integer AmountLeft) {
		AmountLeft -= WithdrawAmount;
		if (AmountLeft<0) {
			System.out.println("Insufficient Funds");
			AmountLeft += WithdrawAmount;
		}
		return AmountLeft;
	}
	Integer Deposit(Integer DepositAmount, Integer AmountLeft) {
		return AmountLeft += DepositAmount;
	}
	Integer Transfer() {
		return null;
	}
	

}
