package masterPruebas.TFD.models;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class GameBuilder {

	private Map<Suit, Foundation> foundations;
	private Stock stock;
	
	GameBuilder() {
		this.foundations = new HashMap<Suit,Foundation>();
		for (Suit s : Suit.values()) {
			this.foundations.put(s, new FoundationBuilder().suit(s).build());
		}
		this.stock = new StockBuilder().build();
	}
	
	public Game build() {
		Game game = new Game();
		updateFoundation(game);
		updateStock(game);
		return game;
	}
	
	public GameBuilder foundation(Foundation foundation) {
		this.foundations.put(foundation.getSuit(), foundation);
		return this;
	}
	
	public GameBuilder stock(Stock stock) {
		this.stock = stock;
		return this;
	}
	
	private void updateStock(Game game) {
		while(!game.getStock().empty()) {
			game.getStock().pop();
		}
		Stack<Card> auxiliarList = new Stack<Card>();
		while (!this.stock.empty()) {
			auxiliarList.push(this.stock.pop());
		}
		while (!auxiliarList.isEmpty()) {
			game.getStock().push(auxiliarList.pop());
		}
	}
	
	private void updateFoundation(Game game) {
		for(Suit s : Suit.values()) {
			game.getFoundations().put(s, this.foundations.get(s));
		}
	}
}
