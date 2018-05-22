// Written by JAcob Krucinski on 5/21/18
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.*;

public class FloorTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		JFrame grid = new JFrame();
		Container pane = grid.getContentPane();
		grid.setTitle("Custom Floor");
		grid.setSize(200, 200);
		grid.setVisible(true);
		grid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// allows program termination when x is clicked on
		
		
		// Read in custom map
		String filepath = "MapTxtFiles/Floor1";
		char[][] testArr = IO.readMapFromTxt(filepath);
		//IO.printMap(testArr);
		Floor testFloor = new Floor(testArr);
		
		
		int rows = 9;
		int cols = 16;
		pane.setLayout(new GridLayout(rows, cols));
		// Fill window
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				pane.add(testFloor.getTile(r, c));
			}
		}
		grid.repaint();
	}

}
