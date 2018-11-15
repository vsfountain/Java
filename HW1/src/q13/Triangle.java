package q13;

public class Triangle {

	public static void main(String[] args) {
		boolean toggle = true;
		for (int x = 0; x < 4; x++) {
			for (int y = x; y >= 0; y--) {
				if (toggle) {
					System.out.print(0 + " ");
				} else {
					System.out.print(1+ " ");
				}
				toggle = !toggle;
			}
			System.out.println();
		}
	}

}
