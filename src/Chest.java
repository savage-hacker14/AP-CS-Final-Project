import java.util.ArrayList;


public class Chest extends Tile {
	
	private ArrayList<Items> itemList;
	
	
	public Chest(ArrayList<Items> items) {
		super(Floor.chest);
		itemList = items;
	}
	
	public ArrayList<Items> getChestItems() {
		return itemList;
	}
	public void setChestItems(int i,Items yeet) {
		itemList.set(i, yeet);
	}
	
}
