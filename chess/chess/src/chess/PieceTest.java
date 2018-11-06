package chess;

import static org.junit.Assert.*;
import org.junit.Test;

public class PieceTest {

	@Test
	public void test0() {

		Piece pawn = new Pawn("White", 0, 0);
		assertEquals(pawn.getColor(), "White");
	}

	@Test
	public void test1() {

		Piece pawn = new Pawn("White", 1, 1);
		assertEquals(pawn.getName(), "Pawn");
	}

	@Test
	public void test2() {

		Piece pawn = new Pawn("White", 1, 1);
		assertEquals(pawn.getPosition().getX(), 1);
	}

	@Test
	public void test4() {

		Piece rook = new Rook("White", 2, 2);

		boolean a = rook.move(new Coordinate(2, 4));
		boolean b = rook.move(new Coordinate(4, 4));
		boolean c = rook.move(new Coordinate(5, 5));

		assertEquals(a && b && c, false);
	}

	@Test
	public void test5() {

		Piece bishop = new Bishop("White", 1, 1);
		bishop.move(new Coordinate(3, 3));
		assertEquals(bishop.getPosition().getX(), 3);
	}

	@Test
	public void test6() {

		Piece knight = new Knight("White", 0, 0);
		assertEquals(true, knight.move(new Coordinate(2, 1)));
	}
	
	@Test
	public void test7() {

		Piece knight = new Knight("White", 0, 0);
		assertEquals(true, knight.move(new Coordinate(1, 2)));
	}

}
