package Comp4004.Poker;

import junit.framework.TestCase;

public class TestDeck extends TestCase {

	public void testGetCard() {
		
		Deck d = new Deck(); //According to the specification a deck contains 52 cards
		assertEquals("S", d.getCard(7).getSuit());
		assertEquals("3", d.getCard(7).getRank());
	}
}
