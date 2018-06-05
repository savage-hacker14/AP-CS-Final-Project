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
	
	public Enemy(BufferedImage img, int helth, int attck, int defnse, int trophy) {
		super(img);
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
	public int getattack() {
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
	public void move(Floor floor) {
		
		// Attacks if player is around them
		
		// NOTE: Revise this to use surrounding objects method?
		
		for (int i = p.x - 1; i < p.x + 2; i++) {
			for (int j = p.y - 1; j < p.y + 2; j++) {
				if (p.x != i || p.y != j) {
					if (floor.getTile(i, j) instanceof Character) {
						
					}
				}
			}
		}
		
		// Moves to a random spot adjacent to it (not diagonally)
		
		
	}
	public int getTrophies() {
		return trophies;
	}
	public void addTrophies(int add) {
		trophies+=add;
	}
}
