package Comp4004.Poker;

import junit.framework.TestCase;

public class TestDeck extends TestCase {

	public void testGetCard() {
		
		//Card a = new Card("D", "2");
		
		Deck d = new Deck(); //According to the specification a deck contains 52 cards
		assertEquals("C", d.getCard(8).getSuit());
		assertEquals("4", d.getCard(8).getRank());
	}
}
