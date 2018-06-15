import java.awt.image.BufferedImage;

public class Items {
	private BufferedImage image;
	private int health;
	private int attack;
	private int defense;
	private int price;
	private String name;
	
	public Items(BufferedImage img) {
		image = img;
	}
	public Items(int heal, int att, int defen, int pric, String nam) {
		health = heal;
		attack = att;
		defense = defen;
		price = pric;
		name =nam;
	}
	public int getHealth() {
		return health;
	}

	/* Increases health by health, but doesn't exceed maxHealth */
	public void increaseHealth(int health) {
		this.health += health;
		
	}
	
	public int getAttack() {
		return attack;
	}

	/* Increases attack by attack, but doesn't exceed maxAttack */
	public void increaseAttack(int attack) {
		this.attack += attack;
		
	}


	public int getDefense() {
		return defense;
	}

	/* Increases defense by defense, but doesn't exceed maxDefense */
	public void increaseDefense(int defense) {
		this.defense += defense;
		
	}

	public String getName() {
		return name;
	}

	/* Increases defense by defense, but doesn't exceed maxDefense */
	public void setName(String nme) {
		name =nme;
	}


}
