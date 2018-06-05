// Written by JAcob Krucinski on 5/21/18
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.image.BufferedImage;
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
			panel.add(buttons[i]);
		}
		
		for (int i = 0; i < characterStatus.length; i++) {
			panel.add(characterStatus[i]);
		}
		
		return panel;
	}
	
	static class ButtonListener implements ActionListener {
		
		private String button;
		private MainCharacter c;
		private Floor f;
		private JPanel mapPanel;
		
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
				c.attack(f);
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
		
		private void cycleEnemyMoves() {
			for (int i = 0; i < f.length; i++) {
				for (int j = 0; j < f.width; j++) {
					if (f.getTile(j, i) instanceof Enemy) {
						((Enemy)f.getTile(i, j)).move(f);
					}
				}
			}
		}
		
	}
	
}
