package Comp4004.Poker;

public class Card {

	String suit;
	String rank;
	
	Card(String suit, String rank){
		this.suit = suit;
		this.rank = rank;
	}
	
	Card(){};
	
	public String getSuit() {
		return this.suit;
	}
	
	public String getRank() {
		return this.rank;
	}
}
