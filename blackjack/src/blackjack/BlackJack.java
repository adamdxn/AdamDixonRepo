package blackjack;
import java.util.Scanner;

public class BlackJack {
	
	Player user;
	Player computer;
	Deck deck;
	
	/*
	 * Start the game of blackjack with a specified amount of cherries
	 */
	BlackJack(int cherries){
		this.user = new Player(cherries);
		this.computer = new Player(cherries);
		this.deck = new Deck();
	}
	
	void discardHand(){
		user.discardHand();
		computer.discardHand();
	}
	
	void showScore(){
		System.out.println("Your hand is: \n" + user.getHandAndScore());
		System.out.println("Would you like to pick another card from the deck? Type 'y' for yes or 'n' for no");
	}
	

	public static void main(String[] args) {
		Deck deck = new Deck();
		boolean playGame = true;
		boolean showScore = true;
		boolean playRound = true;
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		System.out.println("Please input the number of cherries you would like each player to have...");
		BlackJack game = new BlackJack(reader.nextInt());
		
		game.user.pickCard(deck);
		game.computer.pickCard(deck);
		
		while(playGame){
			while(playRound){
			
				if (showScore){
					game.showScore();
					showScore = true;
				}
				String choice = reader.next();
				
				if (choice.equals("y")){
					boolean yes = true;
					while (yes){
						game.user.pickCard(deck);
						if (game.computer.score < 15)
							game.computer.pickCard(deck);
						
						game.showScore();
						String c = reader.next();
						
						if(c.equals("n")){
							showScore = false;
							playRound = false;
							break;
						}
					}
				}
				else if (choice.equals("n")){
					playRound = false;
				}
			}
					if (game.computer.score < 15)
						game.computer.pickCard(deck);
					
					if(game.user.score < 22 && game.user.score > game.computer.score){
						game.user.cherries++;
						game.computer.cherries--;
						System.out.println("You won this round! Your score was: " + game.user.score + " and the computers score was " + game.computer.score);
						System.out.println("You have " + game.user.cherries + " cherries left while the computer has " + game.computer.cherries + " cherries left\n");
						game.discardHand();
					}
					else if (game.computer.score < 22 && game.computer.score > game.user.score || (game.user.score > 21 && game.computer.score < 21)){
						game.computer.cherries++;
						game.user.cherries--;
						System.out.println("You lost this round :( Your score was: " + game.user.score + " and the computers score was " + game.computer.score);
						System.out.println("You have " + game.user.cherries + " cherries left while the computer has " + game.computer.cherries + " cherries left\n");
						game.discardHand();
					}
					else{
						System.out.println("A tie! No one lost any cherries!\n");
						System.out.println("You have " + game.user.cherries + " cherries left while the computer has " + game.computer.cherries + " cherries left\n");
						game.discardHand();
					}
					
					
					if(game.user.cherries == 0){
						System.out.println("Sorry! You lost :(");
						playGame = false;
					}
					else if (game.computer.cherries == 0){
						System.out.println("Congrats! You won!");
						playGame = false;
					}
					if (playGame)
						System.out.println("Would you like to pick a card from the deck? Type 'y' for yes or 'n' for no");
					playRound = true;
				}
		System.out.println("GAME OVER");
			}
}
