// Written by Jacob Krucinski on 5/11/18
import java.awt.*;
import javax.swing.*;

public class SubImagePanel extends JPanel {
	private Image image;
	private JFrame frame;
	
	public SubImagePanel(Image img, JFrame window, Point[] subImgCornersToSet) {
		image = img;
		frame = window;
	}
	
    public void paintComponent (Graphics g) {
        int imgW = image.getWidth(null);
        int imgH = image.getHeight(null);

        // draw sub image based on subImgCorners
        g.drawImage(image, 0, 0, frame.getWidth(), frame.getHeight(), subImgCorners[0].x, subImgCorners[0].y, 
        		subImgCorners[1].x, subImgCorners[1].y, null);
        
        /*
         * img - the specified image to be drawn. This method does nothing if img is null.
         * dx1 - the x coordinate of the first corner of the destination rectangle.
         * dy1 - the y coordinate of the first corner of the destination rectangle.
         * dx2 - the x coordinate of the second corner of the destination rectangle.
         * dy2 - the y coordinate of the second corner of the destination rectangle.
         * sx1 - the x coordinate of the first corner of the source rectangle.
         * sy1 - the y coordinate of the first corner of the source rectangle.
         * sx2 - the x coordinate of the second corner of the source rectangle.
         * sy2 - the y coordinate of the second corner of the source rectangle.
         * observer - object to be notified as more of the image is scaled and converted.
         */
    }
}