// Written by JAcob Krucinski on 5/21/18
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.image.BufferedImage;
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
	
	public static JPanel generatePanel() {
		JPanel panel = new JPanel();
		
		init();
		
		for (int i = 0; i < buttons.length; i++) {
			String buttonName = buttons[i].getText();
			buttons[i].addActionListener(new ButtonListener(buttonName));
			panel.add(buttons[i]);
		}
		
		for (int i = 0; i < characterStatus.length; i++) {
			panel.add(characterStatus[i]);
		}
		
		return panel;
	}
	
	static class ButtonListener implements ActionListener {
		
		private String button;
		// Class for reading button clicks
		public ButtonListener(String buttonTxt) {
			button = buttonTxt;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			switch (button) {
			case "ATTACK":
				System.out.println("ATTACK!");
				break;
			case "DEFEND":
				System.out.println("DEFEND!");
				break;
			case "↑":
				System.out.println("UP!");
				break;
			case "↓":
				System.out.println("DOWN!");
				break;
			case "←":
				System.out.println("LEFT!");
				break;
			case "→":
				System.out.println("RIGHT!");
				break;
			case "INVENTORY":
				System.out.println("INVENTORY!");
				break;
			case "MENU":
				System.out.println("MENU!");
				break;
			case "SHOP":
				System.out.println("SHOP!");
				break;
			}
		}
	}
	
	private void moveUp(Point currentPos) {
		int newY = Math.min(Floor.length, currentPos.y + 1);
		Point newPos = new Point(currentPos.x, newY);
		Floor.setTile(tile, x, y);
	}
}
