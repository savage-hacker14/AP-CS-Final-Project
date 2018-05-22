import java.awt.image.BufferedImage;

public class Knight extends Enemy{
	public Knight(BufferedImage img) {
		super(img);
		setDefense(15);
		setAttack(15);
		setHealth(150);
	}
}
