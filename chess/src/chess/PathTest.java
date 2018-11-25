package chess;

import static org.junit.Assert.*;
import org.junit.Test;

public class PathTest {

	@Test
	public void test0() {
		Board board = new Board();
		Piece blackBishop = board.getPiece(new Coordinate(2,0));
		Path path = new Path(new Coordinate(4,2), board, blackBishop);
		assertEquals(false, path.isClear());
	}
	
	@Test
	public void test1() {
		Board board = new Board();
		Piece blackBishop = board.getPiece(new Coordinate(2,0));
		Path path = new Path(new Coordinate(0,2), board, blackBishop);
		assertEquals(false, path.isClear());
	}
	
	@Test
	public void test2() {
		Board b = new Board();
		Piece blackBishop = b.getPiece(new Coordinate(2,0));		
		
		b.movePiece(new Coordinate(1, 1), new Coordinate(1, 2));
		b.movePiece(new Coordinate(1, 2), new Coordinate(1, 3));
		b.movePiece(new Coordinate(0, 1), new Coordinate(0, 2));
		b.movePiece(new Coordinate(0, 0), new Coordinate(0, 1));
		b.movePiece(new Coordinate(0, 1), new Coordinate(1, 1));
		b.movePiece(new Coordinate(1, 3), new Coordinate(1, 4));
		b.movePiece(new Coordinate(1, 4), new Coordinate(1, 5));
		b.capturePiece(new Coordinate(1, 5), new Coordinate(2, 6));
		b.movePiece(new Coordinate(1, 1), new Coordinate(1, 4));
		b.movePiece(new Coordinate(1, 4), new Coordinate(1, 3));
		b.movePiece(new Coordinate(1, 3), new Coordinate(5, 3));
		b.capturePiece(new Coordinate(5, 3), new Coordinate(5, 6));
		b.capturePiece(new Coordinate(5, 6), new Coordinate(4, 6));
		b.movePiece(new Coordinate(3, 1), new Coordinate(3, 2));
		
		Path path = new Path(new Coordinate(1,1), b, blackBishop);

		assertEquals(true, path.isClear());
	}
	
	@Test
	public void test3() {
		Board b = new Board();
		Piece blackBishop = b.getPiece(new Coordinate(2,0));		
		
		b.movePiece(new Coordinate(1, 1), new Coordinate(1, 2));
		b.movePiece(new Coordinate(1, 2), new Coordinate(1, 3));
		b.movePiece(new Coordinate(0, 1), new Coordinate(0, 2));
		b.movePiece(new Coordinate(0, 0), new Coordinate(0, 1));
		b.movePiece(new Coordinate(0, 1), new Coordinate(1, 1));
		b.movePiece(new Coordinate(1, 3), new Coordinate(1, 4));
		b.movePiece(new Coordinate(1, 4), new Coordinate(1, 5));
		b.capturePiece(new Coordinate(1, 5), new Coordinate(2, 6));
		b.movePiece(new Coordinate(1, 1), new Coordinate(1, 4));
		b.movePiece(new Coordinate(1, 4), new Coordinate(1, 3));
		b.movePiece(new Coordinate(1, 3), new Coordinate(5, 3));
		b.capturePiece(new Coordinate(5, 3), new Coordinate(5, 6));
		b.capturePiece(new Coordinate(5, 6), new Coordinate(4, 6));
		b.movePiece(new Coordinate(3, 1), new Coordinate(3, 2));
		
		Path path = new Path(new Coordinate(2,4), b, blackBishop);
		System.out.println(b.getBoard());

		assertEquals(true, path.isClear());
	}
	
	// Black queen diagonal left
	@Test
	public void test4() {
		Board b = new Board();
		Piece blackQueen = b.getPiece(new Coordinate(4,0));		
		
		b.movePiece(new Coordinate(1, 1), new Coordinate(1, 2));
		b.movePiece(new Coordinate(1, 2), new Coordinate(1, 3));
		b.movePiece(new Coordinate(0, 1), new Coordinate(0, 2));
		b.movePiece(new Coordinate(0, 0), new Coordinate(0, 1));
		b.movePiece(new Coordinate(0, 1), new Coordinate(1, 1));
		b.movePiece(new Coordinate(1, 3), new Coordinate(1, 4));
		b.movePiece(new Coordinate(1, 4), new Coordinate(1, 5));
		b.capturePiece(new Coordinate(1, 5), new Coordinate(2, 6));
		b.movePiece(new Coordinate(1, 1), new Coordinate(1, 4));
		b.movePiece(new Coordinate(1, 4), new Coordinate(1, 3));
		b.movePiece(new Coordinate(1, 3), new Coordinate(5, 3));
		b.capturePiece(new Coordinate(5, 3), new Coordinate(5, 6));
		b.capturePiece(new Coordinate(5, 6), new Coordinate(4, 6));
		b.movePiece(new Coordinate(3, 1), new Coordinate(3, 2));
		
		Path path = new Path(new Coordinate(2,2), b, blackQueen);

		assertEquals(true, path.isClear());
	}
	
	@Test
	public void test5() {
		Board b = new Board();
		Piece blackQueen = b.getPiece(new Coordinate(4,0));		
		
		b.movePiece(new Coordinate(1, 1), new Coordinate(1, 2));
		b.movePiece(new Coordinate(1, 2), new Coordinate(1, 3));
		b.movePiece(new Coordinate(0, 1), new Coordinate(0, 2));
		b.movePiece(new Coordinate(0, 0), new Coordinate(0, 1));
		b.movePiece(new Coordinate(0, 1), new Coordinate(1, 1));
		b.movePiece(new Coordinate(1, 3), new Coordinate(1, 4));
		b.movePiece(new Coordinate(1, 4), new Coordinate(1, 5));
		b.capturePiece(new Coordinate(1, 5), new Coordinate(2, 6));
		b.movePiece(new Coordinate(1, 1), new Coordinate(1, 4));
		b.movePiece(new Coordinate(1, 4), new Coordinate(1, 3));
		b.movePiece(new Coordinate(1, 3), new Coordinate(5, 3));
		b.capturePiece(new Coordinate(5, 3), new Coordinate(5, 6));
		b.capturePiece(new Coordinate(5, 6), new Coordinate(4, 6));
		b.movePiece(new Coordinate(3, 1), new Coordinate(3, 2));
		
		Path path = new Path(new Coordinate(4,5), b, blackQueen);

		assertEquals(false, path.isClear());
	}
}
