import java.awt.Point;
import java.awt.image.BufferedImage;

public class Blob extends Enemy {
	
	
	Blob() {
		super(Floor.blob);
		setHealth(50);
		setAttack(10);
		setDefense(20);
	}
	public Blob(BufferedImage sprit, BufferedImage BG, String name, String grndType, Point location) {
		super(sprit, BG, name, grndType, location,50,10,20,5);
		
	}
	
}
