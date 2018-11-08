package q13;

public class TriangleBinary {

	public static void main(String[] args) {
		/*
		 * the pattern is 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1
		 * so it can be described as counting 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
		 * mod 2 so even values become 0 and odd values become 1
		 * and then we print it out where each level contains one more element than the last
		 */
		String me = "";
		int h = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= i; j++) {
				me += h%2+"\t";
				h++;
			}
			me += "\n";
		}
		System.out.println(me);
	}
}
