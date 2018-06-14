// Written by Jacob Krucinski on 5/11/18
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Tile extends JPanel {
	
	private final Color bg = new Color(251, 214, 159);
	private BufferedImage ground;
	
	private BufferedImage sprite;
	private String spriteType;
	private String groundType;
	protected Point p;				// protected so subclasses can see this
	
	/**
	 * Old constructor (deprecated)
	 * @param img
	 * @deprecated
	 */
	public Tile(BufferedImage img) {
		sprite = img;
	}
	
	/**
	 * Create a Tile object from a previous Tile object
	 * @param til
	 */
	public Tile(Tile til) {
		sprite = til.getSprite();
		spriteType = til.getSpriteType();
		ground = til.getBG();
		groundType = til.getBGImageType();
		p = til.p;
	}
	
	/**
	 * Main constructor for Tile objects
	 * @param sprite 		(BufferedImage)
	 * @param background 	(BufferedImage)
	 * @param spriteName 	(String)
	 * @param groundType	(String)
	 * @param location		(Point)
	 */
	public Tile(BufferedImage sprit, BufferedImage BG, String name, String grndType, Point location) {
		sprite = sprit;
		spriteType = name;
		ground = BG;
		groundType = grndType;
		p = location;		// the r & c value of the tile in the Floor object
	}
	
	/**
	 * Method for drawing Tile objects in GUI
	 */
    public void paintComponent (Graphics g) {
    	super.paintComponent(g);
    	
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(ground, 0, 0, getWidth(), getHeight(), null);
        g2d.drawImage(sprite, 0, 0, getWidth(), getHeight(), null);
        // draw a perimeter
        g.setColor(Color.BLACK);
     	g.drawRect(0, 0, getWidth(), getHeight());    
    }
    
    /**
     * Get background image
     * @return
     */
    public BufferedImage getBG() {
    	return ground;
    }
    
    /**
     * Set background image
     * @return
     */
    public void setBG(BufferedImage newBG) {
    	ground = newBG;
    }
    
    /**
     * Get sprite image
     * @return BufferedImage
     */
    public BufferedImage getSprite() {
    	return sprite;
    }
    
    /**
     * Invert method: Inverts color mapping for sprite image
     */
    public void invert() {  	
    	
    	BufferedImage img = null;
		try {
			img = ImageIO.read(new File("Sprites/" + getSpriteType() + ".png"));
			//System.out.println("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                int rgba = img.getRGB(x, y);
                if (rgba >> 24 != 0x00) {
	                Color col = new Color(rgba, true);
	                col = new Color(255 - col.getRed(),
	                                255 - col.getGreen(),
	                                255 - col.getBlue());
	                img.setRGB(x, y, col.getRGB());
                }
            }
        }
    	System.out.println("done inverting");
    	
    	//Floor f = IO.loadInCurrentFloor();
    	setSprite(img);
    	
    	//IO.writeMap(f, IO.currentFloor());
    	System.out.println("sprite set");
    }
    
    /**
     * Get sprite name/type
     * @return string
     */
    public String getSpriteType() {
    	return spriteType;
    }
    
    /**
     * Set sprite name/type
     * @param str
     */
    public void setSpriteType(String str) {
    	spriteType = str;
    }
    
    /**
     * Get the background image name/type
     * @return
     */
    public String getBGImageType() {
    	return groundType;
    }
    
    public void setBGImageType(String newBGName) {
    	groundType = newBGName;
    }
    
    /**
     * Set sprite image
     * @param img
     */
    public void setSprite(BufferedImage img) {
    	sprite = img;
    }
    
    /**
     * Get point/location of Tile in Floor
     * @return
     */
    public Point getPoint() {
    	return p;
    }
    
    /**
     * Set location of Tile in Floor
     * @param Point
     */
    public void setPoint(Point pt) {
    	p = pt;
    }
    
    /**
     * Returns true if Tile (& sprite) can walk onto this Tile type
     * @return boolean
     */
    public boolean isWalkable() {
    	switch (spriteType) {
    		
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
    
    /**
     * Returns all Tile objects that surround a tile
     * @return adjacent tiles (5 to 8)
     */
    public Tile[] surroundObjs() {
		// Load in the current floor id floor
		Floor f = IO.loadInCurrentFloor();
		String[][] map;

		// will store surrounding tiles
		ArrayList<Tile> tiles = new ArrayList<Tile>();

		// array of all surrounding cell coordinates
		Point[] surr = new Point[8];
		surr[0] = new Point(p.x - 1, p.y - 1);
		surr[1] = new Point(p.x - 1, p.y);
		surr[2] = new Point(p.x - 1, p.y + 1);
		surr[3] = new Point(p.x, p.y - 1);
		surr[4] = new Point(p.x, p.y + 1);
		surr[5] = new Point(p.x + 1, p.y - 1);
		surr[6] = new Point(p.x + 1, p.y);
		surr[7] = new Point(p.x + 1, p.y + 1);

		for (int i = 0; i < surr.length; i++) {
			boolean validPoint = surr[i].x >= 0 && surr[i].x < Floor.width && surr[i].y >= 0
					&& surr[i].y < Floor.length;
			if (validPoint) {
				Tile surrTile = f.getTile(surr[i]);
				//System.out.println(surrTile.toString());
				tiles.add(surrTile);
			}
		}

		// convert arrayList to arr
		Tile[] tilesArr = new Tile[tiles.size()];
		for (int i = 0; i < tilesArr.length; i++) {
			tilesArr[i] = tiles.get(i);
		}

//		// for debug, print out array
//		for (int i = 0; i < tilesArr.length; i++) {
//			System.out.println(tilesArr[i]);
//		}

		// return array
		return tilesArr;
	}
    
    /**
     * Returns true if Tile (& sprite) can walk onto this Tile type
     * @param type
     * @return
     */
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
    
    /**
     * Generate string with Tile information
     */
    public String toString() {
    	String temp = "";
    	temp += "Sprite: " + this.spriteType + "\n";
    	temp += "Background: " + this.getBGImageType() + "\n";
    	temp += "Location: " + p.toString() + "\n";
    	return temp;
    	
    }
    
}
