package masterPruebas.TFD.models;

import java.util.LinkedList;;

public class StockBuilder {
	
	private LinkedList<Card> cards;
	
	public StockBuilder(){
		this.cards = new LinkedList<Card>();
	}
	
	public Stock build() {
		Stock stock = new Stock();
		while(!cards.isEmpty())
			stock.push(cards.pollFirst());
		return stock;
	}
	
	public StockBuilder card(Card card) {
		this.cards.push(card);
		return this;
	}
}
