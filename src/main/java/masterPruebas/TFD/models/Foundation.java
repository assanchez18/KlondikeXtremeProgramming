package masterPruebas.TFD.models;

public class Foundation extends CardStack{
	private Suit suit;
	
	public Foundation(Suit suit) {
		super();
		assert suit != null;
		this.suit = suit;
	}
	
	/*public void push(Card card) {
		//pensar porque Luís decía que existía. Depende de game
	}*/

	public boolean isComplete() {
		return peek().getNumber().getValue() == Number.KING.getValue();
	}
	
	public boolean fitsIn(Card card) {
		assert card != null;
		return (card.isNext(cards.peek()) && card.getSuit() == getSuit());
	}
	
	public Suit getSuit() {
		return this.suit;
	}
}
