package masterPruebas.TFD.models;

public class CardBuilder {

	private Suit suit;
	private Number number;
	private boolean facedUp;
	
	public CardBuilder () {
		this.suit = Suit.PIKES;
		this.number = Number.AS;
		this.facedUp = false;
	}
	Card build() {
		Card card = new Card(this.suit, this.number);
		if(this.facedUp) {
			card.flip();
		}
		return card;
	}
	
	public CardBuilder number(Number number)  {
		assert number != null;
		this.number = number;
		return this;
	}
	
	public CardBuilder suit(Suit suit) {
		assert suit != null;
		this.suit = suit;
		return this;
	}
	

}
