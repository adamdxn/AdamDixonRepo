package chess;

import java.util.LinkedList;

public class Path {

	private Coordinate original;
	private Coordinate destination;
	private Board board;
	private Piece piece;

	Path(Coordinate original, Coordinate destination, Board board, Piece piece) {
		this.original = original;
		this.destination = destination;
		this.board = board;
		this.piece = piece;
	}

	public boolean pathIsClear() {

		switch (piece.getName()) {
		case "Queen":

		case "Rook":
				// If the Rook travels vertical
			if (this.original.getX() == this.destination.getX()) {
				int max = Math.max(this.original.getY(), this.destination.getY());
				int min = Math.min(this.original.getY(), this.destination.getY()) + 1;
				for (int i = min; i < max; i++) {
					if (board.isOccupied(new Coordinate(this.original.getX(), i)))
						return false;
				}
				// If the Rook travels horizontally
			} else {
				int max = Math.max(this.original.getX(), this.destination.getX());
				int min = Math.min(this.original.getX(), this.destination.getX()) + 1;
				for (int i = min; i < max; i++) {
					if (board.isOccupied(new Coordinate(i, this.original.getY())))
						return false;
				}
			}
		case "Bishop":
			LinkedList<Coordinate> points = new LinkedList<>(getPoints());
			for (int i = 0; i < points.size(); i++) {
				if (board.isOccupied(points.get(i)))
					return false;
			}
			return true;
		default:
			return !board.isOccupied(destination);
		}
	}

	private LinkedList<Coordinate> getPoints() {
		int y = original.getY();
		int y1 = destination.getY();

		int x = original.getX();
		int x1 = destination.getX();

		int m = (y - y1) / (x - x1);
		int c = y - m * x;

		int max = Math.max(this.original.getX(), this.destination.getX());
		int min = Math.min(this.original.getX(), this.destination.getX()) + 1;

		LinkedList<Coordinate> points = new LinkedList<>();

		for (int i = min; i < max; i++) {
			points.add(new Coordinate(i, m * i + c));
		}

		return points;
	}
	
	public static void main(String[] args) {
		Board b = new Board();
		System.out.println(b.getBoard());
		
		b.move(new Coordinate(1, 1),new Coordinate(1, 2));
		b.move(new Coordinate(1, 2),new Coordinate(1, 3));
		b.move(new Coordinate(0, 1),new Coordinate(0, 2));
		b.move(new Coordinate(0, 0),new Coordinate(0, 1));
		b.move(new Coordinate(0, 1),new Coordinate(1, 1));
		b.move(new Coordinate(1, 3),new Coordinate(1, 4));
		b.move(new Coordinate(1, 4),new Coordinate(1, 5));
		b.capture(new Coordinate(1, 5),new Coordinate(2, 6));
		System.out.println(b.capture(new Coordinate(2, 6),new Coordinate(1, 7)));
	//	b.move(new Coordinate(1, 4),new Coordinate(1, 5));

		
		System.out.println(b.getBoard());
	}
}
