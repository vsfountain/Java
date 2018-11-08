package q8;

import java.util.ArrayList;

public class Palindromes {

	public static void main(String[] args) {
		String[] words = { "karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer",
				"billy", "did" };
		ArrayList<String> a = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			a.add(words[i]);
		}
		ArrayList<String> pali = new ArrayList<>();
		String temp;
		char[] holder;
		boolean bool;
		int numPs = 0;

		while (a.size() > 0) {
			temp = a.remove(a.size() - 1);
			holder = temp.toCharArray();
			bool = true;
			/*
			 * This method works by splitting the string down the middle (if it is of an odd length
			 * the integer division means that we round down to the nearest whole number and therefore
			 * skip the middle character since a single character must be palindrotic) but we then look
			 * to see if the letters equidistant from the center are the same.
			 */
			for (int i = 0; i < (holder.length - 1) / 2; i++) {
				if (holder[i] != holder[holder.length - i - 1]) {
					bool = false;
					break;
				}
			}

			if (bool) {
				pali.add(temp);
				numPs++;
			}

			System.out.println(temp + " is palindrome?: " + bool);
		}//END WHILE LOOP
		System.out
				.println("We found " + numPs + " and our palindrome ArrayList has " + pali.size() + " strings in it.");
	}

}
