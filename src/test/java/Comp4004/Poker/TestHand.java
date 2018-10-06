package Comp4004.Poker;

import junit.framework.TestCase;

public class TestHand extends TestCase {

	public void testTypeOfHand() {//There are ten types of hands: 1=Royal Flush, 2=Straight Flush, ... 
		Hand[] h = new Hand[10];
		assertEquals(1, h[0].typeOfHand());
		assertEquals(2, h[1].typeOfHand());
		assertEquals(3, h[2].typeOfHand());
		assertEquals(4, h[3].typeOfHand());
		assertEquals(5, h[4].typeOfHand());
		assertEquals(6, h[5].typeOfHand());
		assertEquals(7, h[6].typeOfHand());
		assertEquals(8, h[7].typeOfHand());
		assertEquals(9, h[8].typeOfHand());
		assertEquals(10, h[9].typeOfHand());
	}
}
