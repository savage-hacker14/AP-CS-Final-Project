// Written by Jacob Krucinski on 5/11/18
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Tile extends JPanel {
	
	private final Color bg = new Color(251, 214, 159);
	private BufferedImage ground;
	
	private BufferedImage sprite;
	private String imageType;
	protected Point p;				// protected so subclasses can see this
	
	public Tile(BufferedImage img) {
		sprite = img;
	}
	
	public Tile(BufferedImage sprit, BufferedImage BG, String name, Point location) {
		sprite = sprit;
		imageType = name;
		ground = BG;
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
    
    public BufferedImage getBG() {
    	return ground;
    }
    
    public BufferedImage getSprite() {
    	return sprite;
    }
    
    public BufferedImage invert() {
    	
    	for (int x = 0; x < sprite.getWidth(); x++) {
            for (int y = 0; y < sprite.getHeight(); y++) {
                int rgba = sprite.getRGB(x, y);
                Color col = new Color(rgba, true);
                col = new Color(255 - col.getRed(),
                                255 - col.getGreen(),
                                255 - col.getBlue());
                sprite.setRGB(x, y, col.getRGB());
            }
        }
    	
    	return sprite;
    }
    
    public String getImageType() {
    	return imageType;
    }
    
    public void setImageType(String str) {
    	imageType = str;
    }
    
    public String getBGImageType() {
    	//bg.get
    }
    
    public void setSprite(BufferedImage img) {
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
