package masterPruebas.TFD.models;

import java.util.ArrayList;
import java.util.List;

public class Stock extends CardStack {

	Stock() {
		super();
	}
	
	public List<Card> takeTop(int quantity) {
		assert quantity > 1 && quantity < cards.size();
		List<Card> top = new ArrayList<Card>();
		for(int i = 0; i < quantity; i++) {
			top.add(super.pop());
		}
		return top;
	}
}
