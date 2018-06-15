import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TileStatus {
	private static int chHealth = 1;
	private static int chMaxHealth = 1;
	private static int chAttack = 1;
	private static int chDefense = 1;
	private static int chTrophies = 1;
	private static Items[] backpack; 
	private static ArrayList<Point> enemyFloorID;
	private static ArrayList<Point> enemyTileID;
	private static ArrayList<Integer> enemyHealth;
	private static ArrayList<Integer> enemyTrophies;

	public static void set(int health, int maxHealth, int defense, int attack, int trophies) {
		chHealth = health;
		chMaxHealth = maxHealth;
		chAttack = attack;
		chDefense = defense;
		chTrophies = trophies;

		enemyFloorID = new ArrayList<Point>();
		enemyTileID = new ArrayList<Point>();
		enemyHealth = new ArrayList<Integer>();
		enemyTrophies = new ArrayList<Integer>();
		backpack = new Items[10];
	}

	public static void increaseCharacterAttack(int increment) {
		chAttack += increment;
	}

	public static void increaseCharacterDefense(int increment) {
		chDefense += increment;
	}

	public static void increaseCharacterMaxHealth(int increment) {
		chMaxHealth += increment;
	}

	public static void increaseCharacterHealth(int increment) {
		chHealth += increment;

		if (chHealth > chMaxHealth) {
			chHealth = chMaxHealth;
		}
	}

	public static void attackEnemy(Point enmFloor, Point enmTile, int attackPts, Floor f) {

		// Going through each enemy
		for (int i = 0; i < enemyTileID.size(); i++) {

			// If the attack matches an enemy in the ArrayList
			if (enemyFloorID.get(i).x == enmFloor.x && enemyFloorID.get(i).y == enmFloor.y) {
				if (enemyTileID.get(i).x == enmTile.x && enemyTileID.get(i).y == enmTile.y) {
					enemyHealth.set(i, enemyHealth.get(i) - attackPts);
					System.out.println("WWWWWWWWWWWWWWWWWWWW");
					// When the enemy dies
					if (enemyHealth.get(i) <= 0) {

						// Deletes the enemy from the floor
						f.getTile(enmTile).setSprite(f.getTile(enmTile).getBG());
						f.getTile(enmTile).setSpriteType(f.getTile(enmTile).getBGImageType());

						// Removes the enemy from the ArrayList
						enemyFloorID.remove(i);
						enemyTileID.remove(i);
						enemyHealth.remove(i);
						enemyTrophies.remove(i);
					}

				}
			}
		}

		System.out.print("Enemy healths: ");
		for (int i = 0; i < enemyFloorID.size(); i++) {
			System.out.print(enemyHealth.get(i) + " ");
		}

	}

	public static void attackPlayer(int attackPts) {

		chHealth -= attackPts;

		System.out.println("Character Health: " + chHealth);

		if (chHealth <= 0) {
			chHealth = 0;
			// Character dies : Game Over
			System.out.println("GAME OVER!!!!!!!!!!");
			JFrame endGame = new JFrame();
			String endGameStr = "GAME OVER!" + "\n" + "Your trophies: " + chTrophies;
			JOptionPane.showMessageDialog(endGame, endGameStr);
			System.exit(0);

		}

	}

	public static void updateEnemyPosition(Point enmFloor, Point oldTile, Point newTile) {

		for (int i = 0; i < enemyTileID.size(); i++) {
			if (enemyFloorID.get(i).x == enmFloor.x && enemyFloorID.get(i).y == enmFloor.y) {
				if (enemyTileID.get(i).x == oldTile.x && enemyTileID.get(i).y == oldTile.y) {
					enemyTileID.set(i, new Point(newTile.x, newTile.y));
					return;
				}
			}
		}

	}

	// Make sure enemy positions are updated when re-entering a room so that it
	// doesn't double copy the enemies on the list
	public static void addEnemiesToList(Floor f) {

		// Going through each enemy to see if the FloorID of the enemy matches with any
		// already created enemy
		boolean alreadyAdded = false;

		for (int i = 0; i < enemyFloorID.size(); i++) {
			if (enemyFloorID.get(i).x == f.getFloorID().x && enemyFloorID.get(i).y == f.getFloorID().y) {
				alreadyAdded = true;
				i = enemyFloorID.size();
			}
		}

		if (!alreadyAdded) {
			for (int i = 0; i < f.width; i++) {
				for (int j = 0; j < f.length; j++) {
					if (f.getTile(i, j) instanceof Enemy) {
						enemyFloorID.add(new Point(f.getFloorID().x, f.getFloorID().y));
						enemyTileID.add(new Point(i, j));
						enemyHealth.add(((Enemy) f.getTile(i, j)).getHealth());
						enemyTrophies.add(((Enemy) f.getTile(i, j)).getTrophies());
					}
				}
			}
		}

	}

	public static int getChHealth() {
		return chHealth;
	}

	public static int getChMaxHealth() {
		return chMaxHealth;
	}

	public static int getChAttack() {
		return chAttack;
	}

	public static int getChDefense() {
		return chDefense;
	}

	public static int getChTrophies() {
		return chTrophies;
	}
	public static int itemSpace() {
		for (int i = 0; i < backpack.length; i++) {
			if (backpack[i] == null) {
				return i;
			}
		}
		return -1;
	}
	public  static Items[] getBackpack() {
		return backpack;
	}
	public static Items getItem(int index) {
		return backpack[index];
	}
	

	public static void setItem(Items input, int index) {
		backpack[index] = input;
	}

}
