package q18;

public class MyStringy extends MyAbstract {
	
	/*
	 * check to see if the provided string contains an uppercase letter
	 */
	public boolean containsUppercase(String temp) {
		char[] tempArry = temp.toCharArray();
		int i = tempArry.length-1;
		while (i >= 0) {
			if ((tempArry[i]-0) <= 91 && (tempArry[i]-0) >= 66) {
				return true;
			}
			i--;
		}
		return false;
	}
	
	/*
	 * force the provided string to be all lowercase
	 */
	public String makeLowercase(String temp) { 
		return temp.toLowerCase();
	}
	
	/*
	 * force each letter in the string to its ascii value and sum them then add 10. return value
	 */
	public void str2Int(String temp) {
		char[] tempArry = temp.toCharArray();
		int i = tempArry.length-1;
		int toSend = 10;
		while (i >= 0) {
			toSend += (tempArry[i]-0);
			i--;
		}
		System.out.println(toSend);
	}
}
