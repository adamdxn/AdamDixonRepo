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
	 * 
	 * @return the player who won the game
	 */
	public Player start() {
		System.out.println(board.getBoard());
		boolean checkMate = false;
		Player winner = null;
		
		while(!checkMate) {
			if (turn % 2 == 0) {
				
				playTurn(human);
				System.out.println(board.getBoard());
				checkMate = checkCheckMate(human);
				if (checkMate) winner = human;
				
				
			} else {
				
				playTurn(computer);
				System.out.println(board.getBoard());
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
		boolean incorretInput = true;
		
		if (player.getColor().equals("White")) {
			
			while(incorretInput) {
				System.out.println("Enter the first tile: ");
				String t1 = player.from();
				
				System.out.println("Enter the second tile: ");
				String t2 = player.to();
				
				if (board.turn(human, t1, t2))
					incorretInput = false;
				else
					System.out.println("Incorrect input!");
			}
			return true;
		}
		else {
			System.out.println("Computer turn XD");
			// Computer plays move
			return true;
		}
	}
	
	/*
	 * Check the board if the player has just made a check mate play
	 */
	private boolean checkCheckMate(Player player) {
		return board.checkMate(player.getColor());
	}
	
	public static void main(String[] args) {
		ChessGame game = new ChessGame(new Board());
		game.start();
	}
	
}
