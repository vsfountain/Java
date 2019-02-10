package example.main;

import java.util.Scanner;

public class main {
	public static Scanner scan = new Scanner(System.in);
	public static Durban d = new Durban();
	public static void main(String[] args) {
		init();	
	}

	public static void init() {
		System.out.println("Welcome to my quick tic tac toe game");
		System.out.println("1. Play game");
		System.out.println("2. Quit");
		int choice = 0;
		choice = scan.nextInt() ;
		
		while(choice!=2) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			d.addMove(a, b);
			d.display();
			
		}
	}
}
