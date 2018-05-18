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
	
	
}
