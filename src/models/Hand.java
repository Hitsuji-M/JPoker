package models;

import java.util.ArrayList;
import java.util.Collections;

import utils.CombinationsValues;

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
	
	public int getScore() {
		Collections.sort(this.cards);
		return CombinationsValues.HIGH_CARD;
	}

	@Override
	public String toString() {
		return this.cards.toString();
	}
}
