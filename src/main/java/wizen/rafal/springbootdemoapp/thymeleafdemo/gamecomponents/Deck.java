package wizen.rafal.springbootdemoapp.thymeleafdemo.gamecomponents;

import java.util.ArrayList;
import java.util.List;

public class Deck {

	private List<Card> deck;
	
	private Deck() {
		
	}
	
	public Deck(int numberOfDecks) {
		deck = new ArrayList<Card>();
		for(int i = 0; i < numberOfDecks; i++) {
			for(int j = 1; j <= 13; j++) {
				deck.add(new Card(j , 'H'));
				deck.add(new Card(j , 'S'));
				deck.add(new Card(j , 'D'));
				deck.add(new Card(j , 'C'));
			}
		}
	}
	
	// method for show card from deck without deleting
	public Card showCard(int number) {
		
		return deck.get(number);
	}
	
	// method for getting card out of the deck
	public Card getCardFromDeck() {
		int random = (int)(Math.random() * numberOfCardsLeft());
		Card temp = deck.get(random);
		deck.remove(random);
		//System.out.println(temp.toString());   // for tests
		
		return temp;
	}
	
	public int numberOfCardsLeft() {
		
		return deck.size();
	}
	
	// for tests
	public void printOutCards() {
		for(int i = 0; i < numberOfCardsLeft(); i++) {
			System.out.println("[" + i + "] " + showCard(i).toString());
			}
	}
}
