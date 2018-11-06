package chess;

public class ChessGame {
	private Player human;
	private Player computer;
	private int turn;
	private Board board;
	
	ChessGame(Board b){
		this.human = new Player("White", "Adam", true);
		this.computer = new Player("Black", "Joshua", false);
		this.turn = 1;
		this.board = b;
	}
	/*
	 * Begin the game of chess
	 */
	public Player start() {
		boolean checkMate = false;
		Player winner = null;
		
		while(!checkMate) {
			if (turn % 2 == 0) {
				
				playTurn(human);
				checkMate = checkCheckMate(human);
				if (checkMate) winner = human;
				
			} else {
				
				playTurn(computer);
				checkMate = checkCheckMate(computer);
				if (checkMate) winner = computer;
				
			} turn++;
		}
		return winner;
	}
	
	/*
	 * Player p will play their turn
	 */
	private void playTurn(Player p) {
		if (p.isHuman()) {
		Tile t1 = new Tile(""); // user input
		Tile t2 = new Tile(""); // user input
		}
		else {
			// Computer plays move
		}
		
		return;
	}
	
	/*
	 * Check the board if the player has just made a check mate play
	 */
	private boolean checkCheckMate(Player player) {
		return false;
	}
	
}
