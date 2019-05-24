package masterPruebas.TFD.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class StockTest {

	@Test
	public void givenStock_whenTakeTop_thenReturnQuantityCards() {
	    int quantity = 3;
		Stock stock = new StockBuilder().card(new CardBuilder().build())
				                        .card(new CardBuilder().build())
				                        .card(new CardBuilder().build()).build();
	    assertEquals(quantity, stock.takeTop(quantity).size());
	}
	
	@Test
	public void popStock() {
		Stock stock = new StockBuilder().card(new CardBuilder().build()).build();
		assertFalse(stock.empty());
		stock.pop();
		assertTrue(stock.empty());
	}

	@Test
	public void pushStock() {
		Stock stock = new StockBuilder().build();
		assertTrue(stock.empty());
		stock.push(new CardBuilder().build());
		assertFalse(stock.empty());
	}
}
