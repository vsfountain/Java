package q5;

public class Substring {
	public static void main(String[] args) {
		String me = "My String";
		int index = 2;
		System.out.println(SubString(me, index));
	}
	
	/*
	 * This substring method returns the 0^th through the (idk-1)^st characters of the input string 
	 */
	public static String SubString(String str, int idx) {
		char[] holder = str.toCharArray();
		if (holder.length < idx) {
			return str;
		}
		str = "";
		for (int i = 0; i < idx; i++) { 
			str += holder[i];
		}
		return str;
	}
}
