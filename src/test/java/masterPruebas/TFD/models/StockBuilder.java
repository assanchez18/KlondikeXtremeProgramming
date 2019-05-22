package masterPruebas.TFD.models;

public class StockBuilder {
	
	private Stock stock;
	
	public StockBuilder(){
		this.stock = new Stock();
		stock.push(new Card(Suit.DIAMONDS, Number.AS));
		stock.push(new Card(Suit.PIKES, Number.AS));
		stock.push(new Card(Suit.HEARTS, Number.AS));
		stock.push(new Card(Suit.CLOVERS, Number.AS));
		stock.push(new Card(Suit.DIAMONDS, Number.TWO));
		stock.push(new Card(Suit.PIKES, Number.TWO));
	}
	
	public Stock build() {
		return this.stock;
	}
	
	public StockBuilder card(Card card) {
		stock.push(card);
		return this;
	}
	
	public StockBuilder empty() {
		while(!stock.empty()) {
			stock.pop();
		}
		return this;
	}
}
