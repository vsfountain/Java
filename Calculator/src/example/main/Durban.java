package example.main;

public class Durban {

	public static String [][] arr = new String[3][3] ;
	public static boolean xTurn = true;
	public static boolean yTurn = false;
	
	
	public static void addMove(int a, int b) {
		arr[a][b] = getTurn();
	}
	
	public Durban() {
		// TODO Auto-generated constructor stub
		for(int i = 0 ; i < arr.length ; i ++ ) {
			//if(i==1 || i == 2) {System.out.print("|");}
			System.out.println();
			for(int j = 0 ; j < arr.length ; j ++ ) 
			arr[i][j] = " ";
			
		}
	
	}
	public static String getTurn() {
	
		String result = "";
		if(xTurn == true) {
			result = "X";
			xTurn = !xTurn;
		}
		else {
			result = "Y";
			xTurn = !xTurn;
			
			}
		
		return result;
	}
	
	
	public static void display() {
		for(int i = 0 ; i < arr.length ; i ++ ) {
			//if(i==1 || i == 2) {System.out.print("|");}
			System.out.println();
			for(int j = 0 ; j < arr.length ; j ++ ) 
			System.out.print(arr[i][j] + " ");
			
			
		}System.out.println();
	}
}
