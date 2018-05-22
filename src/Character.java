import java.awt.image.BufferedImage;

public class Character extends Tile {
	
	private int health;
	private int armor;
	private int attack;
	private int defense;
	private int maxHealth;
	private int maxArmor;
	private int maxAttack;
	private int maxDefense;
	
	
	public Character(BufferedImage img) {
		super(img);
		health = 100;
		armor = 0;
		attack = 10;
		defense = 10;
		maxHealth = 100;
		maxArmor = 0;
		maxAttack = 20;
		maxDefense = 20;
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


	public int getArmor() {
		return armor;
	}

	/* Decreases armor by armor, but doesn't go less than 0 */
	public void damageArmor(int armor) {
		this.armor -= armor;
		if (this.armor < 0) {
			this.armor = 0;
		}
	}


	public int getAttack() {
		return attack;
	}

	/* Increases attack by attack, but doesn't exceed maxAttack */
	public void increaseAttack(int attack) {
		this.attack += attack;
		if (this.attack > maxAttack) {
			this.attack = attack;
		}
	}


	public int getDefense() {
		return defense;
	}

	/* Increases defense by defense, but doesn't exceed maxDefense */
	public void increaseDefense(int defense) {
		this.defense += defense;
		if (this.defense > maxDefense) {
			this.defense = maxDefense;
		}
	}


	public int getMaxHealth() {
		return maxHealth;
	}


	public void increaseMaxHealth(int maxHealth) {
		this.maxHealth += maxHealth;
	}


	public int getMaxArmor() {
		return maxArmor;
	}


	public void increaseMaxArmor(int maxArmor) {
		this.maxArmor += maxArmor;
	}


	public int getMaxAttack() {
		return maxAttack;
	}


	public void increaseMaxAttack(int maxAttack) {
		this.maxAttack += maxAttack;
	}


	public int getMaxDefense() {
		return maxDefense;
	}


	public void increaseMaxDefense(int maxDefense) {
		this.maxDefense += maxDefense;
	}
	
	
}
