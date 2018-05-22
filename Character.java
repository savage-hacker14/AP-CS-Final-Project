import java.awt.image.BufferedImage;

public class Character extends Tile {
	
	private int health;
	private int armor;
	private int attack;
	private int defense;
	
	
	public Character(BufferedImage img) {
		super(img);
		health = 100;
		armor = 0;
		attack = 10;
		defense = 10;
		
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int h) {
		health = h;
	}
	public int getarmor() {
		return armor;
	}
	public void setArmor(int h) {
		armor = h;
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
