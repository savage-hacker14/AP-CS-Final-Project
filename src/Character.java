import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
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
	
	public Character(BufferedImage img, String type, Point p) {
		super(img, type, p);
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
	
	public void moveUp(Floor f) {
		int newX;
		if (p.x > 0) {
			newX = p.x - 1;
		}
		else {
			newX = 0;
		}
		
		Point newPos = new Point(newX, p.y);
		
		if (isWalkable(f.getTile(newPos).getImageType())) {
			f.moveTile(p, newPos);
			
			// update character position
			p = (Point) newPos.clone();	
		}
		
//		surroundObjs(f);
//		f.printFloor();
//		
//		System.out.println(p + "\t" + newPos);
	}
	
	public void moveDown(Floor f) {
		int newX = Math.min(Floor.width - 1, p.x + 1);
		Point newPos = new Point(newX, p.y);

//		System.out.println(f.getTile(newPos).getImageType());
//		System.out.println(isWalkable(f.getTile(newPos).getImageType()));
		if (isWalkable(f.getTile(newPos).getImageType())) {
			f.moveTile(p, newPos);
			
			// update character position
			p = (Point) newPos.clone();	
		}
		
//		surroundObjs(f);
//		f.printFloor();
//		
//		System.out.println(p + "\t" + newPos);
		//f.printFloor();
	}
	
	public void moveLeft(Floor f) {
		int newY;
		if (p.y > 0) {
			newY = p.y - 1;
		}
		else {
			newY = 0;
		}
		
		Point newPos = new Point(p.x, newY);
		
		if (isWalkable(f.getTile(newPos).getImageType())) {
			f.moveTile(p, newPos);
			
			// update character position
			p = (Point) newPos.clone();	
		}
		
//		surroundObjs(f);
//		f.printFloor();
//		
//		System.out.println(p + "\t" + newPos);
	}
	
	public void moveRight(Floor f) {
		int newY = Math.min(Floor.length - 1, p.y + 1);
		Point newPos = new Point(p.x, newY);
		
		if (isWalkable(f.getTile(newPos).getImageType())) {
			f.moveTile(p, newPos);
			
			// update character position
			p = (Point) newPos.clone();	
		}
		
//		surroundObjs(f);
//		f.printFloor();
//			
//		System.out.println(p + "\t" + newPos);
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
