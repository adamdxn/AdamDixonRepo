package chess;

public class Player {
	private String color;
	private String name;
	private boolean isHuman;
	private TileDecoder td;
	
	Player(String c, String n, boolean isHuman){
		this.color = c;
		this.name = n;
		this.isHuman = isHuman;
		this.td = new TileDecoder();
	}
	
	/*
	 * Given two tiles, return true if the player can move or capture the piece on tile t2.
	 * Return false if the piece is the opponents or the piece cannot move to from t1 to t2.
	 */
	public boolean makeMove(Tile t1, Tile t2, Board b) {
		Coordinate initialPos = td.decode(t1);
		Coordinate finalPos = td.decode(t2);
		Piece piece = b.getPiece(initialPos);
		Path path = new Path(finalPos, b, piece);
		// Check if you can move to that position
		if (!piece.getColor().equals(color) || !b.pieceCanMove(piece, finalPos) || !path.isClear())
			return false;
		// Capture
		else if (b.isOccupied(finalPos))
			return b.capture(initialPos, finalPos);
		// Move
		else
			return b.move(initialPos, finalPos);
	}
	
	public boolean isHuman() {
		return this.isHuman;
	}
	
	public static void main(String[] args) {
		Player p1 = new Player("Black", "Adam", true);
		Board board = new Board();
		System.out.println(board.getBoard());
		System.out.println(p1.makeMove(new Tile("a7"), new Tile("a6"), board));
		System.out.println(board.getBoard());
		System.out.println(p1.makeMove(new Tile("b8"), new Tile("c6"), board));
	}
}
