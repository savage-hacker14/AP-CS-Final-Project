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

	/**
	 * Set up the TileStatus
	 * @param health
	 * @param maxHealth
	 * @param defense
	 * @param attack
	 * @param trophies
	 */
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

	/**
	 * Increase the character attack by increment
	 * @param increment
	 */
	public static void increaseCharacterAttack(int increment) {
		chAttack += increment;
	}

	/**
	 * Increase the character defense by increment
	 * @param increment
	 */
	public static void increaseCharacterDefense(int increment) {
		chDefense += increment;
	}

	/**
	 * Increase the character max health by increment
	 * @param increment
	 */
	public static void increaseCharacterMaxHealth(int increment) {
		chMaxHealth += increment;
	}

	/**
	 * Increase the character health by increment
	 * @param increment
	 */
	public static void increaseCharacterHealth(int increment) {
		chHealth += increment;

		if (chHealth > chMaxHealth) {
			chHealth = chMaxHealth;
		}
	}

	/**
	 * Attack the enemy (deal damage), then possibly remove from floor if dead
	 * @param enmFloor
	 * @param enmTile
	 * @param attackPts
	 * @param f
	 */
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
						
						// Increase player trophies 
						TileStatus.updateChTrophies(10);
						GameInfo.updateTrophies(TileStatus.getChTrophies());
					}

				}
			}
		}

		System.out.print("Enemy healths: ");
		for (int i = 0; i < enemyFloorID.size(); i++) {
			System.out.print(enemyHealth.get(i) + " ");
		}

	}

	/**
	 * Attack the player (subtract their health if they're in the 5-8 surrounding tile range
	 * @param attackPts
	 */
	public static void attackPlayer(int attackPts) {

		chHealth -= attackPts;

		System.out.println("Character Health: " + chHealth);

		if (chHealth <= 0) {
			chHealth = 0;
			// Character dies : Game Over
			System.out.println("GAME OVER!!!!!!!!!!");
			JFrame endGame = new JFrame();
			String endGameStr = "GAME OVER!" + "\n" + "Your trophies: " + chTrophies;
			IO.playSound("Sounds/CharDeath.wav");
			JOptionPane.showMessageDialog(endGame, endGameStr);
			System.exit(0);

		}

	}

	/**
	 * Update the enemy's position (Point)
	 * @param enmFloor
	 * @param oldTile
	 * @param newTile
	 */
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

	/** 
	 * Make sure enemy positions are updated when re-entering a room so that it
	 * doesn't double copy the enemies on the list
	 * @param Floor
	 */
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

	/**
	 * Get character health
	 * @return health
	 */
	public static int getChHealth() {
		return chHealth;
	}

	/**
	 * Get character max health
	 * @return maxHealth
	 */
	public static int getChMaxHealth() {
		return chMaxHealth;
	}

	/**
	 * Get character attack
	 * @return chAttack
	 */
	public static int getChAttack() {
		return chAttack;
	}

	/**
	 * Get character defense
	 * @return chDefense
	 */
	public static int getChDefense() {
		return chDefense;
	}

	/**
	 * Get character trophies
	 * @return chTrophies
	 */
	public static int getChTrophies() {
		return chTrophies;
	}
	
	/**
	 * Add to character trophies by toSum
	 */
	public static void updateChTrophies(int toSum) {
		chTrophies += toSum;
	}
	
	/**
	 * Find spot for next available item in Backpack
	 * @return
	 */
	public static int itemSpace() {
		for (int i = 0; i < backpack.length; i++) {
			if (backpack[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Get the Backpack object
	 * @return
	 */
	public static Items[] getBackpack() {
		return backpack;
	}
	
	/**
	 * Get index's spot Item in Backpack
	 * @param index
	 * @return
	 */
	public static Items getItem(int index) {
		return backpack[index];
	}
	
	/**
	 * Set index's spot with input in Backpack
	 * @param input
	 * @param index
	 */
	public static void setItem(Items input, int index) {
		backpack[index] = input;
	}

}
