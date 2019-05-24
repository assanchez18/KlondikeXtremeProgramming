package masterPruebas.TFD.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {

	@Test
	public void givenCard_whenFlip_thenFlipped() {		
		Card card = new CardBuilder().build();
		card.flip();
		assertTrue(card.isFaceUp());
		card.flip();
		assertFalse(card.isFaceUp());
	}
	
	@Test
	public void givenCards_isNext() {
		Card firstCard = new CardBuilder().number(Number.FIVE).build();
		Card secondCard = new CardBuilder().number(Number.FOUR).build();
		assertTrue(firstCard.isNext(secondCard));
		Card thirdCard = new CardBuilder().number(Number.SIX).build();
		assertFalse(firstCard.isNext(thirdCard));
	}
}
