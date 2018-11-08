package chess;

import java.util.ArrayList;

public class Rook extends Piece{

	Rook(String color, int x, int y) {
		super(color, x, y);
		this.name = "Rook";
		if (this.getColor().equals("White"))
			this.weight = 50;
		else
			this.weight = -50;
	}

	/*
	 * Return true if the rook is moving vertically or horizontally
	 */
	@Override
	public boolean canMove(Coordinate cord) {
		return this.getPosition().getX() == cord.getX() && this.getPosition().getY() != cord.getY()
				|| this.getPosition().getX() != cord.getX() && this.getPosition().getY() == cord.getY();
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
