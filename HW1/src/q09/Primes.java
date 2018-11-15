package q09;

import java.util.ArrayList;

public class Primes {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int x = 1; x<=100; x++) {
			numbers.add(x);
		}
		System.out.println(numbers);
		primes.add(2); // we know 2 is prime
		for(int x  = 2;x<numbers.size();x++ ) { //start at index 2 since we already the status of 1 and 2
			boolean isPrime = true;
			for(int y = x - 1; y>0; y--) {
				if(numbers.get(x) % numbers.get(y) == 0) { //divide by all numbers less then the one being tested except by 1
					isPrime = false;
				}
			}
			if(isPrime) 
			{
				primes.add(numbers.get(x));
			}
		
		}
		System.out.println(primes);
	}

}
