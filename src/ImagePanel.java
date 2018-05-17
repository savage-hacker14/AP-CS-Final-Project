// Written by Jacob Krucinski on 5/11/18
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class ImagePanel extends JPanel {
	private BufferedImage image;
	private JFrame frame;
	
	// Only for use with subImg images
	private Point subImgCorner;
	private int subImgH;
	private int subImgW;
	
	public ImagePanel(BufferedImage img, JFrame window) {
		image = img;
		frame = window;
	}
	
	public ImagePanel(BufferedImage img, JFrame window, Point subImgCorner, int subW, int subH) {
		image = img;
		frame = window;
		subImgH = subH;
		subImgW = subW;
	}
	
    public void paintComponent (Graphics g) {
    	
        // draw regular image
    	// *** FIGURE OUT WHY THIS ISN'T WORKING!!! ***
        //g.drawImage(image, 0, 0, frame.getWidth(), frame.getHeight(), null);
    	g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
        
        // Draw box to represent zoomed in area (sub image)
        if (subImgCorner != null) {
        	g.setColor(Color.YELLOW);
            Graphics2D g2D = (Graphics2D) g;      
            g2D.setStroke(new BasicStroke(200F));  // set stroke width of 10
        	g2D.drawRect(subImgCorner.x, subImgCorner.y, subImgW, subImgH);
        }
        
        // draw a perimeter
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, frame.getWidth(), frame.getHeight());
    }
    
    public void setImage(BufferedImage img) {
    	image = img;
    }
}
