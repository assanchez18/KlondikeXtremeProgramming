package masterPruebas.TFD.models;

import java.util.List;
import java.util.Stack;

public class Pile extends CardStack {

	private int number;
	private int numberOfFaceUpCards;
	
	Pile(int number, List<Card> cardList) {
		super();
		for (Card card : cardList) {
			cards.push(card);
		}
		flipFirstCard();
		this.number = number;
		numberOfFaceUpCards = 1;
	}
	public boolean fitsIn(Card card) {
		assert card != null;
		if (isEmpty()) {
			return true;
		}
		return (peek().isNext(card) && peek().getSuit() != card.getSuit());
	}
	private void flipFirstCard() {
		cards.peek().flip();
	}
	
	public Stack<Card> getCards() {
		return this.cards;
	}
	
	public void removeTop(int quantity) {
		assert quantity > -1;
		while (quantity < cards.size()) {
			cards.pop();
			quantity--;
		}
		
	}
}
