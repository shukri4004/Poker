package Comp4004.Poker;

import junit.framework.TestCase;

public class TestHand extends TestCase {

	public void testTypeOfHand() {//There are ten types of hands: 1=Royal Flush, 2=Straight Flush, ... 
		Hand[] h = new Hand[10];
		//Royal Flush
		h[0] = new Hand();
		for(int i=0; i<5; i++)
			h[0].cards[i].suit="H";
		h[0].cards[0].rank="10"; h[0].cards[1].rank="J"; h[0].cards[2].rank="Q"; h[0].cards[3].rank="K"; h[0].cards[4].rank="Ace";
		assertEquals(1, h[0].typeOfHand());
		
		//Straight Flush
		h[1] = new Hand();
		for(int i=0; i<5; i++)
			h[1].cards[i].suit="S";
		h[1].cards[0].rank="5"; h[1].cards[1].rank="6"; h[1].cards[2].rank="7"; h[1].cards[3].rank="8"; h[1].cards[4].rank="9";
		assertEquals(2, h[1].typeOfHand());
		
	    //Four of a Kind
		h[2] = new Hand();
		for(int i=0; i<4; i++)
			h[2].cards[i].rank="J";
		h[2].cards[4].rank="3";
		assertEquals(3, h[2].typeOfHand());
		
		//Full House
		h[3] = new Hand();
		h[3].cards[0].rank="5"; h[3].cards[1].rank="5"; h[3].cards[2].rank="5"; h[3].cards[3].rank="9"; h[3].cards[4].rank="9";
		assertEquals(4, h[3].typeOfHand());
		
		//Flush
		h[4] = new Hand();
		for(int i=0; i<5; i++)
			h[4].cards[i].suit="H";
		h[4].cards[0].rank="2"; h[4].cards[1].rank="6"; h[4].cards[2].rank="7"; h[4].cards[3].rank="J"; h[4].cards[4].rank="K";
		assertEquals(5, h[4].typeOfHand());
		
		//Straight
		h[5] = new Hand();
		h[5].cards[0].rank="5"; h[5].cards[1].rank="6"; h[5].cards[2].rank="7"; h[5].cards[3].rank="8"; h[5].cards[4].rank="9";
		h[5].cards[0].suit="H"; h[5].cards[1].suit="D"; h[5].cards[2].suit="S";
		assertEquals(6, h[5].typeOfHand());
		
		//Three of a Kind
		h[6] = new Hand();
		h[6].cards[0].rank="5"; h[6].cards[1].rank="5"; h[6].cards[2].rank="5"; h[6].cards[3].rank="2"; h[6].cards[4].rank="9";
		assertEquals(7, h[6].typeOfHand());
		
		//Two pair
		h[7] = new Hand();
		h[7].cards[0].rank="5"; h[7].cards[1].rank="5"; h[7].cards[2].rank="10"; h[7].cards[3].rank="10"; h[7].cards[4].rank="9";
		h[7].cards[0].suit="S"; h[7].cards[1].suit="H"; h[7].cards[2].suit="D"; h[7].cards[3].suit="C"; 
		assertEquals(8, h[7].typeOfHand());
		
		//One Pair
		h[8] = new Hand();
		h[8].cards[0].rank="5"; h[8].cards[1].rank="5"; h[8].cards[2].rank="10"; h[8].cards[3].rank="3"; h[8].cards[4].rank="9";
		assertEquals(9, h[8].typeOfHand());
		
		//High Card
		h[9] = new Hand();
		h[9].cards[0].rank="5"; h[9].cards[1].rank="Q"; h[9].cards[2].rank="2"; h[9].cards[3].rank="10"; h[9].cards[4].rank="9";
		assertEquals(10, h[9].typeOfHand());

	}
	
	public void testApplyStrategy() {
		Hand h = new Hand();
		int[] hCopyVal = new int[5];
		boolean blComp = true;
		//Providing a Royal Flush hand and expecting no change in the hand when applying strategies
		for(int i=0; i<5; i++)
			h.cards[i].suit="C";
		h.cards[0].rank="10"; h.cards[1].rank="J"; h.cards[2].rank="Q"; h.cards[3].rank="K"; h.cards[4].rank="Ace";
		h.values[0]=32; h.values[1]=36; h.values[2]=40; h.values[3]=44; h.values[4]=48;
		//copy h to h2 before applying strategy. Copying h.values to h2.values will be enough. Refer to how "values" member is created in the Hand constructor
		for(int x=0; x<5; x++) {
			hCopyVal[x]=h.values[x];
		}
		h.applyStrategy();
		//h.values should be updated, if necessary according to the strategy. If royal flush, then no changes.
		//compare values before and after strategy
		for(int x=0; x<5; x++) {
			if(hCopyVal[x]!=h.values[x])
				blComp=false;
		} 
		assertEquals(true, blComp);
		
		//oneAwayFromFullHouse
		h.cards[0].rank="10"; h.cards[1].rank="J"; h.cards[2].rank="10"; h.cards[3].rank="10"; h.cards[4].rank="Ace";
		h.cards[0].suit="H"; h.cards[1].suit="D"; h.cards[2].suit="S"; h.cards[3].suit="C"; h.cards[4].suit="C";
		h.values[0]=12; h.values[1]=37; h.values[2]=35; h.values[3]=32; h.values[4]=48;
		for(int x=0; x<5; x++) {
			hCopyVal[x]=h.values[x];
		}
		
		h.applyStrategy();
		blComp=true;
		if(hCopyVal[1]==h.values[1] || hCopyVal[4]==h.values[4])
			blComp=false;
		if(hCopyVal[0]!=h.values[0] ||hCopyVal[2]!=h.values[2] ||hCopyVal[3]!=h.values[3])
			blComp=false;
		assertEquals(true, blComp);
		
		//oneAwayFromFlush
		h.cards[0].rank="2"; h.cards[1].rank="J"; h.cards[2].rank="7"; h.cards[3].rank="10"; h.cards[4].rank="Ace";
		h.cards[0].suit="H"; h.cards[1].suit="H"; h.cards[2].suit="H"; h.cards[3].suit="C"; h.cards[4].suit="H";
		h.values[0]=12; h.values[1]=37; h.values[2]=35; h.values[3]=32; h.values[4]=48;
		for(int x=0; x<5; x++) {
			hCopyVal[x]=h.values[x];
		}
		
		h.applyStrategy();
		blComp=true;
		if(hCopyVal[3]==h.values[3])
			blComp=false;
		if(hCopyVal[0]!=h.values[0] ||hCopyVal[1]!=h.values[1] ||hCopyVal[2]!=h.values[2]||hCopyVal[4]!=h.values[4])
			blComp=false;
		assertEquals(true, blComp);
		
		//oneAwayFromStraight
		h.cards[0].rank="5"; h.cards[1].rank="6"; h.cards[2].rank="7"; h.cards[3].rank="2"; h.cards[4].rank="9";
		h.cards[0].suit="H"; h.cards[1].suit="C"; h.cards[2].suit="S"; h.cards[3].suit="C"; h.cards[4].suit="H";
		h.values[0]=14; h.values[1]=16; h.values[2]=23; h.values[3]=0; h.values[4]=30;
		for(int x=0; x<5; x++) {
			hCopyVal[x]=h.values[x];
		}
		
		h.applyStrategy();
		blComp=true;
		if(hCopyVal[3]==h.values[3])
			blComp=false;
		if(hCopyVal[0]!=h.values[0] ||hCopyVal[1]!=h.values[1] ||hCopyVal[2]!=h.values[2]||hCopyVal[4]!=h.values[4])
			blComp=false;
		assertEquals(true, blComp);
	}

} // end of TestHand class
