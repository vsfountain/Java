package com.homework.problemthirteen;

public class BTriangle {

	public static void main(String[] args) {
		int num = 0;
		// String[] strArry = { "0", "1 0", "1 0 1", "0 1 0 1" };
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < i+1; j++) {
				System.out.print(num);
				if(num==0) {
					num=1;
				}else {
					num=0;
				}
			}
			System.out.println();
		}

	}

}
