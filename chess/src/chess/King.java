package chess;

public class King extends Piece{
	
	King(String color, int x, int y) {
		super(color, x, y);
		this.name = "King";
	}

	/*
	 * 
	 */
	@Override
	public boolean canMove(Coordinate cord) {
		return (this.getPosition().getX() + 1 == cord.getX() && this.getPosition().getY() == cord.getY()
				|| this.getPosition().getX() + 1 == cord.getX() && this.getPosition().getY() + 1 == cord.getY()
				|| this.getPosition().getX() + 1 == cord.getX() && this.getPosition().getY() - 1 == cord.getY()
				|| this.getPosition().getX() - 1 == cord.getX() && this.getPosition().getY()  == cord.getY()
				|| this.getPosition().getX() - 1 == cord.getX() && this.getPosition().getY() + 1 == cord.getY()
				|| this.getPosition().getX() - 1 == cord.getX() && this.getPosition().getY() - 1 == cord.getY()
				|| this.getPosition().getX() == cord.getX() && this.getPosition().getY() + 1 == cord.getY()
				|| this.getPosition().getX() == cord.getX() && this.getPosition().getY() - 1 == cord.getY());
	}

	@Override
	public boolean canCapture(Coordinate cord) {
		return canMove(cord);
	}
}
