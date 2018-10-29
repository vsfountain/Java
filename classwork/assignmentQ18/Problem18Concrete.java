package com.assignmentQ18;

public class Problem18Concrete extends Problem18Abstract{
	
	 boolean uppercaseChecker(String str) {
		// 65 - 90 are uppercase
		boolean caseCheck = false;
		for (int i = 0; i< str.length();i++) {
			if(str.charAt(i) >= 65 && str.charAt(i) <=90 ) {
				caseCheck = true;				
			}
			else {
				caseCheck = false;
				}
			}
		return caseCheck;
	}
	
	 String makeUpperCase() {
		String test = "Testing word And Stuff";		
		return test.toUpperCase();		
	}
	
	int convertFromString() {
		String test = "12";
		Integer newNum = Integer.parseInt(test);
		return newNum + 10;
	}
}
