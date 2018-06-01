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
		
		
		
	}
	public int getTrophies() {
		return trophies;
	}
	public void addTrophies(int add) {
		trophies+=add;
	}
}
