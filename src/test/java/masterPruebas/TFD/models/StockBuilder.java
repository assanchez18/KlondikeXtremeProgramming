package masterPruebas.TFD.models;

public class StockBuilder {
	
	public StockBuilder(){
	}
	
	public Stock build() {
		Stock stock =  new Stock();
		stock.push(new Card(Suit.DIAMONDS, Number.AS));
		stock.push(new Card(Suit.PIKES, Number.AS));
		stock.push(new Card(Suit.HEARTS, Number.AS));
		stock.push(new Card(Suit.CLOVERS, Number.AS));
		stock.push(new Card(Suit.DIAMONDS, Number.TWO));
		stock.push(new Card(Suit.PIKES, Number.TWO));
		return stock;
	}
}
