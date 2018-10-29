package q3;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(reverse("hello world"));
	}

	static String reverse(String str) {
		char[] reversed = new char[str.length()];
		for(int i = 0, j = str.length()-1; i<str.length();i++,j--) {
			reversed[j] = str.charAt(i);
		}
		return new String(reversed);
	}
}
