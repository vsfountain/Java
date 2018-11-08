package q19;

import java.util.ArrayList;

public class EnumOne2Ten {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			a.add(i);
		}
		System.out.println("Lets show all the numbers in our ArrayList: ");
		for (int i : a) {
			System.out.println(i);
		}
		
		/*
		 * if a number mod 2 returns 0 then it is clearly even else it will return 1
		 * which implies that it was odd.
		 */
		int countEven = 0;
		int countOdd = 0;
		for (int i : a) {
			if (i % 2 == 0) {
				countEven += i;
			} else {
				countOdd += i;
			}
		}
		System.out.println("The even numbers in our ArrayList add up to: " + countEven);
		System.out.println("The odd numbers in our ArrayList add up to: " + countOdd);
		
		
		ArrayList<Integer> prime = new ArrayList<>();
		System.out.println("Lets show our primes from the ArrayList: ");
		for (int i : a) {
			if (checkPrime(i, prime)) {
				prime.add(i);
				System.out.println(i);
			}
		}

		int removeCount = 0;// used because we are decreasing the overall size of our array by 1 when
		// we remove an element therefore the elements in the right half of the
		// ArrayList are shifted
		// left by 1, therefore 'removeCount' adjust for this shift accordingly
		for (int i : prime) {
			a.remove(i - removeCount);
			removeCount++;
		}
		int countPrime = 0;
		for (int i : prime) {
			countPrime += i;
		}
		System.out.println("Our ArrayList has: " + countPrime + " primes!");

		System.out.println("Lets show our ArrayList without primes: ");
		for (int i : a) {
			System.out.println(i);
		}
	}

	/*
	 * this is just the implementation for prime checker in problem 9 of the homework
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
