package masterPruebas.TFD.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

	static final int NUMBER_OF_PILES = 7;
	private Map<Suit, Foundation> foundations;
	private Stock stock;
	private Waste waste;
	private List<Pile> piles;
	
	public Game() {
		this.foundations = new HashMap<Suit,Foundation>();
		for (Suit s : Suit.values()) {
			this.foundations.put(s, new Foundation(s));
		}
		this.waste = new Waste();
		this.piles = new ArrayList<Pile>(Game.NUMBER_OF_PILES);
		
		for(int i = 0; i < Game.NUMBER_OF_PILES; i++) {
			this.piles.add(new Pile(0, new ArrayList<Card>()));
		}
		
		stock = new Stock();
		int hiddenCards = 0;
		for(Pile p : this.piles) {
			for(int j = 0; j < (hiddenCards); j++) {
				p.push(stock.pop());
			}
			Card c = stock.pop();
			c.flip();
			p.push(c);
			hiddenCards++;
		}
	}
	
	public void clear() {
		this.foundations = new HashMap<Suit, Foundation>();
		this.stock = new Stock();
		this.waste = new Waste();
		this.piles = new ArrayList<Pile>();
	}
	
	public boolean isFinished() {
		for (Foundation f : this.foundations.values()) {
			if (f.empty() || !f.isComplete()) {
				return false;
			}
		}
		return true;
	}
	
	public Error moveFromStockToWaste() {
		if (stock.empty()) {
			return Error.EMPTY_STOCK;
		}
		else {
			waste.push(stock.pop());
			return null;
		}
	}
	public Error moveFromWasteToFoundation() {
		if( this.waste.peek().getNumber() == Number.AS || (!this.foundations.get(this.waste.peek().getSuit()).empty()  && this.waste.peek().isNext(this.foundations.get(this.waste.peek().getSuit()).peek()))) {
			this.foundations.get(this.waste.peek().getSuit()).push(this.waste.pop());
			return null;
		}
		return Error.NO_FIT_FOUNDATION;
	}
	
	public Stock getStock() {
		return this.stock;
	}
	
	public Waste getWaste() {
		return this.waste;
	}
	
	public Map<Suit,Foundation> getFoundations() {
		return foundations;
	}
	
	public List<Pile> getPiles() {
		return this.piles;
	} 
	
}
