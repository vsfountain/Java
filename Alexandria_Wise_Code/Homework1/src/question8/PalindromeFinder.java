package question8;

import java.util.ArrayList;
import java.util.List;

public class PalindromeFinder {
	
	public static void main(String[] args) {

		//creating and filling the arraylist
		List<String> wordBank = new ArrayList<>();
		
		wordBank.add(new String("karan"));
		wordBank.add(new String("madam"));
		wordBank.add(new String("tom"));
		wordBank.add(new String("civic"));
		wordBank.add(new String("radar"));
		wordBank.add(new String("sexes"));
		wordBank.add(new String("jimmy"));
		wordBank.add(new String("kayak"));
		wordBank.add(new String("john"));
		wordBank.add(new String("refer"));
		wordBank.add(new String("billy"));
		wordBank.add(new String("did"));
		
		//creating an array list for palindromes
		List<String> palindromes = new ArrayList<>();
		
		//determines which strings are palindromes and adds them to the arraylist
		System.out.println("List of Strings:");
		for(int i = 0; i < wordBank.size(); i++) {
			System.out.println(wordBank.get(i));
			int k = wordBank.get(i).length();
			for(int j = 0; j < k/2; j++) {	//compares the characters in each string from the outside in
				if(wordBank.get(i).charAt(j)==wordBank.get(i).charAt(k-j-1)) {
					palindromes.add(new String(wordBank.get(i)));
					break;
				}
			}
		}
		//prints the palindromes arraylist
		System.out.println("List of Palindromes:");
		for(int i = 0; i < palindromes.size(); i++) {
			System.out.println(palindromes.get(i));
		}
		
		
		
	}

}
