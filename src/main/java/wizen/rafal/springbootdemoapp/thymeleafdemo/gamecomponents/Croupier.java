package wizen.rafal.springbootdemoapp.thymeleafdemo.gamecomponents;

import java.util.ArrayList;
import java.util.List;

public class Croupier {

	private List <Card> croupiersCards;
	private int sum;
	
	public Croupier() {
		croupiersCards = new ArrayList<>();
	}

	public List<Card> getCroupiersCards() {
		return croupiersCards;
	}

	// method to add card to croupiers stack
	public void addCardToCroupiersStack(Card temp) {
		croupiersCards.add(temp);
	}
	
	// method to check sum of croupiers stack
	public int cardsSum() {
		sum = 0;
		for(int i = 0; i < croupiersCards.size(); i++) {
			sum += croupiersCards.get(i).getCardStrenght();
		}
		return sum;
	}

	// method to check if in croupiers stack is Ace with value 11
	public void checkForAce() {
		for(int i = 0; i < croupiersCards.size(); i++) {
			if(croupiersCards.get(i).isItHighAce()) {
				changeAceElevenToOne(croupiersCards.get(i));
			}
		}
	}
	
	// method to change value of ace to 1
	public void changeAceElevenToOne(Card Ace) {
		Ace.changeAceElevenToOne();
	}
	
	// method to check for loose
		public boolean isBusted() {
			if(cardsSum() > 21) {
				checkForAce();
				if(cardsSum() > 21) {
					System.out.println("Croupier busted");
					return true;
				}
			}
			return false;
		}
}
