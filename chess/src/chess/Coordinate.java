package chess;

public class Coordinate {
	private int x;
	private int y;

	/*
	 * Coordinate is an object to represent an x and y coordinate
	 */
	Coordinate(int x, int y) {

		if (x > 8 || y > 8)
			throw new IllegalArgumentException();

		this.x = x;
		this.y = y;
	}
	
	/*
	 * Getter function to return the x coordinate
	 */
	public int getX() {
		return this.x;
	}
	
	/*
	 * Getter function to return the y coordinate
	 */
	public int getY() {
		return this.y;
	}
	
	/*
	 * Setter function to set the x coordinate to the given p
	 */
	public void setX(int p) {
		this.x = p;
	}
	
	/*
	 * Setter function to set the x coordinate to the given p
	 */
	public void setY(int p) {
		this.y = p;
	}
}
