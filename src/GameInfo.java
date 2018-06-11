
// Written by JAcob Krucinski on 5/21/18
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameInfo {
	private static JButton[] buttons;
	private static JLabel[] characterStatus;
	private static BufferedImage currentMapView;

	private static void init() {

		// init buttons
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
		characterStatus = new JLabel[3];
		characterStatus[0] = new JLabel("Health: ");
		characterStatus[1] = new JLabel("Magic");
		characterStatus[2] = new JLabel("Attack: ");

		// init current map view
		// do later
	}

	public static JPanel generatePanel(MainCharacter c, JPanel mapPanel) {
		JPanel panel = new JPanel();

		init();

		for (int i = 0; i < buttons.length; i++) {
			String buttonName = buttons[i].getText();
			buttons[i].addActionListener(new ButtonListener(buttonName, c, mapPanel, panel));
			buttons[i].addKeyListener(new KeyReader(c, mapPanel, panel));
			panel.add(buttons[i]);
		}
		
		characterStatus[0].setText(characterStatus[0].getText() + c.getHealth() + "%");
		characterStatus[2].setText(characterStatus[2].getText() + c.getAttack() + "%");
		for (int i = 0; i < characterStatus.length; i++) {
			panel.add(characterStatus[i]);
		}

		// doesn't seem to work
		// panel.addKeyListener(new KeyReader(c, f, mapPanel));

		return panel;
	}

	static class ButtonListener implements ActionListener {

		protected String button;
		protected MainCharacter c;
		protected JPanel mapPanel;
		protected JPanel info;
		protected Floor f = IO.loadInCurrentFloor();

		// Class for reading button clicks
		public ButtonListener(String buttonTxt, MainCharacter ch, JPanel map, JPanel i) {
			button = buttonTxt;
			c = ch;
			mapPanel = map;
			info = i;
		}

		@Override
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
				//f.refreshAll(c, mapPanel, info);
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
					//c.surroundObjs();
					f.refresh(mapPanel);
					//f.refreshAll(c, mapPanel, info);
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
					//c.surroundObjs();
					f.refresh(mapPanel);
					//f.refreshAll(c, mapPanel, info);
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
					//c.surroundObjs();
					f.refresh(mapPanel);
					//f.refreshAll(c, mapPanel, info);
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
					//c.surroundObjs();
					f.refresh(mapPanel);
					//f.refreshAll(c, mapPanel, info);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case "INVENTORY":
				System.out.println("INVENTORY!");
				break;
			case "MENU":
				System.out.println("MENU!");
				break;
			case "SHOP":
				System.out.println("SHOP!");
				String answer = "";
				// need to fix it so it changes main character
				answer = JOptionPane
						.showInputDialog("Type one to purchase potion(50), type two to purchase sword(150)");
				if (answer.equals("one")) {

				} else if (answer.equals("two")) {

				}
				break;
			}

		}

		// What does this do Matt?
		protected void cycleEnemyMoves() {

			ArrayList<Point> skip = new ArrayList<Point>();

			// Replace with static Floor variables
			for (int i = 0; i < Floor.width; i++) {
				for (int j = 0; j < Floor.length; j++) {
					if (f.getTile(i, j) instanceof Enemy) {

						boolean isRepeated = false;

						for (int k = 0; k < skip.size(); k++) {
							if (skip.get(k).x == f.getTile(i, j).p.x) {
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
			f.printFloor();
			try {
				IO.writeMap(f, "MapTxtFiles/Floor1_" + Floor.currentFloorID.x + "x" + Floor.currentFloorID.y);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	static class KeyReader extends ButtonListener implements KeyListener {

		// Class for reading button clicks
		public KeyReader(MainCharacter ch, JPanel map, JPanel info) {
			super("", ch, map, info);
			// win = window;
		}

		// Make this method more efficient
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

		private void moveUp() {
			System.out.println("UP!");
			try {
				System.out.println(Floor.currentFloorID);
				f = c.moveUp();
				cycleEnemyMoves();
				f.refreshAll(c, mapPanel, info);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		private void moveDown() {
			System.out.println("DOWN!");
			try {
				f = c.moveDown();
				cycleEnemyMoves();
				f.refreshAll(c, mapPanel, info);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		private void moveLeft() {
			System.out.println("LEFT!");
			try {
				f = c.moveLeft();
				cycleEnemyMoves();
				f.refreshAll(c, mapPanel, info);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		private void moveRight() {
			System.out.println("RIGHT!");
			try {
				f = c.moveRight();
				cycleEnemyMoves();
				f.refreshAll(c, mapPanel, info);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		private void attack() {
			System.out.println("ATTACK!");
			// cycleEnemyMoves();

			// f.getTile(new Point(c.p.x, c.p.y - 1)).invert();
			try {
				f = ((Character) c).attack();
			} catch (InterruptedException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			f.refreshAll(c, mapPanel, info);
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
