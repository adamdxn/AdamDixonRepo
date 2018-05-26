package blackjack;

public class Card {
	private String suit;
	private int value;
	
	Card(int val){
		this.value = val % 13;
		int s = val/13;
		switch (s){
			case 0 : this.suit = "Hearts";
			break;
			case 1 : this.suit = "Clubs";
			break;
			case 2: this.suit = "Diamonds";
			break;
			case 3 : this.suit = "Spades";
		}
	}
	
	String getSuit(){
		return this.suit;
	}
	
	/*
	 * Face cards worth 10. Aces worth 1. All others same as value
	 */
	int getValue(){
		if (value >= 10 || value == 1)
			return 10;
		else if (value == 0)
			return 1;
		else
			return this.value;
	}
	
	/*
	 * Return the name and value of the card
	 */
	String getCard(){
		switch (value){
			case 0 : return "Ace of " + suit;
			case 1 : return "Jack of " + suit;
			case 11 : return "Queen of " + suit;
			case 12 : return "King of " + suit;
		default: return value + " of " + suit;	
		}
	}
	
}
