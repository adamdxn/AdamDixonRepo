package blackjack;
import java.util.Random;
import java.util.LinkedList;

public class Deck {
	
	private LinkedList<Card> deck;
	boolean isEmpty;
	
	Deck(){
		LinkedList<Card> deck = new LinkedList<>();
		this.deck = deck;
		for (int i = 0; i < 52; i++){
			deck.add(new Card(i));
		}
		this.isEmpty = false;
	}
	/*
	 * Return a random card from the deck. Sets "isEmpty" to true if there
	 * are no more card in the deck after you picked one up
	 */
	Card pickCard(){
		if(isEmpty)
			reshuffleDeck();
		Random r = new Random();
		if(deck.size() == 1)
			this.isEmpty = true;
		int index = r.nextInt(deck.size());
		Card card = deck.get(index);
		deck.remove(index);
		return card;
	}
	/*
	 * Re-shuffle the deck. Create an entirely new deck
	 */
	private void reshuffleDeck() {
		LinkedList<Card> deck = new LinkedList<>();
		this.deck = deck;
		for (int i = 0; i < 52; i++){
			deck.add(new Card(i));
		}
		this.isEmpty = false;
	}
}
