package wizen.rafal.springbootdemoapp.thymeleafdemo.gamecomponents;

import java.util.List;

public class GameTable {

	Player player;
	Croupier croupier;
	Deck deck;

	public GameTable() {
		player = new Player();
		croupier = new Croupier();
		deck = new Deck(1);
		startNewGame();
	}
	
	// method for start new game
	public void startNewGame() {
		playerGetsCard();
		playerGetsCard();
		croupierGetsCard();
	}
	
	// TEST method
	// method to take out all cards
	public void test() {
		while(deck.numberOfCardsLeft()>0) {
		deck.getCardFromDeck();
		deck.printOutCards();
		}
	}
	
	// method to add card from deck to players stack
	public void playerGetsCard() {
		Card temp = deck.getCardFromDeck();
		System.out.println("Player gets:" + temp + "\n");
		player.addCardToPlayersStack(temp);
		System.out.println("Players sum: "+player.cardsSum());
	}
	
	public int getPlayerMoney() {
		return player.getMoney();
	}
	
	public List<Card> getPlayersCards() {
		return player.getPlayersCards();
	}
	
	public List<Card> getCroupiersCards() {
		return croupier.getCroupiersCards();
	}
	
	public int croupiersCardsSum() {
		return croupier.cardsSum();
	}
	
	public int playersCardsSum() {
		return player.cardsSum();
	}
	
	// method to add card from deck to croupiers stack
	public void croupierGetsCard() {
		Card temp = deck.getCardFromDeck();
		System.out.println("Croupier gets:" + temp + "\n");
		croupier.addCardToCroupiersStack(temp);
	}
	
	// method to print all cards + sum of them
	public void printCards() {
		System.out.println("Players cards:");
		System.out.println(player.getPlayersCards());
		System.out.println("Players sum: "+player.cardsSum());
		System.out.println("Croupiers cards:");
		System.out.println(croupier.getCroupiersCards());
		System.out.println("Croupiers sum: " + croupier.cardsSum());
		System.out.println("\n");
	}

	public boolean checkforPlayersLoose() {
		return player.checkLoose();
	}
	
	// player stands and croupier takes cards if sum is less than 17
	// method called while pressed "3"
	public void croupierStartsHisTurn() {
		
		// print out all players cards + sum of them
		System.out.println("Players cards:");
		System.out.println(player.getPlayersCards());
		System.out.println("Players sum: "+player.cardsSum());
		
		// croupier starts to take cards until he has 17 or more
		System.out.println("Croupier starts his turn:");
		while(croupier.cardsSum() < 17) {			
			croupierGetsCard();
			// method to check for loose of croupier + change aces to 1 if necessary
			croupier.isBusted();
		}
		
		// print out all croupiers cards + sum of them
		System.out.println("Croupiers cards:");
		System.out.println(croupier.getCroupiersCards());
		System.out.println("Croupiers sum: " + croupier.cardsSum());
		
		isPlayerAWinner();
	}
	
	public boolean isPlayerAWinner() {
		if(croupier.isBusted() || player.cardsSum() > croupier.cardsSum()) {
			System.out.println("Player won");
			return true;
		}
		System.out.println("Player lost");
		return false;
	}
	
}
