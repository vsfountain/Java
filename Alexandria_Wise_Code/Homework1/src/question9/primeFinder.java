package question9;

import java.util.ArrayList;
import java.util.List;


public class primeFinder {
	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList<>();
		
		for(Integer i = 1; i<101; i++) {
			numbers.add(i);
		}
		System.out.println("Prime Numbers 1 to 100");
		for(int j = 0; j<numbers.size(); j++) {
			int count = 0;
			for(int k = j-1; k>1; k--) {
				if(numbers.get(j)%k == 0){
					count++;
					break;
				}
			}
			if(count==0) {
				System.out.println(numbers.get(j));
			}
		}
		
		
	}
}
