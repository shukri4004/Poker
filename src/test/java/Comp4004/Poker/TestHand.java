package Comp4004.Poker;

import junit.framework.TestCase;

public class TestHand extends TestCase {

	public void testTypeOfHand() {//There are ten types of hands: 1=Royal Flush, 2=Straight Flush, ... 
		Hand[] h = new Hand[10];
		//Royal Flush
		h[0] = new Hand();
		for(int i=0; i<5; i++)
			h[0].cards[i].suit="H";
		h[0].cards[0].rank="T"; h[0].cards[1].rank="J"; h[0].cards[2].rank="Q"; h[0].cards[3].rank="K"; h[0].cards[4].rank="A";
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
		h[7].cards[0].rank="5"; h[7].cards[1].rank="5"; h[7].cards[2].rank="T"; h[7].cards[3].rank="T"; h[7].cards[4].rank="9";
		h[7].cards[0].suit="S"; h[7].cards[1].suit="H"; h[7].cards[2].suit="D"; h[7].cards[3].suit="C"; 
		assertEquals(8, h[7].typeOfHand());
		
		//One Pair
		h[8] = new Hand();
		h[8].cards[0].rank="5"; h[8].cards[1].rank="5"; h[8].cards[2].rank="T"; h[8].cards[3].rank="3"; h[8].cards[4].rank="9";
		assertEquals(9, h[8].typeOfHand());
		
		//High Card
		h[9] = new Hand();
		h[9].cards[0].rank="5"; h[9].cards[1].rank="Q"; h[9].cards[2].rank="2"; h[9].cards[3].rank="T"; h[9].cards[4].rank="9";
		assertEquals(10, h[9].typeOfHand());

	}
	
	public void testApplyStrategy() {
		Hand h = new Hand();
		int[] hCopyVal = new int[5];
		boolean blComp = true;
		//Providing a Royal Flush hand and expecting no change in the hand when applying strategies
		for(int i=0; i<5; i++)
			AIP.cards[i].suit="C";
		AIP.cards[0].rank="T"; AIP.cards[1].rank="J"; AIP.cards[2].rank="Q"; AIP.cards[3].rank="K"; AIP.cards[4].rank="A";
		AIP.values[0]=32; AIP.values[1]=36; AIP.values[2]=40; AIP.values[3]=44; AIP.values[4]=48;
		//copy h to h2 before applying strategy. Copying AIP.values to h2.values will be enougAIP. Refer to how "values" member is created in the Hand constructor
		for(int x=0; x<5; x++) {
			hCopyVal[x]=AIP.values[x];
		}
		AIP.applyStrategy();
		//AIP.values should be updated, if necessary according to the strategy. If royal flush, then no changes.
		//compare values before and after strategy
		for(int x=0; x<5; x++) {
			if(hCopyVal[x]!=AIP.values[x])
				blComp=false;
		} 
		assertEquals(true, blComp);
		
		//oneAwayFromFullHouse
		AIP.cards[0].rank="T"; AIP.cards[1].rank="J"; AIP.cards[2].rank="T"; AIP.cards[3].rank="T"; AIP.cards[4].rank="A";
		AIP.cards[0].suit="H"; AIP.cards[1].suit="D"; AIP.cards[2].suit="S"; AIP.cards[3].suit="C"; AIP.cards[4].suit="C";
		AIP.values[0]=12; AIP.values[1]=37; AIP.values[2]=35; AIP.values[3]=32; AIP.values[4]=48;
		for(int x=0; x<5; x++) {
			hCopyVal[x]=AIP.values[x];
		}
		
		AIP.applyStrategy();
		blComp=true;
		if(hCopyVal[1]==AIP.values[1] || hCopyVal[4]==AIP.values[4])
			blComp=false;
		if(hCopyVal[0]!=AIP.values[0] ||hCopyVal[2]!=AIP.values[2] ||hCopyVal[3]!=AIP.values[3])
			blComp=false;
		assertEquals(true, blComp);
		
		//oneAwayFromFlush
		AIP.cards[0].rank="2"; AIP.cards[1].rank="J"; AIP.cards[2].rank="7"; AIP.cards[3].rank="T"; AIP.cards[4].rank="A";
		AIP.cards[0].suit="H"; AIP.cards[1].suit="H"; AIP.cards[2].suit="H"; AIP.cards[3].suit="C"; AIP.cards[4].suit="H";
		AIP.values[0]=2; AIP.values[1]=38; AIP.values[2]=22; AIP.values[3]=32; AIP.values[4]=50;
		for(int x=0; x<5; x++) {
			hCopyVal[x]=AIP.values[x];
		}
		
		AIP.applyStrategy();
		blComp=true;
		if(hCopyVal[3]==AIP.values[3])
			blComp=false;
		if(hCopyVal[0]!=AIP.values[0]||hCopyVal[1]!=AIP.values[1]||hCopyVal[2]!=AIP.values[2]||hCopyVal[4]!=AIP.values[4])
			blComp=false;
		assertEquals(true, blComp);
		
		//oneAwayFromStraight
		AIP.cards[0].rank="5"; AIP.cards[1].rank="6"; AIP.cards[2].rank="7"; AIP.cards[3].rank="2"; AIP.cards[4].rank="9";
		AIP.cards[0].suit="H"; AIP.cards[1].suit="C"; AIP.cards[2].suit="S"; AIP.cards[3].suit="C"; AIP.cards[4].suit="H";
		AIP.values[0]=14; AIP.values[1]=16; AIP.values[2]=23; AIP.values[3]=0; AIP.values[4]=26;
		for(int x=0; x<5; x++) {
			hCopyVal[x]=AIP.values[x];
		}
		
		AIP.applyStrategy();
		blComp=true;
		if(hCopyVal[3]==AIP.values[3])
			blComp=false;
		if(hCopyVal[0]!=AIP.values[0] ||hCopyVal[1]!=AIP.values[1] ||hCopyVal[2]!=AIP.values[2]||hCopyVal[4]!=AIP.values[4])
			blComp=false;
		assertEquals(true, blComp);
		
		//isThreeOfSameSuit
		AIP.cards[0].rank="2"; AIP.cards[1].rank="6"; AIP.cards[2].rank="7"; AIP.cards[3].rank="4"; AIP.cards[4].rank="J";
		AIP.cards[0].suit="C"; AIP.cards[1].suit="C"; AIP.cards[2].suit="S"; AIP.cards[3].suit="C"; AIP.cards[4].suit="H";
		AIP.values[0]=0; AIP.values[1]=16; AIP.values[2]=23; AIP.values[3]=8; AIP.values[4]=38;
		for(int x=0; x<5; x++) {
			hCopyVal[x]=AIP.values[x];
		}
		
		AIP.applyStrategy();
		blComp=true;
		if(hCopyVal[2]==AIP.values[2]||hCopyVal[4]==AIP.values[4])
			blComp=false;
		if(hCopyVal[0]!=AIP.values[0] ||hCopyVal[1]!=AIP.values[1] ||hCopyVal[3]!=AIP.values[3])
			blComp=false;
		assertEquals(true, blComp);
		
		//isThreeCardSequence
		AIP.cards[0].rank="2"; AIP.cards[1].rank="6"; AIP.cards[2].rank="7"; AIP.cards[3].rank="8"; AIP.cards[4].rank="J";
		AIP.cards[0].suit="C"; AIP.cards[1].suit="D"; AIP.cards[2].suit="S"; AIP.cards[3].suit="C"; AIP.cards[4].suit="H";
		AIP.values[0]=0; AIP.values[1]=17; AIP.values[2]=23; AIP.values[3]=24; AIP.values[4]=38;
		for(int x=0; x<5; x++) {
			hCopyVal[x]=AIP.values[x];
		}
		
		AIP.applyStrategy();
		blComp=true;
		if(hCopyVal[0]==AIP.values[0]||hCopyVal[4]==AIP.values[4])
			blComp=false;
		if(hCopyVal[1]!=AIP.values[1] ||hCopyVal[2]!=AIP.values[2] ||hCopyVal[3]!=AIP.values[3])
			blComp=false;
		assertEquals(true, blComp);
		
		//One pair
		AIP.cards[0].rank="2"; AIP.cards[1].rank="6"; AIP.cards[2].rank="6"; AIP.cards[3].rank="8"; AIP.cards[4].rank="J";
		AIP.cards[0].suit="C"; AIP.cards[1].suit="D"; AIP.cards[2].suit="S"; AIP.cards[3].suit="C"; AIP.cards[4].suit="H";
		AIP.values[0]=0; AIP.values[1]=17; AIP.values[2]=19; AIP.values[3]=24; AIP.values[4]=38;
		for(int x=0; x<5; x++) {
			hCopyVal[x]=AIP.values[x];
		}
		
		AIP.applyStrategy();
		blComp=true;
		if(hCopyVal[0]==AIP.values[0]||hCopyVal[3]==AIP.values[3]||hCopyVal[4]==AIP.values[4])
			blComp=false;
		if(hCopyVal[1]!=AIP.values[1]||hCopyVal[2]!=AIP.values[2])
			blComp=false;
		assertEquals(true, blComp);
		
		//High Card
				AIP.cards[0].rank="2"; AIP.cards[1].rank="5"; AIP.cards[2].rank="6"; AIP.cards[3].rank="8"; AIP.cards[4].rank="J";
				AIP.cards[0].suit="C"; AIP.cards[1].suit="D"; AIP.cards[2].suit="S"; AIP.cards[3].suit="C"; AIP.cards[4].suit="H";
				AIP.values[0]=0; AIP.values[1]=13; AIP.values[2]=19; AIP.values[3]=24; AIP.values[4]=38;
				for(int x=0; x<5; x++) {
					hCopyVal[x]=AIP.values[x];
				}
				
				AIP.applyStrategy();
				blComp=true;
				if(hCopyVal[0]==AIP.values[0]||hCopyVal[1]==AIP.values[1]||hCopyVal[2]==AIP.values[2])
					blComp=false;
				if(hCopyVal[3]!=AIP.values[3]||hCopyVal[4]!=AIP.values[4])
					blComp=false;
				assertEquals(true, blComp);
	}

	public void testWinner() {
		Hand opponent, AIP = new Hand();
		//One pair for opponent
		opponent.cards[0].rank="2"; opponent.cards[1].rank="6"; opponent.cards[2].rank="6"; opponent.cards[3].rank="8"; opponent.cards[4].rank="J";
		opponent.cards[0].suit="C"; opponent.cards[1].suit="D"; opponent.cards[2].suit="S"; opponent.cards[3].suit="C"; opponent.cards[4].suit="H";
		opponent.values[0]=0; opponent.values[1]=17; opponent.values[2]=19; opponent.values[3]=24; opponent.values[4]=38;
		//High card for AIP
		AIP.cards[0].rank="2"; AIP.cards[1].rank="5"; AIP.cards[2].rank="6"; AIP.cards[3].rank="8"; AIP.cards[4].rank="J";
		AIP.cards[0].suit="C"; AIP.cards[1].suit="D"; AIP.cards[2].suit="S"; AIP.cards[3].suit="C"; AIP.cards[4].suit="H";
		AIP.values[0]=0; AIP.values[1]=13; AIP.values[2]=19; AIP.values[3]=24; AIP.values[4]=38;
		assertEquals(1, AIP.winner(opponent));
	}
	
} // end of TestHand class
