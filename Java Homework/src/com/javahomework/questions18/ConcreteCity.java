package com.javahomework.questions18;

public class ConcreteCity extends ConcreteJungle {

	@Override
	public boolean checkCase(String s) {
		// TODO Auto-generated method stub
		boolean oneLetter = false;

		for (int i = 0; i < s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i))) {
				return oneLetter = true;
			}
			return oneLetter;
		}
		return oneLetter;
	}

	@Override
	public String convertCase(String s) {
		// TODO Auto-generated method stub
		return s.toUpperCase();
	}

	@Override
	public int convertToInteger(String s) {
		// TODO Auto-generated method stub
		return Integer.parseInt(s);
	}

}
