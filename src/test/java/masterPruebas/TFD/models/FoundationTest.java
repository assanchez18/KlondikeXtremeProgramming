package masterPruebas.TFD.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class FoundationTest {

	@Test
	public void givenCompleteFoundation_thenIsComplete() {
		Foundation foundation = new CompleteFoundationBuilder().build();
		assertTrue(foundation.isComplete());
	}

	@Test
	public void givenFoundationAndCard_whenFitsIn_thenFitsIn() {
		Foundation foundation = new FoundationBuilder()
				.suit(Suit.PIKES)
				.card(new CardBuilder().number(Number.AS).build()) 
				.card(new CardBuilder().number(Number.TWO).build())
				.card(new CardBuilder().number(Number.THREE).build())
				.card(new CardBuilder().number(Number.FOUR).build())
				.card(new CardBuilder().number(Number.FIVE).build())
				.build();
		assertTrue(foundation.fitsIn( new CardBuilder().number(Number.SIX).build()));
		assertFalse(foundation.fitsIn( new CardBuilder().number(Number.SIX).suit(Suit.DIAMONDS).build()));
	}

}
