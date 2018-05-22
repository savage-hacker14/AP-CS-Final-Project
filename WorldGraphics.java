// Written by Jacob Krucinski on 5/11/18
// Import key listener packages
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class WorldGraphics {
	private static String imgFilePath = "ZeldaWorld_1000x1000.png";
	// should be tied to project so no file path required
	
	private static int subImgW = 100;
	private static int subImgH = 100;
	private static int frameMovmt = 20;
	private static Image zeldaWorldImg;
	private static Point subImgCorner = new Point(subImgW, subImgH);
	
	// Class JFrame variable
	private static JFrame window;
		
	public static void main(String[] args) throws IOException, InterruptedException {
		// Set up GUI for world
		window = new JFrame("Zelda World");
		Container pane = window.getContentPane();
		window.setSize(800, 800);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel[][] panelArr = new JPanel[3][1];		
		pane.setLayout(new GridLayout(3, 1));
		
		// Init graphics variables
		JTextField tf = new JTextField();
		//window.add(tf);					// for inputting keystrokes
		//tf.setVisible(false);
		
		KeyListener k = new KeyListener();
		tf.addKeyListener(k);
		
		ImageIcon zeldaWorldIcon = new ImageIcon(imgFilePath);	// image of Zelda world
		zeldaWorldImg = zeldaWorldIcon.getImage();
		
		BufferedImage a = ImageIO.read(new File(imgFilePath));
		
		// Set up panels for window
		panelArr[0][0] = new JPanel();
		panelArr[0][0].add(tf);
		//panelArr[0][0].setVisible(false);
		pane.add(panelArr[0][0]);
		
		panelArr[1][0] = new ImagePanel(a, window, subImgCorner, subImgW, subImgH);
		pane.add(panelArr[1][0]);
		
		BufferedImage subImg = a.getSubimage(subImgCorner.x, subImgCorner.y, subImgW, subImgH);
		//BufferedImage subImage = a.getSubimage(700, 100, subImgW, subImgH);JFrame.EXIT_ON_CLOSE);

		panelArr[2][0] = new ImagePanel(subImg, window);
		pane.add(panelArr[2][0]);
		
		while (true) {
			subImg = a.getSubimage(subImgCorner.x, subImgCorner.y, subImgW, subImgH);
			//BufferedImage subImage = a.getSubimage(700, 100, subImgW, subImgH);
			((ImagePanel) panelArr[2][0]).setImage(subImg);
			window.repaint();
			Thread.sleep(1000);
		}
	}
	
	public static void subImgCornerLeftArrow() {
		int newX = subImgCorner.x - frameMovmt;
		
		if (newX < 0) {
			newX = 0;
		}

		subImgCorner.setLocation(newX, subImgCorner.y);
	}
	
	public static void subImgCornerRightArrow() {
		int newX = subImgCorner.x + frameMovmt;
		newX = Math.min(newX, zeldaWorldImg.getWidth(null));
		
		subImgCorner.setLocation(newX, subImgCorner.y);
	}
	
	public static void subImgCornerUpArrow() {
		int newY = subImgCorner.y - frameMovmt;
		
		if (newY < 0) {
			newY = 0;
		}
		
		subImgCorner.setLocation(subImgCorner.x, newY);
	}
	
	public static void subImgCornerDownArrow() {
		int newY = subImgCorner.y + frameMovmt;
		newY = Math.min(newY, zeldaWorldImg.getHeight(null));

		subImgCorner.setLocation(subImgCorner.x, newY);
	}
	
	// Class for reading key presses
	static class KeyListener extends KeyAdapter {
		
		public void keyPressed(KeyEvent event) {
			int code = event.getKeyCode();
			
			window.repaint();
			
			switch (code) {
				case 37:
					System.out.println("Left arrow");
					System.out.println(subImgCorner);
					subImgCornerLeftArrow();
					break;
					
				case 38:
					System.out.println("Up arrow");
					System.out.println(subImgCorner);
					subImgCornerUpArrow();
					break;
					
				case 39:
					System.out.println("Right arrow");
					System.out.println(subImgCorner);
					subImgCornerRightArrow();
					break;
					
				case 40:
					System.out.println("Down arrow");
					System.out.println(subImgCorner);
					subImgCornerDownArrow();
					break;
					
				default:
					System.out.println("Not an arrow key!");
			}
		}
	}
}
