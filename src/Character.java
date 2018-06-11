import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;
import javax.swing.plaf.synth.SynthSpinnerUI;

public class Character extends Tile {

	private int health;
	private int attack;
	private int defense;
	private int maxHealth;

	public Character(BufferedImage img) {
		super(img);
		health = 100;
		attack = 10;
		defense = 10;
		maxHealth = 100;
	}

	public Character(BufferedImage img, BufferedImage BG, String spriteType, String BGName, Point p) {
		super(img, BG, spriteType, BGName, p);
		health = 100;
		attack = 10;
		defense = 10;
		maxHealth = 100;
	}

	//public void resetAll() {
		//health = 100;
		//attack = 10;
		//defense = 10;
		//maxHealth = 100;
	//}

	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	public void setAttack(int attack) {
		this.attack = attack;
	}

	/* Increases health by health, but doesn't exceed maxHealth */
	public void changeHealth(int health) {
		this.health += health;
		if (this.health > maxHealth) {
			this.health = maxHealth;
		} else if (this.health < 0) {
			System.out.println("GAME OVER!");

		}
		System.out.println(this.health);
	}

	public int getAttack() {
		return attack;
	}

	/* Increases attack by attack, but doesn't exceed maxAttack */
	public void increaseAttack(int attack) {
		this.attack += attack;

	}

	public int getDefense() {
		return defense;
	}

	/* Increases defense by defense, but doesn't exceed maxDefense */
	public void increaseDefense(int defense) {
		this.defense += defense;

	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	// Character movements
	// NOTE: X and Y represent row and col, respectively

	public Floor moveUp() throws IOException {
		// Load in the current floor id floor
		String filepath = "MapTxtFiles/Floor1_" + Floor.currentFloorID.x + "x" + Floor.currentFloorID.y;
		String[][] map = IO.readMapFromTxt(filepath);
		Floor f = IO.loadInCurrentFloor();

		// load in new floor
		if (p.x == 0) {

			// Removes old Player from previous floor
			removeOldPlayer(map, f, filepath);

			// load in upper floor
			String newfilepath = "MapTxtFiles/Floor1_" + Floor.currentFloorID.x + "x" + (Floor.currentFloorID.y + 1);
			// System.out.println(newfilepath);

			// get new floor ID
			Point newFID = IO.strToFloorID(newfilepath);
			Floor.currentFloorID = (Point) newFID.clone();
			// System.out.println(Floor.currentFloorID);

			String[][] newCharArr = IO.readMapFromTxt(newfilepath);
			Floor newF = new Floor(newCharArr, newFID);
			// System.out.println(Floor.currentFloorID);

			// place character in new correct position
			newF.setTile(this, new Point(Floor.width - 1, p.y));
			newF.getTile(new Point(Floor.width - 1, p.y)).setSpriteType("Player1");
			// System.out.println(newF.getTile(new Point(Floor.width - 1,
			// p.y)).getImageType());
			p.setLocation(Floor.width - 1, p.y);

			// write new map file
			IO.writeMap(newF, newfilepath);

			return newF;
		}

		int newX;
		if (p.x > 0) {
			newX = p.x - 1;
		} else {
			newX = 0;
		}

		System.out.println("Stuff: " + p);

		Point newPos = new Point(newX, p.y);

		System.out.println(p + "\t" + newPos);

		if (isWalkable(f.getTile(newPos).getSpriteType())) {
			f.moveTile(p, newPos);
			f.printFloor();

			// write new map file
			IO.writeMap(f, filepath);

			// update character position
			p = (Point) newPos.clone();
		}

		return f;
	}

	public Floor moveDown() throws IOException {
		// Load in the current floor id floor
		String filepath = "MapTxtFiles/Floor1_" + Floor.currentFloorID.x + "x" + Floor.currentFloorID.y;
		String[][] map = IO.readMapFromTxt(filepath);
		Floor f = IO.loadInCurrentFloor();

		// load in new floor
		if (p.x == Floor.width - 1) {

			// Removes old Player from previous floor
			removeOldPlayer(map, f, filepath);

			// load in upper floor
			String newfilepath = "MapTxtFiles/Floor1_" + f.getFloorID().x + "x" + (f.getFloorID().y - 1);
			// System.out.println(newfilepath);

			// get new floor ID
			Point newFID = IO.strToFloorID(newfilepath);
			Floor.currentFloorID = (Point) newFID.clone();
			// System.out.println(Floor.currentFloorID);

			String[][] newCharArr = IO.readMapFromTxt(newfilepath);
			Floor newF = new Floor(newCharArr, newFID);
			// System.out.println(Floor.currentFloorID);

			// place character in new correct position
			newF.setTile(this, new Point(0, p.y));
			p.setLocation(0, p.y);
			newF.getTile(new Point(0, p.y)).setSpriteType("Player1");
			// System.out.println(newF.getTile(new Point(Floor.width - 1,
			// p.y)).getImageType());

			// write new map file
			IO.writeMap(newF, newfilepath);

			return newF;
		}

		int newX = Math.min(Floor.width - 1, p.x + 1);
		Point newPos = new Point(newX, p.y);

		System.out.println(p + "\t" + newPos);

		if (isWalkable(f.getTile(newPos).getSpriteType())) {
			f.moveTile(p, newPos);
			f.printFloor();

			// write new map file
			IO.writeMap(f, filepath);

			// update character position
			p = (Point) newPos.clone();
		}

		return f;
	}

	public Floor moveLeft() throws IOException {
		// Load in the current floor id floor
		String filepath = "MapTxtFiles/Floor1_" + Floor.currentFloorID.x + "x" + Floor.currentFloorID.y;
		String[][] map = IO.readMapFromTxt(filepath);
		Floor f = IO.loadInCurrentFloor();

		// load in new floor
		if (p.y == 0) {

			// Removes old Player from previous floor
			removeOldPlayer(map, f, filepath);

			// load in upper floor
			String newfilepath = "MapTxtFiles/Floor1_" + (f.getFloorID().x - 1) + "x" + f.getFloorID().y;
			// System.out.println(newfilepath);

			// get new floor ID
			Point newFID = IO.strToFloorID(newfilepath);
			Floor.currentFloorID = (Point) newFID.clone();
			// System.out.println(Floor.currentFloorID);

			String[][] newCharArr = IO.readMapFromTxt(newfilepath);
			Floor newF = new Floor(newCharArr, newFID);
			// System.out.println(Floor.currentFloorID);

			// place character in new correct position
			newF.setTile(this, new Point(p.x, Floor.length - 1));
			p.setLocation(p.x, Floor.length - 1);
			newF.getTile(new Point(p.x, Floor.length - 1)).setSpriteType("Player1");

			// write new map file
			IO.writeMap(newF, newfilepath);

			return newF;
		}

		int newY;
		if (p.y > 0) {
			newY = p.y - 1;
		} else {
			newY = 0;
		}

		Point newPos = new Point(p.x, newY);

		System.out.println(p + "\t" + newPos);

		if (isWalkable(f.getTile(newPos).getSpriteType())) {
			f.moveTile(p, newPos);
			f.printFloor();

			// write new map file
			IO.writeMap(f, filepath);

			// update character position
			p = (Point) newPos.clone();
		}

		return f;
	}

	public Floor moveRight() throws IOException {
		// Load in the current floor id floor
		String filepath = "MapTxtFiles/Floor1_" + Floor.currentFloorID.x + "x" + Floor.currentFloorID.y;
		String[][] map = IO.readMapFromTxt(filepath);
		Floor f = IO.loadInCurrentFloor();

		// load in new floor
		if (p.y == Floor.length - 1) {

			// Removes old Player from previous floor
			removeOldPlayer(map, f, filepath);

			// load in upper floor
			String newfilepath = "MapTxtFiles/Floor1_" + (f.getFloorID().x + 1) + "x" + f.getFloorID().y;
			// System.out.println(newfilepath);

			// get new floor ID
			Point newFID = IO.strToFloorID(newfilepath);
			Floor.currentFloorID = (Point) newFID.clone();
			// System.out.println(Floor.currentFloorID);

			String[][] newCharArr = IO.readMapFromTxt(newfilepath);
			Floor newF = new Floor(newCharArr, newFID);
			// System.out.println(Floor.currentFloorID);

			// place character in new correct position
			newF.setTile(this, new Point(p.x, 0));
			p.setLocation(p.x, 0);
			newF.getTile(new Point(p.x, 0)).setSpriteType("Player1");

			// write new map file
			IO.writeMap(newF, newfilepath);

			return newF;
		}

		int newY = Math.min(Floor.length - 1, p.y + 1);
		Point newPos = new Point(p.x, newY);

		System.out.println(p + "\t" + newPos);

		if (isWalkable(f.getTile(newPos).getSpriteType())) {
			f.moveTile(p, newPos);
			f.printFloor();

			// write new map file
			IO.writeMap(f, filepath);

			// update character position
			p = (Point) newPos.clone();
		}

		return f;
	}

	// Sensory commands
	public Floor attack() throws InterruptedException {
		Floor f = IO.loadInCurrentFloor();
			
		// array of all surrounding cell coordinates
		Point[] surr = new Point[8];
		surr[0] = new Point(p.x - 1, p.y - 1);
		surr[1] = new Point(p.x - 1, p.y);
		surr[2] = new Point(p.x - 1, p.y + 1);
		surr[3] = new Point(p.x, p.y - 1);
		surr[4] = new Point(p.x, p.y + 1);
		surr[5] = new Point(p.x + 1, p.y - 1);
		surr[6] = new Point(p.x + 1, p.y);
		surr[7] = new Point(p.x + 1, p.y + 1);

		for (int i = 0; i < surr.length; i++) {
			boolean validPoint = surr[i].x >= 0 && surr[i].x < Floor.width && surr[i].y >= 0
					&& surr[i].y < Floor.length;
			if (validPoint && f.getTile(surr[i]) instanceof Enemy) {
				Tile surrTile = f.getTile(surr[i]);
				surrTile.invert();
				
				((Enemy) surrTile).setHealth(((Enemy) surrTile).getHealth() - this.getAttack());
			}
		}
		
		return f;
	}

	private void removeOldPlayer(String[][] map, Floor f, String filepath) throws IOException {
		// Removes player from old

		//////////////////////////////////////////////////////////////////////////// Check
		//////////////////////////////////////////////////////////////////////////// this
		Tile tileToChange;
		if (map[f.getFloorID().x][f.getFloorID().y].substring(0, 1).equals("g")) {
			tileToChange = new Tile(Floor.grass, Floor.grass, "Grass", "Grass", p);
		} else { // if (map[p.x][p.y].substring(0, 1).equals("w")) {
			tileToChange = new Tile(Floor.wood, Floor.wood, "Wood", "Wood", p);
		}
		f.setTile(tileToChange, p);
		System.out.println(tileToChange.getSpriteType() + " " + p.getX() + " " + p.getY());

		IO.writeMap(f, filepath);
	}

}
