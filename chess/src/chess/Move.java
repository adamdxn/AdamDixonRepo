package chess;

/*
 * Object to determine if a move is valid to make on a chess board. This object cannot 
 * change the state of the board
 */
public class Move {
	private Coordinate initialPosition;
	private Coordinate finalPosition;
	private Board board;
	private Piece piece;
	private TileDecoder td;
	
	Move(Board board, Coordinate initialPosition, Coordinate finalPosition){
		this.setInitialPosition(initialPosition);
		this.setFinalPosition(finalPosition);
		this.board = board;
		this.piece = board.getPiece(initialPosition);
		this.td = new TileDecoder();
	}
	
	Move(Board board, String initialPosition, String finalPosition){
		this.td = new TileDecoder();
		this.setInitialPosition(td.decode(new Tile(initialPosition)));
		this.setFinalPosition(td.decode(new Tile(finalPosition)));
		this.board = board;
		this.piece = board.getPiece(td.decode(new Tile(initialPosition)));
	}
	
	/*
	 * If the piece can move to finialPosition and its path is clear, return true.
	 * Else return false
	 */
	public boolean canMakeMove() {
		return piece.canMove(finalPosition) && (new Path(finalPosition, board, piece)).isClear();
	}

	/************************************************************************************************************
	 ******************************************* Getter functions ***********************************************
	 ************************************************************************************************************/
	
	public Coordinate getInitialPosition() {
		return initialPosition;
	}
	
	public Coordinate getFinalPosition() {
		return finalPosition;
	}
	
	/************************************************************************************************************
	 ******************************************* Setter functions ***********************************************
	 ************************************************************************************************************/
	public void setFinalPosition(Coordinate finalPosition) {
		this.finalPosition = finalPosition;
	}
	
	public void setInitialPosition(Coordinate initialPosition) {
		this.initialPosition = initialPosition;
	}
}
