import java.awt.image.BufferedImage;

public class Demon extends Enemy {
	Demon() {
		super(Floor.demon);
		setDefense(15);
		setAttack(15);
		setHealth(150);
	}
}
