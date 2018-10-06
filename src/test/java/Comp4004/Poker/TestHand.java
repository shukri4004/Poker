package Comp4004.Poker;

import junit.framework.TestCase;

public class TestHand extends TestCase {

	public void testTypeOfHand() {//There are ten types of hands: 1=Royal Flush, 2=Straight Flush, ... 
		Hand[] h = new Hand[10];
		h[0] = new Hand();
		assertEquals(1, h[0].typeOfHand());
		h[1] = new Hand();
		assertEquals(1, h[1].typeOfHand());
		h[2] = new Hand();
		assertEquals(1, h[2].typeOfHand());
		h[3] = new Hand();
		assertEquals(1, h[3].typeOfHand());
		h[4] = new Hand();
		assertEquals(1, h[4].typeOfHand());
		h[5] = new Hand();
		assertEquals(1, h[5].typeOfHand());
		h[6] = new Hand();
		assertEquals(1, h[6].typeOfHand());
		h[7] = new Hand();
		assertEquals(1, h[7].typeOfHand());
		h[8] = new Hand();
		assertEquals(1, h[8].typeOfHand());
		h[9] = new Hand();
		assertEquals(1, h[9].typeOfHand());

	}
}
