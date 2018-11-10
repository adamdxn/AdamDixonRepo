package chess;

/*
 * This class is used to check whether the path for a Bishop, Rook or Queen is clear, 
 * although it also works with every other piece. 
 */
public class Path {
	private Coordinate startPoint;
	private Coordinate endPoint;
	private Board board;
	private Piece piece;

	/*
	 * A path requires a board and the piece that is moving from startPoint to
	 * endPoint
	 */
	Path(Coordinate endPoint, Board board, Piece piece) {
		this.startPoint = piece.getPosition();
		this.endPoint = endPoint;
		this.board = board;
		this.piece = piece;
	}
	
	Path(int xf, int yf, Board board, Piece piece){
		this.startPoint = piece.getPosition();
		this.endPoint = new Coordinate(xf, yf);
		this.board = board;
		this.piece = piece;
	}

	/*
	 * Private method that will return true if the path is clear for an instance of
	 * a Rook
	 */
	private boolean rookPathIsClear() {
		// If the Rook travels vertically
		if (this.startPoint.getX() == this.endPoint.getX()) {
			int max = Math.max(this.startPoint.getY(), this.endPoint.getY());
			int min = Math.min(this.startPoint.getY(), this.endPoint.getY()) + 1;
			for (int i = min; i < max; i++) {
				if (board.isOccupied(new Coordinate(this.startPoint.getX(), i)))
					return false;
			}
			// If the Rook travels horizontally
		} else {
			int max = Math.max(this.startPoint.getX(), this.endPoint.getX());
			int min = Math.min(this.startPoint.getX(), this.endPoint.getX()) + 1;
			for (int i = min; i < max; i++) {
				if (board.isOccupied(new Coordinate(i, this.startPoint.getY())))
					return false;
			}
		}
		return true;
	}

	/*
	 * Private method that will return true if the path is clear for an instance of
	 * a Bishop
	 */
	private boolean bishopPathIsClear() {
		int deltaX = endPoint.getX() - this.startPoint.getX();
		int deltaY = endPoint.getY() - this.startPoint.getY();

		// (+,+)
		if (deltaX > 0 && deltaY > 0) {
			for (int i = 1; i <= deltaX; i++) {
				if (board.isOccupied(new Coordinate(this.startPoint.getX() + i, this.startPoint.getY() + i))) {
					return false;
				}
			}
			// (+,-)
		} else if (deltaX > 0 && deltaY < 0) {
			for (int i = 1; i <= deltaX; i++) {
				if (board.isOccupied(new Coordinate(this.startPoint.getX() + i, this.startPoint.getY() - i))) {
					return false;
				}
			}
			// (-,+)
		} else if (deltaX < 0 && deltaY > 0) {
			for (int i = 1; i <= deltaY; i++) {
				if (board.isOccupied(new Coordinate(this.startPoint.getX() - i, this.startPoint.getY() + i))) {
					return false;
				}
			}
			// (-,-)
		} else if (deltaX < 0 && deltaY < 0) {
			for (int i = 1; i <= deltaY; i++) {
				if (board.isOccupied(new Coordinate(this.startPoint.getX() - i, this.startPoint.getY() + i))) {
					return false;
				}
			}
		}
		return true;

	}

	/*
	 * Returns true if the path is clear for the piece
	 */
	public boolean isClear() {

		if (this.piece instanceof Rook)
			return rookPathIsClear();
		else if (this.piece instanceof Bishop)
			return bishopPathIsClear();
		else if (this.piece instanceof Queen) {
			if (startPoint.getX() == endPoint.getX() || startPoint.getY() == endPoint.getY())
				return rookPathIsClear();
			return bishopPathIsClear();
		}
		else
			return !this.board.isOccupied(this.endPoint);
	}
}

