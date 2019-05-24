package masterPruebas.TFD.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void whenClear_thenNewGameGenerated() {
		Game game = new Game();
		int stockSize = 24;
		int totalCards = 52 - stockSize;
		int cardsOnPile = 1;
		int numberOfFaceUpCards = 1;
		assertEquals(stockSize, game.getStock().getSize());
		
		for(Pile p : game.getPiles()) {
			assertEquals(cardsOnPile, p.getNumber());
			assertEquals(numberOfFaceUpCards, p.getNumberOfFaceUpCards());
			cardsOnPile++;
			totalCards -= p.getNumber();
		}
		assertEquals(0, totalCards);
		}
	
	@Test
	public void givenFinishedGame_thenIsFinishedTrue() {
		Game game = new FinishedGameBuilder().build();
		assertTrue(game.isFinished());
	}
	
	@Test
	public void givenNotFinishedGame_thenIsFinishedFalse() {
		Game game = new GameBuilder().build();
		assertFalse(game.isFinished());
	}
	
	@Test
	public void givenGame_whenMovingFromStockToWaste_thenMoveSuccesfull() {
		Game game = new GameBuilder().stock(new StockBuilder()
				                                             .card(new CardBuilder().number(Number.AS).suit(Suit.PIKES).build())
				                                             .card(new CardBuilder().number(Number.TWO).suit(Suit.PIKES).build())
				                                             .card(new CardBuilder().number(Number.THREE).suit(Suit.PIKES).build())
				                                             .build()).build();
		assertNull(game.moveFromStockToWaste());
	}
	
	@Test
	public void givenGameWithEmptyStock_whenMovingFromStockToWaste_thenMoveError() {
		Game game = new GameBuilder().stock(new StockBuilder().build()).build();
		assertEquals(Error.EMPTY_STOCK, game.moveFromStockToWaste());
	}

	@Test
	public void givenGame_whenMovingFromWasteToFoundation_thenMoveSuccesfull() {
		Waste waste = new WasteBuilder().card(new CardBuilder().number(Number.AS).suit(Suit.PIKES).build()).build();
		Foundation foundation = new FoundationBuilder().suit(Suit.PIKES).build();
		Game game = new GameBuilder().waste(waste).foundation(foundation).build();
		assertNull(game.moveFromWasteToFoundation());				
	}
	
	@Test
	public void givenGame_whenMovingFromWasteToFoundation_thenMoveError() {
		Waste waste = new WasteBuilder().card(new CardBuilder().number(Number.TWO).suit(Suit.PIKES).build()).build();
		Foundation foundation = new FoundationBuilder().suit(Suit.PIKES).build();
		Game game = new GameBuilder().waste(waste).foundation(foundation).build();
		assertEquals(Error.NO_FIT_FOUNDATION,game.moveFromWasteToFoundation());				
	}
	
	@Test
	public void givenGame_whenMovingFromWasteToStock_thenMoveSuccesfull() {
		fail("Not implemented");		
	}
	
	@Test
	public void givenGame_whenMovingFromWasteToStock_thenMoveError() {
		fail("Not implemented");
	}
	
	@Test
	public void givenGame_whenMovingFromWasteToPile_thenMoveSuccesfull() {
		fail("Not implemented");
	}
	
	@Test
	public void givenGame_whenMovingFromWasteToPile_thenMoveError() {
		fail("Not implemented");
	}

	@Test
	public void givenGame_whenMovingFromFoundationToPile_thenMoveSuccesfull() {
		fail("Not implemented");
	}
	
	@Test
	public void givenGame_whenMovingFromFoundationToPile_thenMoveError() {
		fail("Not implemented");
	}
	
	@Test
	public void givenGame_whenMovingFromPileToFoundation_thenMoveSuccesfull() {
		fail("Not implemented");
	}
	
	@Test
	public void givenGame_whenMovingFromPileToFoundation_thenMoveError() {
		fail("Not implemented");
	}
	
	@Test
	public void givenGame_whenMovingFromPileToPile_thenMoveSuccesfull() {
		fail("Not implemented");
	}
	
	@Test
	public void givenGame_whenMovingFromPileToPile_thenMoveError() {
		fail("Not implemented");
	}
	
}
