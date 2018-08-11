package chess;

public class Rook extends Piece{

	Rook(String color, int x, int y) {
		super(color, x, y);
		this.name = "Rook";
	}

	@Override
	public boolean canMove(Coordinate cord) {
		return this.getPosition().getX() == cord.getX() && this.getPosition().getY() != cord.getY()
				|| this.getPosition().getX() != cord.getX() && this.getPosition().getY() == cord.getY();
	}

	@Override
	public boolean canCapture(Coordinate cord) {
		return canMove(cord);
	}

}
