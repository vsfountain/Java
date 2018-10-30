package question19;

import java.util.ArrayList;
import java.util.List;

public class ListModifier {
		
		public static void main(String[] args) {

			//creating and filling the arraylist
			List<Integer> numbers = new ArrayList<>();
			
			for(Integer i = 1; i<11; i++) {
				numbers.add(i);
			}
			
			System.out.println("Original list: " +numbers);
			
			//add all even numbers and display the sum
			int k = 0;
			for(int i = 1; i < numbers.size()+1; i+=2) {
				k += numbers.get(i);
			}
			
			System.out.println("Sum of evens: "+k);
			
			//add all odd numbers and display the sum
			int m = 0;
			for(int i = 0; i < numbers.size(); i+=2) {
				m += numbers.get(i);
			}
			System.out.println("Sum of odds: "+m);
			
			//find primes and delete them from arraylist
			for(int j = 0; j<numbers.size(); j++) {
				int count = 0;
				for(int n = j-1; n>1; n--) {
					if(numbers.get(j)%n == 0){
						count++;
						break;
					}
				}
				if(count==0) {
					numbers.remove(j);
				}
			}
			System.out.println("List without primes: "+numbers);
		}
}
