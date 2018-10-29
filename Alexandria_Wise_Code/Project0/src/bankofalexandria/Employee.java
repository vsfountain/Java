package bankofalexandria;
import java.util.Scanner;

public class Employee extends Customer {
	
	static boolean approveAccount(double initialBalance) {
		boolean create = false;
		if(initialBalance<100) {
			System.out.println("Insufficient funds. Connot create account.");
		}else {
			System.out.println("You've been approved.");
			create = true;
		}
		
		return create;
		}
		
	}
	
	
	


