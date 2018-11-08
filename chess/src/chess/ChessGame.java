package chess;

public class ChessGame {
	private Player human;
	private Player computer;
	private int turn;
	private Board board;
	
	ChessGame(Board board){
		this.human = new Player("White");
		this.computer = new Player("Black");
		this.turn = 1;
		this.board = board;
	}
	/*
	 * Begin the game of chess
	 */
	public Player start() {
		System.out.println(board.getBoard());
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
	 * Player will play make their move
	 */
	private boolean playTurn(Player player) {
		if (player.getColor().equals("White")) {
		Tile t1 = new Tile(""); // user input
		Tile t2 = new Tile(""); // user input
		return player.makeMove(board, t1, t2);
		}
		else {
			// Computer plays move
			return false;
		}
	}
	
	/*
	 * Check the board if the player has just made a check mate play
	 */
	private boolean checkCheckMate(Player player) {
		return board.checkMate(player.getColor());
	}
	
}
