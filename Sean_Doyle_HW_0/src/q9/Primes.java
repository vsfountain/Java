package q9;

import java.util.ArrayList;

public class Primes {
	public static void main(String[] args) {
		ArrayList<Integer> storeNum = new ArrayList<>();
		ArrayList<Integer> prime = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			storeNum.add(i);
			if (checkPrime(i, prime)) {
				prime.add(i);
				System.out.println(i);
			}
		}
	}

	
	/*
	 * This method takes in a list of numbers we know to be prime (started at 1)
	 * and checks if the number passed in is divisible by any of the primes, if so
	 * the test fails since a prime is only divisible by 1 and itself, else it passes. 
	 */
	public static boolean checkPrime(int num, ArrayList<Integer> b) {
		if (b.size() == 0) {
			return true;
		}
		Integer temp;
		int i = 1;
		while (i < b.size()) {
			temp = b.get(i);
			i++;
			if (num % temp == 0) {
				return false;
			}
		}
		return true;
	}
}
