package chess;

public class TestingBoard extends Board{
	
	public Piece[][] b;
	TestingBoard(){
		Piece[][] b = new Piece[8][8];
		b[0][0] = new King("White", 0, 0);
		b[2][0] = new Rook("Black", 2, 0);
		b[0][2] = new Rook("Black", 0, 2);
		b[2][2] = new Bishop("Black", 2, 2);
		
		b[3][3] = new King("Black", 3, 3);
		this.whiteKing = (King) b[0][0];
		this.blackKing = (King) b[3][3];
		this.b = b;
	}
	
	public static void main(String[] args) {
		TestingBoard board = new TestingBoard();
		System.out.println(board.checkMate("White"));
	}
	
	/*
	 * Create a string representation of the board
	 * 
	 * @return a string representation of the board
	 */
	@Override
	public String getBoard() {
		String [] numbers = {"8", "7", "6", "5", "4", "3", "2", "1"};
		String s = "		a		b		c		d		e		f		g		h\n";
		for (int y = 0; y <= 7; y++) {
			s += numbers[y] + "	";
			for (int x = 0; x <= 7; x++) {
				if (b[x][y] != null)
					s += b[x][y].getPiece() + "     ";
				else
					s += "     Empty     ";
			} s += "\n\n";
		}
		return s;
	}
	
	/*
	 * Determine if the color's king is check matted
	 * 
	 * @param color of the king you are checking for defeat
	 * @return true if the king of the specified color will be 
	 * captured regardless of where he moves
	 */
	@Override
	public boolean checkMate(String color) {
		King king = getKing(color);
		int x = king.getPosition().getX();
		int y = king.getPosition().getY();
		
		// (x - 1, y - 1)
		return (willBeCaptured(king, new Coordinate(x - 1, y - 1))
				// (x, y - 1)
				&& (willBeCaptured(king, new Coordinate(x, y - 1))
				// (x + 1, y - 1)
				&& (willBeCaptured(king, new Coordinate(x + 1, y - 1))
				// (x - 1, y)
				&& (willBeCaptured(king,new Coordinate(x - 1, y))
				// (x + 1, y)
				&& (willBeCaptured(king, new Coordinate(x + 1, y))
				// (x - 1, y + 1)
				&& (willBeCaptured(king, new Coordinate(x - 1, y + 1))
				// (x + 1, y + 1)
				&& (willBeCaptured(king, new Coordinate(x + 1, y + 1)))))))));
	}
	
	/*
	 * Determine if the piece will be captured at (finalX, finalY)
	 * 
	 * @param piece is not null
	 * @param 0 <= initialX <= 7
	 * @param 0 <= initialY <= 7
	 * @param 0 <= finalX <= 7
	 * @param 0 <= finalY <= 7
	 * @return true if the piece cannot move to (finalX, finalY) or the piece will be captured
	 * at (initialX, initialY). Otherwise return true.
	 */
	private boolean willBeCaptured(Piece piece, Coordinate finalPosition) {
		
		if (!pieceCanMove(piece, finalPosition))
			return true;
		
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				// if the position on the board is an enemy piece that can capture your piece return true
				if (b[x][y] != null && !b[x][y].getColor().equals(piece.getColor())) {
					Piece enemyPiece = b[x][y];
					if (enemyPiece.canCapture(finalPosition)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	

	/*
	 * Return true if the given position is occupied by a piece.
	 * 
	 * @param position is a valid board position
	 * @return true if the position is occupied by a piece already
	 */
	@Override
	public boolean isOccupied(Coordinate position) {
		if (b[position.getX()][position.getY()] == null)
			return false;
		return true;
	}
}
