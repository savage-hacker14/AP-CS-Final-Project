import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Chest extends Tile {
	private ArrayList<Items> itemList;
	
	
	public Chest(ArrayList<Items> items) {
		super(Floor.chest);
		itemList = items;
	}
	
}
