package q19;

import java.util.ArrayList;
import java.util.Iterator;

public class NumOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sum = 0;
		//build and populate the ArrayList
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<10; i++)
			list.add(i+1);
		//display the arrayList
		for(int i:list)
			System.out.print(i + ",");
		System.out.println();
		//sum even numbers
		for(int i=0; i<list.size(); i+=2)
			sum += list.get(i);
		System.out.println("The sum of the odd numbers is: " + sum);
		//sum odd numbers
		sum = 0;
 		for(int i=1; i<list.size(); i+=2)
			sum += list.get(i);
		System.out.println("The sum of the even numbers is: " + sum);
		//find/remove prime numbers
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()) {
			int n = itr.next();
			if(isPrime(n))
				itr.remove();
			else
				System.out.print(n + ",");
		}
	}

	static boolean isPrime(int n) {
		if(n <= 1) return false;
		for(int i=2; i<n; i++) 
			if(n%i == 0) return false;
		return true;
	}
}
