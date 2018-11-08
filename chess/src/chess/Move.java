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
	
	Move(Board board, Coordinate initialPosition, Coordinate finalPosition){
		this.setInitialPosition(initialPosition);
		this.setFinalPosition(finalPosition);
		this.board = board;
		this.piece = board.getPiece(initialPosition);
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
