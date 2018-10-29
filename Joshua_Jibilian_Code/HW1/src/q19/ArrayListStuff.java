package q19;

import java.util.ArrayList;

public class ArrayListStuff {
	public static void main(String[] args) {
		ArrayList<Integer> ints = new ArrayList();
		for (int i = 1; i <= 10; i++) {
			ints.add(i);
		}

		System.out.println(ints);
		int oddSum = 0;
		int evenSum = 0;

		for (int x : ints) {
			//System.out.println(x);
			if (x % 2 == 0) {
				evenSum += x;
			} else {
				oddSum +=x;
			}
		}
		System.out.println("Even sum : " + evenSum + " Odd Sum: "+ oddSum);
		
		ArrayList<Integer> notPrime = new ArrayList<Integer>();
		for (Integer x : ints) {
			//System.out.println(x);
			boolean isPrime = true;
			int z = (int)x;
			for(int y = x - 1; y>=2; y--) {
				//System.out.println(x + " " + y);
				
				if(x % y == 0 && (x != 1 || x != 2)) { //divide by all numbers less then the one being tested except by 1
					//System.out.println();
					isPrime = false;
				}
			}
			if (!isPrime) {
				notPrime.add(x);
			}
		}
		ints = notPrime;
		//System.out.println(notPrime);
		System.out.println(ints);
	}
}
