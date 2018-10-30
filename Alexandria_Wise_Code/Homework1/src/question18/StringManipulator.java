package question18;

import java.util.Arrays;
import java.util.Scanner;

public class StringManipulator extends StringOperations {
	
	@Override
	public boolean checkUppercase(String S) {
		boolean upperCase = false;
		int count =0;
		for(int i =0; i<S.length(); i++) {
			if(S.charAt(i)>64 && S.charAt(i)<91) {
				count++;
			}
		}
		if(count==0) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public String convertLowercase(String S) {
		
		//convert the string into a character array
		char[] SArray = S.toCharArray();
		
		for(int i =0; i<S.length(); i++) {
			if(S.charAt(i)>64 && S.charAt(i)<91) {
				SArray[i]+=32;
			}
		}
		String lowercaseS = new String(SArray);
		return lowercaseS;
	}

	@Override
	public String convertAndAdd(String S) {
		//convert the string into a character array
		int[] SArray = new int[S.length()];
		
		for(int i = 0; i<S.length(); i++) {
			SArray[i] = S.charAt(i)+10;
		}
	
		return Arrays.toString(SArray);
	}
	
	
	
	

}
