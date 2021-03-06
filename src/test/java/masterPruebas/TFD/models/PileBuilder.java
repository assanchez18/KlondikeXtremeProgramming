package masterPruebas.TFD.models;

import java.util.LinkedList;

public class PileBuilder {

	LinkedList<Card> cards;

	PileBuilder() {
		cards = new LinkedList<Card>();
	}

	Pile build() {
		if (cards.size() > 0) {
			cards.peekLast().flip();
		}
		Pile pile = new Pile(cards.size(), cards);
		return pile;
	}

	PileBuilder card(Card card) {
		cards.add(card);
		return this;
	}
}
