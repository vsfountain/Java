package q8;

import java.util.ArrayList;

public class Palindromes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> words = new ArrayList<String>();
		String[] wordsArr = {"karan","madam","tom","civic","radar","sexes","jimmy","kayak","john","refer","billy","did"};

		ArrayList<String> palindromes = new ArrayList<String>();
		
		for(String word:wordsArr) {
			words.add(word);
			String rev = reverse(word);
			if(rev.equals(word)) {
				palindromes.add(word);
				System.out.println(word);
			}
		}
	}
	static String reverse(String str) {
		char[] reversed = new char[str.length()];
		for(int i = 0, j = str.length()-1; i<str.length();i++,j--) {
			reversed[j] = str.charAt(i);
		}
		return new String(reversed);
	}
}
