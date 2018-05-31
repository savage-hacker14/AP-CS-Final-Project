import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
	
	public Character(BufferedImage img, BufferedImage BG, String type, Point p) {
		super(img, BG, type, p);
		health = 100;
		attack = 10;
		defense = 10;
		maxHealth = 100;
	}
	
	public void resetAll() {
		health = 100;
		attack = 10;
		defense = 10;
		maxHealth = 100;
	}

	public int getHealth() {
		return health;
	}

	/* Increases health by health, but doesn't exceed maxHealth */
	public void increaseHealth(int health) {
		this.health += health;
		if (this.health > maxHealth) {
			this.health = maxHealth;
		}
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
	
	public Floor moveUp(Floor f) throws IOException {
		Floor newF = f;
		
		// load in new floor
		if (p.x == 0) {
			// load in upper floor
			String filepath = "MapTxtFiles/Floor1_" + f.getFloorID().x + "x" + (f.getFloorID().y + 1);
			System.out.println(filepath);
			
			// get new floor ID
			Point newFID = IO.strToFloorID(filepath);
			
			String[][] newCharArr = IO.readMapFromTxt(filepath);
			newF = new Floor(newCharArr, newFID);
			
			// place character in new correct position
			newF.setTile(this, new Point(Floor.width - 1, p.y));
			p.setLocation(Floor.width - 1, p.y);
		}
		
		int newX;
		if (p.x > 0) {
			newX = p.x - 1;
		}
		else {
			newX = 0;
		}
		
		Point newPos = new Point(newX, p.y);
		
		System.out.println(p + "\t" + newPos);
		
		if (isWalkable(f.getTile(newPos).getImageType())) {
			f.moveTile(p, newPos);
			
			// update character position
			p = (Point) newPos.clone();	
		}
		
		return newF;
		
//		surroundObjs(f);
//		f.printFloor();
//		
	}
	
	public Floor moveDown(Floor f) throws IOException {
		Floor newF = f;
		
		// load in new floor
		if (p.x == Floor.width - 1) {
			// load in upper floor
			String filepath = "MapTxtFiles/Floor1_" + f.getFloorID().x + "x" + (f.getFloorID().y - 1);
			System.out.println(filepath);
			
			// get new floor ID
			Point newFID = IO.strToFloorID(filepath);
			
			String[][] newCharArr = IO.readMapFromTxt(filepath);
			newF = new Floor(newCharArr, newFID);
			
			// place character in new correct position
			newF.setTile(this, new Point(0, p.y));
			p.setLocation(0, p.y);
		}
		
		int newX = Math.min(Floor.width - 1, p.x + 1);
		Point newPos = new Point(newX, p.y);
		
		System.out.println(p + "\t" + newPos);
		
		if (isWalkable(f.getTile(newPos).getImageType())) {
			f.moveTile(p, newPos);
			
			// update character position
			p = (Point) newPos.clone();	
		}
		
		return newF;
	}
	
	public Floor moveLeft(Floor f) throws IOException {
		Floor newF = f;
		// load in new floor
		if (p.y == 0) {
			// load in upper floor
			String filepath = "MapTxtFiles/Floor1_" + (f.getFloorID().x - 1) + "x" + f.getFloorID().y;
			
			// get new floor ID
			Point newFID = IO.strToFloorID(filepath);
			
			String[][] newCharArr = IO.readMapFromTxt(filepath);
			newF = new Floor(newCharArr, newFID);
			
			// place character in new correct position
			newF.setTile(this, new Point(p.x, Floor.length - 1));
			p.setLocation(p.x, Floor.length - 1);
		}
		
		int newY;
		if (p.y > 0) {
			newY = p.y - 1;
		}
		else {
			newY = 0;
		}
		
		Point newPos = new Point(p.x, newY);
		
		System.out.println(p + "\t" + newPos);
		
		if (isWalkable(f.getTile(newPos).getImageType())) {
			f.moveTile(p, newPos);
			
			// update character position
			p = (Point) newPos.clone();	
		}
		
		return newF;
	}
	
	public Floor moveRight(Floor f) throws IOException {
		Floor newF = f;
		// load in new floor
		if (p.y == Floor.length - 1) {
			// load in upper floor
			String filepath = "MapTxtFiles/Floor1_" + (f.getFloorID().x + 1) + "x" + f.getFloorID().y;
			
			// get new floor ID
			Point newFID = IO.strToFloorID(filepath);
			newFID.setLocation(newFID.x, newFID.y + 1);
			
			String[][] newCharArr = IO.readMapFromTxt(filepath);
			newF = new Floor(newCharArr, newFID);
			
			// place character in new correct position
			newF.setTile(this, new Point(p.x, 0));
			p.setLocation(p.x, 0);
		}
		
		int newY = Math.min(Floor.length - 1, p.y + 1);
		Point newPos = new Point(p.x, newY);
		
		System.out.println(p + "\t" + newPos);
		
		if (isWalkable(f.getTile(newPos).getImageType())) {
			f.moveTile(p, newPos);
			
			// update character position
			p = (Point) newPos.clone();	
		}
		
		return newF;
	}
	
	
	// Sensory commands
	public Tile[] surroundObjs(Floor f) {
		// will store surrounding tiles
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		
		// array of all surrounding cell coordinates
		Point[] surr = new Point[8];
		surr[0] = new Point(p.x  - 1, p.y - 1);
		surr[1] = new Point(p.x - 1, p.y);
		surr[2] = new Point(p.x - 1, p.y + 1);
		surr[3] = new Point(p.x, p.y - 1);
		surr[4] = new Point(p.x, p.y + 1);
		surr[5] = new Point(p.x + 1, p.y - 1);
		surr[6] = new Point(p.x + 1, p.y);
		surr[7] = new Point(p.x + 1, p.y + 1);
		
		for (int i = 0; i < surr.length; i++) {
			boolean validPoint = surr[i].x >= 0 && surr[i].x < Floor.length && surr[i].y >= 0 && surr[i].y < Floor.width;
			if (validPoint) {
				Tile surrTile = f.getTile(surr[i]);
				tiles.add(surrTile);
			}
		}
		
		// convert arrayList to arr
		Tile[] tilesArr = new Tile[tiles.size()];
		for (int i = 0; i < tilesArr.length; i++) {
			tilesArr[i] = tiles.get(i);
		}
		
		// for debug, print out array
		for (int i = 0; i < tilesArr.length; i++) {
			System.out.println(tilesArr[i].getImageType().substring(0, 1));
		}
		
		// return array
		return tilesArr;
	}
}
