package chess;

import java.util.ArrayList;

/*
 * Class to represent a pawn chess piece.
 */
public class Pawn extends Piece {

	/*
	 * Construct a pawn. Each piece has a color, either black or white and an
	 * initial x and y position on the board
	 */
	Pawn(String color, int x, int y) {
		super(color, x, y);
		this.name = "Pawn";
		this.weight = (this.getColor().equals("White")) ? 10 : -10;
	}

	/*
	 * Returns true if the position is 1 upwards or downwards depending on the color
	 */
	@Override
	public boolean canMove(Coordinate cord) {
		if (this.getColor().equals("Black"))
			return cord.getX() == this.getPosition().getX() && cord.getY() == this.getPosition().getY() + 1;
		return cord.getX() == this.getPosition().getX() && cord.getY() == this.getPosition().getY() - 1;
	}

	@Override
	public boolean canCapture(Coordinate cord) {
		if (this.getColor().equals("Black"))
			return cord.getX() == this.getPosition().getX() + 1 && cord.getY() == this.getPosition().getY() + 1
					|| cord.getX() == this.getPosition().getX() - 1 && cord.getY() == this.getPosition().getY() + 1;
		return cord.getX() == this.getPosition().getX() + 1 && cord.getY() == this.getPosition().getY() - 1
				|| cord.getX() == this.getPosition().getX() - 1 && cord.getY() == this.getPosition().getY() - 1;
	}

	@Override
	public ArrayList<Move> getAllMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}
