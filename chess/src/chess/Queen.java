package chess;

import java.util.ArrayList;

/*
 * Class to represent a queen chess piece.
 */
public class Queen extends Piece{

	/*
	 * Construct a queen. Each queen has a color, either black or white
	 * and an initial x and y position on the board
	 */
	Queen(String color, int x, int y) {
		super(color, x, y);
		this.name = "Queen";
		this.weight = (this.getColor().equals("White")) ? 90 : -90;
	}

	/*
	 * A queen can move like a rook or a bishop. Return true if the piece tries to move like a rook
	 * or a bishop.
	 */
	@Override
	public boolean canMove(Coordinate cord) {
		boolean moveLikeRook = this.getPosition().getX() == cord.getX() && this.getPosition().getY() != cord.getY()
				|| this.getPosition().getX() != cord.getX() && this.getPosition().getY() == cord.getY();
		int k = Math.abs(this.getPosition().getX() - cord.getX());
		boolean moveLikeBishop = cord.getX() == this.getPosition().getX() + k && cord.getY() == this.getPosition().getY() + k
				|| cord.getX() == this.getPosition().getX() + k && cord.getY() == this.getPosition().getY() - k
				|| cord.getX() == this.getPosition().getX() - k && cord.getY() == this.getPosition().getY() + k
				|| cord.getX() == this.getPosition().getX() - k && cord.getY() == this.getPosition().getY() - k;
		
		return moveLikeRook || moveLikeBishop;
	}

	/*
	 * If you can move to the given coordinate cord, then you can capture the enemy piece
	 */
	@Override
	public boolean canCapture(Coordinate cord) {
		return canMove(cord);
	}

	@Override
	public ArrayList<Move> getAllMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}
