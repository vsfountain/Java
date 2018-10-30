package question18;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Enter a string: ");
		Scanner scanner = new Scanner(System.in);
		String userString = scanner.nextLine();
		
		StringManipulator S = new StringManipulator();
		
		System.out.println(S.checkUppercase(userString));
		System.out.println(S.convertLowercase(userString));
		System.out.println(S.convertAndAdd(userString));
		
	}
}
