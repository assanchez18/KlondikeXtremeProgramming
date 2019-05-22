package masterPruebas.TFD.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PileTest {

	@Test
	public void givenAPile_whenAddACardThatDoesNotFitInByColorSuit_ThenTheResultIsFalse() {
		Pile pile = new PileBuilder().card(new CardBuilder().number(Number.KING).suit(Suit.PIKES).build()).build();
		Card card = new CardBuilder().number(Number.QUEEN).suit(Suit.PIKES).build();
		assertFalse(pile.fitsIn(card));		
	}
	
	@Test
	public void givenAPile_whenAddACardThatDoesNotFitInByNumber_ThenTheResultIsFalse() {
		Pile pile = new PileBuilder().card(new CardBuilder().number(Number.KING).suit(Suit.PIKES).build()).build();
		Card card = new CardBuilder().number(Number.TWO).suit(Suit.DIAMONDS).build();
		assertFalse(pile.fitsIn(card));		
	}
	
	@Test
	public void givenAPile_whenAddACardThatFitsIn_ThenTheResultIsTrue() {
		Pile pile = new PileBuilder().card(new CardBuilder().number(Number.SEVEN).suit(Suit.PIKES).build()).build();
		Card card = new CardBuilder().number(Number.SIX).suit(Suit.HEARTS).build();
		assertTrue(pile.fitsIn(card));		
	}
	
	@Test
	public void givenAPile_whenAddACardThatDoesNotFitInByCloseUpperNumber_ThenTheResultIsFalse() {
		Pile pile = new PileBuilder().card(new CardBuilder().number(Number.SEVEN).suit(Suit.PIKES).build()).build();
		Card card = new CardBuilder().number(Number.EIGHT).suit(Suit.HEARTS).build();
		assertFalse(pile.fitsIn(card));		
	}

	@Test
	public void givenAPileWith2Cards_whenGetTop2Cards_ThenTheResultIsTheTwoCorrectCards() {
		int quantity = 2;
		Card card1 = new CardBuilder().number(Number.SEVEN).suit(Suit.PIKES).build();
		Card card2 = new CardBuilder().number(Number.EIGHT).suit(Suit.HEARTS).build();
		Pile pile = new PileBuilder().card(card1).card(card2).build();
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(card1);
		cardList.add(card2);
		assertEquals(cardList, pile.getTop(quantity));		
	}
	
	@Test
	public void givenAPileWith3Cards_whenGetTop2Cards_ThenTheResultIsTheTwoCorrectCards() {
		int quantity = 2;
		Card card1 = new CardBuilder().number(Number.SEVEN).suit(Suit.PIKES).build();
		Card card2 = new CardBuilder().number(Number.EIGHT).suit(Suit.HEARTS).build();
		Card card3 = new CardBuilder().number(Number.NINE).suit(Suit.PIKES).build();
		Pile pile = new PileBuilder().card(card1).card(card2).card(card3).build();
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(card2);
		cardList.add(card3);
		assertEquals(cardList, pile.getTop(quantity));		
	}

	@Test
	public void givenAPile_whenGetTop0Cards_ThenTheResultIsEmptyList() {
		int quantity = 0;
		Pile pile = new PileBuilder().build();
		assertEquals(new ArrayList<Card>(), pile.getTop(quantity));		
	}
	
	@Test
	public void givenAPileWith2Cards_whenGetTop3Cards_ThenTheResultIsEmptyList() {
		int quantity = 3;
		Card card1 = new CardBuilder().number(Number.SEVEN).suit(Suit.PIKES).build();
		Card card2 = new CardBuilder().number(Number.EIGHT).suit(Suit.HEARTS).build();
		Pile pile = new PileBuilder().card(card1).card(card2).build();
		assertEquals(new ArrayList<Card>(),pile.getTop(quantity));		
	}
	
	
	@Test
	public void givenAPileWith1Card_whenAddToTop1Card_ThenTheResultIsTheListWithThese2Cards() {
		Card card1 = new CardBuilder().number(Number.EIGHT).suit(Suit.PIKES).build();
		Card card2 = new CardBuilder().number(Number.SEVEN).suit(Suit.HEARTS).build();
		Pile pile = new PileBuilder().card(card1).build();
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(card1);
		cardList.add(card2);
		
		List<Card> cardsToAdd = new ArrayList<Card>();
		cardsToAdd.add(card2);
		pile.addToTop(cardsToAdd);
		assertEquals(cardList, pile.getCards());		
	}
	
	@Test
	public void givenAnEmptyPile_AddToTop1Card_ThenTheResultIsTheListWithThisCard() {
		Card card1 = new CardBuilder().number(Number.KING).suit(Suit.PIKES).build();
		Pile pile = new PileBuilder().build();
		
		List<Card> cardsToAdd = new ArrayList<Card>();
		cardsToAdd.add(card1);
		pile.addToTop(cardsToAdd);
		assertEquals(cardsToAdd, pile.getCards());		
	}
	
	@Test
	public void givenAnEmptyPile_whenAddToTop0Cards_ThenNoCardsAdded() {
		Pile pile = new PileBuilder().build();
		pile.addToTop(new ArrayList<Card>());
		assertTrue(pile.getCards().isEmpty());		
	}
	
	@Test
	public void givenAPileWith2Cards_whenRemoveTop0Cards_ThenNoCardsRemoved() {
		Card card1 = new CardBuilder().number(Number.EIGHT).suit(Suit.PIKES).build();
		Card card2 = new CardBuilder().number(Number.SEVEN).suit(Suit.HEARTS).build();
		Pile pile = new PileBuilder().card(card1).card(card2).build();
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(card1);
		cardList.add(card2);

		int quantity = 0;
		pile.removeTop(quantity);
		assertEquals(cardList, pile.getCards());		
	}
	
	@Test
	public void givenAPileWith2Cards_whenRemoveTop1Card_ThenOneCardRemoved() {
		Card card1 = new CardBuilder().number(Number.EIGHT).suit(Suit.PIKES).build();
		Card card2 = new CardBuilder().number(Number.SEVEN).suit(Suit.HEARTS).build();
		Pile pile = new PileBuilder().card(card1).card(card2).build();
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(card1);

		int quantity = 1;
		pile.removeTop(quantity);
		assertEquals(cardList, pile.getCards());			
	}
	
	@Test
	public void givenAPileWith2Cards_whenRemoveTop3Cards_ThenOnlyTwoCardsRemoved() {
		Card card1 = new CardBuilder().number(Number.EIGHT).suit(Suit.PIKES).build();
		Card card2 = new CardBuilder().number(Number.SEVEN).suit(Suit.HEARTS).build();
		Pile pile = new PileBuilder().card(card1).card(card2).build();
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(card1);
		cardList.add(card2);

		int quantity = 3;
		pile.removeTop(quantity);
		assertEquals(cardList, pile.getCards());			
	}

}