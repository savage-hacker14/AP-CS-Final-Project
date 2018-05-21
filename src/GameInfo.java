// Written by JAcob Krucinski on 5/21/18

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
		buttons[2] = new JButton("UP");
		buttons[3] = new JButton("DOWN");
		buttons[4] = new JButton("LEFT");
		buttons[5] = new JButton("RIGHT");
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
			panel.add(buttons[i]);
		}
		
		for (int i = 0; i < characterStatus.length; i++) {
			panel.add(characterStatus[i]);
		}
		
		return panel;
	}
	
	static class ButtonListener extends KeyAdapter {
		// Class for reading button clicks
	}
}
