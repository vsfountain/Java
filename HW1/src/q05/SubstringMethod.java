package q05;

public class SubstringMethod {

	public static void main(String[] args) {
		System.out.println(mySubstring("Substring",1,6));
	}

	public static String mySubstring(String s, int x, int dx) {
		String toBuild = "";
		for(int z = x; z<dx; z++) {
			toBuild = toBuild + s.charAt(z)+"";
		}
		return toBuild;
	}
}
