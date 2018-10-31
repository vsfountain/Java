package com.example.q18;

public class ExtendsAbstractQ18 extends q18{

@Override
	public boolean checkForUpperCase(String myString) {
		// TODO Auto-generated method stub
		for(int i = 0; i<myString.length(); i++) {
			
			if(myString.charAt(i) >= 65 && myString.charAt(i) <=90 ) {
				return true;
			}
			
			
			
		}
		return false;
	}


	@Override
	public String convertToUppercase(String myLowerCaseString) {
		// TODO Auto-generated method stub
		
		String a = myLowerCaseString.toUpperCase();
		
		
		
		return a;
	}

	@Override
	public Integer convertStringToIntegerThenAddTen(String myNum) {
		// TODO Auto-generated method stub
		int a = Integer.parseInt(myNum) + 10;
		return a;
	}

	

}
