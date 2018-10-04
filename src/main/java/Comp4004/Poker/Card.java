package Comp4004.Poker;

public class Card {

	String suit;
	String rank;
	
	Card(String suit, String rank){
		this.suit = suit;
		this.rank = rank;
	}
	
	public String getSuit() {
		return this.suit;
	}
	
}
