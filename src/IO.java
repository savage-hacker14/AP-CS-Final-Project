// Written by Jacob on 5/20/18

import java.awt.Point;
import java.io.*;
import java.util.Arrays;

public class IO {
	
	// This method can read in a character matrix from a .txt file 
	public static char[][] readMapFromTxt(String filepath) throws IOException {
		int maxR = 9;
		int maxC = 16;
		
		char[][] arr = new char[maxR][maxC];
		
		FileReader reader = new FileReader(new File(filepath));
		
		int r = 0; int c = 0;
		while (reader.ready()) {
			int c_int = reader.read();
			
			//System.out.println(c_int);
			if (c_int != 32 && c_int != 10) {
				arr[r][c] = (char) c_int;
				c++;
				
				if (c == arr[0].length) {
					r++;
					c = 0;
				}
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
