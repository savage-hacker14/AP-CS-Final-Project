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
	public static BufferedImage gBlob;
	public static BufferedImage gBush;
	public static BufferedImage gChest;
	public static BufferedImage gChilli;
	public static BufferedImage gDemon;
	public static BufferedImage gEnemy;
	public static BufferedImage gFireball;
	public static BufferedImage gKey;
	public static BufferedImage gKnightWings;
	public static BufferedImage gKnight;
	public static BufferedImage gPlayer1;
	public static BufferedImage gPlayer2;
	public static BufferedImage gPlayer3;
	public static BufferedImage gPotion;
	public static BufferedImage gRock;
	public static BufferedImage gSword1;
	public static BufferedImage gSword2;
	public static BufferedImage gSword3;
	public static BufferedImage wBlob;
	public static BufferedImage wBush;
	public static BufferedImage wChest;
	public static BufferedImage wChilli;
	public static BufferedImage wDemon;
	public static BufferedImage wEnemy;
	public static BufferedImage wFireball;
	public static BufferedImage wKey;
	public static BufferedImage wKnightWings;
	public static BufferedImage wKnight;
	public static BufferedImage wPlayer1;
	public static BufferedImage wPlayer2;
	public static BufferedImage wPlayer3;
	public static BufferedImage wPotion;
	public static BufferedImage wRock;
	public static BufferedImage wSword1;
	public static BufferedImage wSword2;
	public static BufferedImage wSword3;

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
		grass = ImageIO.read(new File("Sprites/Grass.png"));
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

		// Grass background images
		gBlob = ImageIO.read(new File("Sprites/Blob.png"));
		gBush = ImageIO.read(new File("Sprites/Bush.png"));
		gChest = ImageIO.read(new File("Sprites/Chest.png"));
		gChilli = ImageIO.read(new File("Sprites/Chilli.png"));
		gDemon = ImageIO.read(new File("Sprites/Demon.png"));
		gEnemy = ImageIO.read(new File("Sprites/Enemy1.png"));
		gFireball = ImageIO.read(new File("Sprites/FireBall.png"));
		gKnight = ImageIO.read(new File("Sprites/KnightShield.png"));
		gKnightWings = ImageIO.read(new File("Sprites/KnightShieldWings.png"));
		gPlayer1 = ImageIO.read(new File("Sprites/Player.gif"));
		gPlayer2 = ImageIO.read(new File("Sprites/Player.gif"));
		gPlayer3 = ImageIO.read(new File("Sprites/Player.gif"));
		gPotion = ImageIO.read(new File("Sprites/PotionRed.png"));
		gSword1 = ImageIO.read(new File("Sprites/SmallSwordVertical.png"));
		gSword2 = ImageIO.read(new File("Sprites/SmallSwordVertical.png"));
		gSword3 = ImageIO.read(new File("Sprites/SmallSwordVertical.png"));
		gKey = ImageIO.read(new File("Sprites/Water.png"));
		gRock = ImageIO.read(new File("Sprites/Water.png"));

		// Wood background images
		wBlob = ImageIO.read(new File("Sprites/Blob.png"));
		wBush = ImageIO.read(new File("Sprites/Bush.png"));
		wChest = ImageIO.read(new File("Sprites/Chest.png"));
		wChilli = ImageIO.read(new File("Sprites/Chilli.png"));
		wDemon = ImageIO.read(new File("Sprites/Demon.png"));
		wEnemy = ImageIO.read(new File("Sprites/Enemy1.png"));
		wFireball = ImageIO.read(new File("Sprites/FireBall.png"));
		wKnight = ImageIO.read(new File("Sprites/KnightShield.png"));
		wKnightWings = ImageIO.read(new File("Sprites/KnightShieldWings.png"));
		wPlayer1 = ImageIO.read(new File("Sprites/Player.gif"));
		wPlayer2 = ImageIO.read(new File("Sprites/Player.gif"));
		wPlayer3 = ImageIO.read(new File("Sprites/Player.gif"));
		wPotion = ImageIO.read(new File("Sprites/PotionRed.png"));
		wSword1 = ImageIO.read(new File("Sprites/SmallSwordVertical.png"));
		wSword2 = ImageIO.read(new File("Sprites/SmallSwordVertical.png"));
		wSword3 = ImageIO.read(new File("Sprites/SmallSwordVertical.png"));
		wKey = ImageIO.read(new File("Sprites/Water.png"));
		wRock = ImageIO.read(new File("Sprites/Water.png"));

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
				case "nblb":
					floorTiles[r][c] = new Tile(blob, tile, tileLocation);
					break;
				case "nbsh":
					floorTiles[r][c] = new Tile(bush, tile, tileLocation);
					break;
				case "ncht":
					floorTiles[r][c] = new Tile(chest, tile, tileLocation);
					break;
				case "nchl":
					floorTiles[r][c] = new Tile(chilli, tile, tileLocation);
					break;
				case "ndmn":
					floorTiles[r][c] = new Tile(demon, tile, tileLocation);
					break;
				case "ndor":
					floorTiles[r][c] = new Tile(door, tile, tileLocation);
					break;
				case "ndrl":
					floorTiles[r][c] = new Tile(doorLock, tile, tileLocation);
					break;
				case "nenm":
					floorTiles[r][c] = new Tile(enemy, tile, tileLocation);
					break;
				case "nfbl":
					floorTiles[r][c] = new Tile(fireball, tile, tileLocation);
					break;
				case "gblb":
					floorTiles[r][c] = new Tile(gBlob, tile, tileLocation);
					break;
				case "gbsh":
					floorTiles[r][c] = new Tile(gBush, tile, tileLocation);
					break;
				case "gchl":
					floorTiles[r][c] = new Tile(gChilli, tile, tileLocation);
					break;
				case "gcht":
					floorTiles[r][c] = new Tile(gChest, tile, tileLocation);
					break;
				case "gdmn":
					floorTiles[r][c] = new Tile(gDemon, tile, tileLocation);
					break;
				case "genm":
					floorTiles[r][c] = new Tile(gEnemy, tile, tileLocation);
					break;
				case "gfbl":
					floorTiles[r][c] = new Tile(gFireball, tile, tileLocation);
					break;
				case "gkey":
					floorTiles[r][c] = new Tile(gKey, tile, tileLocation);
					break;
				case "gknw":
					floorTiles[r][c] = new Tile(gKnightWings, tile, tileLocation);
					break;
				case "gknt":
					floorTiles[r][c] = new Tile(gKnight, tile, tileLocation);
					break;
				case "gpl1":
					floorTiles[r][c] = new Tile(gPlayer1, tile, tileLocation);
					break;
				case "gpl2":
					floorTiles[r][c] = new Tile(gPlayer2, tile, tileLocation);
					break;
				case "gpl3":
					floorTiles[r][c] = new Tile(gPlayer3, tile, tileLocation);
					break;
				case "gpot":
					floorTiles[r][c] = new Tile(gPotion, tile, tileLocation);
					break;
				case "ngra":
					floorTiles[r][c] = new Tile(grass, tile, tileLocation);
					break;
				case "grck":
					floorTiles[r][c] = new Tile(gRock, tile, tileLocation);
					break;
				case "gsw1":
					floorTiles[r][c] = new Tile(gSword1, tile, tileLocation);
					break;
				case "gsw2":
					floorTiles[r][c] = new Tile(gSword2, tile, tileLocation);
					break;
				case "gsw3":
					floorTiles[r][c] = new Tile(gSword3, tile, tileLocation);
					break;
				case "nkey":
					floorTiles[r][c] = new Tile(key, tile, tileLocation);
					break;
				case "nknt":
					floorTiles[r][c] = new Tile(knight, tile, tileLocation);
					break;
				case "nknw":
					floorTiles[r][c] = new Tile(knightWings, tile, tileLocation);
					break;
				case "nlva":
					floorTiles[r][c] = new Tile(lava, tile, tileLocation);
					break;
				case "npl1":
					floorTiles[r][c] = new Tile(player1, tile, tileLocation);
					break;
				case "npl2":
					floorTiles[r][c] = new Tile(player2, tile, tileLocation);
					break;
				case "npl3":
					floorTiles[r][c] = new Tile(player3, tile, tileLocation);
					break;
				case "npot":
					floorTiles[r][c] = new Tile(potion, tile, tileLocation);
					break;
				case "nrck":
					floorTiles[r][c] = new Tile(rock, tile, tileLocation);
					break;
				case "nstn":
					floorTiles[r][c] = new Tile(stone, tile, tileLocation);
					break;
				case "nsw1":
					floorTiles[r][c] = new Tile(sword1, tile, tileLocation);
					break;
				case "nsw2":
					floorTiles[r][c] = new Tile(sword2, tile, tileLocation);
					break;
				case "nsw3":
					floorTiles[r][c] = new Tile(sword3, tile, tileLocation);
					break;
				case "nwtr":
					floorTiles[r][c] = new Tile(water, tile, tileLocation);
					break;
				case "wblb":
					floorTiles[r][c] = new Tile(wBlob, tile, tileLocation);
					break;
				case "wbsh":
					floorTiles[r][c] = new Tile(wBush, tile, tileLocation);
					break;
				case "wcht":
					floorTiles[r][c] = new Tile(wChest, tile, tileLocation);
					break;
				case "wchl":
					floorTiles[r][c] = new Tile(wChilli, tile, tileLocation);
					break;
				case "wdmn":
					floorTiles[r][c] = new Tile(wDemon, tile, tileLocation);
					break;
				case "wenm":
					floorTiles[r][c] = new Tile(wEnemy, tile, tileLocation);
					break;
				case "wfbl":
					floorTiles[r][c] = new Tile(wFireball, tile, tileLocation);
					break;
				case "wkey":
					floorTiles[r][c] = new Tile(wKey, tile, tileLocation);
					break;
				case "wknt":
					floorTiles[r][c] = new Tile(wKnight, tile, tileLocation);
					break;
				case "wknw":
					floorTiles[r][c] = new Tile(wKnightWings, tile, tileLocation);
					break;
				case "nwod":
					floorTiles[r][c] = new Tile(wood, tile, tileLocation);
					break;
				case "wpl1":
					floorTiles[r][c] = new Tile(wPlayer1, tile, tileLocation);
					break;
				case "wpl2":
					floorTiles[r][c] = new Tile(wPlayer2, tile, tileLocation);
					break;
				case "wpl3":
					floorTiles[r][c] = new Tile(wPlayer3, tile, tileLocation);
					break;
				case "wpot":
					floorTiles[r][c] = new Tile(wPotion, tile, tileLocation);
					break;
				case "wrck":
					floorTiles[r][c] = new Tile(wRock, tile, tileLocation);
					break;
				case "wsw1":
					floorTiles[r][c] = new Tile(wSword1, tile, tileLocation);
					break;
				case "wsw2":
					floorTiles[r][c] = new Tile(wSword2, tile, tileLocation);
					break;
				case "wsw3":
					floorTiles[r][c] = new Tile(wSword3, tile, tileLocation);
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
			setTile(new Tile(Floor.grass, "Grass", old), old);
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
