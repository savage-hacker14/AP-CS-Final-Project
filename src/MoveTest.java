import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Point;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.synth.SynthSpinnerUI;

public class MoveTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		JFrame window = new JFrame();
		Container pane = window.getContentPane();
		window.setTitle("Test Moves");
		window.setSize(300, 300);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// allows program termination when x is clicked on
		pane.setLayout(new GridLayout(2,1));
		pane.setBackground(Color.LIGHT_GRAY);
		
		//load in floor from text file
		JPanel map = new JPanel();
		String filepath = "MapTxtFiles/TestCharacterMoves";
		char[][] testArr = IO.readMapFromTxt(filepath);
		//IO.printMap(testArr);
		Floor testFloor = new Floor(testArr);
		int rows = 9;
		int cols = 16;
		map.setLayout(new GridLayout(rows, cols));
		
		// Fill window
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				//testFloor.getTile(r, c).setOpaque(true);
				map.add(testFloor.getTile(r, c));
			}
		}
		pane.add(map);
		window.revalidate();
		window.repaint();
		
		
		// try moves
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Point charPos = testFloor.findChar();
		System.out.println("Old Map:");
		testFloor.printFloor();
		
		testFloor.moveTile(testFloor.findChar(), new Point(charPos.x + 1, charPos.y));
		testFloor.setTile(new Tile(Floor.lava, "Lava", new Point(0, 0)), new Point(0, 0));
		testFloor.refresh(map);
		
		testFloor = new Floor(testFloor.getFloor());
		window.repaint();
		window.revalidate();
		System.out.println("\n");
		System.out.println("New Map:");
		testFloor.printFloor();
	}

}
