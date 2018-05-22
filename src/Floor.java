import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Floor {

	private Tile[][] floorTiles;
	
	// Images/sprites to be used
	public static BufferedImage character;
	public static BufferedImage wall;
	public static BufferedImage bush;
	public static BufferedImage door;
	public static BufferedImage chest;
	public static BufferedImage lava;

	// Initialize image constants
	public static void init() throws IOException {
		character 	= ImageIO.read(new File("Sprites/Player.gif"));		// this file format might cause errors
		wall 		= ImageIO.read(new File("Sprites/Stone.png"));
		bush 		= ImageIO.read(new File("Sprites/Bush.png"));
		door 		= ImageIO.read(new File("Sprites/Door.png"));
		chest 		= ImageIO.read(new File("Sprites/Chest.png"));
		lava		= ImageIO.read(new File("Sprites/Lava.png"));
		
	}
	
	// Default constructor with Tile matrix input
	public Floor(Tile[][] arr) throws IOException {
		// init image constants
		init();
		
		// init floor array
		floorTiles = new Tile[arr.length][arr[0].length];
		
		// Jacob: omit 9x16 size for now
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				floorTiles[r][c] = arr[r][c];
			}
		}

	}
	
	// Constructor that builds floor based on character matrix input
	public Floor(char[][] arr) throws IOException {
		// init image constants
		init();
		
		// init floor array
		floorTiles = new Tile[arr.length][arr[0].length];
		
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				char tile = arr[r][c];
				
				switch (tile) {
					case 'p':
						floorTiles[r][c] = new Tile(character);
						break;
						
					case 'w':
						floorTiles[r][c] = new Tile(wall);
						break;
						
					case 'b':
						floorTiles[r][c] = new Tile(bush);
						break;
	
					case 'd':
						floorTiles[r][c] = new Tile(door);
						break;
	
					case 'c':
						floorTiles[r][c] = new Tile(chest);
						break;
	
					case 'l':
						floorTiles[r][c] = new Tile(lava);
						break;
				}
			}
		}
		
	}
	
	public Tile getTile(int x, int y) {
		return floorTiles[x][y];
	}
	
	public void setTile(Tile tile, int x, int y) {
		floorTiles[x][y] = tile;
	}
	
	public Tile[][] getFloor() {
		return floorTiles;
	}

}
