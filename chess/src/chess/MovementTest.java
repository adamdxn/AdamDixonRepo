package chess;

import static org.junit.Assert.*;
import org.junit.Test;

public class MovementTest {

	@Test
	public void test0() {
		Board board = new Board();
		Player human = new Player("White");

		assertEquals(false, board.turn(human, "c1", "e3"));
	}
	
	@Test
	public void test1() {
		Board board = new Board();
		Player human = new Player("White");

		assertEquals(true, board.turn(human, "d2", "d3") && board.turn(human, "c1", "e3"));
	}
	
	@Test
	public void test2() {
		Board board = new Board();
		Player computer = new Player("Black");
		System.out.println(board.getBoard());
		assertEquals(true, board.turn(computer, "d7", "d6") && board.turn(computer, "c8", "e6"));
	}
	
	@Test
	public void test3() {
		Board board = new Board();
		Player human = new Player("White");
	}
	
}
