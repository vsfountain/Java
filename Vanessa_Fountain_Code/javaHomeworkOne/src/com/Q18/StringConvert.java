package com.Q18;
import com.Q18.StringCheck;

public class StringConvert extends StringCheck{
	//static String s = "10";

	public static void main(String [] args) {
		StringConvert convert = new StringConvert();
		String s = "10";
		System.out.println(convert.CheckUpperCase(s));
		System.out.println(convert.ConvertToUpper(s));
		System.out.println(convert.ConvertToInt(s));
		
	}

	@Override
	boolean CheckUpperCase(String s) {
		String upper = ConvertToUpper(s);
		char[] su = upper.toCharArray();
		char[] ss = s.toCharArray();
		for(char c:su) {
			for (char ch : ss) {
				if (c == ch) {
					//System.out.println(false);
					return false;
				}
			}
		}
		//System.out.println(true);
		return true;
	}
	
	@Override
	String ConvertToUpper(String s) {
		//System.out.println(s.toUpperCase());
		return s.toUpperCase();
	}

	@Override
	Integer ConvertToInt(String s) {
		return Integer.parseInt(s)+10;
	}
}