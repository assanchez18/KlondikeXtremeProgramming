package masterPruebas.TFD.models;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class GameBuilder {

	private Map<Suit, Foundation> foundations;
	private Stack<Card> stock;
	private LinkedList<Card> waste;
	
	public GameBuilder() {
		
		this.foundations = new HashMap<Suit,Foundation>();
		for (Suit s : Suit.values()) {
			this.foundations.put(s, new FoundationBuilder().suit(s).build());
		}
		this.stock = new Stack<Card>();
		this.waste = new LinkedList<Card>();
	}
	
	public Game build() {
		Game game = new Game();
		updateFoundation(game);
		updateStock(game);
		updateWaste(game);
		return game;
	}
	
	public GameBuilder foundation(Foundation foundation) {
		this.foundations.put(foundation.getSuit(), foundation);
		return this;
	}
	
	public GameBuilder stock(Stock stock) {
		while(!stock.empty()) {
			this.stock.push(stock.pop());	
		}
		return this;
	}
	
	private void updateStock(Game game) {
		while(!game.getStock().empty()) {
			game.getStock().pop();
		}
		while (!this.stock.empty()) {
			game.getStock().push(this.stock.pop());
		}
	}
	
	private void updateFoundation(Game game) {
		for(Suit s : Suit.values()) {
			game.getFoundations().put(s, this.foundations.get(s));
		}
	}
	
	private void updateWaste(Game game) {
		while(!this.waste.isEmpty() ) {
			game.getWaste().push(this.waste.pop());
		}
	}
	
	public GameBuilder waste(Waste waste) {
		while(!waste.empty()) {
			this.waste.push(waste.pop());	
		}
		return this;
	}
}
