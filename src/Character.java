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
}
