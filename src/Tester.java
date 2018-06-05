import java.awt.*;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tester {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JFrame window = new JFrame();
		Container pane = window.getContentPane();
		window.setTitle("Custom Floor");
		window.setSize(300, 300);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// allows program termination when x is clicked on
		pane.setLayout(new GridLayout(2,1));
		pane.setBackground(Color.LIGHT_GRAY);
		
		//load in floor from text file
		JPanel map = new JPanel();
		String filepath = "MapTxtFiles/Floor1_0x0";
		String[][] testArr = IO.readMapFromTxt(filepath);
		//IO.printMap(testArr);
		Floor testFloor = new Floor(testArr, IO.strToFloorID(filepath));
		int rows = 9;
		int cols = 16;
		map.setLayout(new GridLayout(rows, cols));
		// Fill window
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				//testFloor.getTile(r, c).setOpaque(true);
				//testFloor.getTile(r, c).setSprite(testFloor.getTile(r, c).invert());
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
		JPanel gameInfo = GameInfo.generatePanel(testFloor, main, map);
		pane.add(gameInfo);
		window.repaint();
		
//		// test character moves
//		while (true) {
//			main.moveDown(testFloor);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			main.moveUp(testFloor);
//			window.repaint();
//		}
	
	}

}