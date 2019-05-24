package masterPruebas.TFD.models;

import java.util.LinkedList;

public class WasteBuilder {

	LinkedList<Card> cards;
	
	public WasteBuilder() {
		this.cards = new LinkedList<Card>();
	}
	
	public Waste build() {
		Waste waste = new Waste();
		while(!cards.isEmpty()) {
			waste.push(cards.poll());
		}
		return waste;
	}
	
	public WasteBuilder card(Card card) {
		cards.push(card);
		return this;
	}
}
