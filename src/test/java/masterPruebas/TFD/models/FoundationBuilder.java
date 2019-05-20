package masterPruebas.TFD.models;

import java.util.*;

public class FoundationBuilder {
	private Queue<Card> stack;
	private Suit suit;
	
	public FoundationBuilder(){
		suit = Suit.PIKES;
		stack = new ArrayDeque<Card>();
	}
	
	public Foundation build() {
		Foundation foundation =  new Foundation(suit);
		while (!stack.isEmpty()) {
			foundation.push(stack.poll());
		}
		return foundation;
	}
	
	public FoundationBuilder card(Card card) {
		assert card != null;
		stack.add(card);
		return this;
	}
	
	public FoundationBuilder suit(Suit suit) {
		this.suit = suit;
		return this;
	}
	
}