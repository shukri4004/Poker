package Comp4004.Poker;

public class Deck {

	Card[] cardHolder = new Card[52];
	String[] suits = {"C","D","H","S"}; 
	String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","Ace"}; 
	
	
	Deck(){
	int i = 0;
	
	for(int y = 0; y < 13; y++){
		for(int x = 0; x < 4; x++) {
			cardHolder[i] = new Card();
			cardHolder[i].suit=suits[x];
			cardHolder[i].rank=ranks[y];
			i = i + 1;
		}
	}
	}
	
	public Card getCard(int a) {
		return this.cardHolder[a];
	}
}
