package chess;

/*
 * A tile has an (x,y) position and a chess name (a4 for example)
 */
public class Tile {
	
	private String tile;
	private Coordinate coodrinate;
	
	Tile (String tile){
		this.tile = tile;
	}
	
	public String getTile() {
		return tile;
	}

	public Coordinate getCoodrinate() {
		return coodrinate;
	}

	public void setCoodrinate(Coordinate coodrinate) {
		this.coodrinate = coodrinate;
	}
	

	
}
