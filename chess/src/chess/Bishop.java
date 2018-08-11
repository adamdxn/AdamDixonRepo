package chess;

public class Bishop extends Piece{

	Bishop(String color, int x, int y) {
		super(color, x, y);
		this.name = "Bishop";
	}

	/*
	 * Bishop can move in any diagonal direction.
	 */
	@Override
	public boolean canMove(Coordinate cord) {
		int k = Math.abs(this.getPosition().getX() - cord.getX());
		
		return cord.getX() == this.getPosition().getX() + k && cord.getY() == this.getPosition().getY() + k
				|| cord.getX() == this.getPosition().getX() + k && cord.getY() == this.getPosition().getY() - k
				|| cord.getX() == this.getPosition().getX() - k && cord.getY() == this.getPosition().getY() + k
				|| cord.getX() == this.getPosition().getX() - k && cord.getY() == this.getPosition().getY() - k;
	}

	/*
	 * If you can move to the given coordinate cord, then you can capture the enemy piece
	 */
	@Override
	public boolean canCapture(Coordinate cord) {
		return canMove(cord);
	}

}