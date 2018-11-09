package chess;

import java.util.LinkedList;

/*
 * A board is a mutable object used in a game of chess.
 */
public class Board {

	private Piece[][] board;
	private LinkedList<Piece> graveyard;
	protected King whiteKing;
	protected King blackKing;

	/*
	 * Construct the board object. The board is a 8x8 units and contains two sets of
	 * pieces, one white and one black.
	 */
	Board() {
		Piece[][] b = new Piece[8][8];

		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {

				if (y == 0 && (x == 0 || x == 7)) 
					b[x][y] = new Rook("Black", x, y);
				
				if (y == 0 && (x == 1 || x == 6))
					b[x][y] = new Knight("Black", x, y);
				
				if (y == 0 && (x == 2 || x == 5))
					b[x][y] = new Bishop("Black", x, y);
				
				if (y == 0 && x == 3) {
					b[x][y] = new King("Black", x, y);
					this.blackKing = (King) b[x][y];
				}
				
				if (y == 0 && x == 4)
					b[x][y] = new Queen("Black", x, y);
				
				if (y == 1)
					b[x][y] = new Pawn("Black", x, y);
				
				if (y == 7 && (x == 0 || x == 7))
					b[x][y] = new Rook("White", x, y);
				
				if (y == 7 && (x == 1 || x == 6))
					b[x][y] = new Knight("White", x, y);
				
				if (y == 7 && (x == 2 || x == 5))
					b[x][y] = new Bishop("White", x, y);
				
				if (y == 7 && x == 3) {
					b[x][y] = new King("White", x, y);
					this.whiteKing = (King) b[x][y];
				}
				
				if (y == 7 && x == 4)
					b[x][y] = new Queen("White", x, y);
				
				if (y == 6)
					b[x][y] = new Pawn("White", x, y);
			}
		}
		this.board = b;
		this.graveyard = new LinkedList<Piece>();
	}
	
	/************************************************************************************************************
	 ******************************************* Mutating methods ***********************************************
	 ************************************************************************************************************/

	/*
	 * Given a piece, move it to a new position. Assume that the new position is not
	 * already occupied.
	 * 
	 * @param initialPosition is not null
	 * @param finalPosition is not null
	 * @return true if the piece at position initialPosition successfully moved to finalPosition
	 */
	public boolean movePiece(Coordinate initialPosition, Coordinate finalPosition) {

		Piece piece = board[initialPosition.getX()][initialPosition.getY()];
		
		if (piece == null)
			return false;

		if (pieceCanMove(piece, finalPosition)) {
			piece.move(finalPosition);
			board[finalPosition.getX()][finalPosition.getY()] = piece;
			board[initialPosition.getX()][initialPosition.getY()] = null;
			return true;
		}
		return false;
	}

	/*
	 * Get the piece at the position oldPos and see if it can capture the piece at
	 * position newPos and then do it
	 * 
	 * @param initialPosition is not null
	 * @param finalPosition is not null
	 * @return true if the piece at position initialPosition successfully captured the piece
	 *  at position finalPosition
	 */
	public boolean capturePiece(Coordinate initialPosition, Coordinate finalPosition) {
		boolean canCapture = false;
		Piece piece = board[initialPosition.getX()][initialPosition.getY()];
		
		if (piece == null)
			return false;

		if (piece.canCapture(finalPosition) && isClear(piece, finalPosition)) {
			canCapture = true;
			piece.move(finalPosition);
			graveyard.add(board[finalPosition.getX()][finalPosition.getY()]);
			board[finalPosition.getX()][finalPosition.getY()] = piece;
			board[initialPosition.getX()][initialPosition.getY()] = null;
		}
		return canCapture;
	}
	
	/*
	 * Given two coordinates, play the turn.
	 * 
	 * @param player is not null and has color either "White" or "Black"
	 * @param initialPosition is of length 2
	 * @param finalPosition is of length 2
	 * @return true if the play was successfully made, false if it is not a valid move
	 */
	public boolean turn(Player player, String initialPosition, String finalPosition) {
		
		if (initialPosition.charAt(0) < 97 || initialPosition.charAt(0) > 104
				|| finalPosition.charAt(0) < 97 || finalPosition.charAt(0) > 104
				|| initialPosition.charAt(1) < 49 || initialPosition.charAt(1) > 56
				|| finalPosition.charAt(1) < 49 || finalPosition.charAt(1) > 56
				|| initialPosition.length() != 2 || finalPosition.length() != 2)
			return false;
		
		TileDecoder td = new TileDecoder();
			
		Coordinate iPos = td.decode(new Tile(initialPosition));
		Coordinate fPos = td.decode(new Tile(finalPosition));
				
		if (board[iPos.getX()][iPos.getY()] == null)
			return false;
		if (!board[iPos.getX()][iPos.getY()].getColor().equals(player.getColor()))
			return false;
		
		return (board[fPos.getX()][fPos.getY()] == null) ? movePiece(iPos, fPos) : capturePiece(iPos, fPos);
	}
	
	/************************************************************************************************************
	 ******************************************* Boolean methods ***********************************************
	 ************************************************************************************************************/
	
	/*
	 * Given a piece and a new position that piece should be placed on the board,
	 * return true if and only if the piece can be moved to that position. A piece
	 * can be moved if there are no other pieces occupying the newPosition.
	 * 
	 * @param piece is not null
	 * @param finalPosition is not null
	 * @return true if the piece has the capability of moving to finalPosition, the board is not
	 * occupied at finalPosition by any piece and the path is clear for the path traveled
	 */
	public boolean pieceCanMove(Piece piece, Coordinate finalPosition) {
			return piece.canMove(finalPosition) && finalPosition.getX() >= 0 && finalPosition.getX() <= 7
					&& finalPosition.getY() >= 0 && finalPosition.getY() <= 7 && !isOccupied(finalPosition)
					&& isClear(piece, finalPosition);
	}

	/*
	 * Return true if the given position is occupied by a piece.
	 * 
	 * @param position is a valid board position
	 * @return true if the position is occupied by a piece already
	 */
	public boolean isOccupied(Coordinate position) {
		return (board[position.getX()][position.getY()] == null) ? false : true;
	}
	
	/*
	 * Determine if the color's king is check matted
	 * 
	 * @param color of the king you are checking for defeat
	 * @return true if the king of the specified color will be 
	 * captured regardless of where he moves
	 */
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
				if (board[x][y] != null && !board[x][y].getColor().equals(piece.getColor())) {
					Piece enemyPiece = board[x][y];
					if (enemyPiece.canCapture(finalPosition) && (new Path(finalPosition, this, enemyPiece)).isClear()) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/************************************************************************************************************
	 ******************************************* Getter functions ***********************************************
	 ************************************************************************************************************/
	
	/*
	 * Return the piece at the given coordinate or null if there is none
	 * 
	 * @param position is not null
	 * @return the piece at position
	 */
	public Piece getPiece(Coordinate position) {
		return this.board[position.getX()][position.getY()];
	}
	
	/*
	 * Create a string representation of the board
	 * 
	 * @return a string representation of the board
	 */
	public String getBoard() {
		String [] numbers = {"8", "7", "6", "5", "4", "3", "2", "1"};
		String s = "		a		b		c		d		e		f		g		h\n";
		for (int y = 0; y <= 7; y++) {
			s += numbers[y] + "	";
			for (int x = 0; x <= 7; x++) {
				if (board[x][y] != null)
					s += board[x][y].getPiece() + "     ";
				else
					s += "     Empty     ";
			} s += "\n\n";
		}
		return s;
	}
	
	/*
	 * Return the king of the specified color
	 * 
	 * @param color either "Black" or "White"
	 * @return King of the specified color
	 */
	public King getKing(String color) {
		return color.equals("White") ? whiteKing : blackKing;
	}
	
	/************************************************************************************************************
	 ********************************************** Methods *****************************************************
	 ************************************************************************************************************/
	
	/*
	 * Return all possible moves a given piece can perform on the board.
	 * 
	 * @param piece is not null and is on the board
	 * @return a list containing each possible move the piece can make at the current boards state
	 */
	public LinkedList<Move> getAllMoves(Piece piece){
		
		LinkedList<Move> moves = new LinkedList<>();
		
		for (int y = 0; y <= 7; y++) {
			for (int x = 0; x <= 7; x++) {
				if (piece.canCapture(new Coordinate(x,y))) {
					// add to possible move list
				}
			}
		}
			
		return moves;
	}
	
	/************************************************************************************************************
	 ********************************************** Private methods *********************************************
	 ************************************************************************************************************/
	
	/*
	 * Private method that will return true if the path is clear for an instance of
	 * a Rook
	 */
	private boolean rookPathIsClear(Rook rook, Coordinate finalPosition) {
		Coordinate initialPosition = rook.getPosition();
		// If the Rook travels vertically
		if (initialPosition.getX() == finalPosition.getX()) {
			int max = Math.max(initialPosition.getY(), finalPosition.getY());
			int min = Math.min(initialPosition.getY(), finalPosition.getY()) + 1;
			for (int i = min; i < max; i++) {
				if (this.isOccupied(new Coordinate(initialPosition.getX(), i)))
					return false;
			}
			// If the Rook travels horizontally
		} else {
			int max = Math.max(initialPosition.getX(), finalPosition.getX());
			int min = Math.min(initialPosition.getX(), finalPosition.getX()) + 1;
			for (int i = min; i < max; i++) {
				if (this.isOccupied(new Coordinate(i, initialPosition.getY())))
					return false;
			}
		}
		return true;
	}

	/*
	 * Private method that will return true if the path is clear for an instance of
	 * a Bishop
	 */
	private boolean bishopPathIsClear(Bishop bishop, Coordinate finalPosition) {
		Coordinate initialPosition = bishop.getPosition();
		int deltaX = finalPosition.getX() - initialPosition.getX();
		int deltaY = finalPosition.getY() - initialPosition.getY();

		// (+,+)
		if (deltaX > 0 && deltaY > 0) {
			for (int i = 1; i <= deltaX; i++) {
				if (this.isOccupied(new Coordinate(initialPosition.getX() + i, initialPosition.getY() + i))) {
					return false;
				}
			}
			// (+,-)
		} else if (deltaX > 0 && deltaY < 0) {
			for (int i = 1; i <= deltaX; i++) {
				if (this.isOccupied(new Coordinate(initialPosition.getX() + i, initialPosition.getY() - i))) {
					return false;
				}
			}
			// (-,+)
		} else if (deltaX < 0 && deltaY > 0) {
			for (int i = 1; i <= deltaY; i++) {
				if (this.isOccupied(new Coordinate(initialPosition.getX() - i, initialPosition.getY() + i))) {
					return false;
				}
			}
			// (-,-)
		} else if (deltaX < 0 && deltaY < 0) {
			for (int i = 1; i <= deltaY; i++) {
				if (this.isOccupied(new Coordinate(initialPosition.getX() - i, initialPosition.getY() + i))) {
					return false;
				}
			}
		}
		return true;

	}

	/*
	 * Returns true if the path is clear for the piece
	 */
	public boolean isClear(Piece piece, Coordinate finalPosition) {
		Coordinate initialPosition = piece.getPosition();

		if (piece instanceof Rook)
			return rookPathIsClear((Rook) piece, finalPosition);
		else if (piece instanceof Bishop)
			return bishopPathIsClear((Bishop) piece, finalPosition);
		else if (piece instanceof Queen) {
			if (initialPosition.getX() == finalPosition.getX() || initialPosition.getY() == finalPosition.getY())
				return rookPathIsClear((Rook) piece, finalPosition);
			return bishopPathIsClear((Bishop) piece, finalPosition);
		}
		else
			return !this.isOccupied(finalPosition);
	}
	
}
