package Comp4004.Poker;

import java.util.Random; //To get a random card from the deck

public class Hand {

	Card[] cards = new Card[5];
	int[] values = new int[5]; //To hold value of each card in hand
	Hand(){
	Random rand = new Random();
	
	Deck d = new Deck();
	int rd;
	for(int x = 0; x<5; x++) {
		rd = rand.nextInt(52);
		this.cards[x] = d.cardHolder[rd];
		values[x] = rd;	
	}
	//sort values of the hand from largest to smallest. It will be useful to compare hands and to get the type of hand
	int temp;
    for (int i = 0; i < 5; i++) 
    {
        for (int j = i + 1; j < 5; j++) 
        {
            if (values[i] < values[j]) 
            {
                temp = values[i];
                values[i] = values[j];
                values[j] = temp;
            }
        }
    }
	
	}
	
	
	public int typeOfHand() { //according to strategy
		return 1;
	}
	
	
	
	
	
}