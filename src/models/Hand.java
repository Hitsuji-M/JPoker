package models;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards;
	
	public Hand() {
		this.cards = new ArrayList<Card>();
	}
	
	public void addCard(final Card card) {
		this.cards.add(card);
	}
	
	public void removeCard(final Card card) {
		this.cards.remove(card);
	}
	
	public Card removeCard(final int index) {
		return this.cards.remove(index);
	}

	@Override
	public String toString() {
		return this.cards.toString();
	}
}
