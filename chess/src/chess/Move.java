package chess;

/*
 * Object to determine if a move is valid to make on a chess board. This object cannot 
 * change the state of the board
 */
public class Move {
	private Coordinate initialPosition;
	private Coordinate finalPosition;
	
	Move(Coordinate initialPosition, Coordinate finalPosition){
		this.setInitialPosition(initialPosition);
		this.setFinalPosition(finalPosition);
	}

	/************************************************************************************************************
	 ******************************************* Getter functions ***********************************************
	 ************************************************************************************************************/
	
	public Coordinate getInitialPosition() {
		return initialPosition;
	}
	
	public Coordinate getFinalPosition() {
		return finalPosition;
	}
	
	/************************************************************************************************************
	 ******************************************* Setter functions ***********************************************
	 ************************************************************************************************************/
	public void setFinalPosition(Coordinate finalPosition) {
		this.finalPosition = finalPosition;
	}
	
	public void setInitialPosition(Coordinate initialPosition) {
		this.initialPosition = initialPosition;
	}
}
