import java.awt.Point;
import java.awt.image.BufferedImage;

public class Knight extends Enemy{
	public Knight(BufferedImage img) {
		super(img);
		setDefense(15);
		setAttack(15);
		setHealth(150);
	}
	public Knight(BufferedImage sprit, BufferedImage BG, String name, String grndType, Point location) {
		super(sprit, BG, name, grndType, location,200, 30, 80, 40);
		
	}
}
