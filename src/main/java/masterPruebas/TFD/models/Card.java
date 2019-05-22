package masterPruebas.TFD.models;

public class Card {
	private boolean faceUp;
	private Suit suit;
	private Number number;

	Card(Suit suit, Number number) {
		this.suit = suit;
		this.number = number;
		this.faceUp = false;
	}

	public void flip() {
		this.faceUp = !this.faceUp;
	}

	public boolean isFaceUp() {
		return faceUp;
	}

	public boolean isNext(Card card) {
		return getNumber().getValue() == (card.getNumber().getValue() + 1);
	}
	
	Number getNumber() {
		return this.number;
	}
	
	public Suit getSuit() {
		return this.suit;
	}
	
	public Color getColor() {
		return this.suit.getColor();
	}
	
	@Override
	public String toString() {
		return "Color: " +  getSuit() + " -- Number: " + getNumber();
		
	}
}
