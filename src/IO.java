// Written by Jacob on 5/20/18

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
			
			if (c_int != 20) {
				arr[r][c] = (char) c_int;
				c++;
				
				if (c == arr[0].length) {
					r++;
					c = 0;
				}
			}	
		}
		
		System.out.println(Arrays.toString(arr));
		
		return arr;
	}
}
