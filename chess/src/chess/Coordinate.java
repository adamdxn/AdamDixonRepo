package chess;

public class Coordinate {
	private int x;
	private int y;

	/*
	 * Coordinate is an object to represent an x and y coordinate
	 */
	Coordinate(int x, int y) {
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
	
	public boolean isValid() {
		return x >= 0 && x <=7 && y >= 0 && y <= 7;
	}
	
	public boolean equals(Coordinate cord) {
		return cord.getX() == this.getX() && cord.getY() == this.getY();
	}
}
