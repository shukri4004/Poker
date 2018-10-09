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

	public void applyStrategy() {
		Deck d = new Deck();
		Random rand = new Random();
		int rd;
		int a = 0;
		int b = 0;
		int c = 0;
		int y = 0;
		int z = 0;
		int i;
		
		if(this.typeOfHand()<=6); //Straight or better
			
		else if(oneCardAwayFromFullHouse()) {
			//Three of a kind and Two pair are unnecessary to test since NOT being one card away 
			//	from Full House means the hand cannot be either of them
			if(isTwoPair()) {
				for(int x = 1; x<5; x++) {
					if(this.cards[0].getRank()==this.cards[x].getRank())
						a=1;
				}
				for(int x = 0; x<5; x++) {
					if(this.cards[1].getRank()==this.cards[x].getRank() && x!=1)
						b=1;
				}
				for(int x = 0; x<5; x++) {
					if(this.cards[2].getRank()==this.cards[x].getRank() && x!=2)
						c=1;
				}
				for(int x = 0; x<5; x++) {
					if(this.cards[3].getRank()==this.cards[x].getRank() && x!=3)
						y=1;
				}
				if(a==0)
					i=0;
				else if(b==0)
					i=1;
				else if(c==0)
					i=2;
				else if(y==0)
					i=3;
				else
					i=4;
					
				//Exchange the card
				rd = rand.nextInt(52);
				this.cards[i] = d.getCard(rd);
				// update the "values" member
				this.values[i] = rd;
			}
			
			else //isThreeOfKind()), change the two remaining cards
			{
				for(int x = 1; x<5; x++) {
					if(this.cards[0].getRank()==this.cards[x].getRank())
						a=1;
				}
				for(int x = 0; x<5; x++) {
					if(this.cards[1].getRank()==this.cards[x].getRank() && x!=1)
						b=1;
				}
				for(int x = 0; x<5; x++) {
					if(this.cards[2].getRank()==this.cards[x].getRank() && x!=2)
						c=1;
				}
				for(int x = 0; x<5; x++) {
					if(this.cards[3].getRank()==this.cards[x].getRank() && x!=3)
						y=1;
				}
				for(int x = 0; x<4; x++) {
					if(this.cards[4].getRank()==this.cards[x].getRank())
						z=1;
				}
				if(a==0){
					rd = rand.nextInt(52);
					this.cards[0] = d.getCard(rd);
					// update the "values" member
					this.values[0] = rd;
				}
				if(b==0){
					rd = rand.nextInt(52);
					this.cards[1] = d.getCard(rd);
					this.values[1] = rd;
				}
				if(c==0){
					rd = rand.nextInt(52);
					this.cards[2] = d.getCard(rd);
					this.values[2] = rd;
				}
				if(y==0){
					rd = rand.nextInt(52);
					this.cards[3] = d.getCard(rd);
					this.values[3] = rd;
				}
				if(z==0){
					rd = rand.nextInt(52);
					this.cards[4] = d.getCard(rd);
					this.values[4] = rd;
				}
			}
		}
		else if(oneCardAwayFromFlush()) {
			for(int x = 1; x<5; x++) {
				if(this.cards[0].getSuit()==this.cards[x].getSuit())
					a=1;
			}
			for(int x = 0; x<5; x++) {
				if(this.cards[1].getSuit()==this.cards[x].getSuit() && x!=1)
					b=1;
			}
			for(int x = 0; x<5; x++) {
				if(this.cards[2].getSuit()==this.cards[x].getSuit() && x!=2)
					c=1;
			}
			for(int x = 0; x<5; x++) {
				if(this.cards[3].getSuit()==this.cards[x].getSuit() && x!=3)
					y=1;
			}
			if(a==0)
				i=0;
			else if(b==0)
				i=1;
			else if(c==0)
				i=2;
			else if(y==0)
				i=3;
			else
				i=4;

				
			//Exchange the card
			rd = rand.nextInt(52);
			this.cards[i] = d.getCard(rd);
			this.values[i] = rd;
	}
	else if(oneCardAwayFromStraight()) {
	//Get the index i of the card to exchange
		int arr[]= new int[5];
		int arr2[]= new int[5];
		for(int x = 0; x<5; x++) {
			if(this.cards[x].getRank()=="2")
				arr[x]=1;
			if(this.cards[x].getRank()=="3")
				arr[x]=2;
			if(this.cards[x].getRank()=="4")
				arr[x]=3;
			if(this.cards[x].getRank()=="5")
				arr[x]=4;
			if(this.cards[x].getRank()=="6")
				arr[x]=5;
			if(this.cards[x].getRank()=="7")
				arr[x]=6;
			if(this.cards[x].getRank()=="8")
				arr[x]=7;
			if(this.cards[x].getRank()=="9")
				arr[x]=8;
			if(this.cards[x].getRank()=="10")
				arr[x]=9;
			if(this.cards[x].getRank()=="J")
				arr[x]=10;
			if(this.cards[x].getRank()=="Q")
				arr[x]=11;
			if(this.cards[x].getRank()=="K")
				arr[x]=12;
			if(this.cards[x].getRank()=="Ace")
				arr[x]=13;
	} 
		for(int x = 0; x<5; x++) {
			arr2[x]=arr[x];
		}
		Arrays.sort(arr); // Sorting smallest to largest to find a sequence, if any
		if(arr[0]+1!=arr[1])
			i=0;
		else
			i=4;
		for(int x = 0; x<5; x++) {
			if(arr2[x]==arr[i]) {
				rd = rand.nextInt(52);
				this.cards[x] = d.getCard(rd);
				this.values[x] = rd;
			}
		}
	}
	else if(isThreeOfSameSuit()) {
		for(int x = 1; x<5; x++) {
			if(this.cards[0].getSuit()==this.cards[x].getSuit())
				a=1;
		}
		for(int x = 0; x<5; x++) {
			if(this.cards[1].getSuit()==this.cards[x].getSuit() && x!=1)
				b=1;
		}
		for(int x = 0; x<5; x++) {
			if(this.cards[2].getSuit()==this.cards[x].getSuit() && x!=2)
				c=1;
		}
		for(int x = 0; x<5; x++) {
			if(this.cards[3].getSuit()==this.cards[x].getSuit() && x!=3)
				y=1;
		}
		for(int x = 0; x<4; x++) {
			if(this.cards[4].getSuit()==this.cards[x].getSuit())
				z=1;
		}
		if(a==0){
			rd = rand.nextInt(52);
			this.cards[0] = d.getCard(rd);
			this.values[0] = rd;
		}
		if(b==0){
			rd = rand.nextInt(52);
			this.cards[1] = d.getCard(rd);
			this.values[1] = rd;
		}
		if(c==0){
			rd = rand.nextInt(52);
			this.cards[2] = d.getCard(rd);
			this.values[2] = rd;
		}
		if(y==0){
			rd = rand.nextInt(52);
			this.cards[3] = d.getCard(rd);
			this.values[3] = rd;
		}
		if(z==0){
			rd = rand.nextInt(52);
			this.cards[4] = d.getCard(rd);
			this.values[4] = rd;
		}

	}
	
	else if(isThreeCardSequence()) { //Exchange the two cards not in sequential order
									//After sorting assigned numbers to the cards, either the first 2, the last 2, or the first and last are non-sequential
									//Assigned numbers to the cards is done by array variable below
		int arr[]= new int[5];
		int arr2[]= new int[5];
		int n;
		for(int x = 0; x<5; x++) {
			if(this.cards[x].getRank()=="2")
				arr[x]=1;
			if(this.cards[x].getRank()=="3")
				arr[x]=2;
			if(this.cards[x].getRank()=="4")
				arr[x]=3;
			if(this.cards[x].getRank()=="5")
				arr[x]=4;
			if(this.cards[x].getRank()=="6")
				arr[x]=5;
			if(this.cards[x].getRank()=="7")
				arr[x]=6;
			if(this.cards[x].getRank()=="8")
				arr[x]=7;
			if(this.cards[x].getRank()=="9")
				arr[x]=8;
			if(this.cards[x].getRank()=="10")
				arr[x]=9;
			if(this.cards[x].getRank()=="J")
				arr[x]=10;
			if(this.cards[x].getRank()=="Q")
				arr[x]=11;
			if(this.cards[x].getRank()=="K")
				arr[x]=12;
			if(this.cards[x].getRank()=="Ace")
				arr[x]=13;
	} 
		
		for(int x = 0; x<5; x++) {
			arr2[x]=arr[x];
		}
		Arrays.sort(arr); // Sorting smallest to largest to find a sequence, if any
		if(arr[1]+1!=arr[2]) {
			i=0;
			n=1;
		}
		else if(arr[2]+1!=arr[3]) {
			i=3;
			n=4;
		}
		else {
			i=0;
			n=4;
		}
		for(int x = 0; x<5; x++) {
			if(arr2[x]==arr[i]||arr2[x]==arr[n]) {
				rd = rand.nextInt(52);
				this.cards[x] = d.getCard(rd);
				this.values[x] = rd;
			}
		}
	}
			
	else if(this.typeOfHand()==9) { //One pair
		for(int x = 1; x<5; x++) {
			if(this.cards[0].getRank()==this.cards[x].getRank())
				a=1;
		}
		for(int x = 0; x<5; x++) {
			if(this.cards[1].getRank()==this.cards[x].getRank() && x!=1)
				b=1;
		}
		for(int x = 0; x<5; x++) {
			if(this.cards[2].getRank()==this.cards[x].getRank() && x!=2)
				c=1;
		}
		for(int x = 0; x<5; x++) {
			if(this.cards[3].getRank()==this.cards[x].getRank() && x!=3)
				y=1;
		}
		for(int x = 0; x<4; x++) {
			if(this.cards[4].getRank()==this.cards[x].getRank())
				z=1;
		}
		if(a==0){
			rd = rand.nextInt(52);
			this.cards[0] = d.getCard(rd);
			this.values[0] = rd;
		}
		if(b==0){
			rd = rand.nextInt(52);
			this.cards[1] = d.getCard(rd);
			this.values[1] = rd;
		}
		if(c==0){
			rd = rand.nextInt(52);
			this.cards[2] = d.getCard(rd);
			this.values[2] = rd;
		}
		if(y==0){
			rd = rand.nextInt(52);
			this.cards[3] = d.getCard(rd);
			this.values[3] = rd;
		}
		if(z==0){
			rd = rand.nextInt(52);
			this.cards[4] = d.getCard(rd);
			this.values[4] = rd;
		}
}
	else //High card
	{
		// Get the last 3 cards from hand.values, it's a sorted array in ascendent order
		int i2, i3;
		Arrays.sort(values);
		i = this.values[0];
		i2 = this.values[1];
		i3 = this.values[2];
		
		for(int x=0; x<5; x++) {
			if(this.cards[x].suit==d.cardHolder[i].suit && this.cards[x].rank==d.cardHolder[i].rank) {
				rd = rand.nextInt(52);
				this.cards[x] = d.getCard(rd);
				this.values[x] = rd;
			}
			if(this.cards[x].suit==d.cardHolder[i2].suit && this.cards[x].rank==d.cardHolder[i2].rank) {
				rd = rand.nextInt(52);
				this.cards[x] = d.getCard(rd);
				this.values[x] = rd;
			}
			if(this.cards[x].suit==d.cardHolder[i3].suit && this.cards[x].rank==d.cardHolder[i3].rank) {
				rd = rand.nextInt(52);
				this.cards[x] = d.getCard(rd);
				this.values[x] = rd;
			}
		}
	}
		
	}
	
	public boolean oneCardAwayFromFullHouse() {
		if(this.typeOfHand()==7||this.typeOfHand()==8)
			return true;
		else
			return false;
	}
	
public boolean oneCardAwayFromFlush() {
		
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
		if(s==4||h==4||d==4||c==4)
			return true;
		else
			return false;
	}

public boolean oneCardAwayFromStraight() {//check if one away from straight
										//(Royal Flush and Straight Flush are unnecessary to test because having a Straight means having them too)
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
	 Arrays.sort(a);
	 int y = 0;
	 int z = 0;
	 int n;
	 for(int x = 0; x<4; x++) {
			if(a[x]+1==a[x+1])
				y++;
			if(a[x]+2==a[x+1])
				z++;
	 }
	 n=y+z;
	 if(n==3 && z<=1)//This means there are four cards in sequential order
			return true;
		else
			return false;
	
}

public boolean isThreeOfSameSuit() {
	int y = 0;
	int z = 0;
	int a = 0;
	for(int x = 1; x<5; x++) {
		if(this.cards[0].getSuit()==this.cards[x].getSuit())
			y++;
	}
	for(int x = 2; x<5; x++) {
		if(this.cards[1].getSuit()==this.cards[x].getSuit())
			z++;
	}
	for(int x = 3; x<5; x++) {
		if(this.cards[2].getSuit()==this.cards[x].getSuit())
			a++;
	}
	if(y>=2||z>=2||a==2)//This means there are three cards of the same suit
		return true;
	else
		return false;
}

public boolean isThreeCardSequence() {
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
	 if(y==2)//This means there are three cards in sequential order
			return true;
		else
			return false;
}


} // end of Hand class