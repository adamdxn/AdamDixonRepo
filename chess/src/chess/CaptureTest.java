package chess;

import static org.junit.Assert.*;
import org.junit.Test;

public class CaptureTest {
	Board b;

	@Test
	public void test0() {

		Board b = new Board();
		this.b = b;

		b.movePiece(3, 1, 3, 2);
		b.movePiece(3, 2, 3, 3);

		b.movePiece(3, 6, 3, 5);
		
		
		b.movePiece(4, 6, 4, 5);
		b.movePiece(4, 5, 4, 4);
		
		System.out.println(b.getBoard());
	}
}
