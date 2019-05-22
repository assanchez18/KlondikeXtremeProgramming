package masterPruebas.TFD.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {

	@Test
	public void givenFaceDownCard_whenFlip_thenCardFaceUp() {		
		Card card = new CardBuilder().build();
		card.flip();
		assertTrue(card.isFaceUp());
	}
	
	@Test
	public void givenNumberFiveCardAndNumberFourCard_whenisNext_thenTrue() {
		Card firstCard = new CardBuilder().number(Number.FIVE).build();
		Card secondCard = new CardBuilder().number(Number.FOUR).build();
		assertTrue(firstCard.isNext(secondCard));
	}
}
