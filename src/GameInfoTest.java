// Written by JAcob Krucinski on 5/21/18
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.*;

public class GameInfoTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		JFrame window = new JFrame();
		Container pane = window.getContentPane();
		window.setTitle("Custom Floor");
		window.setSize(200, 200);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// allows program termination when x is clicked on
		pane.setLayout(new GridLayout(1, 1));
		
		pane.add(GameInfo.generatePanel());
		window.repaint();
	}

}
