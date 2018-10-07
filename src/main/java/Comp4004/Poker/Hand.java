package Comp4004.Poker;

import java.util.Random; //To get a random card from the deck
import java.util.Arrays;

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
		if(isRoyalFlush())
			return 1; //Royal Flush
		else if(isStraightFlush())
			return 2; //Straight Flush
		else if(isFourOfKind())
			return 3; //Four of a kind
		else if(isFullHouse())
			return 4; //Full House
		else if(isFlush())
			return 5; //Flush
		else if(isStraight())
			return 6; //Straight
		else if(isThreeOfKind())
			return 7; //Three of a kind
		else if(isTwoPair())
			return 8; //Two pair
		else if(isPair())
			return 9; //One pair
		else
			return 10; //High Card
	}
	
	
	public boolean isRoyalFlush() {
		
		if(!isFlush())
			return false;
		
		int t = 0;
		int j = 0;
		int q = 0;
		int k = 0;
		int a = 0;
		
		for(int x = 0; x<5; x++) {
			if(this.cards[x].getRank()=="10")
				t++;
			if(this.cards[x].getRank()=="J")
				j++;
			if(this.cards[x].getRank()=="Q")
				q++;
			if(this.cards[x].getRank()=="K")
				k++;
			if(this.cards[x].getRank()=="Ace")
				a++;
		}
		if(t==1 && j==1 && q==1 && k==1 && a==1)//check if one of each card
			return true;
		else
			return false;
	}
	
	public boolean isStraightFlush() {
		
		if(!isFlush())
			return false;
		
		int a[]= new int[5];
		for(int x = 0; x<5; x++) {
			if(this.cards[x].getRank()=="2")
				a[x]=1;
			if(this.cards[x].getRank()=="3")
				a[x]=2;
			if(this.cards[x].getRank()=="4")
				a[x]=3;
			if(this.cards[x].getRank()=="5")
				a[x]=4;
			if(this.cards[x].getRank()=="6")
				a[x]=5;
			if(this.cards[x].getRank()=="7")
				a[x]=6;
			if(this.cards[x].getRank()=="8")
				a[x]=7;
			if(this.cards[x].getRank()=="9")
				a[x]=8;
			if(this.cards[x].getRank()=="10")
				a[x]=9;
			if(this.cards[x].getRank()=="J")
				a[x]=10;
			if(this.cards[x].getRank()=="Q")
				a[x]=11;
			if(this.cards[x].getRank()=="K")
				a[x]=12;
			if(this.cards[x].getRank()=="Ace")
				a[x]=13;
	}
		 Arrays.sort(a); // Sorting smallest to largest to find a sequence, if any
		 int y = 0;
		 for(int x = 0; x<4; x++) {
				if(a[x]+1==a[x+1])
					y++;
		 }
		 if(y==4)//This means there are five cards in sequential order
				return true;
			else
				return false;
		
	}
	
	public boolean isFourOfKind() {
		
		int y = 0;
		int z = 0;
		for(int x = 1; x<5; x++) {
			if(this.cards[0].getRank()==this.cards[x].getRank())
				y++;
		}
		for(int x = 2; x<5; x++) {
			if(this.cards[1].getRank()==this.cards[x].getRank())
				z++;
		}
		if(y==3||z==3)//This means there are four cards of the same rank
			return true;
		else
			return false;
	}
	
	public boolean isFullHouse() {
		if(isThreeOfKind() && isPair())
			return true;
		else
			return false;
	}
	
	public boolean isFlush() {
		
		int s = 0;
		int h = 0;
		int d = 0;
		int c = 0;
		
		for(int x = 0; x<5; x++) {
			if(this.cards[x].getSuit()=="S")
				s++;
			if(this.cards[x].getSuit()=="H")
				h++;
			if(this.cards[x].getSuit()=="D")
				d++;
			if(this.cards[x].getSuit()=="C")
				c++;
		}
		if(s==5||h==5||d==5||c==5)//check if hand is a Flush
			return true;
		else
			return false;
	}

	public boolean isStraight() {
		int a[]= new int[5];
		for(int x = 0; x<5; x++) {
			if(this.cards[x].getRank()=="2")
				a[x]=1;
			if(this.cards[x].getRank()=="3")
				a[x]=2;
			if(this.cards[x].getRank()=="4")
				a[x]=3;
			if(this.cards[x].getRank()=="5")
				a[x]=4;
			if(this.cards[x].getRank()=="6")
				a[x]=5;
			if(this.cards[x].getRank()=="7")
				a[x]=6;
			if(this.cards[x].getRank()=="8")
				a[x]=7;
			if(this.cards[x].getRank()=="9")
				a[x]=8;
			if(this.cards[x].getRank()=="10")
				a[x]=9;
			if(this.cards[x].getRank()=="J")
				a[x]=10;
			if(this.cards[x].getRank()=="Q")
				a[x]=11;
			if(this.cards[x].getRank()=="K")
				a[x]=12;
			if(this.cards[x].getRank()=="Ace")
				a[x]=13;
	}
		 Arrays.sort(a); // Sorting smallest to largest to find a sequence, if any
		 int y = 0;
		 for(int x = 0; x<4; x++) {
				if(a[x]+1==a[x+1])
					y++;
		 }
		 if(y==4)//This means there are five cards in sequential order
				return true;
			else
				return false;
	}
	
	public boolean isThreeOfKind() {
		int y = 0;
		int z = 0;
		int a = 0;
		for(int x = 1; x<5; x++) {
			if(this.cards[0].getRank()==this.cards[x].getRank())
				y++;
		}
		for(int x = 2; x<5; x++) {
			if(this.cards[1].getRank()==this.cards[x].getRank())
				z++;
		}
		for(int x = 3; x<5; x++) {
			if(this.cards[2].getRank()==this.cards[x].getRank())
				a++;
		}
		if(y>=2||z>=2||a==2)//This means there are three cards of the same rank
			return true;
		else
			return false;
	}
	
	public boolean isTwoPair() {
		
		int[] a = new int[5];
		int s = 0;
		for(int x = 0; x<5; x++) {
			s=0;
			for(int y = 0; y<5; y++) {	
				if(this.cards[x].getRank()==this.cards[y].getRank() && x!=y)
					{
						a[x]=a[x]+1;
						//s = s + a[x];
					}
		}
		}
		for(int x = 0; x<5; x++)
			if (a[x]== 1) 
					s++; 
		if(s==4)
			return true;
		else return false;
		
	}
	
	public boolean isPair() { //This method will not be applied if there are more than two of the same kind, because of the threeOfKind method

		int y = 0;
		int z = 0;
		int a = 0;
		int b = 0;
		for(int x = 0; x<5; x++) {
			if(this.cards[0].getRank()==this.cards[x].getRank() && x!=0)
				y++;
		}
		for(int x = 0; x<5; x++) {
			if(this.cards[1].getRank()==this.cards[x].getRank() && x!=1)
				z++;
		}
		for(int x = 0; x<5; x++) {
			if(this.cards[2].getRank()==this.cards[x].getRank() && x!=2)
				a++;
		}
		for(int x = 0; x<5; x++) {
			if(this.cards[3].getRank()==this.cards[x].getRank() && x!=3)
				b++;
		}
		if(y==1||z==1||a==1||b==1)//This means there is a pair
			return true;
		else
			return false;
	}

	
} // end of Hand class