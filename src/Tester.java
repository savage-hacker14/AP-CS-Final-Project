import java.awt.*;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tester {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JFrame window = new JFrame();
		Container pane = window.getContentPane();
		window.setTitle("Zelda");
		window.setSize(500, 500);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// allows program termination when x is clicked on
		pane.setLayout(new GridLayout(2,1));
		pane.setBackground(Color.LIGHT_GRAY);
		
		// Checks to find player throughout whole map and returns floor ID point that finds him
		Point floorPt = IO.findPlayerFloorID("Floor1_", 3, 5);
		Floor.currentFloorID = floorPt;
		
//		//load in floor from text file
		JPanel map = new JPanel();
//		String filepath = "MapTxtFiles/Floor1_" + floorPt.x + "x" + floorPt.y;
//		String[][] testArr = IO.readMapFromTxt(filepath);
//		//IO.printMap(testArr);
		
		Floor testFloor = IO.loadInCurrentFloor();
		int rows = 9;
		int cols = 16;
		map.setLayout(new GridLayout(rows, cols));
		// Fill window
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				//testFloor.getTile(r, c).setSprite(testFloor.getTile(r, c).invert());
				//testFloor.getTile(r, c).invert();
				map.add(testFloor.getTile(r, c));
			}
		}
		pane.add(map);
		window.revalidate();
		window.repaint();
		
		MainCharacter main = new MainCharacter(Floor.player1, Floor.grass, "Player", "Grass", testFloor.findChar());
		//System.out.println(main.getPoint());
		testFloor.printFloor();
		
		//create game info panel
		JPanel gameInfo = GameInfo.generatePanel(main, map);
		pane.add(gameInfo);
		window.repaint();
	}

}