package chess;

import java.util.ArrayList;

/*
 * Abstract class to represent a chess piece. 
 * Each piece has a color and is either captured or not.
 */
public abstract class Piece {

	private String color;
	private Coordinate position;
	protected String name;
	protected int weight;

	/*
	 * Construct a piece. Each piece has a color, either black or white
	 */
	Piece(String color, int x, int y) {

		if (color.equals("Black") || color.equals("White")) {
			this.color = color;
			this.position = new Coordinate(x, y);
		} else
			throw new IllegalArgumentException();
	}

	/************************************************************************************************************
	 ************************************************ Methods ***************************************************
	 ************************************************************************************************************/
	
	/*
	 * Move the piece to the given Coordinate. Return true if the piece is capable
	 * of moving to the given position.
	 */
	public boolean move(Coordinate newPosition) {
		if (canMove(newPosition)) {
			setPosition(newPosition);
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
			setPosition(newPosition);
			return true;
		}
		return false;
	}
	
	/************************************************************************************************************
	 ******************************************* Abstract Functions *********************************************
	 ************************************************************************************************************/
	
	/*
	 * Abstract function to return true if a move is possible.
	 */
	public abstract boolean canMove(Coordinate cord);

	/*
	 * Abstract function to return true if a capture can be made
	 */
	public abstract boolean canCapture(Coordinate cord);
	
	/*
	 * Abstract function to return a list of all possible moves
	 */
	public abstract ArrayList<Move> getAllMoves();
	
	/************************************************************************************************************
	 ******************************************* Getter functions ***********************************************
	 ************************************************************************************************************/
	
	public String getColor() {
		return this.color;
	}

	public String getName() {
		return this.name;
	}

	public String getPiece() {
		return this.color + " " + this.name;
	}

	public Coordinate getPosition() {
		return this.position;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	/************************************************************************************************************
	 ******************************************* Setter functions ***********************************************
	 ************************************************************************************************************/
	
	private void setPosition(Coordinate newPosition) {
		this.position = newPosition;
	}
}
