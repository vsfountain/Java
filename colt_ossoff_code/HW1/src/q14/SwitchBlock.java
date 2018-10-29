package q14;

import java.util.Date;

public class SwitchBlock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		switcher(3);
		switcher(1);
		switcher(2);
	}

	static void switcher(int i) {
		switch(i) {
		case 1:
			System.out.println("The square root of 81 is: " + Math.sqrt(81));
			break;
		case 2:
			System.out.println("Today's date is " + new Date());
			break;
		case 3:
			String[] words = "I am learning Core Java".split(" ");
			for (String i1:words) {
				System.out.println(i1);
			}
			break;
		}
	}
}
