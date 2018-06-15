import java.awt.Point;
import java.awt.image.BufferedImage;

public class Blob extends Enemy {
	
	
	Blob() {
		super(Floor.blob);
		setHealth(50);
		setAttack(15);
		setDefense(20);
	}
	public Blob(BufferedImage sprit, BufferedImage BG, String name, String grndType, Point location) {
		super(sprit, BG, name, grndType, location,50,15,20,5);
		
	}
	
}
