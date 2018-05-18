// Written by Jacob Krucinski on 5/11/18
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class ImagePanel extends JPanel {
	private BufferedImage image;
	private JFrame frame;
	private int numR;
	private int numC;
	
	public ImagePanel(BufferedImage img, JFrame window, int r, int c) {
		image = img;
		frame = window;
		numR = r;
		numC = c;
	}
	
    public void paintComponent (Graphics g) {
    	
        // draw regular image
    	g.drawImage(image, 0, 0, frame.getWidth() / numR, frame.getHeight() / numC, null);
        
        // draw a perimeter
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, frame.getWidth(), frame.getHeight());
    }
    
    public void setImage(BufferedImage img) {
    	image = img;
    }
}
