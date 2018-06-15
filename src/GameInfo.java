
// Written by JAcob Krucinski on 5/21/18
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameInfo {
	private static JButton[] buttons;
	private static JLabel[] characterStatus;
	private static BufferedImage currentMapView;

	/**
	 * Initialize all buttons and labels in info panel
	 */
	private static void init() {

		// main buttons
		buttons = new JButton[9];
		buttons[0] = new JButton("ATTACK");
		buttons[1] = new JButton("DEFEND");
		buttons[2] = new JButton("↑");
		buttons[3] = new JButton("↓");
		buttons[4] = new JButton("←");
		buttons[5] = new JButton("→");
		buttons[6] = new JButton("INVENTORY");
		buttons[7] = new JButton("MENU");
		buttons[8] = new JButton("SHOP");

		// init characterStatus
		characterStatus = new JLabel[4];
		characterStatus[0] = new JLabel("Health: " + TileStatus.getChHealth());
		characterStatus[1] = new JLabel("Magic: ");
		characterStatus[2] = new JLabel("Attack: " + TileStatus.getChAttack());
		characterStatus[3] = new JLabel("Trophies: " + TileStatus.getChTrophies());

		// init current map view
		// do later
	}

	/**
	 * Create a JPanel with all the buttons and info with a unique 
	 * 
	 * @param c
	 *            (MainCharacter)
	 * @param mapPanel
	 *            (??)
	 * @return
	 */
	public static JPanel generatePanel(MainCharacter c, JPanel mapPanel) {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		JPanel arrowPanel = new JPanel();
		arrowPanel.setLayout(new GridLayout(1,4));
		
		JPanel statusPanel = new JPanel();
		statusPanel.setLayout(new GridLayout(1, 3));
		
		JPanel interact = new JPanel();
		interact.setLayout(new GridLayout(1, 5));
		
		init();

		for (int i = 0; i < buttons.length; i++) {
			String buttonName = buttons[i].getText();
			buttons[i].addActionListener(new ButtonListener(buttonName, c, mapPanel, mapPanel));
			buttons[i].addKeyListener(new KeyReader(c, mapPanel, mapPanel));
			
			// add move buttons to arrowPanel and interact buttons to interact panel
			if (i >= 2 && i <= 5) {
				arrowPanel.add(buttons[i]);
			}
			else {
				interact.add(buttons[i]);
			}
		}

		for (int i = 0; i < characterStatus.length; i++) {
			statusPanel.add(characterStatus[i]);
		}
		
		mainPanel.add(arrowPanel, BorderLayout.NORTH);
		mainPanel.add(statusPanel, BorderLayout.SOUTH);
		mainPanel.add(interact, BorderLayout.CENTER);

		// doesn't seem to work
		// panel.addKeyListener(new KeyReader(c, f, mapPanel));

		return mainPanel;
	}

	/**
	 * Update player's health indicator in GameInfo panel
	 * 
	 * @param newHealth
	 */
	public static void updateHealth(int newHealth) {
		String newTxt = "Health: " + newHealth + "/100";
		characterStatus[0].setText(newTxt);

	}

	/**
	 * Update player's attack indicator in GameInfo panel
	 * 
	 * @param newAttack
	 */
	public static void updateAttack(int newAttack) {
		String newTxt = "Attack: " + newAttack + "/100";
		characterStatus[0].setText(newTxt);
	}

	static class ButtonListener implements ActionListener {

		protected String button;
		protected MainCharacter c;
		protected JPanel mapPanel;
		protected JPanel info;
		protected Floor f = IO.loadInCurrentFloor();

		/**
		 * Constructor for the class reading button clicks
		 * 
		 * @param buttonTxt
		 * @param ch
		 * @param map
		 * @param i
		 */
		public ButtonListener(String buttonTxt, MainCharacter ch, JPanel map,
				JPanel i) {
			button = buttonTxt;
			c = ch;
			mapPanel = map;
			info = i;
		}

		@Override
		/**
		 * Checks what button is pressed at does its corresponding action
		 */
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			switch (button) {
			case "ATTACK":
				System.out.println("ATTACK!");

				// f.getTile(new Point(c.p.x, c.p.y - 1)).invert();
				try {
					f = ((Character) c).attack();
				} catch (InterruptedException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				cycleEnemyMoves();
				f.refresh(mapPanel);
				// f.refreshAll(c, mapPanel, info);
				// c.surroundObjs();
				break;
			case "DEFEND":
				System.out.println("DEFEND!");
				cycleEnemyMoves();
				break;
			case "↑":
				System.out.println("UP!");
				try {
					System.out.println(Floor.currentFloorID);
					f = c.moveUp();
					cycleEnemyMoves();
					// c.surroundObjs();
					f.refresh(mapPanel);
					// f.refreshAll(c, mapPanel, info);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case "↓":
				System.out.println("DOWN!");
				try {
					f = c.moveDown();
					cycleEnemyMoves();
					// c.surroundObjs();
					f.refresh(mapPanel);
					// f.refreshAll(c, mapPanel, info);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case "←":
				System.out.println("LEFT!");
				try {
					f = c.moveLeft();
					cycleEnemyMoves();
					// c.surroundObjs();
					f.refresh(mapPanel);
					// f.refreshAll(c, mapPanel, info);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case "→":
				System.out.println("RIGHT!");
				try {
					f = c.moveRight();
					cycleEnemyMoves();
					// c.surroundObjs();
					f.refresh(mapPanel);
					// f.refreshAll(c, mapPanel, info);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case "INVENTORY":
				System.out.println("INVENTORY!");
				int l = ((MainCharacter) c).getBackpack().length;
				String answer = "";
				for (int i = 0; i < l; i++) {
					if (i > 0) {
						answer += ", ";
					}
					if (((MainCharacter) c).getItem(i) == null) {
						answer+="Empty Space";
					} else {
						answer += ((MainCharacter) c).getItem(i);
					}

				}
				JFrame inventory = new JFrame();
				JOptionPane.showMessageDialog(inventory, answer);
				break;
			case "MENU":
				System.out.println("MENU!");
				String ans = JOptionPane.showInputDialog("Type save to save");
				if (ans.equals("save")) {
					System.exit(0);
				}
				break;
			case "SHOP":
				System.out.println("SHOP!");
				// String answer = "";
				// need to fix it so it changes main character
				String answ = JOptionPane.showInputDialog(
						"Type one to purchase potion(50), type two to purchase sword(150)");
				if (answ.equals("one")) {

				} else if (answ.equals("two")) {

				}
				break;
			}

		}

		/**
		 * Calls the move method for all the enemies in the game
		 */
		protected void cycleEnemyMoves() {

			ArrayList<Point> skip = new ArrayList<Point>();

			// Replace with static Floor variables
			for (int i = 0; i < Floor.width; i++) {
				for (int j = 0; j < Floor.length; j++) {
					if (f.getTile(i, j) instanceof Enemy) {

						boolean isRepeated = false;

						for (int k = 0; k < skip.size(); k++) {
							if (skip.get(k).x == f.getTile(i, j).p.x && skip.get(k).y == f.getTile(i, j).p.y) {
								isRepeated = true;
								k = skip.size();
							}
						}

						if (!isRepeated) {
							skip.add(((Enemy) f.getTile(i, j)).move(f));
						}
					}
				}
			}
			// makes enemies attack
			for (int i = 0; i < Floor.width; i++) {
				for (int j = 0; j < Floor.length; j++) {
					if (f.getTile(i, j) instanceof Enemy) {

						((Enemy) f.getTile(i, j)).attack(f);
					}
				}
			}
			f.printFloor();
			try {
				IO.writeMap(f, "MapTxtFiles/Floor1_" + Floor.currentFloorID.x
						+ "x" + Floor.currentFloorID.y);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	static class KeyReader extends ButtonListener implements KeyListener {

		/**
		 * Class for reading key presses
		 * 
		 * @param ch
		 *            (MainCharacter)
		 * @param map
		 *            (JPanel)
		 * @param info
		 *            (JPanel)
		 */
		public KeyReader(MainCharacter ch, JPanel map, JPanel info) {
			super("", ch, map, info);
			// win = window;
		}

		/*
		 * Checks which key was pressed and responds accordingly
		 */
		public void keyPressed(KeyEvent e) {
			// super.actionPerformed((ActionEvent) e); // doesn't work
			int key = e.getKeyCode();

			if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
				moveUp();
			} else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
				moveDown();
			} else if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
				moveLeft();
			} else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
				moveRight();
			} else if (key == KeyEvent.VK_Q) {
				attack();
			}
		}

		/**
		 * Move character upwards. Called during the proper keypress.
		 */
		private void moveUp() {
			System.out.println("UP!");
			try {
				System.out.println(Floor.currentFloorID);
				f = c.moveUp();
				cycleEnemyMoves();
				// c.surroundObjs();
				f.refresh(mapPanel);
				// f.refreshAll(c, mapPanel, info);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		/**
		 * Move character downwards. Called during the proper keypress.
		 */
		private void moveDown() {
			System.out.println("DOWN!");
			try {
				f = c.moveDown();
				cycleEnemyMoves();
				// c.surroundObjs();
				f.refresh(mapPanel);
				// f.refreshAll(c, mapPanel, info);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		/**
		 * Move character to the left. Called during the proper keypress.
		 */
		private void moveLeft() {
			System.out.println("LEFT!");
			try {
				f = c.moveLeft();
				cycleEnemyMoves();
				// c.surroundObjs();
				f.refresh(mapPanel);
				// f.refreshAll(c, mapPanel, info);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		/**
		 * Move character to the right. Called during the proper keypress.
		 */
		private void moveRight() {
			System.out.println("RIGHT!");
			try {
				f = c.moveRight();
				cycleEnemyMoves();
				// c.surroundObjs();
				f.refresh(mapPanel);
				// f.refreshAll(c, mapPanel, info);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		/**
		 * Has character attack all surrounding enemies (determined by
		 * surrObjs() method). Called during proper keypress.
		 */
		private void attack() {
			System.out.println("ATTACK!");

			// f.getTile(new Point(c.p.x, c.p.y - 1)).invert();
			try {
				f = ((Character) c).attack();
			} catch (InterruptedException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			cycleEnemyMoves();
			f.refresh(mapPanel);
			// f.refreshAll(c, mapPanel, info);
			// c.surroundObjs();

		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			// Dont worry about code here
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			// Dont worry about code here
		}
	}

}
