// Written by Jacob on 5/20/18

import java.awt.Point;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;

public class IO {
	
	/**
	 * This method can read in a String matrix from a .txt file 
	 * @param filepath
	 * @return string matrix
	 * @throws IOException
	 */
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
	/**
	 * Write a Floor object to its corresponding .txt file
	 * @param map
	 * @param filepath
	 * @throws IOException
	 */
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
				case "Furnace":
					writer.write(bg + "frn ");
					break;
				case "Monster":
					writer.write(bg + "mon ");
					break;
				}
			}
			
			if (r != Floor.width - 1)
				writer.newLine();
		}
		writer.flush();
		writer.close();
	}
	
	/**
	 * For debugging, print out map read in by the readMap method
	 * @param arr
	 * @deprecated
	 */
	public static void printMap(char[][] arr) {
		for (char[] row : arr) {
			for (char c : row) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * Create Floor ID from String
	 * @param String
	 * @return Floor ID (Point)
	 */
	public static Point strToFloorID(String str) {
		int x = Integer.parseInt(str.substring(19, 20));
		int y = Integer.parseInt(str.substring(21, 22));
		
		System.out.println("x: " + x + "\t" + "y: " + y);
		
		return new Point(x, y);
	}
	
	/**
	 * Name of .txt file for current floor
	 * @return
	 */
	public static String currentFloor() {
		int x = Floor.currentFloorID.x;
		int y = Floor.currentFloorID.y;
		return "Floor1_" + x + "x" + y;
	}
	
	/**
	 * Read in current floor (based on currentFloorID)
	 * @return Floor object
	 */
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
	
	
	/*
	 * Returns the floorID point when it finds the first pl1 it sees on the whole map
	 * @Param String floorName is "MapTxtFiles/Floor1_" unless we do a Floor2_
	 * @Param maxWidth is width of Floor1
	 * @Param maxWidth is length of Floor1
	 * 
	 * */
	public static Point findPlayerFloorID(String floorName, int maxWidth, int maxHeight) {
		// clean up code; why not use find char here?
		
		
		//Cycle through floors
		for (int i = 0; i < maxWidth; i++) {
			for (int j = 0; j < maxHeight; j++) {
				
				//If the floor exists in the MapTxtFlies and finds pl1, then it returns that floor
				try {
					String[][] strFloor2D = IO.readMapFromTxt("MapTxtFiles/" + floorName + i + "x" + j);
					for (int k = 0; k < Floor.width; k++) {
						for (int l = 0; l < Floor.length; l++) {
							
							if (strFloor2D[k][l].substring(1).equals("pl1")) {
								return new Point(i, j);
							}
						}
					}
				} catch (IOException e) {}
			}
		}
		
		// If it doesn't find a player it sets the player to 0x0 floorID and puts the player back to its original position
		try {
			
			File oldFile = new File("MapTxtFiles/Floor1_0x0");
			Scanner reader = new Scanner(oldFile);
			String[][] strArr = readMapFromTxt("MapTxtFiles/Floor1_0x0");
			//oldFile.delete();
			BufferedWriter writer = new BufferedWriter(new FileWriter("MapTxtFiles/Floor1_0x0"));
			strArr[6][5] = "gpl1";
			for (int i = 0; i < strArr.length; i++) {
				for (int j = 0; j < strArr[0].length; j++) {
					writer.write(strArr[i][j] + " ");
				}
				writer.newLine();
			}
			writer.flush();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Oh no!!!!!!!!!!!!!!!!!!!!!It no print level right!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			e.printStackTrace();
		}
		
		System.out.println("Failed to find player :(\nPlayer added to Floor1_0x0 at (6, 5)");
		return new Point(0, 0);
		
	}
	
	public static void playSound(String filename) {
		File audioFile = new File(filename);
		 
		AudioInputStream audioStream = null;
		try {
			audioStream = AudioSystem.getAudioInputStream(audioFile);
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AudioFormat format = audioStream.getFormat();
		 
		DataLine.Info info = new DataLine.Info(Clip.class, format);
		
		Clip audioClip = null;
		try {
			audioClip = (Clip) AudioSystem.getLine(info);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			audioClip.open(audioStream);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		audioClip.start();
	}
}
