// Written by Jacob Krucinski on 5/11/18
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Tile extends JPanel {
	
	private final Color bg = new Color(251, 214, 159);
	private BufferedImage ground = Floor.grass;
	
	private BufferedImage sprite;
	private String imageType;
	protected Point p;				// protected so subclasses can see this
	
	public Tile(BufferedImage img) {
		sprite = img;
	}
	
	public Tile(BufferedImage img, String name, Point location) {
		sprite = img;
		imageType = name;
		p = location;		// the r & c value of the tile in the Floor object
	}
	
    public void paintComponent (Graphics g) {
    	super.paintComponent(g);
    	
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(ground, 0, 0, getWidth(), getHeight(), null);
        g2d.drawImage(sprite, 0, 0, getWidth(), getHeight(), null);

        
        // draw a perimeter
        g.setColor(Color.BLACK);
     	g.drawRect(0, 0, getWidth(), getHeight());    
    }
    
    private BufferedImage overlayImages(BufferedImage bg, BufferedImage fg) {
    	Graphics2D g = bg.createGraphics();
    	
//        // Set Antialias Rendering
//        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//                RenderingHints.VALUE_ANTIALIAS_ON);

        g.drawImage(bg, getWidth(), getHeight(), null);

        g.drawImage(fg, getWidth(), getHeight(), null);
 
        //g.dispose();
        
        return bg;
    }
    
    public String getImageType() {
    	return imageType;
    }
    
    public void setImage(BufferedImage img) {
    	sprite = img;
    }
    
    public Point getPoint( ) {
    	return p;
    }
    
    public void setPoint(Point pt) {
    	p = pt;
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
    
    public boolean isWalkable(String type) {
    	switch (type) {
    		
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
