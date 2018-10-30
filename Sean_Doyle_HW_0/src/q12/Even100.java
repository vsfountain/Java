package q12;

public class Even100 {
public static void main(String[] args) {
	int[] me = new int[100];
	for(int i = 0; i < 100; i++) {
		me[i] = i+1;
	}
	for (int i:me) {
		if (i%2 == 0) {
			System.out.println(i);
		}
	}
}
}
