package chess;

/*
 * Abstract class to represent a chess piece. 
 * Each piece has a color and is either captured or not.
 */
public abstract class Piece {

	private String color;
	private boolean isCaptured;
	private Coordinate position;
	protected String name;
	protected int weight;

	/*
	 * Construct a piece. Each piece has a color, either black or white
	 */
	Piece(String color, int x, int y) {

		if (color.equals("Black") || color.equals("White")) {
			this.color = color;
			this.isCaptured = false;
			this.position = new Coordinate(x, y);
		} else
			throw new IllegalArgumentException();
	}

	/*
	 * Abstract function to return true if a move is possible.
	 */
	public abstract boolean canMove(Coordinate cord);

	/*
	 * Abstract function to return true if a capture can be made
	 */
	public abstract boolean canCapture(Coordinate cord);

	public void setPosition(Coordinate pos) {
		this.position = pos;
	}

	/*
	 * Getter function called to return true if the piece has been captured or not
	 */
	public boolean isCaptured() {
		return this.isCaptured;
	}

	/*
	 * Getter function that returns the piece color.
	 */
	public String getColor() {
		return this.color;
	}

	/*
	 * Return a string representing the piece name. (ex: "Pawn")
	 */
	public String getName() {
		return this.name;
	}

	/*
	 * Return a string representing the piece. (ex: "White Pawn")
	 */
	public String getPiece() {
		return this.color + " " + this.name;
	}

	/*
	 * Return the Coordinate of the piece.
	 */
	public Coordinate getPosition() {
		return this.position;
	}

	/*
	 * Move the piece to the given Coordinate. Return true if the piece can move to
	 * the given position.
	 */
	public boolean move(Coordinate newPosition) {
		if (canMove(newPosition)) {
			this.position = newPosition;
			return true;
		}
		return false;
	}

	/*
	 * Move the the given Coordinate and capture the piece if and only if the piece
	 * can move to that position and if the enemy piece can be captured
	 */
	public boolean capture(Coordinate newPosition) {
		if (canCapture(newPosition)) {
			this.position = newPosition;
			return true;
		}
		return false;
	}
	
	public int getWeight() {
		return this.weight;
	}

}
