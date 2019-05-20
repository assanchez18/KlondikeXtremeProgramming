package masterPruebas.TFD.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class StockTest {

	@Test
	public void givenStock_whenPop_thenReturnQuantityCards() {
	    int quantity = 3;
		Stock stock = new StockBuilder().build();
	    assertEquals(quantity, stock.takeTop(quantity).size());
	    //CHECK WHAT TO ASSERT WHEN QUANTITY > stock.size();
	}

}
