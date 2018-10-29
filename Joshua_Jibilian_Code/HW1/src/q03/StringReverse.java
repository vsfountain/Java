package q03;

public class StringReverse {
	public static void main(String[] args) {
		String toReverse = "Reverse the string!";

		for (int i = 0; i < toReverse.length(); i++) {
			toReverse = toReverse.substring(1,toReverse.length()-i ) +
					toReverse.substring(0,1) + toReverse.substring(toReverse.length()-i, toReverse.length());
			
		}
		System.out.println(toReverse);
	}
}
