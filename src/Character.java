import java.awt.Point;
import java.awt.image.BufferedImage;

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
	public void moveUp(Floor f) {
		int newY = Math.min(0, p.y - 1);
		Point newPos = new Point(p.x, newY);
		f.moveTile(p, newPos);
		
		// update character position
		p = newPos;
	}
	
	public void moveDown(Floor f) {
		int newY = Math.min(Floor.width, p.y + 1);
		Point newPos = new Point(p.x, newY);
		f.moveTile(p, newPos);
		
		// update character position
		p = newPos;
	}
	
	public void moveLeft(Floor f) {
		int newX = Math.min(0, p.x - 1);
		Point newPos = new Point(newX, p.y);
		f.moveTile(p, newPos);
		
		// update character position
		p = newPos;
	}
	
	public void moveRight(Floor f) {
		int newX = Math.min(Floor.length, p.x + 1);
		Point newPos = new Point(newX, p.y);
		f.moveTile(p, newPos);
		
		// update character position
		p = newPos;
	}
}
