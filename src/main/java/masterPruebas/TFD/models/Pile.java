package masterPruebas.TFD.models;

import java.util.List;
import java.util.Stack;

public class Pile extends CardStack {

	private int number;
	private int numberOfFaceUpCards;
	
	Pile(int number, List<Card> cardList) {
		super();
		this.numberOfFaceUpCards = 0;
		for (Card card : cardList) {
			cards.push(card);
			if (card.isFaceUp()) {
				this.numberOfFaceUpCards ++;
			}
		}
		if (number > 0) {
			flipFirstCard();
			numberOfFaceUpCards++;
		}
		this.number = number;
	}
	
	private void flipFirstCard() {
		cards.peek().flip();
	}
	
	public boolean fitsIn(Card card) {
		assert card != null;
		if (empty()) {
			return true;
		}
		return (peek().isNext(card) && peek().getSuit() != card.getSuit()) || !peek().isFaceUp();
	}

	public List<Card> getTop(int quantity) {
		assert quantity > -1;
		Stack<Card> top = new Stack<Card>();
		while (quantity > 0 && this.numberOfFaceUpCards >= quantity && this.number > 0) {
			top.add(0, cards.pop());
			quantity--;
			this.numberOfFaceUpCards--;
			this.number--;
		}
		if (numberOfFaceUpCards == 0 && this.number > 0) {
			flipFirstCard();
			this.numberOfFaceUpCards++;
		}
		return top;
	}

	public void addToTop(List<Card> cards) {
		assert cards != null;
		assert !cards.isEmpty();
		for(int i = 0; i < cards.size(); i++ ) {
			push(cards.get(i));
		}
	}
	
	public void removeTop(int quantity) {
		assert quantity > -1;
		while (quantity < cards.size() && quantity > 0) {
			cards.pop();
			quantity--;
			this.numberOfFaceUpCards--;
			this.number--;
		}
		if (numberOfFaceUpCards == 0 && this.number > 0) {
			flipFirstCard();
			this.numberOfFaceUpCards++;
			this.number++;
		}
	}
	
	public int getNumberOfFaceUpCards() {
		return this.numberOfFaceUpCards;
	}
	
	@Override
	public boolean empty() {
		return cards.isEmpty();
	}
	
	public Stack<Card> getCards() {
		return this.cards;
	}
		
	public int getNumber() {
		return this.number;
	}

	@Override
	public void push (Card card){
		if(fitsIn(card)) {
			super.push(card);
			this.number++;
			if(card.isFaceUp()) {
				this.numberOfFaceUpCards++;
			}
		}
	}
	
}
