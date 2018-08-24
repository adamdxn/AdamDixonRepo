package chess;

/*
 * Class to represent a queen chess piece.
 */
public class Queen extends Piece{

	/*
	 * Construct a queen. Each piece has a color, either black or white
	 * and an initial x and y position on the board
	 */
	Queen(String color, int x, int y) {
		super(color, x, y);
		this.name = "Queen";
	}

	

	@Override
	public boolean canCapture(Coordinate cord) {
		return canMove(cord);
	}


	@Override
	public boolean canMove(Coordinate cord) {
		return false;
	}
	
	public static boolean pathIsClear(Path p) {
		return false;
	}

}
