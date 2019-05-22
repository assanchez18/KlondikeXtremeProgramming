package masterPruebas.TFD.models;

public class EmptyStockBuilder {

	private StockBuilder stockBuilder;
	
	public EmptyStockBuilder() {
		this.stockBuilder = new StockBuilder();
	}
	
	public Stock build() {
		return this.stockBuilder.empty().build();
	}
}
