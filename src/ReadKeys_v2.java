// Written by Jacob Krucinski on 5/11/18
// Import key listener packages
// a comment was added here by Jacob
import java.awt.event.*;
import javax.swing.*;

public class ReadKeys_v2 {
	
	public static void main(String[] args) {
		// Set up GUI for testing
		JFrame window = new JFrame("ReadKeys");
		window.setSize(200, 50);
		JTextField tf = new JTextField();
		window.add(tf);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		KeyListener k = new KeyListener();
		tf.addKeyListener(k);
	}
	
	static class KeyListener extends KeyAdapter {
		
		public void keyPressed(KeyEvent event) {
			int code = event.getKeyCode();
			
			switch (code) {
				case 37:
					System.out.println("Left arrow");
					break;
					
				case 38:
					System.out.println("Up arrow");
					break;
					
				case 39:
					System.out.println("Right arrow");
					break;
					
				case 40:
					System.out.println("Down arrow");
					break;
					
				default:
					System.out.println("Not an arrow key!");
			}
		}
	}
}