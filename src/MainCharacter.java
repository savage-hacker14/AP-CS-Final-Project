import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class MainCharacter extends Character {
	private Items[] backpack;
	private int money;

	public MainCharacter(BufferedImage img) {
		super(img);
		backpack = new Items[10];
		money = 0;
	}

	public MainCharacter(BufferedImage img, BufferedImage BG,String name, String type, Point p) {
		super(img, BG, name,type, p);
	}

	public Items getItem(int index) {
		return backpack[index];
	}

	public void setItem(Items input, int index) {
		backpack[index] = input;
	}

	// checks for open spots
	public int itemSpace() {
		for (int i = 0; i < backpack.length; i++) {
			if (backpack[i] == null) {
				return i;
			}
		}
		return -1;
	}

	public void readItems() {
		//resetAll();
		for (int i = 0; i < backpack.length; i++) {
			setMaxHealth(backpack[i].getHealth() + getMaxHealth());
			changeHealth(backpack[i].getHealth());
			increaseAttack(backpack[i].getHealth());
			increaseDefense(backpack[i].getHealth());
		}
	}

	public int getMoney() {
		return money;
	}

	public void addMoney(int add) {
		money += add;
	}

	public void attack(Floor f){
		Tile[] arr = surroundObjs();
		
		for(int i =0;i<arr.length;i++){
			if(arr[i].getClass().getName().equals("Enemy")){
				((Enemy)arr[i]).setHealth(((Enemy)arr[i]).getHealth()-this.getAttack());
					break;
			}	
		}	
	}
}
