package com.hw1.q18;

public class ChildClass extends SuperClass {

	@Override
	public boolean checkCaseOfStringUp(String mySt) {
		// TODO Auto-generated method stub
		for(int i = 0; i<mySt.length(); i++) {
			if(mySt.charAt(i) >=65 && mySt.charAt(i)<=90) {
				return true;
				//ASCII 65 - 90
			}
		}
		return false;
	}

	@Override
	public String cvtCase(String input) {
		// TODO Auto-generated method stub
		
		String result;
		result = input.toUpperCase();
		return result;
	}

	@Override
	public Integer cvtStToint(String num) {
		// TODO Auto-generated method stub
		
		int result;
		result = Integer.parseInt(num);
		return result;
	}


}
