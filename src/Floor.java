import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Floor {

	private Tile[][] floorTiles;
	
	// Images/sprites to be used
	public static BufferedImage blob;
	public static BufferedImage bush;
	public static BufferedImage chest;
	public static BufferedImage chilli;
	public static BufferedImage demon;
	public static BufferedImage door;
	public static BufferedImage doorLock;
	public static BufferedImage enemy1;
	public static BufferedImage fireball;
	public static BufferedImage grass;
	public static BufferedImage knight1;
	public static BufferedImage knight2;
	public static BufferedImage lava;
	public static BufferedImage player;
	public static BufferedImage redPotion;
	public static BufferedImage smallSwordV;
	public static BufferedImage stone;
	public static BufferedImage water;

	// Initialize image constants
	public static void init() throws IOException {
		blob 		= ImageIO.read(new File("Sprites/Blob.png"));
		bush 		= ImageIO.read(new File("Sprites/Bush.png"));
		chest 		= ImageIO.read(new File("Sprites/Chest.png"));
		chilli 		= ImageIO.read(new File("Sprites/Chilli.png"));
		demon 		= ImageIO.read(new File("Sprites/Demon.png"));
		door 		= ImageIO.read(new File("Sprites/Door.png"));
		doorLock 	= ImageIO.read(new File("Sprites/DoorLock.png"));
		enemy1 		= ImageIO.read(new File("Sprites/Enemy1.png"));
		fireball	= ImageIO.read(new File("Sprites/FireBall.png"));
		grass 		= ImageIO.read(new File("Sprites/Grass.png"));
		knight1 	= ImageIO.read(new File("Sprites/KnightShield.png"));
		knight2		= ImageIO.read(new File("Sprites/KnightShieldWings.png"));
		lava 		= ImageIO.read(new File("Sprites/Lava.png"));
		player 		= ImageIO.read(new File("Sprites/Player.gif"));
		redPotion	= ImageIO.read(new File("Sprites/PotionRed.png"));
		smallSwordV	= ImageIO.read(new File("Sprites/SmallSwordVertical.png"));
		stone 		= ImageIO.read(new File("Sprites/Stone.png"));
		water 		= ImageIO.read(new File("Sprites/Water.png"));
			
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
						floorTiles[r][c] = new Tile(player, "Player1");
						break;
						
					case 'w':
						//floorTiles[r][c] = new Tile(wall);
						break;
						
					case 'b':
						floorTiles[r][c] = new Tile(bush, "Bush");
						break;
	
					case 'd':
						floorTiles[r][c] = new Tile(door, "Door");
						break;
	
					case 'c':
						floorTiles[r][c] = new Tile(chest, "Chest");
						break;
	
					case 'l':
						floorTiles[r][c] = new Tile(lava, "Lava");
						break;
					case 'o':
						floorTiles[r][c] = new Tile(blob, "Blob");
						break;
					case 'h':
						floorTiles[r][c] = new Tile(blob, "Chilli");
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
