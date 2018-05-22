import java.awt.image.BufferedImage;

public class MainCharacter extends Character{
	private Items[]backpack;
	public MainCharacter(BufferedImage img) {
		super(img);
		backpack= new Items[10];
		
	}
	public Items getItem(int index) {
		return backpack[index];
	}
	public void setItem(Items input,int index){
		backpack[index]=input;
	}
	public void readItems() {
		resetAll();
		for(int i=0;i<backpack.length;i++) {
			setMaxHealth(backpack[i].getHealth()+getMaxHealth());
			increaseHealth(backpack[i].getHealth());
			increaseAttack(backpack[i].getHealth());
			increaseDefense(backpack[i].getHealth());
		}
	}
}
