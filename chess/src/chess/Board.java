package chess;

import java.util.LinkedList;

/*
 * A board is a mutable object used in a game of chess.
 */
public class Board {

	private Piece[][] board;
	private LinkedList<Piece> graveyard;
	private King whiteKing;
	private King blackKing;

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
	 */
	public boolean movePiece(Coordinate initialPosition, Coordinate finalPosition) {

		Piece piece = board[initialPosition.getX()][initialPosition.getY()];

		if (pieceCanMove(piece, finalPosition)) {
			piece.move(finalPosition);
			board[finalPosition.getX()][finalPosition.getY()] = piece;
			board[initialPosition.getX()][initialPosition.getY()] = null;
			return true;
		}
		return false;
	}
	/*
	 * Given a piece, move it to a new position. Assume that the new position is not
	 * already occupied.
	 */
	public boolean movePiece(int x1, int y1, int x2, int y2) {
		Piece piece = board[x1][y1];

		if (pieceCanMove(piece, new Coordinate(x2, y2))) {
			piece.move(new Coordinate(x2, y2));
			board[x2][y2] = piece;
			board[x1][y1] = null;
			return true;
		}
		return false;
	}

	/*
	 * Add a piece p to the board at the coordinate cord if cord is not already
	 * occupied
	 */
	public boolean add(Piece piece, Coordinate position) {
		if (!isOccupied(position)) {
			piece.move(position);
			this.board[position.getX()][position.getY()] = piece;
			return true;
		}
		return false;
	}

	/*
	 * Get the piece at the position oldPos and see if it can capture the piece at
	 * position newPos and then do it
	 */
	public boolean capture(Coordinate initialPosition, Coordinate finalPosition) {
		boolean canCapture = false;
		Piece piece = board[initialPosition.getX()][initialPosition.getY()];

		// If the piece can capture, move it to the newPos, put the old piece in the
		// grave yard and make the oldPos null
		if (piece.canCapture(finalPosition)) {
			canCapture = true;
			piece.move(finalPosition);
			graveyard.add(board[finalPosition.getX()][finalPosition.getY()]);
			board[finalPosition.getX()][finalPosition.getY()] = piece;
			board[initialPosition.getX()][initialPosition.getY()] = null;
		}
		return canCapture;
	}
	
	/*
	 * Given a move, execute it. Assume the move is valid.
	 */
	public boolean makeMove(Move move) {
		if (move.canMakeMove()) {
			movePiece(move.getInitialPosition(), move.getFinalPosition());
			return true;
		}
		return false;
	}
	
	/************************************************************************************************************
	 ******************************************* Boolean methods ***********************************************
	 ************************************************************************************************************/
	
	/*
	 * Given a piece and a new position that piece should be placed on the board,
	 * return true if and only if the piece can be moved to that position. A piece
	 * can be moved if there are no other pieces occupying the newPosition.
	 */
	public boolean pieceCanMove(Piece piece, Coordinate finalPosition) {
			return piece.canMove(finalPosition) && finalPosition.getX() >= 0 && finalPosition.getX() <= 7
					&& finalPosition.getY() >= 0 && finalPosition.getY() <= 7 && !isOccupied(finalPosition);
	}

	/*
	 * Return true if the given position is occupied by a piece.
	 */
	public boolean isOccupied(Coordinate position) {
		if (board[position.getX()][position.getY()] == null)
			return false;
		return true;
	}
	
	/*
	 * Return true if the color's king is checkmatted
	 */
	public boolean checkMate(String color) {
		King king = getKing(color);
		
		// (x - 1, y - 1)
		return (willBeCaptured(king, king.getPosition().getX(),
				king.getPosition().getY(),
				king.getPosition().getX() - 1,
				king.getPosition().getY() - 1))
				// (x, y - 1)
				&& (willBeCaptured(king, king.getPosition().getX(),
						king.getPosition().getY(),
						king.getPosition().getX(),
						king.getPosition().getY() - 1))
				// (x + 1, y - 1)
				&& (willBeCaptured(king, king.getPosition().getX(),
						king.getPosition().getY(),
						king.getPosition().getX() + 1,
						king.getPosition().getY() - 1))
				// (x - 1, y)
				&& (willBeCaptured(king, king.getPosition().getX(),
						king.getPosition().getY(),
						king.getPosition().getX() - 1,
						king.getPosition().getY()))
				// (x + 1, y)
				&& (willBeCaptured(king, king.getPosition().getX(),
						king.getPosition().getY(),
						king.getPosition().getX() + 1,
						king.getPosition().getY()))
				// (x - 1, y + 1)
				&& (willBeCaptured(king, king.getPosition().getX(),
						king.getPosition().getY(),
						king.getPosition().getX() - 1,
						king.getPosition().getY() + 1))
				// (x + 1, y + 1)
				&& (willBeCaptured(king, king.getPosition().getX(),
						king.getPosition().getY(),
						king.getPosition().getX() + 1,
						king.getPosition().getY() + 1));
	}
	
	private boolean willBeCaptured(Piece piece, int initialX, int initialY, int finalX, int finalY) {
		if (!pieceCanMove(piece, new Coordinate(finalX, finalY)))
			return false;
		
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				// if the position on the board is an enemy piece that can capture your piece return true
				if (board[x][y] != null && !board[x][y].getColor().equals(piece.getColor())) {
					Piece enemyPiece = board[x][y];
					if (enemyPiece.canCapture(new Coordinate(initialX, initialY))) {
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
	 */
	public Piece getPiece(Coordinate position) {
		return this.board[position.getX()][position.getY()];
	}
	
	/*
	 * Return a string representation of the board
	 */
	public String getBoard() {
		String s = "";
		for (int y = 0; y <= 7; y++) {
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
	 */
	public King getKing(String color) {
		if (color.equals("White"))
			return whiteKing;
		return blackKing;
	}
	
}
