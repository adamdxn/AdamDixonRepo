package chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Object to represent a chess player.
 */
public class Player {
	private String color;
	
	Player(String color){
		this.color = color;
	}
	
	/*
	 * @return a string to represent the coordinate the player wants to make their move from
	 */
	public String from() {
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		String from = "";
		try {
			from = bufferReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return from;
	}
	
	/*
	 * @return a string to represent the coordinate the player wants to make their move to
	 */
	public String to() {
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		String to = "";
		try {
			to = bufferReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return to;
	}
	
	public String getColor() {
		return this.color;
	}
}
