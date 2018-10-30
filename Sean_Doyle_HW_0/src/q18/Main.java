package q18;

/*
 * show that our abstract class has been connected properly
 */

public class Main {

	public static void main(String[] args) {
		MyStringy ms = new MyStringy();
		String me = "HjurksYllo!&+=>";
		System.out.println(ms.containsUppercase(me));
		System.out.println(ms.makeLowercase(me));
		ms.str2Int(me);

	}

}
