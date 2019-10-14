package wizen.rafal.springbootdemoapp.thymeleafdemo.gamecomponents;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private List <Card> playersCards;
	private int sum;
	private int money;
	
	public Player() {
		playersCards = new ArrayList<>();
		money = 500;
	}

	public List<Card> getPlayersCards() {
		return playersCards;
	}
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	// method to add card to players stack
	public void addCardToPlayersStack(Card temp) {
		playersCards.add(temp);
	}
	
	// method to check sum of players stack
	public int cardsSum() {
		sum = 0;
		for(int i = 0; i < playersCards.size(); i++) {
			sum += playersCards.get(i).getCardStrenght();
		}
		return sum;
	}
	
	// method to check if in players stack is Ace with value 11
	public void checkForAce() {
		for(int i = 0; i < playersCards.size(); i++) {
			if(playersCards.get(i).isItHighAce()) {
				changeAceElevenToOne(playersCards.get(i));
			}
		}
	}
	
	// method to change value of ace to 1
	public void changeAceElevenToOne(Card Ace) {
		Ace.changeAceElevenToOne();
	}
	
	// method to check for loose
	public boolean checkLoose() {
		if(cardsSum() > 21) {
			checkForAce();
			if(cardsSum() > 21) {
				System.out.println("Player busted");
				return true;
			}
		}
		return false;
	}
	
	
}
