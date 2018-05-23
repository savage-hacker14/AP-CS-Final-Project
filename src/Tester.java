import java.awt.Container;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tester {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JFrame window = new JFrame();
		Container pane = window.getContentPane();
		window.setTitle("Custom Floor");
		window.setSize(200, 200);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// allows program termination when x is clicked on
		pane.setLayout(new GridLayout(2,1));
		
		//load in floor from text file
		JPanel map = new JPanel();
		String filepath = "MapTxtFiles/Floor1";
		char[][] testArr = IO.readMapFromTxt(filepath);
		//IO.printMap(testArr);
		Floor testFloor = new Floor(testArr);
		int rows = 9;
		int cols = 16;
		map.setLayout(new GridLayout(rows, cols));
		// Fill window
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				map.add(testFloor.getTile(r, c));
			}
		}
		pane.add(map);
		
		
		//create game info panel
		JPanel gameInfo = GameInfo.generatePanel();
		pane.add(gameInfo);
		window.repaint();
		
	
	}

}