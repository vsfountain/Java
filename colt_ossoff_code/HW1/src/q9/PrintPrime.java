package q9;

import java.util.ArrayList;

public class PrintPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> arrli = new ArrayList<Integer>(100);
		for(int i = 1; i<101; i++) {
			arrli.add(i);
			if (isPrime(i)) System.out.println(i);
		}
		
	}
	static boolean isPrime(int n) {
		if(n <= 1) return false;
		for(int i = 2; i<n; i++)
			if(n%i == 0)
				return false;
		return true;
	}

}
