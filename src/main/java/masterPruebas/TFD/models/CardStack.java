package masterPruebas.TFD.models;

import java.util.Stack;

public abstract class CardStack {

	protected Stack<Card> cards;
	
	CardStack() {
		this.cards = new Stack<Card>();
	}
	
	public boolean empty() {
		return cards.empty();
	}
	
	public Card peek() {
		return this.cards.peek();
	}
	
	public Card pop() {
		return this.cards.pop();
	}
	
	public void push(Card card) {
		assert card != null;
		this.cards.push(card);
	}
}
