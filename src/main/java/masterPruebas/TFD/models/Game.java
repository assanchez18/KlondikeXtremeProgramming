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
		clear();
	}
	
	public void clear() {
		//BUILDER PARA Stock en el futuro
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
			return Error.NO_ERROR;
		}
	}
	
	public Stock getStock() {
		return this.stock;
	}
	
	public Map<Suit,Foundation> getFoundations() {
		return foundations;
	}
	
	public List<Pile> getPiles() {
		return this.piles;
	} 
	
}
