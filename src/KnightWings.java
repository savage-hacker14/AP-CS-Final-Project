import java.awt.Point;
import java.awt.image.BufferedImage;

public class KnightWings extends Enemy{
	KnightWings(){
		super(Floor.knightWings);
		setDefense(30);
		setAttack(20);
		setHealth(200);
	}
	public KnightWings(BufferedImage sprit, BufferedImage BG, String name, String grndType, Point location) {
		super(sprit, BG, name, grndType, location, 200, 50, 120, 60);
		
	}
}
