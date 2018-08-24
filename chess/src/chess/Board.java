package chess;

import java.util.LinkedList;

public class Board {

	private Piece[][] board;
	private LinkedList<Piece> graveyard;

	/*
	 * Construct the board object. The board is a 8x8 units and contains two sets of
	 * pieces, one white and one black.
	 */
	Board() {
		Piece[][] b = new Piece[8][8];

		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {

				if (y == 0 && (x == 0 || x == 7)) {
					b[x][y] = new Rook("Black", x, y);
				}
				if (y == 0 && (x == 1 || x == 6)) {
					b[x][y] = new Knight("Black", x, y);
				}
				if (y == 0 && (x == 2 || x == 5)) {
					b[x][y] = new Bishop("Black", x, y);
				}
				if (y == 0 && x == 3) {
					b[x][y] = new King("Black", x, y);
				}
				if (y == 0 && x == 4) {
					b[x][y] = new Queen("Black", x, y);
				}
				if (y == 1) {
					b[x][y] = new Pawn("Black", x, y);
				}
				if (y == 7 && (x == 0 || x == 7)) {
					b[x][y] = new Rook("White", x, y);
				}
				if (y == 7 && (x == 1 || x == 6)) {
					b[x][y] = new Knight("White", x, y);
				}
				if (y == 7 && (x == 2 || x == 5)) {
					b[x][y] = new Bishop("White", x, y);
				}
				if (y == 7 && x == 3) {
					b[x][y] = new King("White", x, y);
				}
				if (y == 7 && x == 4) {
					b[x][y] = new Queen("White", x, y);
				}
				if (y == 6) {
					b[x][y] = new Pawn("White", x, y);
				}
			}
		}
		this.board = b;
		this.graveyard = new LinkedList<Piece>();
	}

	/*
	 * Return the piece at the given coordinate or null if there is none
	 */
	public Piece getPiece(Coordinate coord) {
		return this.board[coord.getX()][coord.getY()];
	}

	/*
	 * Given a piece and a new position that piece should be placed on the board,
	 * return true if and only if the piece can be moved to that position. A piece
	 * can be moved if there are no other pieces occupying the newPosition.
	 */
	public boolean pieceCanMove(Piece piece, Coordinate newPosition) {
		return piece.canMove(newPosition) && newPosition.getX() >= 0 && newPosition.getX() <= 7
				&& newPosition.getY() >= 0 && newPosition.getY() <= 7 && !isOccupied(newPosition);
	}

	/*
	 * Return true if the given position is occupied by a piece.
	 */
	public boolean isOccupied(Coordinate pos) {
		if (board[pos.getX()][pos.getY()] == null)
			return false;
		return true;
	}

	/*
	 * Given a piece, move it to a new position. Assume that the new position is not
	 * already occupied.
	 */
	public boolean move(Coordinate oldPosition, Coordinate newPosition) {

		Piece piece = board[oldPosition.getX()][oldPosition.getY()];

		if (pieceCanMove(piece, newPosition)) {
			piece.setPosition(newPosition);
			board[newPosition.getX()][newPosition.getY()] = piece;
			board[oldPosition.getX()][oldPosition.getY()] = null;
			return true;
		}
		return false;
	}

	public boolean move(int x1, int y1, int x2, int y2) {
		Piece piece = board[x1][y1];
		System.out.println(piece);

		if (pieceCanMove(piece, new Coordinate(x2, y2))) {
			piece.setPosition(new Coordinate(x2, y2));
			board[x2][y2] = piece;
			board[x1][y1] = null;
			return true;
		}
		return false;
	}

	/*
	 * Add a piece p to the board at the coordinate cord if cord is not already occupied
	 */
	public boolean add(Piece p, Coordinate cord) {
		if (!isOccupied(cord)) {
			p.setPosition(cord);
			this.board[cord.getX()][cord.getY()] = p;
			return true;
		}
		return false;
	}

	/*
	 * Get the piece at the position oldPos and see if it can capture the piece at
	 * position newPos and then do it
	 */
	public boolean capture(Coordinate oldPos, Coordinate newPos) {
		boolean canCapture = false;
		Piece piece = board[oldPos.getX()][oldPos.getY()];

		// If the piece can capture, move it to the newPos, put the old piece in the
		// graveyard and make the oldPos null
		if (piece.canCapture(newPos)) {
			canCapture = true;
			piece.setPosition(newPos);
			graveyard.add(board[newPos.getX()][newPos.getY()]);
			board[newPos.getX()][newPos.getY()] = piece;
			board[oldPos.getX()][oldPos.getY()] = null;
		}
		return canCapture;
	}

	public String getBoard() {

		String s = "";

		for (int y = 0; y <= 7; y++) {
			for (int x = 0; x <= 7; x++) {
				if (board[x][y] != null) {
					s += board[x][y].getPiece() + "     ";
				} else {
					s += "     Empty     ";
				}
			}
			s += "\n\n";
		}

		return s;
	}

}
