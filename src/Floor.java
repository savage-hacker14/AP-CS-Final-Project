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
		player1 = ImageIO.read(new File("Sprites/Player1.PNG"));
		player2 = ImageIO.read(new File("Sprites/Player2.PNG"));
		player3 = ImageIO.read(new File("Sprites/Player3.PNG"));
		potion = ImageIO.read(new File("Sprites/PotionRed.png"));
		sword1 = ImageIO.read(new File("Sprites/SmallSwordVertical.png"));
		sword2 = ImageIO.read(new File("Sprites/SmallSwordVertical.png"));
		sword3 = ImageIO.read(new File("Sprites/SmallSwordVertical.png"));
		stone = ImageIO.read(new File("Sprites/Stone.png"));
		water = ImageIO.read(new File("Sprites/Water.png"));
		key = ImageIO.read(new File("Sprites/Key.png"));
		rock = ImageIO.read(new File("Sprites/Rock.png"));
		
		// Backgrounds
		grass = ImageIO.read(new File("Sprites/Grass.png"));
		wood = ImageIO.read(new File("Sprites/Wood.png"));
	}

	public Floor() {
		floorTiles = new Tile[Floor.width][Floor.length];
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
					floorTiles[r][c] = new Enemy(blob, background, "Blob", BGName, tileLocation, 100, 10, 20, 10);
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
					floorTiles[r][c] = new Enemy(demon, background, "Demon", BGName, tileLocation, 2000, 100, 200, 200);
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
					floorTiles[r][c] = new Enemy(knight, background, "Knight", BGName, tileLocation, 200, 30, 80, 40);
					break;
				case "knw":
					floorTiles[r][c] = new Enemy(knightWings, background, "KnightWings", BGName, tileLocation, 200, 50, 120, 60);
					break;
				case "lva":
					floorTiles[r][c] = new Tile(lava, background, "Lava", BGName, tileLocation);
					break;
				case "pl1":
					floorTiles[r][c] = new Tile(player1, background, "Player1", BGName, tileLocation);
					break;
				case "pl2":
					floorTiles[r][c] = new Tile(player2, background, "Player2", BGName, tileLocation);
					break;
				case "pl3":
					floorTiles[r][c] = new Tile(player3, background, "Player3", BGName, tileLocation);
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
				
				}
			}
		}

	}
	
	public Floor clone(Floor f) {
		try {
			return new Floor(f.getFloor());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return (Floor) new Object();
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

	public void printFloor() {
		for (int r = 0; r < width; r++) {
			for (int c = 0; c < length; c++) {
				System.out.print(floorTiles[r][c].getSpriteType().substring(0, 1) + " ");
			}
			System.out.println();
		}
	}

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
	
	
}
