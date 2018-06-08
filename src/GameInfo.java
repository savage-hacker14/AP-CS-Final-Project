// Written by JAcob Krucinski on 5/21/18
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

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
		characterStatus[0] = new JLabel("Health: 100%");
		characterStatus[1] = new JLabel("Magic");
		characterStatus[2] = new JLabel("Attack: ___");
		
		// init current map view
		// do later
	}
	
	public static JPanel generatePanel(Floor f, MainCharacter c, JPanel mapPanel) {
		JPanel panel = new JPanel();
		
		init();
		
		for (int i = 0; i < buttons.length; i++) {
			String buttonName = buttons[i].getText();
			buttons[i].addActionListener(new ButtonListener(buttonName, c, f, mapPanel));
			buttons[i].addKeyListener(new KeyReader(c, f, mapPanel));
			panel.add(buttons[i]);
		}
		
		for (int i = 0; i < characterStatus.length; i++) {
			panel.add(characterStatus[i]);
		}
		
		// doesn't seem to work
		//panel.addKeyListener(new KeyReader(c, f, mapPanel));
		
		return panel;
	}
	
	static class ButtonListener implements ActionListener {
		
		protected String button;
		protected MainCharacter c;
		protected Floor f;
		protected JPanel mapPanel;
		
		// Class for reading button clicks
		public ButtonListener(String buttonTxt, MainCharacter ch, Floor fl, JPanel map) {
			button = buttonTxt;
			c = ch;
			f = fl;
			mapPanel = map;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			switch (button) {
			case "ATTACK":
				System.out.println("ATTACK!");
				cycleEnemyMoves();
				
				f = IO.loadInCurrentFloor();
				f.getTile(new Point(c.p.x, c.p.y - 1)).invert(f);
//				try {
//					((Character) c).attack();
//				} catch (InterruptedException e3) {
//					// TODO Auto-generated catch block
//					e3.printStackTrace();
//				}
				f.refresh(mapPanel);
				//c.surroundObjs();
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
					f.refresh(mapPanel);
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
					f.refresh(mapPanel);
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
					f.refresh(mapPanel);
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
					f.refresh(mapPanel);
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
				//need to fix it so it changes main character
				answer = JOptionPane.showInputDialog("Type one to purchase potion(50), type two to purchase sword(150)");
				if(answer.equals("one")) {
					
				}else if(answer.equals("two")){
					
				}
				break;
			}
			
		}
		
		protected void cycleEnemyMoves() {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 16; j++) {
					if (f.getTile(i, j) instanceof Enemy) {
						((Enemy)f.getTile(i, j)).move(f);
					}
				}
			}
		}
		
	}
	
	static class KeyReader extends ButtonListener implements KeyListener {
	
			// Class for reading button clicks
			public KeyReader(MainCharacter ch, Floor fl, JPanel map) {
				super("", ch, fl, map);
				//win = window;
			}
			
			// Make this method more efficient
			public void keyPressed(KeyEvent e) {
				//super.actionPerformed((ActionEvent) e);		// doesn't work
				int key = e.getKeyCode();
				
				if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
					moveUp();
				} 
				else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
					moveDown();
				} 
				else if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
					moveLeft();
				} 
				else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
					moveRight();
				}
				else if (key == KeyEvent.VK_Q) {
					attack();
				}		
			}
			
			private void moveUp() {
				System.out.println("UP!");
				try {
					System.out.println(Floor.currentFloorID);
					f = c.moveUp();
					cycleEnemyMoves();
					f.refresh(mapPanel);
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
					f.refresh(mapPanel);
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
					f.refresh(mapPanel);
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
					f.refresh(mapPanel);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			private void attack() {
				System.out.println("ATTACK!");
				//cycleEnemyMoves();
				
				//((Character) c).attack();
				c.invert(f);
				f = IO.loadInCurrentFloor();
				f.refresh(mapPanel);
				//c.surroundObjs();
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
