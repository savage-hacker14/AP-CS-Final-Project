// Written by Jacob on 5/20/18

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class IO {
	
	// This method can read in a character matrix from a .txt file 
	public static String[][] readMapFromTxt(String filepath) throws IOException {
		int maxR = Floor.width;
		int maxC = Floor.length;
		
		String[][] arr = new String[maxR][maxC];
		Scanner reader = new Scanner(new File(filepath));
		
		
		for (int i = 0; i < 9; i++) {
			String temp = reader.nextLine();
			for (int j = 0; j < 16; j++) {
				arr[i][j] = temp.substring(j * 5, j * 5 + 4);
			}
		}

		
//		System.out.println(Arrays.toString(arr));
		
		return arr;
	}
	
	public static void printMap(char[][] arr) {
		for (char[] row : arr) {
			for (char c : row) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}
	
	public static Point strToFloorID(String str) {
		int x = Integer.parseInt(str.substring(19, 20));
		int y = Integer.parseInt(str.substring(21, 22));
		
		System.out.println("x: " + x + "\t" + "y: " + y);
		
		return new Point(x, y);
	}
}
