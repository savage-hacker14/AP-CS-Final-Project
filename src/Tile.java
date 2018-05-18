// Written by Jacob Krucinski on 5/11/18
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Tile extends JPanel {
	private BufferedImage image;
	
	public Tile(BufferedImage img) {
		image = img;
	}
	
    public void paintComponent (Graphics g) {
    	
        // draw regular image
    	//g.drawImage(image, 0, 0, frame.getWidth() / numR, frame.getHeight() / numC, null);
    	g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        
        // draw a perimeter
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth(), getHeight());
    }
    
    public void setImage(BufferedImage img) {
    	image = img;
    }
}
