import java.awt.Point;
import java.awt.image.BufferedImage;

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
		
		System.out.println(p + "\t" + newPos);
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
		
		System.out.println(p + "\t" + newPos);
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
		
		System.out.println(p + "\t" + newPos);
	}
	
	public void moveRight(Floor f) {
		int newY = Math.min(Floor.length - 1, p.y + 1);
		Point newPos = new Point(p.x, newY);
		
		if (isWalkable(f.getTile(newPos).getImageType())) {
			f.moveTile(p, newPos);
			
			// update character position
			p = (Point) newPos.clone();	
		}
			
		System.out.println(p + "\t" + newPos);
	}
}
