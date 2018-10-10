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
			if(this.cards[x].getRank()=="T")
				t++;
			if(this.cards[x].getRank()=="J")
				j++;
			if(this.cards[x].getRank()=="Q")
				q++;
			if(this.cards[x].getRank()=="K")
				k++;
			if(this.cards[x].getRank()=="A")
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
		
		int array[]= new int[5];
		for(int x = 0; x<5; x++) {
			if(this.cards[x].getRank()=="2")
				array[x]=1;
			if(this.cards[x].getRank()=="3")
				array[x]=2;
			if(this.cards[x].getRank()=="4")
				array[x]=3;
			if(this.cards[x].getRank()=="5")
				array[x]=4;
			if(this.cards[x].getRank()=="6")
				array[x]=5;
			if(this.cards[x].getRank()=="7")
				array[x]=6;
			if(this.cards[x].getRank()=="8")
				array[x]=7;
			if(this.cards[x].getRank()=="9")
				array[x]=8;
			if(this.cards[x].getRank()=="T")
				array[x]=9;
			if(this.cards[x].getRank()=="J")
				array[x]=10;
			if(this.cards[x].getRank()=="Q")
				array[x]=11;
			if(this.cards[x].getRank()=="K")
				array[x]=12;
			if(this.cards[x].getRank()=="A")
				array[x]=13;
	}
		 Arrays.sort(array); // Sorting smallest to largest to find a sequence, if any
		 int y = 0;
		 for(int x = 0; x<4; x++) {
				if(array[x]+1==array[x+1])
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
		int array[]= new int[5];
		for(int x = 0; x<5; x++) {
			if(this.cards[x].getRank()=="2")
				array[x]=1;
			if(this.cards[x].getRank()=="3")
				array[x]=2;
			if(this.cards[x].getRank()=="4")
				array[x]=3;
			if(this.cards[x].getRank()=="5")
				array[x]=4;
			if(this.cards[x].getRank()=="6")
				array[x]=5;
			if(this.cards[x].getRank()=="7")
				array[x]=6;
			if(this.cards[x].getRank()=="8")
				array[x]=7;
			if(this.cards[x].getRank()=="9")
				array[x]=8;
			if(this.cards[x].getRank()=="T")
				array[x]=9;
			if(this.cards[x].getRank()=="J")
				array[x]=10;
			if(this.cards[x].getRank()=="Q")
				array[x]=11;
			if(this.cards[x].getRank()=="K")
				array[x]=12;
			if(this.cards[x].getRank()=="A")
				array[x]=13;
	}
		 Arrays.sort(array); // Sorting smallest to largest to find a sequence, if any
		 int y = 0;
		 for(int x = 0; x<4; x++) {
				if(array[x]+1==array[x+1])
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
			if(this.cards[x].getRank()=="T")
				arr[x]=9;
			if(this.cards[x].getRank()=="J")
				arr[x]=10;
			if(this.cards[x].getRank()=="Q")
				arr[x]=11;
			if(this.cards[x].getRank()=="K")
				arr[x]=12;
			if(this.cards[x].getRank()=="A")
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
			if(this.cards[x].getRank()=="T")
				arr[x]=9;
			if(this.cards[x].getRank()=="J")
				arr[x]=10;
			if(this.cards[x].getRank()=="Q")
				arr[x]=11;
			if(this.cards[x].getRank()=="K")
				arr[x]=12;
			if(this.cards[x].getRank()=="A")
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
	int array[]= new int[5];
	for(int x = 0; x<5; x++) {
		if(this.cards[x].getRank()=="2")
			array[x]=1;
		if(this.cards[x].getRank()=="3")
			array[x]=2;
		if(this.cards[x].getRank()=="4")
			array[x]=3;
		if(this.cards[x].getRank()=="5")
			array[x]=4;
		if(this.cards[x].getRank()=="6")
			array[x]=5;
		if(this.cards[x].getRank()=="7")
			array[x]=6;
		if(this.cards[x].getRank()=="8")
			array[x]=7;
		if(this.cards[x].getRank()=="9")
			array[x]=8;
		if(this.cards[x].getRank()=="T")
			array[x]=9;
		if(this.cards[x].getRank()=="J")
			array[x]=10;
		if(this.cards[x].getRank()=="Q")
			array[x]=11;
		if(this.cards[x].getRank()=="K")
			array[x]=12;
		if(this.cards[x].getRank()=="A")
			array[x]=13;
}
	 Arrays.sort(array);
	 int y = 0;
	 int z = 0;
	 int n;
	 for(int x = 0; x<4; x++) {
			if(array[x]+1==array[x+1])
				y++;
			if(array[x]+2==array[x+1])
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
	int array[]= new int[5];
	for(int x = 0; x<5; x++) {
		if(this.cards[x].getRank()=="2")
			array[x]=1;
		if(this.cards[x].getRank()=="3")
			array[x]=2;
		if(this.cards[x].getRank()=="4")
			array[x]=3;
		if(this.cards[x].getRank()=="5")
			array[x]=4;
		if(this.cards[x].getRank()=="6")
			array[x]=5;
		if(this.cards[x].getRank()=="7")
			array[x]=6;
		if(this.cards[x].getRank()=="8")
			array[x]=7;
		if(this.cards[x].getRank()=="9")
			array[x]=8;
		if(this.cards[x].getRank()=="T")
			array[x]=9;
		if(this.cards[x].getRank()=="J")
			array[x]=10;
		if(this.cards[x].getRank()=="Q")
			array[x]=11;
		if(this.cards[x].getRank()=="K")
			array[x]=12;
		if(this.cards[x].getRank()=="A")
			array[x]=13;
}
	 Arrays.sort(array); // Sorting smallest to largest to find a sequence, if any
	 int y = 0;
	 for(int x = 0; x<4; x++) {
			if(array[x]+1==array[x+1])
				y++;
	 }
	 if(y==2)//This means there are three cards in sequential order
			return true;
		else
			return false;
}

public void tieBreaker(Hand other) {// for comparing equally ranked hands
	int x=0;
	int y=0;
	int z=0;
	int a=0;
	int n=0;
	
	if(this.typeOfHand()==1) {
		Arrays.sort(this.values);
		Arrays.sort(other.values);
		if(this.values[0]>other.values[0])
			System.out.println("AIP wins");
		else if(this.values[0]<other.values[0])
			System.out.println("Opponent wins");
		else
			System.out.println("It's a draw");
	}
		
	else if(this.typeOfHand()==2||this.typeOfHand()==6) {
		for(int i = 1; i<5; i++) {
			if(this.cards[i].getRank()=="2") {
				x++;
				i=100;
			}
		}
		for(int i = 1; i<5; i++) {
			if(this.cards[i].getRank()=="3") {
				x++;
				i=100;
			}
		}
		for(int i = 1; i<5; i++) {
			if(this.cards[i].getRank()=="4") {
				x++;
				i=100;
			}
		}
		for(int i = 1; i<5; i++) {
			if(this.cards[i].getRank()=="5") {
				x++;
				i=100;
			}
		}
		for(int i = 1; i<5; i++) {
			if(this.cards[i].getRank()=="A") {
				x++;
				i=100;
				y=i;
			}
		}
		if(x==5) //If Ace is used along with 2, 3, 4, and 5, it becomes the lowest ranked card of the hand
			this.values[y]=-1;
		
		x=0;
		
		for(int i = 1; i<5; i++) {
			if(other.cards[i].getRank()=="2") {
				x++;
				i=100;
			}
		}
		for(int i = 1; i<5; i++) {
			if(other.cards[i].getRank()=="3") {
				x++;
				i=100;
			}
		}
		for(int i = 1; i<5; i++) {
			if(other.cards[i].getRank()=="4") {
				x++;
				i=100;
			}
		}
		for(int i = 1; i<5; i++) {
			if(other.cards[i].getRank()=="5") {
				x++;
				i=100;
			}
		}
		for(int i = 1; i<5; i++) {
			if(other.cards[i].getRank()=="A") {
				x++;
				i=100;
				y=i;
			}
		}
		if(x==5) //If Ace is used along with 2, 3, 4, and 5, it becomes the lowest ranked card of the hand
			other.values[y]=-1;
		
		Arrays.sort(this.values);
		Arrays.sort(other.values);
		if(this.values[4]>other.values[4])
			System.out.println("AIP wins");
		else if(this.values[4]<other.values[4])
			System.out.println("Opponent wins");
		else
			System.out.println("It's a draw");
	}
	
	else if(this.typeOfHand()==3) {
		for(int i = 1; i<5; i++) {
			if(this.cards[0].getRank()==this.cards[i].getRank())
				x=1;
		}
		for(int i = 0; i<5; i++) {
			if(this.cards[1].getRank()==this.cards[i].getRank() && i!=1)
				y=1;
		}
		for(int i = 0; i<5; i++) {
			if(this.cards[2].getRank()==this.cards[i].getRank() && i!=2)
				z=1;
		}
		for(int i = 0; i<5; i++) {
			if(this.cards[3].getRank()==this.cards[i].getRank() && i!=3)
				a=1;
		}
		
		if(x==0)
			n=0;
		else if(y==0)
			n=1;
		else if(z==0)
			n=2;
		else if(a==0)
			n=3;
		else
			n=4;
		this.values[n]=-1;
		
		x=0; y=0; z=0; a=0;
		
		for(int i = 1; i<5; i++) {
			if(other.cards[0].getRank()==other.cards[i].getRank())
				x=1;
		}
		for(int i = 0; i<5; i++) {
			if(other.cards[1].getRank()==other.cards[i].getRank() && i!=1)
				y=1;
		}
		for(int i = 0; i<5; i++) {
			if(other.cards[2].getRank()==other.cards[i].getRank() && i!=2)
				z=1;
		}
		for(int i = 0; i<5; i++) {
			if(other.cards[3].getRank()==other.cards[i].getRank() && i!=3)
				a=1;
		}
		
		if(x==0)
			n=0;
		else if(y==0)
			n=1;
		else if(z==0)
			n=2;
		else if(a==0)
			n=3;
		else
			n=4;
		other.values[n]=-1;
		
		Arrays.sort(this.values);
		Arrays.sort(other.values);
		
		if(this.values[4]>other.values[4])
			System.out.println("AIP wins");
		else if(this.values[4]<other.values[4])
			System.out.println("Opponent wins");
		else
			System.out.println("It's a draw");
		
	}
	
	else if(this.typeOfHand()==4||this.typeOfHand()==7){
		for(int i = 1; i<5; i++) {
			if(this.cards[0].getRank()==this.cards[i].getRank())
				x++;
		}
		for(int i = 0; i<5; i++) {
			if(this.cards[1].getRank()==this.cards[i].getRank() && i!=1)
				y++;
		}
		for(int i = 0; i<5; i++) {
			if(this.cards[2].getRank()==this.cards[i].getRank() && i!=2)
				z++;
		}
		for(int i = 0; i<5; i++) {
			if(this.cards[3].getRank()==this.cards[i].getRank() && i!=3)
				a++;
		}
		for(int i = 0; i<4; i++) {
			if(this.cards[4].getRank()==this.cards[i].getRank())
				n++;
		}
		
		if(x<2)
			this.values[0]=-1;
		if(y<2)
			this.values[1]=-1;
		if(z<2)
			this.values[2]=-1;
		if(a<2)
			this.values[3]=-1;
		if(n<2)
			this.values[4]=-1;
		
		x=0; y=0; z=0; a=0; n=0;
		
		for(int i = 1; i<5; i++) {
			if(other.cards[0].getRank()==other.cards[i].getRank())
				x++;
		}
		for(int i = 0; i<5; i++) {
			if(other.cards[1].getRank()==other.cards[i].getRank() && i!=1)
				y++;
		}
		for(int i = 0; i<5; i++) {
			if(other.cards[2].getRank()==other.cards[i].getRank() && i!=2)
				z++;
		}
		for(int i = 0; i<5; i++) {
			if(other.cards[3].getRank()==other.cards[i].getRank() && i!=3)
				a++;
		}
		for(int i = 0; i<4; i++) {
			if(other.cards[4].getRank()==other.cards[i].getRank())
				n++;
		}
		
		if(x<2)
			other.values[0]=-1;
		if(y<2)
			other.values[1]=-1;
		if(z<2)
			other.values[2]=-1;
		if(a<2)
			other.values[3]=-1;
		if(n<2)
			other.values[4]=-1;
		
		Arrays.sort(this.values);
		Arrays.sort(other.values);
		
		if(this.values[4]>other.values[4])
			System.out.println("AIP wins");
		else if(this.values[4]<other.values[4])
			System.out.println("Opponent wins");
		else
			System.out.println("It's a draw");
		
	}	
	
	else if(this.typeOfHand()==5) {
		int[] array = new int[5];
		int[] array2 = new int[5];
		for(int i = 0; i<5; i++) {
			if(this.cards[i].getRank()=="2")
				array[i]=1;
			if(this.cards[i].getRank()=="3")
				array[i]=2;
			if(this.cards[i].getRank()=="4")
				array[i]=3;
			if(this.cards[i].getRank()=="5")
				array[i]=4;
			if(this.cards[i].getRank()=="6")
				array[i]=5;
			if(this.cards[i].getRank()=="7")
				array[i]=6;
			if(this.cards[i].getRank()=="8")
				array[i]=7;
			if(this.cards[i].getRank()=="9")
				array[i]=8;
			if(this.cards[i].getRank()=="T")
				array[i]=9;
			if(this.cards[i].getRank()=="J")
				array[i]=10;
			if(this.cards[i].getRank()=="Q")
				array[i]=11;
			if(this.cards[i].getRank()=="K")
				array[i]=12;
			if(this.cards[i].getRank()=="A")
				array[i]=13;
	}
		Arrays.sort(array);
		
		for(int i = 0; i<5; i++) {
			if(other.cards[i].getRank()=="2")
				array2[i]=1;
			if(other.cards[i].getRank()=="3")
				array2[i]=2;
			if(other.cards[i].getRank()=="4")
				array2[i]=3;
			if(other.cards[i].getRank()=="5")
				array2[i]=4;
			if(other.cards[i].getRank()=="6")
				array2[i]=5;
			if(other.cards[i].getRank()=="7")
				array2[i]=6;
			if(other.cards[i].getRank()=="8")
				array2[i]=7;
			if(other.cards[i].getRank()=="9")
				array2[i]=8;
			if(other.cards[i].getRank()=="T")
				array2[i]=9;
			if(other.cards[i].getRank()=="J")
				array2[i]=10;
			if(other.cards[i].getRank()=="Q")
				array2[i]=11;
			if(other.cards[i].getRank()=="K")
				array2[i]=12;
			if(other.cards[i].getRank()=="A")
				array2[i]=13;
	}
		Arrays.sort(array2);
		
		for(int i = 4; i>=0; i--) {
			if(array[i]>array2[i]) {
				System.out.println("AIP wins");
				i=-1;
				a=10;
			}
			else if(array[i]<array2[i]) {
				System.out.println("Opponent wins");
				i=-1;
				a=10;
			}
		}
		if(a!=10) {
			if(this.values[0]>other.values[0])
				System.out.println("AIP wins");
			else if(this.values[0]<other.values[0])
				System.out.println("Opponent wins");
			else
				System.out.println("It's a draw");
		}
			
		
	}
	
	else if(this.typeOfHand()==8) {
		for(int i = 1; i<5; i++) {
			if(this.cards[0].getRank()==this.cards[i].getRank())
				x=1;
		}
		for(int i = 0; i<5; i++) {
			if(this.cards[1].getRank()==this.cards[i].getRank() && i!=1)
				y=1;
		}
		for(int i = 0; i<5; i++) {
			if(this.cards[2].getRank()==this.cards[i].getRank() && i!=2)
				z=1;
		}
		for(int i = 0; i<5; i++) {
			if(this.cards[3].getRank()==this.cards[i].getRank() && i!=3)
				a=1;
		}
		
		if(x==0)
			this.values[0]=-1;
		else if(y==0)
			this.values[1]=-1;
		else if(z==0)
			this.values[2]=-1;
		else if(a==0)
			this.values[3]=-1;
		else
			this.values[4]=-1;
		
		x=0; y=0; z=0; a=0;
		
		for(int i = 1; i<5; i++) {
			if(other.cards[0].getRank()==other.cards[i].getRank())
				x=1;
		}
		for(int i = 0; i<5; i++) {
			if(other.cards[1].getRank()==other.cards[i].getRank() && i!=1)
				y=1;
		}
		for(int i = 0; i<5; i++) {
			if(other.cards[2].getRank()==other.cards[i].getRank() && i!=2)
				z=1;
		}
		for(int i = 0; i<5; i++) {
			if(other.cards[3].getRank()==other.cards[i].getRank() && i!=3)
				a=1;
		}
		
		if(x==0)
			other.values[0]=-1;
		else if(y==0)
			other.values[1]=-1;
		else if(z==0)
			other.values[2]=-1;
		else if(a==0)
			other.values[3]=-1;
		else
			other.values[4]=-1;
		
		Arrays.sort(this.values);
		Arrays.sort(other.values);
		
		if(this.values[4]>other.values[4])
			System.out.println("AIP wins");
		else if(this.values[4]<other.values[4])
			System.out.println("Opponent wins");
		else
			System.out.println("It's a draw");
	}
	
	else if(this.typeOfHand()==9) {
		for(int i = 1; i<5; i++) {
			if(this.cards[0].getRank()==this.cards[i].getRank())
				x=1;
		}
		for(int i = 0; i<5; i++) {
			if(this.cards[1].getRank()==this.cards[i].getRank() && i!=1)
				y=1;
		}
		for(int i = 0; i<5; i++) {
			if(this.cards[2].getRank()==this.cards[i].getRank() && i!=2)
				z=1;
		}
		for(int i = 0; i<5; i++) {
			if(this.cards[3].getRank()==this.cards[i].getRank() && i!=3)
				a=1;
		}
		for(int i = 1; i<5; i++) {
			if(this.cards[4].getRank()==this.cards[i].getRank())
				n=1;
		}
		
		if(x==0)
			this.values[0]=-1;
		if(y==0)
			this.values[1]=-1;
		if(z==0)
			this.values[2]=-1;
		if(a==0)
			this.values[3]=-1;
		if(n==0)
			this.values[4]=-1;
		
		x=0; y=0; z=0; a=0; n=0;
		
		for(int i = 1; i<5; i++) {
			if(other.cards[0].getRank()==other.cards[i].getRank())
				x=1;
		}
		for(int i = 0; i<5; i++) {
			if(other.cards[1].getRank()==other.cards[i].getRank() && i!=1)
				y=1;
		}
		for(int i = 0; i<5; i++) {
			if(other.cards[2].getRank()==other.cards[i].getRank() && i!=2)
				z=1;
		}
		for(int i = 0; i<5; i++) {
			if(other.cards[3].getRank()==other.cards[i].getRank() && i!=3)
				a=1;
		}
		for(int i = 0; i<4; i++) {
			if(other.cards[4].getRank()==other.cards[i].getRank())
				n=1;
		}
		
		if(x==0)
			other.values[0]=-1;
		if(y==0)
			other.values[1]=-1;
		if(z==0)
			other.values[2]=-1;
		if(a==0)
			other.values[3]=-1;
		if(n==0)
			other.values[4]=-1;
		
		Arrays.sort(this.values);
		Arrays.sort(other.values);
		
		if(this.values[4]>other.values[4])
			System.out.println("AIP wins");
		else if(this.values[4]<other.values[4])
			System.out.println("Opponent wins");
		else
			System.out.println("It's a draw");
	}
		
	else {
		Arrays.sort(this.values);
		Arrays.sort(other.values);
		
		if(this.values[4]>other.values[4])
			System.out.println("AIP wins");
		else if(this.values[4]<other.values[4])
			System.out.println("Opponent wins");
		else
			System.out.println("It's a draw");
	}
}

public int winner(Hand other) {

	if(this.typeOfHand()<other.typeOfHand()) {
		System.out.println("AIP wins");
		return 2;
	}
	else if(this.typeOfHand()>other.typeOfHand()) {
		System.out.println("Opponent wins");
		return 1;
	}
	else {
		tieBreaker(other);
		return 0;
	}
	}

} // end of Hand class