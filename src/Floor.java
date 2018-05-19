
public class Floor {

	private Tile[][] floorTiles;

	public Floor(Tile[][] arr) {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 16; j++) {
				floorTiles[i][j] = arr[i][j];
			}
		}

	}
	
	public Tile getTile(int x, int y) {
		return floorTiles[x][y];
	}
	
	public void setTile(Tile tile, int x, int y) {
		floorTiles[x][y] = tile;
	}

}
