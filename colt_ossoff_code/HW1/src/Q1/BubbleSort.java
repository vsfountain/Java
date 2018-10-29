package Q1;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] set = {1,0,5,6,3,2,3,7,9,8,4};
		for(int i=0;i<set.length;i++)
			System.out.print(set[i]);
		System.out.println("\n");
		
		for(int i = 0; i < set.length; i++) {
			
			for(int j = 0; j < set.length-i-1; j++) {
				if ( set[j+1] < set[j]) {
					int n = set[j+1];
					set[j+1] = set[j];
					set[j] = n;
				}
			}
		}
		for(int i=0;i<set.length;i++)
			System.out.print(set[i]);
		System.out.println();
	}

}
