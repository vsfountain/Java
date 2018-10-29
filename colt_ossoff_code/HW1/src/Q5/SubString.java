package Q5;

public class SubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ret = subString("Hello World", 5);
		System.out.println(ret);
	}
	
	static String subString(String str, int idx) {
		char[] sub = new char[idx];
		
		for(int i = 0; i < idx; i++) {
			sub[i] = str.charAt(i);
		}
		
		return new String(sub);
	}

}
