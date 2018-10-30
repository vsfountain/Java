package question13;

public class pyramidPrinter {
	public static void main(String[] args) {
		int num = 0;
		int k = 1;
		
		loop:
		for(int i = 0; i<k; i++) {
			for(int j = 0; j<k; j++) {
				System.out.print(num+" ");
				if(num==0) {
					num=1;
				}else {
					num=0;
				}
			}
			k++;
			if(k>4) {
				break loop;
			}
			System.out.print("\n");

		}
	}
}
