import java.awt.Point;
import java.awt.image.BufferedImage;

public class Enemy extends Tile {
	private int health;
	private int attack;
	private int defense;
	private int trophies;

	public Enemy(BufferedImage img) {
		super(img);
		health = 100;
		attack = 10;
		defense = 10;
		trophies = 0;
	}
	
	public Enemy(Enemy enm) {
		super(enm.getSprite(), enm.getBG(), enm.getSpriteType(), enm.getBGImageType(), enm.p);
		health = enm.getHealth();
		attack = enm.getAttack();
		defense = enm.getDefense();
		trophies = enm.getTrophies();
	}
	
	public Enemy(BufferedImage sprit, BufferedImage BG, String name, String grndType, Point location, int helth,
			int attck, int defnse, int trophy) {
		super(sprit, BG, name, grndType, location);
		health = helth;
		attack = attck;
		defense = defnse;
		trophies = trophy;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int h) {
		health = h;
	}

	public void attackedByPlayer(int health) {
		if (Math.random() < .25) { // Randomly defends
			if (health - defense > 0) {
				this.health -= health;
			}
		}
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int h) {
		attack = h;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int h) {
		defense = h;
	}

	public Point move(Floor floor) {

		// Attacks if player is around them

		// NOTE: Revise this to use surrounding objects method?

		// I made it so that the Enemies don't go on the edge of the screen so that when a player comes into the new floor, they don't override the tile
		int openSpots = 0;
		if (p.x > 1 && floor.getTile(p.x - 1, p.y).isWalkable()) {
			openSpots++;
		}
		if (p.x < Floor.width - 2 && floor.getTile(p.x + 1, p.y).isWalkable()) {
			openSpots++;
		}
		if (p.y > 1 && floor.getTile(p.x, p.y - 1).isWalkable()) {
			openSpots++;
		}
		if (p.y < Floor.length - 2 && floor.getTile(p.x, p.y + 1).isWalkable()) {
			openSpots++;
		}

		int randNum = (int) (Math.random() * openSpots);
		Point newSpot1 = new Point(p.x - 1, p.y);
		Point newSpot2 = new Point(p.x + 1, p.y);
		Point newSpot3 = new Point(p.x, p.y - 1);
		Point newSpot4 = new Point(p.x, p.y + 1);
		if (p.x > 1 && floor.getTile(p.x - 1, p.y).isWalkable()) {
			
			if (randNum == 0) {
				Point oldSpot = new Point(p);
				Enemy newTile = new Enemy(this);
				Tile oldTile = new Tile(floor.getTile(newSpot1));
				floor.setTile(new Enemy(newTile.getSprite(), newTile.getBG(), newTile.getSpriteType(), newTile.getBGImageType(), newSpot1, newTile.getHealth(), newTile.getAttack(), newTile.getDefense(), newTile.getTrophies()), newSpot1);
				floor.setTile(new Tile(oldTile.getSprite(), oldTile.getBG(), oldTile.getSpriteType(), oldTile.getBGImageType(), oldSpot), oldSpot);
				
				return newSpot1;
			} else {
				openSpots--;
				randNum = (int) (Math.random() * openSpots);
			}
		}
		
		if (p.x < Floor.width - 2 && floor.getTile(p.x + 1, p.y).isWalkable()) {
			if (randNum == 0) {
				Point oldSpot = new Point(p);
				Enemy newTile = new Enemy(this);
				Tile oldTile = new Tile(floor.getTile(newSpot2));
				floor.setTile(new Enemy(newTile.getSprite(), newTile.getBG(), newTile.getSpriteType(), newTile.getBGImageType(), newSpot2, newTile.getHealth(), newTile.getAttack(), newTile.getDefense(), newTile.getTrophies()), newSpot2);
				floor.setTile(new Tile(oldTile.getSprite(), oldTile.getBG(), oldTile.getSpriteType(), oldTile.getBGImageType(), oldSpot), oldSpot);
				
				return newSpot2;
			} else {
				openSpots--;
				randNum = (int) (Math.random() * openSpots);
			}
		}
		
		if (p.y > 1 && floor.getTile(p.x, p.y - 1).isWalkable()) {
			if (randNum == 0) {
				Point oldSpot = new Point(p);
				Enemy newTile = new Enemy(this);
				Tile oldTile = new Tile(floor.getTile(newSpot3));
				floor.setTile(new Enemy(newTile.getSprite(), newTile.getBG(), newTile.getSpriteType(), newTile.getBGImageType(), newSpot3, newTile.getHealth(), newTile.getAttack(), newTile.getDefense(), newTile.getTrophies()), newSpot3);
				floor.setTile(new Tile(oldTile.getSprite(), oldTile.getBG(), oldTile.getSpriteType(), oldTile.getBGImageType(), oldSpot), oldSpot);
				
				return newSpot3;
			}
		}
		
		if (p.y < Floor.length - 2 && floor.getTile(p.x, p.y + 1).isWalkable()) {
				Point oldSpot = new Point(p);
				Enemy newTile = new Enemy(this);
				Tile oldTile = new Tile(floor.getTile(newSpot4));
				floor.setTile(new Enemy(newTile.getSprite(), newTile.getBG(), newTile.getSpriteType(), newTile.getBGImageType(), newSpot4, newTile.getHealth(), newTile.getAttack(), newTile.getDefense(), newTile.getTrophies()), newSpot4);
				floor.setTile(new Tile(oldTile.getSprite(), oldTile.getBG(), oldTile.getSpriteType(), oldTile.getBGImageType(), oldSpot), oldSpot);
				System.out.println(floor.getTile(newSpot4) instanceof Enemy);
				System.out.println(floor.getTile(oldSpot) instanceof Enemy);
				return newSpot4;
		}
		
		return p;
		// Moves to a random spot adjacent to it (not diagonally)

	}

	public int getTrophies() {
		return trophies;
	}

	public void attack(Floor f) {
		Tile[] arr = surroundObjs();
		for (int i = 0; i < arr.length; i++) {
			String name = arr[i].getClass().getName();
			if (name.equals("Player1") || name.equals("Player2") || name.equals("Player3")) {
				// invert(f);
				((MainCharacter) arr[i]).changeHealth(this.getAttack());

				break;
			}
		}
	}

	public void addTrophies(int add) {
		trophies += add;
	}
}
