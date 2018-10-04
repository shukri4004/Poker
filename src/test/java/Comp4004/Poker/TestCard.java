package Comp4004.Poker;

import junit.framework.TestCase;

public class TestCard extends TestCase {

		public void testGetSuit() {
		
			Card c = new Card();
			assertEquals("S", c.getSuit());
		}
		
}
