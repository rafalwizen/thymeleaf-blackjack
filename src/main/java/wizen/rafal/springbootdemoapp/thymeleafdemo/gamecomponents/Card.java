package wizen.rafal.springbootdemoapp.thymeleafdemo.gamecomponents;

public class Card {

	private int value; // 1-13, 1 - Ace, 11 - Jack, 12 - Queen, 13 - King
	private char color; // H - heart, S - spades, D - diamonds, C - clubs
	private int cardStrength; // Ace - 11/1, Figures - 10
	private String cardView;
	
	public Card() {
		
	}
	
	public Card(int value, char color) {
		this.value = value;
		this.color = color;
		if(value == 11 ||value == 12 ||value == 13) { // set Figures strenght to 10
			this.cardStrength = 10;
		} else if (value == 1) {        // set Ace start strenght to 11
			this.cardStrength = 11;
		} else {
			this.cardStrength = value; // set rest to value number
		}
		this.cardView = "/images/" + value + color + ".png";
		
		// TO EDIT - TEMP
		//this.cardView = "/images/1d.png";
	}

	@Override
	public String toString() {
		return "Card [value=" + value + ", color=" + color + ", cardStrenght=" + cardStrength + "]";
	}

	public int getValue() {
		return value;
	}

	public int getCardStrenght() {
		return cardStrength;
	}
	
	public String getCardView() {
		return cardView;
	}

	public void setCardView(String cardView) {
		this.cardView = cardView;
	}

	// method to check if card is an Ace with strength 11
	public boolean isItHighAce() {
		if(cardStrength == 11) {
			return true;
		}
		return false;
	}
	
	// method to change value of ace to 1
	public void changeAceElevenToOne() {
		if(cardStrength == 11) {
			cardStrength = 1;
		}
	}
}
