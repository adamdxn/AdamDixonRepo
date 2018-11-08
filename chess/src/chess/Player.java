package chess;

/*
 * Object to represent a chess player.
 */
public class Player {
	private String color;
	private TileDecoder td;
	
	Player(String color){
		this.color = color;
		this.td = new TileDecoder();
	}
	
	/*
	 * Given two tiles, return true if the player can move or capture the piece on tile t2.
	 * Return false if the piece is the opponents or the piece cannot move to from t1 to t2.
	 */
	public boolean makeMove(Board b, Tile t1, Tile t2) {
		Coordinate initialPos = td.decode(t1);
		Coordinate finalPos = td.decode(t2);
		
		Move move = new Move(b, initialPos, finalPos);
		
		Piece piece = b.getPiece(initialPos);
		
		if (!piece.getColor().equals(color) || !move.canMakeMove())
			return false;
		// Capture
		else if (b.isOccupied(finalPos))
			return b.capture(initialPos, finalPos);
		// Move
		else
			return b.movePiece(initialPos, finalPos);
	}
	
	public String getColor() {
		return this.color;
	}
}
