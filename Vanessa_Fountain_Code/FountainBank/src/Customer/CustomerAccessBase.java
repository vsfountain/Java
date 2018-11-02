package Customer;

public class CustomerAccessBase {
	
	Integer withdraw(Integer WithdrawAmount, Integer val) {
		val -= WithdrawAmount;
		if (val<0) {
			System.out.println("Insufficient Funds");
			val += WithdrawAmount;
		}
		return val;
	}
	Integer Deposit(Integer DepositAmount, Integer AmountLeft) {
		return AmountLeft += DepositAmount;
	}
	Integer Transfer() {
		return null;
	}
	
	
}
