import java.awt.Point;
import java.awt.image.BufferedImage;

public class Enemy extends Tile {
	private int health;
	private int attack;
	private int defense;
	private int trophies;

	public Enemy(BufferedImage img) {
		super(img);
		health = 100;
		attack = 10;
		defense = 10;
		trophies = 0;
	}

	public Enemy(BufferedImage sprit, BufferedImage BG, String name, String grndType, Point location, int helth,
			int attck, int defnse, int trophy) {
		super(sprit, BG, name, grndType, location);
		health = helth;
		attack = attck;
		defense = defnse;
		trophies = trophy;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int h) {
		health = h;
	}

	public void attackedByPlayer(int health) {
		if (Math.random() < .25) { // Randomly defends
			if (health - defense > 0) {
				this.health -= health;
			}
		}
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int h) {
		attack = h;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int h) {
		defense = h;
	}

	public void move(Floor floor) {

		// Attacks if player is around them

		// NOTE: Revise this to use surrounding objects method?

		Tile[] surr8 = surroundObjs();
		Tile[] surr4 = { surr8[1], surr8[3], surr8[4], surr8[6] };
		boolean[] walkableSurr4 = new boolean[4];
		int count = 0;
		for (int i = 0; i < surr4.length; i++) {
			walkableSurr4[i] = surr4[i].isWalkable();
			count++;
		}
		int antiCount = 0;

		for (int i = 0; i < 4; i++) {
			if (walkableSurr4[i]) {
				if ((int) (Math.random() * count - antiCount) == 0) {
					// Move up, down, left, or right depending on random number
				}
				antiCount++;
			}
		}

		// Moves to a random spot adjacent to it (not diagonally)

	}

	public int getTrophies() {
		return trophies;
	}

	public void attack(Floor f) {
		Tile[] arr = surroundObjs();
		for (int i = 0; i < arr.length; i++) {
			String name = arr[i].getClass().getName();
			if (name.equals("Player1") || name.equals("Player2") || name.equals("Player3")) {
				invert(f);
				((MainCharacter) arr[i]).changeHealth(this.getAttack());

				break;
			}
		}
	}

	public void addTrophies(int add) {
		trophies += add;
	}
}
