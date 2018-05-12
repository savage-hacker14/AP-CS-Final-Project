// Import key listener packages
import java.awt.event.*;
import javax.swing.*;

public class ReadKeys {
	
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
			System.out.println(code);
		}
	}
}