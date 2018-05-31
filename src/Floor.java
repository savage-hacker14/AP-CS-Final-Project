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

	private Point floorID; // String that stores current part of floor

	// Images/sprites to be used
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

	// Initialize image constants
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
		player1 = ImageIO.read(new File("Sprites/Player.gif"));
		player2 = ImageIO.read(new File("Sprites/Player.gif"));
		player3 = ImageIO.read(new File("Sprites/Player.gif"));
		potion = ImageIO.read(new File("Sprites/PotionRed.png"));
		sword1 = ImageIO.read(new File("Sprites/SmallSwordVertical.png"));
		sword2 = ImageIO.read(new File("Sprites/SmallSwordVertical.png"));
		sword3 = ImageIO.read(new File("Sprites/SmallSwordVertical.png"));
		stone = ImageIO.read(new File("Sprites/Stone.png"));
		water = ImageIO.read(new File("Sprites/Water.png"));
		key = ImageIO.read(new File("Sprites/Water.png"));
		rock = ImageIO.read(new File("Sprites/Water.png"));
		
		// Backgrounds
		grass = ImageIO.read(new File("Sprites/Grass.png"));
		wood = ImageIO.read(new File("Sprites/Wood.png"));


	}

	// Default constructor with Tile matrix input
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

	// Constructor that builds floor based on character matrix input
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
				switch (tile) {
				case "gblb":
					floorTiles[r][c] = new Tile(blob, grass, "Blob", tileLocation);
					break;
				case "gbsh":
					floorTiles[r][c] = new Tile(bush, grass, "Bush", tileLocation);
					break;
				case "gcht":
					floorTiles[r][c] = new Tile(chest, grass, "Chest", tileLocation);
					break;
				case "gchl":
					floorTiles[r][c] = new Tile(chilli, grass, "Chilli", tileLocation);
					break;
				case "gdmn":
					floorTiles[r][c] = new Tile(demon, grass, "Demon", tileLocation);
					break;
				case "gdor":
					floorTiles[r][c] = new Tile(door, grass, "Door", tileLocation);
					break;
				case "gdrl":
					floorTiles[r][c] = new Tile(doorLock, grass, "DoorLock", tileLocation);
					break;
				case "genm":
					floorTiles[r][c] = new Tile(enemy, grass, "Enemy", tileLocation);
					break;
				case "gfbl":
					floorTiles[r][c] = new Tile(fireball, grass, "Fireball", tileLocation);
					break;		
				case "ggra":
					floorTiles[r][c] = new Tile(grass, grass, "Grass", tileLocation);
					break;
				case "gkey":
					floorTiles[r][c] = new Tile(key, grass, "Key", tileLocation);
					break;
				case "gknt":
					floorTiles[r][c] = new Tile(knight, grass, "Knight", tileLocation);
					break;
				case "gknw":
					floorTiles[r][c] = new Tile(knightWings, grass, "KnightWings", tileLocation);
					break;
				case "glva":
					floorTiles[r][c] = new Tile(lava, grass, "Lava", tileLocation);
					break;
				case "gpl1":
					floorTiles[r][c] = new Tile(player1, grass, "Player1", tileLocation);
					break;
				case "gpl2":
					floorTiles[r][c] = new Tile(player2, grass, "Player2", tileLocation);
					break;
				case "gpl3":
					floorTiles[r][c] = new Tile(player3, grass, "Player3", tileLocation);
					break;
				case "gpot":
					floorTiles[r][c] = new Tile(potion, grass, "Potion", tileLocation);
					break;
				case "grck":
					floorTiles[r][c] = new Tile(rock, grass, "Rock", tileLocation);
					break;
				case "gstn":
					floorTiles[r][c] = new Tile(stone, grass, "Stone", tileLocation);
					break;
				case "gsw1":
					floorTiles[r][c] = new Tile(sword1, grass, "Sword1", tileLocation);
					break;
				case "gsw2":
					floorTiles[r][c] = new Tile(sword2, grass, "Sword2", tileLocation);
					break;
				case "gsw3":
					floorTiles[r][c] = new Tile(sword3, grass, "Sword3", tileLocation);
					break;
				case "gwtr":
					floorTiles[r][c] = new Tile(water, grass, "Water", tileLocation);
					break;
				case "wwod":
					floorTiles[r][c] = new Tile(wood, grass, "Wood", tileLocation);
					break;
				case "wblb":
					floorTiles[r][c] = new Tile(blob, wood, "Blob", tileLocation);
					break;
				case "wbsh":
					floorTiles[r][c] = new Tile(bush, wood, "Bush", tileLocation);
					break;
				case "wcht":
					floorTiles[r][c] = new Tile(chest, wood, "Chest", tileLocation);
					break;
				case "wchl":
					floorTiles[r][c] = new Tile(chilli, wood, "Chilli", tileLocation);
					break;
				case "wdmn":
					floorTiles[r][c] = new Tile(demon, wood, "Demon", tileLocation);
					break;
				case "wdor":
					floorTiles[r][c] = new Tile(door, wood, "Door", tileLocation);
					break;
				case "wdrl":
					floorTiles[r][c] = new Tile(doorLock, wood, "DoorLock", tileLocation);
					break;
				case "wenm":
					floorTiles[r][c] = new Tile(enemy, wood, tile, tileLocation);
					break;
				case "wfbl":
					floorTiles[r][c] = new Tile(fireball, wood, tile, tileLocation);
					break;		
				case "wgra":
					floorTiles[r][c] = new Tile(grass, wood, tile, tileLocation);
					break;
				case "wkey":
					floorTiles[r][c] = new Tile(key, wood, tile, tileLocation);
					break;
				case "wknt":
					floorTiles[r][c] = new Tile(knight, wood, tile, tileLocation);
					break;
				case "wknw":
					floorTiles[r][c] = new Tile(knightWings, wood, tile, tileLocation);
					break;
				case "wlva":
					floorTiles[r][c] = new Tile(lava, wood, tile, tileLocation);
					break;
				case "wpl1":
					floorTiles[r][c] = new Tile(player1, wood, tile, tileLocation);
					break;
				case "wpl2":
					floorTiles[r][c] = new Tile(player2, wood, tile, tileLocation);
					break;
				case "wpl3":
					floorTiles[r][c] = new Tile(player3, wood, tile, tileLocation);
					break;
				case "wpot":
					floorTiles[r][c] = new Tile(potion, wood, tile, tileLocation);
					break;
				case "wrck":
					floorTiles[r][c] = new Tile(rock, wood, tile, tileLocation);
					break;
				case "wstn":
					floorTiles[r][c] = new Tile(stone, wood, tile, tileLocation);
					break;
				case "wsw1":
					floorTiles[r][c] = new Tile(sword1, wood, tile, tileLocation);
					break;
				case "wsw2":
					floorTiles[r][c] = new Tile(sword2, wood, tile, tileLocation);
					break;
				case "wsw3":
					floorTiles[r][c] = new Tile(sword3, wood, tile, tileLocation);
					break;
				case "wwtr":
					floorTiles[r][c] = new Tile(water, wood, tile, tileLocation);
					break;
				}
			}
		}

	}

	public Tile getTile(int x, int y) {
		return floorTiles[x][y];
	}

	public Tile getTile(Point p) {
		return floorTiles[p.x][p.y];
	}

	public void setTile(Tile tile, int x, int y) {
		floorTiles[x][y] = tile;
	}

	public void setTile(Tile tile, Point p) {
		floorTiles[p.x][p.y] = tile;
	}

	public Tile[][] getFloor() {
		return floorTiles;
	}

	public Point getFloorID() {
		return floorID;
	}

	// new method. Moves tiles from old x,y to new x,y
	public void moveTile(Point old, Point newPt) {
		floorTiles[newPt.x][newPt.y] = floorTiles[old.x][old.y];

		if (!(old.equals(newPt))) {
			// reset old cell
			Tile oldTile = getTile(old);
			setTile(new Tile(oldTile.getSprite(), oldTile.getBG(), oldTile.getName(), old), old);
		}
	}

	public Point findChar() {
		MainCharacter main = new MainCharacter(player1);

		for (int r = 0; r < width; r++) {
			for (int c = 0; c < length; c++) {
				if (floorTiles[r][c].getClass().getName().equals(main.getClass().getName())) {
					Point poin = new Point(r, c);
					return poin;
				}
			}
		}

		Point poin = new Point(-1, -1);
		return poin;
	}

	public void printFloor() {
		for (int r = 0; r < width; r++) {
			for (int c = 0; c < length; c++) {
				System.out.print(floorTiles[r][c].getImageType().substring(0, 1) + " ");
			}
			System.out.println();
		}
	}

	public void refresh(JPanel mapPanel) {
		mapPanel.removeAll();
		for (int r = 0; r < width; r++) {
			for (int c = 0; c < length; c++) {
				// testFloor.getTile(r, c).setOpaque(true);
				mapPanel.add(getTile(r, c));
			}
		}

		mapPanel.repaint();
		mapPanel.revalidate();
	}
}
