package question12;

public class OnetoOnHundred {
	public static void main(String[] args) {
		int[] X = new int[100];
		
		for(int i = 0;i<100;i++) {
			X[i] = i+1;
		}
		
		for(int p: X) { //for each loop
			if((p%2)!=0) {
				continue;
			}
			System.out.println(p);
		}
	}
}
