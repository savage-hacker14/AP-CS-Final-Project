import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Floor {

	private Tile[][] floorTiles;

	public static int length = 16;
	public static int width = 9;

	private Point floorID; // String that stores current part of floors
	public static Point currentFloorID = new Point (0, 0);

	// Images/sprites to be used
	//yuh yuh
	public static BufferedImage blob;
	public static BufferedImage bush;
	public static BufferedImage chest;
	public static BufferedImage chilli;
	public static BufferedImage demon;
	public static BufferedImage door;
	public static BufferedImage doorLock;
	public static BufferedImage enemy;
	public static BufferedImage fireball;
	public static BufferedImage grass;
	public static BufferedImage knight;
	public static BufferedImage knightWings;
	public static BufferedImage lava;
	public static BufferedImage key;
	public static BufferedImage rock;
	public static BufferedImage wood;
	public static BufferedImage sword1;
	public static BufferedImage sword2;
	public static BufferedImage sword3;
	public static BufferedImage player1;
	public static BufferedImage player2;
	public static BufferedImage player3;
	public static BufferedImage potion;
	public static BufferedImage stone;
	public static BufferedImage water;
	public static BufferedImage monster;
	public static BufferedImage furnace;
	

	/**
	 * Initialize all sprite images / backgrounds (Buffered Images)
	 * @throws IOException
	 */
	public static void init() throws IOException {

		// No background images
		blob = ImageIO.read(new File("Sprites/Blob.png"));
		bush = ImageIO.read(new File("Sprites/Bush.png"));
		chest = ImageIO.read(new File("Sprites/Chest.png"));
		chilli = ImageIO.read(new File("Sprites/Chilli.png"));
		demon = ImageIO.read(new File("Sprites/Demon.png"));
		door = ImageIO.read(new File("Sprites/Door.png"));
		doorLock = ImageIO.read(new File("Sprites/DoorLock.png"));
		enemy = ImageIO.read(new File("Sprites/Enemy1.png"));
		fireball = ImageIO.read(new File("Sprites/FireBall.png"));
		knight = ImageIO.read(new File("Sprites/KnightShield.png"));
		knightWings = ImageIO.read(new File("Sprites/KnightShieldWings.png"));
		lava = ImageIO.read(new File("Sprites/Lava.png"));
		player1 = ImageIO.read(new File("Sprites/Player1.PNG"));
		player2 = ImageIO.read(new File("Sprites/Player2.PNG"));
		player3 = ImageIO.read(new File("Sprites/Player3.PNG"));
		potion = ImageIO.read(new File("Sprites/PotionRed.png"));
		sword1 = ImageIO.read(new File("Sprites/Sword1.png"));
		sword2 = ImageIO.read(new File("Sprites/Sword2.png"));
		sword3 = ImageIO.read(new File("Sprites/Sword3.png"));
		stone = ImageIO.read(new File("Sprites/Stone.png"));
		water = ImageIO.read(new File("Sprites/Water.png"));
		key = ImageIO.read(new File("Sprites/Key.png"));
		rock = ImageIO.read(new File("Sprites/Rock.png"));
		monster = ImageIO.read(new File("Sprites/Monster.png"));
		furnace = ImageIO.read(new File("Sprites/Furnace.png"));
		
		// Backgrounds
		grass = ImageIO.read(new File("Sprites/Grass.png"));
		wood = ImageIO.read(new File("Sprites/Wood.png"));
	}
	/**
	 * Default constructor
	 */
	public Floor() {
		floorTiles = new Tile[Floor.width][Floor.length];
	}
	
	/**
	 * Constructor with Tile matrix input
	 * @param arr
	 * @throws IOException
	 */
	public Floor(Tile[][] arr) throws IOException {
		// init image constants
		init();

		// init floor array
		floorTiles = new Tile[width][length];

		// Jacob: omit 9x16 size for now
		for (int r = 0; r < width; r++) {
			for (int c = 0; c < length; c++) {
				floorTiles[r][c] = arr[r][c];
			}
		}

	}

	/**
	 * Constructor that builds floor based on character matrix input
	 * @param arr (string matrix from .txt file)
	 * @param id
	 * @throws IOException
	 */
	public Floor(String[][] arr, Point id) throws IOException {
		// init image constants
		init();

		// set floor id
		floorID = id;

		// init floor array
		floorTiles = new Tile[arr.length][arr[0].length];

		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				String tile = arr[r][c];

				Point tileLocation = new Point(r, c);

				// For the format of the text inputs it's n(no background)/g(grass
				// background)/w(woodBackground) + three letter abbreviation: Grass background
				// blob is gblb for its name
				BufferedImage background = grass; //Default background is grass in case it gets messed up in the txt files
				String BGName = "Grass";
				if (tile.substring(0, 1).equalsIgnoreCase("w")) {
					background = wood;
					BGName = "Wood";
				} else if (tile.substring(0, 1).equalsIgnoreCase("g")) { // This is else if in case we want to add more backgrounds
					background = grass;
					BGName = "Grass";
				}
				
				tile = tile.substring(1); // gets the last three letters for the foreground image
				
				switch (tile) {
				case "blb":
					floorTiles[r][c] = new Blob(blob, background, "Blob", BGName, tileLocation);
					break;
				case "bsh":
					floorTiles[r][c] = new Tile(bush, background, "Bush", BGName, tileLocation);
					break;
				case "cht":
					floorTiles[r][c] = new Tile(chest, background, "Chest", BGName, tileLocation);
					break;
				case "chl":
					floorTiles[r][c] = new Tile(chilli, background, "Chilli", BGName, tileLocation);
					break;
				case "dmn":
					floorTiles[r][c] = new Demon(demon, background, "Demon", BGName, tileLocation);
					break;
				case "dor":
					floorTiles[r][c] = new Tile(door, background, "Door", BGName, tileLocation);
					break;
				case "drl":
					floorTiles[r][c] = new Tile(doorLock, background, "DoorLock", BGName, tileLocation);
					break;
				case "enm":
					floorTiles[r][c] = new Enemy(enemy, background, "Enemy", BGName, tileLocation, 40, 20, 10, 5);
					break;
				case "fbl":
					floorTiles[r][c] = new Tile(fireball, background, "Fireball", BGName, tileLocation);
					break;		
				case "gra":
					floorTiles[r][c] = new Tile(grass, background, "Grass", BGName, tileLocation);
					break;
				case "key":
					floorTiles[r][c] = new Tile(key, background, "Key", BGName, tileLocation);
					break;
				case "knt":
					floorTiles[r][c] = new Knight(knight, background, "Knight", BGName, tileLocation);
					break;
				case "knw":
					floorTiles[r][c] = new KnightWings (knightWings, background, "KnightWings", BGName, tileLocation);
					break;
				case "lva":
					floorTiles[r][c] = new Tile(lava, background, "Lava", BGName, tileLocation);
					break;
				case "pl1":
					floorTiles[r][c] = new MainCharacter(player1, background, "Player1", BGName, tileLocation);
					break;
				case "pl2":
					floorTiles[r][c] = new MainCharacter(player2, background, "Player2", BGName, tileLocation);
					break;
				case "pl3":
					floorTiles[r][c] = new MainCharacter(player3, background, "Player3", BGName, tileLocation);
					break;
				case "pot":
					floorTiles[r][c] = new Tile(potion, background, "Potion", BGName, tileLocation);
					break;
				case "rck":
					floorTiles[r][c] = new Tile(rock, background, "Rock", BGName, tileLocation);
					break;
				case "stn":
					floorTiles[r][c] = new Tile(stone, background, "Stone", BGName, tileLocation);
					break;
				case "sw1":
					floorTiles[r][c] = new Tile(sword1, background, "Sword1", BGName, tileLocation);
					break;
				case "sw2":
					floorTiles[r][c] = new Tile(sword2, background, "Sword2", BGName, tileLocation);
					break;
				case "sw3":
					floorTiles[r][c] = new Tile(sword3, background, "Sword3", BGName, tileLocation);
					break;
				case "wtr":
					floorTiles[r][c] = new Tile(water, background, "Water", BGName, tileLocation);
					break;
				case "wod":
					floorTiles[r][c] = new Tile(wood, background, "Wood", BGName, tileLocation);
					break;
				case "mon":
					floorTiles[r][c] = new Enemy(monster, background, "Monster", BGName, tileLocation, 500, 150, 200, 250);
					break;
				case "frn":
					floorTiles[r][c] = new Tile(furnace, background, "Furnace", BGName, tileLocation);
					break;
				
				}
			}
		}

	}
	
	/**
	 * Clone method for a Floor object
	 * @param f
	 * @return
	 */
	public Floor clone(Floor f) {
		try {
			return new Floor(f.getFloor());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return (Floor) new Object();
	}

	/**
	 * Get tile x,y (row,col) from Floor object
	 * @param x
	 * @param y
	 * @return
	 */
	public Tile getTile(int x, int y) {
		return floorTiles[x][y];
	}
	
	/**
	 * Get tile in Floor object from Point p
	 * @param p
	 * @return
	 */
	public Tile getTile(Point p) {
		return floorTiles[p.x][p.y];
	}
	
	/**
	 * Set a tile at position x,y (row,col) on the Floor object 
	 * @param tile
	 * @param x
	 * @param y
	 */
	public void setTile(Tile tile, int x, int y) {
		floorTiles[x][y] = tile;
	}

	/**
	 * Set a tile at position Point p (row,col) on the Floor object 
	 * @param tile
	 * @param p
	 */
	public void setTile(Tile tile, Point p) {
		floorTiles[p.x][p.y] = tile;
	}
	
	/**
	 * Return floor object
	 * @return
	 */
	public Tile[][] getFloor() {
		return floorTiles;
	}
	
	/**
	 * Return Floor ID (Point)
	 * @return
	 */
	public Point getFloorID() {
		return floorID;
	}

	/**
	 * Move tile at location old to location newPt
	 * @param old
	 * @param newPt
	 */
	public void moveTile(Point old, Point newPt) {
		//floorTiles[newPt.x][newPt.y] = floorTiles[old.x][old.y];
		
		if (!(old.equals(newPt))) {
			// reset old cell
			Tile oldTile = this.getTile(old);
			Tile newTile = this.getTile(newPt);
			//this.setTile(new Tile(oldTile.getSprite(), newTile.getBG(), oldTile.getImageType(), newTile.getBGImageType(), old), newPt);
			// fix line above to actual image type of background
			
			BufferedImage tempImg = oldTile.getSprite();
			oldTile.setSprite(oldTile.getBG());				// removes sprite from oldTile
			newTile.setSprite(tempImg);						// Adds sprite on new tile
			
			String tempStr = oldTile.getSpriteType();		
			oldTile.setSpriteType(oldTile.getBGImageType()); // update sprite name for oldTile
			newTile.setSpriteType(tempStr);					// update sprite name for newTile
			
			// update locations
			oldTile.setLocation(old);
			newTile.setLocation(newPt);
		}
	}

	/**
	 * Finds the first player (when scanning row by row) on the Floor
	 * @return
	 */
	public Point findChar() {
		MainCharacter main = new MainCharacter(player1);

		for (int r = 0; r < width; r++) {
			for (int c = 0; c < length; c++) {
				if (floorTiles[r][c].getSpriteType().length() == 7 && floorTiles[r][c].getSpriteType().substring(0, 6).equalsIgnoreCase("Player")) {
					Point poin = new Point(r, c);
					return poin;
				}
			}
		}

		Point poin = new Point(-1, -1);
		return poin;
	}

	/**
	 * For debugging, print out first letter of each tile in the Floor object
	 */
	public void printFloor() {
		for (int r = 0; r < width; r++) {
			for (int c = 0; c < length; c++) {
				//System.out.print(floorTiles[r][c].getSpriteType().substring(0, 1) + " ");
			}
			//System.out.println();
		}
	}

	/**
	 * Refresh graphics panel that contains floor to the latest floor
	 * @param mapPanel
	 */
	public void refresh(JPanel mapPanel) {
		mapPanel.removeAll();
		for (int r = 0; r < width; r++) {
			for (int c = 0; c < length; c++) {
				// testFloor.getTile(r, c).setOpaque(true);
				mapPanel.add(this.getTile(r, c));
			}
		}

		mapPanel.repaint();
		mapPanel.revalidate();
	}
	
	/**
	 * Refresh floor and info/button panel in GUI
	 * @param c
	 * @param map
	 * @param info
	 */
	public void refreshAll(MainCharacter c, JPanel map, JPanel info) {
		this.refresh(map);
		
		info.removeAll();
		info.add(GameInfo.generatePanel(c, map));
		
		info.repaint();
		info.revalidate();
	}
	
}
