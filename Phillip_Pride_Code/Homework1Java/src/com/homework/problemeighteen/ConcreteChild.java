package com.homework.problemeighteen;

public class ConcreteChild extends AbstractParent {

	@Override
	boolean anyUpCase(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (("" + str.charAt(i)).equals(("" + str.charAt(i)).toUpperCase())) {
				return true;
			}
		}
		return false;
	}

	@Override
	String toUpCase(String str2) {
		return str2.toUpperCase();
	}

	@Override
	int stringToInt(String str3) {
		int[] word = new int[str3.length()];
		int sToi = 0;
		
		for(int i = 0; i < word.length; i++) {
			word[i] = (int)str3.charAt(i);
		}
		for(int j = 0; j < word.length; j++) {
			sToi += word[j];
		}
		return sToi + 10;
		
	}

}
