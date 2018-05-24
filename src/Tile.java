// Written by Jacob Krucinski on 5/11/18
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Tile extends JPanel {
	
	private final Color bg = new Color(251, 214, 159);
	private BufferedImage image;
	private String imageType;
	private Point p;
	
	public Tile(BufferedImage img) {
		image = img;
	}
	
	public Tile(BufferedImage img, String name) {
		image = img;
		imageType = name;
	}
	
    public void paintComponent (Graphics g) {
    	
        // draw regular image
    	//g.drawImage(image, 0, 0, frame.getWidth() / numR, frame.getHeight() / numC, null);
    	//g.drawImage(image, 0, 0, getWidth() - 10, getHeight() - 10, null);
        
        // draw a perimeter
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth(), getHeight());
        
        // draw tan background
        setBackground(Color.BLACK);
        //g.setColor(Color.black);
        //g.drawRect(0, 0, getWidth(), getHeight());
    }
    
    public void setImage(BufferedImage img) {
    	image = img;
    }
    public boolean isWalkable() {
    	switch (imageType) {
    		
    	case "Grass":
    		return true;
    	case "Chilli":
    		return true;
    	case "PotionRed":
    		return true;
    	case "Wood":
    		return true;
    	}
    	
    	return false;
    }
}
