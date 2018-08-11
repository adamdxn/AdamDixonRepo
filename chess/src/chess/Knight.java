package chess;

public class Knight extends Piece {

	Knight(String color, int x, int y) {
		super(color, x, y);
		this.name = "Knight";
	}

	/*
	 * Knight can move in any L shaped position.
	 */
	@Override
	public boolean canMove(Coordinate cord) {
		return (this.getPosition().getX() + 2 == cord.getX() && this.getPosition().getY() + 1 == cord.getY()
				|| this.getPosition().getX() + 2 == cord.getX() && this.getPosition().getY() - 1 == cord.getY()
				|| this.getPosition().getX() - 2 == cord.getX() && this.getPosition().getY() + 1 == cord.getY()
				|| this.getPosition().getX() - 2 == cord.getX() && this.getPosition().getY() - 1 == cord.getY()
				|| this.getPosition().getX() + 1 == cord.getX() && this.getPosition().getY() + 2 == cord.getY()
				|| this.getPosition().getX() + 1 == cord.getX() && this.getPosition().getY() - 2 == cord.getY()
				|| this.getPosition().getX() - 1 == cord.getX() && this.getPosition().getY() + 2 == cord.getY()
				|| this.getPosition().getX() - 1 == cord.getX() && this.getPosition().getY() - 2 == cord.getY());
	}

	@Override
	public boolean canCapture(Coordinate cord) {
		return canMove(cord);
	}

}
