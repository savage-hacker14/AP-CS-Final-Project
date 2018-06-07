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
				String type = map.getTile(r, c).getSpriteType();
				
				String bg = "";
				
				if (map.getTile(r, c).getBGImageType().equalsIgnoreCase("Grass")) {
					bg = "g";
					
				} else if (map.getTile(r, c).getBGImageType().equalsIgnoreCase("Wood")) {
					bg = "w";
				}
				
				//String bg = "g"; 	// change later

				switch (type) {
				case "Blob":
					writer.write(bg + "blb ");
					break;
				case "Bush":
					writer.write(bg + "bsh ");
					break;
				case "Chest":
					writer.write(bg + "cht ");
					break;
				case "Chilli":
					writer.write(bg + "chl ");
					break;
				case "Demon":
					writer.write(bg + "dmn ");
					break;
				case "Door":
					writer.write(bg + "dor ");
					break;
				case "DoorLock":
					writer.write(bg + "drl ");
					break;
				case "Enemy":
					writer.write(bg + "enm ");
					break;
				case "Fireball":
					writer.write(bg + "fbl ");
					break;		 
				case "Grass":
					writer.write(bg + "gra ");
					break;
				case "Key":
					writer.write(bg + "key ");
					break;
				case "Knight":
					writer.write(bg + "knt ");
					break;
				case "KnightWings":
					writer.write(bg + "knw ");
					break;
				case "Lava":
					writer.write(bg + "lva ");
					break;
				case "Player1":
					writer.write(bg + "pl1 ");
					break;
				case "Player2":
					writer.write(bg + "pl2 ");
					break;
				case "Player3":
					writer.write(bg + "pl3 ");
					break;
				case "Potion":
					writer.write(bg + "pot ");
					break;
				case "Rock":
					writer.write(bg + "rck ");
					break;
				case "Stone":
					writer.write(bg + "stn ");
					break;
				case "Sword1":
					writer.write(bg + "sw1 ");
					break;
				case "Sword2":
					writer.write(bg + "sw2 ");
					break;
				case "Sword3":
					writer.write(bg + "sw3 ");
					break;
				case "Water":
					writer.write(bg + "wtr ");
					break;
				case "Wood":
					writer.write(bg + "wod ");
					break;
				}
			}
			
			if (r != Floor.width - 1)
				writer.newLine();
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
	
	public static String currentFloor() {
		int x = Floor.currentFloorID.x;
		int y = Floor.currentFloorID.y;
		return "Floor1_" + x + "x" + y;
	}
	
	public static Floor loadInCurrentFloor() {
		String filepath = "MapTxtFiles/Floor1_" + Floor.currentFloorID.x + "x" + Floor.currentFloorID.y;
		String[][] map;
		Floor f = new Floor();
		
		try {
			map = IO.readMapFromTxt(filepath);
			f = new Floor(map, Floor.currentFloorID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;		
	}
}
