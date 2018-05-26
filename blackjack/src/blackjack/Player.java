package blackjack;

import java.util.LinkedList;

public class Player {
	LinkedList<Card> hand;
	int score;
	int cherries;
	
	Player(int cherries){
		this.hand = new LinkedList<Card>();
		this.score = 0;
		this.cherries = cherries;
		
	}
	
	/*
	 * Pick a card from the top of the deck
	 */
	void pickCard(Deck deck){
		Card pickedCard = deck.pickCard();
		hand.add(pickedCard);
		this.score += pickedCard.getValue();
	}
	
	/*
	 * Prints all cards in the players hand to the screen
	 */
	String getHandAndScore(){
		String s = "***************\n";
		for(int i = 0; i < hand.size(); i++){
			s += hand.get(i).getCard() + "\n";
		}
		s += "***************\n";
		s += "Your score is " + score;
		return s;
	}
	
	void discardHand(){
		this.hand = new LinkedList<Card>();
		this.score = 0;
	}
	
	public static void main(String[] args) {
		Player p = new Player(3);
		Deck d = new Deck();
		
		for(int i = 0; i < 3; i++)
			p.pickCard(d);
		
		System.out.println(p.getHandAndScore());
		System.out.println(p.score);
	}
}
