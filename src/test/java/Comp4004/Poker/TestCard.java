package Comp4004.Poker;

import junit.framework.TestCase;

public class TestCard extends TestCase {

		public void testGetSuit() {
		
			Card c = new Card("S", "2");
			assertEquals("S", c.getSuit());
		}
		
		public void testGetRank() {
			
			Card c = new Card("D", "4");
			assertEquals("4", c.getRank());
		}
		
}
