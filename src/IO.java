// Written by Jacob on 5/20/18

import java.awt.Point;
import java.io.*;
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
	
	public static void writeMap(Floor map, String filepath) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
		
		for (int r = 0; r < Floor.width; r++) {
			for (int c = 0; c < Floor.length; c++) {
				String type = map.getTile(r, c).getImageType();

				switch (type) {
				case "Blob":
					writer.write("blb ");
					break;
				case "Bush":
					writer.write("bsh ");
					break;
				case "Chest":
					writer.write("cht ");
					break;
				case "Chilli":
					writer.write("chl ");
					break;
				case "Demon":
					writer.write("dmn ");
					break;
				case "Door":
					writer.write("dor");
					break;
				case "DoorLock":
					writer.write("drl ");
					break;
				case "Enemy":
					writer.write("enm ");
					break;
				case "Fireball":
					writer.write("fbl ");
					break;		
				case "Grass":
					writer.write("gra ");
					break;
				case "Key":
					writer.write("key ");
					break;
				case "Knight":
					writer.write("knt ");
					break;
				case "KnightWings":
					writer.write("knw ");
					break;
				case "Lava":
					writer.write("lva ");
					break;
				case "Player1":
					writer.write("pl1 ");
					break;
				case "Player2":
					writer.write("pl2 ");
					break;
				case "Player3":
					writer.write("pl3 ");
					break;
				case "Potion":
					writer.write("pot ");
					break;
				case "Rock":
					writer.write("rck ");
					break;
				case "Stone":
					writer.write("stn ");
					break;
				case "Sword1":
					writer.write("sw1 ");
					break;
				case "Sword2":
					writer.write("sw2 ");
					break;
				case "Sword3":
					writer.write("sw3 ");
					break;
				case "Water":
					writer.write("wtr ");
					break;
				case "Wood":
					writer.write("wod ");
					break;
				}
				writer.newLine();
			}
		}
		writer.flush();
		writer.close();
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
