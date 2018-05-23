import java.awt.image.BufferedImage;

public class Enemy extends Tile {
	private int health;
	private int attack;
	private int defense;
	
	
	public Enemy(BufferedImage img) {
		super(img);
		health = 100;
		attack = 10;
		defense = 10;
		
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int h) {
		health = h;
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
}
