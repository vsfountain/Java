package question3;

public class StringReverse {
	public static void main(String[] args) {
		//declaration of string
		String S = "My String";
		
		//convert the string into a character array
		char[] SArray = S.toCharArray();
		
		//create empty char array to hold reverse
		char[] ReverseArray = new char[S.length()];		
		
		for(int i=0; i<S.length();i++) {	//setting elements of SArray to Reverse
			ReverseArray[i] = SArray[S.length()-i-1];		//in reverse order
		}
		
		String ReverseString = new String(ReverseArray);
		
		System.out.println(ReverseString);
	}
}
