package q6;

public class IsEven {

	public static void main(String[] args) {
		int me = 250789014;
		System.out.println("The number "+ me + " is even? " + isEven(me));
	}
	/*
	 * Uses the definition of even versus odd integers as:
	 * evenInt = 2*k where k is an element of the set of integers
	 * oddInt = (2*k+1) where k is an element of the set of integers
	 * if we then use integer division (denoted //) and divide the even and odd integers by 2 we get:
	 * evenInt//2 = k where k is the element of the set of integers
	 * oddInt//2 = floor(k+0.5) where k is the element of the set of integers
	 * 
	 * if we instead first subtract 1 from out integers we find something different:
	 * (evenInt-1)//2 = floor(k-0.5) where k is the element of the set of integers
	 * (oddInt-1)//2 = k where k is the element of the set of integers
	 * 
	 * so we compare:
	 * evenInt//2 = k   				vs    		(evenInt-1)//2 = floor(k-0.5)--> (k-1)
	 * oddInt//2 = floor(k+0.5)--> k   	vs    		(oddInt-1)//2 = k
	 * so if they are equivalent we started with an odd integer, if they are different then we started with an even integer
	 */
	public static boolean isEven(int num) {
		if (num/2 > (num-1)/2) {
			//we are even
			return true;
		}
		else {
			//we are odd
			return false;
		}

	}
	/*
	 * This is an alternative method where a true boolean represents an even number
	 */
//	public static boolean isEven(int num) {
//		boolean flag = true;
//		for (int i = 0;  i < num; i++) {
//			flag = !flag;
//		}
//		return flag;
//
//	}

}
