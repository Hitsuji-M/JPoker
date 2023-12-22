package models;

public class Player {
	private String name;
	private Hand hand;
	
	public Player(final String name) {
		this.name = name;
		this.hand = new Hand();
	}

	public Hand getHand() {
		return this.hand;
	}

	public String getHandString() {
		return this.hand.toString();
	}
	
	public void addCardToHand(final Card card) {
		this.hand.addCard(card);
	}
	
	public void addCardsToHand(final Card[] cards) {
		for (Card card : cards) {
			this.hand.addCard(card);
		}
	}
	
	public void removeCardFromHand(final Card card) {
		this.hand.removeCard(card);
	}
	
	public void removeCardsFromHand(final Card[] cards) {
		for (Card card : cards) {
			this.hand.removeCard(card);	
		}
	}
	
	public Card[] removeCardsFromHand(final int[] indexes) {
		Card[] cards = new Card[indexes.length];
		for (int i = 0; i < indexes.length; i++) {
			cards[i] = this.hand.removeCard(indexes[i]);
		}
		return cards;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
