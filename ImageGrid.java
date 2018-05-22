// Written by Jacob Krucinski on 5/16/18

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageGrid {
	
	// String for image name
	private static final String imgName = "Sprites/Blob.png";
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		JFrame grid = new JFrame();
		Container pane = grid.getContentPane();
		grid.setTitle("Image Grid");
		
		
		String input = JOptionPane.showInputDialog("# of Rows: ");		// nice little dialogue box
		int rows = Integer.parseInt(input);								// Parse the strings input for char that forms the integer, will crash if string not completely an int
		String input2 = JOptionPane.showInputDialog("# of Columns: ");	// nice little dialogue box
		int cols = Integer.parseInt(input2);								// Parse the strings input for char that forms the integer, will crash if string not completely an int
		pane.setLayout(new GridLayout(rows, cols));
		
		Tile panelArray[][] = new Tile[rows][cols];
		grid.setSize(cols * 20, rows * 20);
		grid.setVisible(true);
		grid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// allows program termination when x is clicked on
		
		
		// Image to be displayed on all panels
		BufferedImage img = ImageIO.read(new File(imgName));
		//img = img.getSubimage(0, 0, 10, 10); 					// Limit image size to 10x10 pixels
		
		// Place image / sprite in all panels
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				panelArray[r][c] = new Tile(img);
				pane.add(panelArray[r][c]);
			}
		}
		
		
		grid.repaint();

	}

}
