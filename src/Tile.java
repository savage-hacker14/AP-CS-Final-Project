// Written by Jacob Krucinski on 5/11/18
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.*;

public class Tile extends JPanel {
	
	private final Color bg = new Color(251, 214, 159);
	private BufferedImage ground;
	
	private BufferedImage sprite;
	private String spriteType;
	private String groundType;
	protected Point p;				// protected so subclasses can see this
	
	public Tile(BufferedImage img) {
		sprite = img;
	}
	
	public Tile(BufferedImage sprit, BufferedImage BG, String name, String grndType, Point location) {
		sprite = sprit;
		spriteType = name;
		ground = BG;
		groundType = grndType;
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
    
    public String getSpriteType() {
    	return spriteType;
    }
    
    public void setImageType(String str) {
    	spriteType = str;
    }
    
    public String getBGImageType() {
    	return groundType;
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
    public Tile[] surroundObjs(Floor f) {
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
			boolean validPoint = surr[i].x >= 0 && surr[i].x < Floor.length && surr[i].y >= 0
					&& surr[i].y < Floor.width;
			if (validPoint) {
				Tile surrTile = f.getTile(surr[i]);
				tiles.add(surrTile);
			}
		}

		// convert arrayList to arr
		Tile[] tilesArr = new Tile[tiles.size()];
		for (int i = 0; i < tilesArr.length; i++) {
			tilesArr[i] = tiles.get(i);
		}

		// for debug, print out array
		for (int i = 0; i < tilesArr.length; i++) {
			System.out.println(tilesArr[i].getImageType().substring(0, 1));
		}

		// return array
		return tilesArr;
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
