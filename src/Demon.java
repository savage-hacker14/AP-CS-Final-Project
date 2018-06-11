import java.awt.Point;
import java.awt.image.BufferedImage;

public class Demon extends Enemy {
	Demon() {
		super(Floor.demon);
		setDefense(15);
		setAttack(15);
		setHealth(150);
	}
	public Demon(BufferedImage sprit, BufferedImage BG, String name, String grndType, Point location) {
		super(sprit, BG, name, grndType, location,2000, 100, 200, 200);
		
	}
}
