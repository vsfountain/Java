package q08;

import java.util.ArrayList;
import java.util.Arrays;

public class Palindromes {
	public static void main(String[] args) {
		ArrayList<String> words =  new ArrayList<String>(
						Arrays.asList("karan", "madam", "tom", "civic", "radar", "sexes", "jimmy",
						"kayak", "john", "refer", "billy", "did"));
		
		ArrayList<String>  palindromes = new ArrayList<String>();
		for (String s : words) {
			if (isPalendrome(s)) {
				palindromes.add(s);
			}
		}
		System.out.println("all words tested: " + words);
		System.out.println("The palindromes: " + palindromes);
		
	}
	
	public static boolean isPalendrome(String s){
		for(int x = 0; x < s.length()/2; x++) {
			if(s.charAt(x) != s.charAt(s.length() - 1 - x)) {
				return false;
			}
		}
		
		
		return true;
	}
	
}
