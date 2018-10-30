package question14;
import static java.lang.Math.sqrt;
import java.util.Scanner;
import java.util.*;

public class switchExample {
	public static void main(String[] args) {
		System.out.println("Enter 1, 2, or 3:");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		switch(n) {
		case 1:
			System.out.println("Enter a number:");
			Scanner scan2 = new Scanner(System.in);
			int x = scan2.nextInt();

			float root = (float) Math.sqrt(x);
			System.out.println("The square root of " +x+ " is " +root);
			break;
		
		case 2:
			Date today = new Date();
			System.out.println("Today's date is " +today);
			break;
			
		case 3:
			String[] words = new String[5];
			
			String sentence = new String("I am learning Core Java ");
			int i = sentence.indexOf(" ");
			int k = 0;
			
			for(int j=0; j<5; j++) {
				words[j] = sentence.substring(k, i);
				k = i;
				i = sentence.indexOf(" ", k+1);
				System.out.println(words[j]);
			}

			break;
			
		}
	}

}
