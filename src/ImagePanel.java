// Written by Jacob Krucinski on 5/11/18
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class ImagePanel extends JPanel {
	private BufferedImage image;
	private JFrame frame;
	
	public ImagePanel(BufferedImage img, JFrame window) {
		image = img;
		frame = window;
	}
	
    public void paintComponent (Graphics g) {
        int imgW = image.getWidth(null);
        int imgH = image.getHeight(null);

        // draw regular image
        g.drawImage(image, 0, 0, frame.getWidth(), frame.getHeight(), null);
    }
    
    public void setImage(BufferedImage img) {
    	image = img;
    }
}
