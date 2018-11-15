package q3;

public class StringReverse {
	public static void main(String[] args) {
		String temp = "abcdefghijklmnopqrstuvwxyz";
		//String temp = "1234567890";
		/*
		 * This switches the first and the last characters in the string since it can be classified 
		 * as an edge case of the CamelCase flip method.
		 */
		temp = temp.substring(temp.length() - 1, temp.length()) + temp.substring(1, temp.length() - 1) 
		+ temp.substring(0, 1);
		int j = 0;
		/*
		 * CamelCase flip method: break the string into 5 separate parts [0:X-1, X, X+1:Y-1, Y, Y+1:N] 
		 * and simply flip the X and Y substrings (which happen to be "chars") like: [0:X-1, Y, X+1:Y-1, X, Y+1:N] 
		 * where i:j represents a range of indices from the ith place to the jth place and N is the overall length 
		 * of the string.
		 */
		if (temp.length() %2 == 0) {
			/*
			 * This is the case that the string has an even length and therefore there is no middle 
			 * character in the middle of the string, rather a space between two characters which acts as the pivot.
			 */
			for (int i = 1; i < temp.length()/2; i++) {
				j = temp.length()-i-1;
				temp = temp.substring(0, i) + temp.substring(j, j + 1)
				+ temp.substring(i + 1, j) + temp.substring(i, i+1)
				+ temp.substring(j+1, temp.length());
			}
		}
		else {
			/*
			 * This is the case that the string has an odd length and therefore there is a middle 
			 * character in the middle of the string which doesn't need to be flipped, since rotation 
			 * doesn't change the character's location.
			 */
			for (int i = 1; i < (temp.length()-1)/2; i++) {
				j = temp.length()-i-1;
				temp = temp.substring(0, i) + temp.substring(j, j + 1)
				+ temp.substring(i + 1, j) + temp.substring(i, i+1)
				+ temp.substring(j+1, temp.length());
			}
		}
		
		System.out.println(temp);
	}
}
