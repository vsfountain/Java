package question6;

public class Evens {
	public static void main(String[] args) {
		int x = 11;					//find out how to take in a variable
		
		int y = x/2;				//divide number by 2 and check that the 
		if((y*2)==x) {				//result*2 is the original number
			System.out.println("The number you input is even");
		}
		else {
			System.out.println("The number you input is not even");
		}
		
	}
}
