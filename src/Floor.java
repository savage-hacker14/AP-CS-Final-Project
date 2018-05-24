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
	public static BufferedImage knightShield;
	public static BufferedImage knightShieldWings;
	public static BufferedImage lava;
	public static BufferedImage player1;
	public static BufferedImage player2;
	public static BufferedImage player3;
	public static BufferedImage redPotion;
	public static BufferedImage smallSwordVertical;
	public static BufferedImage stone;
	public static BufferedImage water;

	// Initialize image constants
	public static void init() throws IOException {
		blob 				= ImageIO.read(new File("Sprites/Blob.png"));
		bush 				= ImageIO.read(new File("Sprites/Bush.png"));
		chest 				= ImageIO.read(new File("Sprites/Chest.png"));
		chilli 				= ImageIO.read(new File("Sprites/Chilli.png"));
		demon 				= ImageIO.read(new File("Sprites/Demon.png"));
		door 				= ImageIO.read(new File("Sprites/Door.png"));
		doorLock 			= ImageIO.read(new File("Sprites/DoorLock.png"));
		enemy1 				= ImageIO.read(new File("Sprites/Enemy1.png"));
		fireball			= ImageIO.read(new File("Sprites/FireBall.png"));
		grass 				= ImageIO.read(new File("Sprites/Grass.png"));
		knightShield 		= ImageIO.read(new File("Sprites/KnightShield.png"));
		knightShieldWings	= ImageIO.read(new File("Sprites/KnightShieldWings.png"));
		lava 				= ImageIO.read(new File("Sprites/Lava.png"));
		player1 			= ImageIO.read(new File("Sprites/Player.gif"));
		player2 			= ImageIO.read(new File("Sprites/Player.gif"));
		player3 			= ImageIO.read(new File("Sprites/Player.gif"));
		redPotion			= ImageIO.read(new File("Sprites/PotionRed.png"));
		smallSwordVertical	= ImageIO.read(new File("Sprites/SmallSwordVertical.png"));
		stone 				= ImageIO.read(new File("Sprites/Stone.png"));
		water 				= ImageIO.read(new File("Sprites/Water.png"));
			
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
					case '1':
						floorTiles[r][c] = new Tile(player1, "Player1");
						break;
					case '2':
						floorTiles[r][c] = new Tile(player2, "Player2");
						break;
					case '3':
						floorTiles[r][c] = new Tile(player3, "Player3");
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
						floorTiles[r][c] = new Tile(chilli, "Chilli");
						break;
					case 'e':
						floorTiles[r][c] = new Tile(demon, "Demon");
						break;
					case 'r':
						floorTiles[r][c] = new Tile(doorLock, "DoorLock");
						break;
					case 'n':
						floorTiles[r][c] = new Tile(enemy1, "Enemy1");
						break;
					case 'f':
						floorTiles[r][c] = new Tile(fireball, "Fireball");
						break;
					case 'g':
						floorTiles[r][c] = new Tile(grass, "Grass");
						break;
					case 'k':
						floorTiles[r][c] = new Tile(knightShield, "KnightShield");
						break;
					case 'i':
						floorTiles[r][c] = new Tile(knightShieldWings, "KnightShieldWings");
						break;
					case 'p':
						floorTiles[r][c] = new Tile(redPotion, "RedPotion");
						break;
					case 's':
						floorTiles[r][c] = new Tile(smallSwordVertical, "SmallSwordVertical");
						break;
					case 't':
						floorTiles[r][c] = new Tile(stone, "Stone");
						break;
					case 'w':
						floorTiles[r][c] = new Tile(water, "Water");
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
