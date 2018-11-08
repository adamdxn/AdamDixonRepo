package chess;

import java.util.ArrayList;

/*
 * Object used to decode a tile position into a coordinate
 */
public class TileDecoder {

	private ArrayList<Character> letters;
	private ArrayList<Character> numbers;
	
	TileDecoder() {
		ArrayList<Character> letters = new ArrayList<>();
		letters.add('a');
		letters.add('b');
		letters.add('c');
		letters.add('d');
		letters.add('e');
		letters.add('f');
		letters.add('g');
		letters.add('h');
		this.letters = letters;
		
		ArrayList<Character> numbers = new ArrayList<>();
		numbers.add('8');
		numbers.add('7');
		numbers.add('6');
		numbers.add('5');
		numbers.add('4');
		numbers.add('3');
		numbers.add('2');
		numbers.add('1');
		this.numbers = numbers;


	}

	/*
	 * Decode a given tile into its coordinate on the board
	 */
	public Coordinate decode(Tile t) {
		String s = t.getTile();
		char[] pos = s.toCharArray();
		return new Coordinate(letters.indexOf(pos[0]), numbers.indexOf(pos[1]));
	}
}
