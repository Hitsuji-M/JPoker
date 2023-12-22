package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

import utils.CombinationsValues;
import utils.Symbols;

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
		TreeSet<Card> tmp = new TreeSet<Card>(this.cards);
		Card[] setHand = new Card[tmp.size()];
		int index = 0;
		int count;

		for (Card card : tmp) {
			setHand[index++] = card;
		}
		
		switch (setHand.length) {
			case 5: {
				boolean straight = false;
				boolean flush = true;
				Symbols oldSymbol = setHand[0].getSymbol();

				if ((setHand[0].getValue() == setHand[4].getValue() + 4) ||
					(setHand[0].getValue() == 14 && setHand[1].getValue() == 5)
				) {
					straight = true;
				}

				for (Card card : setHand) {
					if (card.getSymbol() != oldSymbol) {
						flush = false;
						break;
					}
					oldSymbol = card.getSymbol();
				}

				if (straight && flush) {
					return CombinationsValues.STRAIGHT_FLUSH;
				} else if (straight) {
					return CombinationsValues.STRAIGHT;
				} else if (flush) {
					return CombinationsValues.FLUSH;
				} else {
					return CombinationsValues.HIGH_CARD;
				}
				
			}

			case 4:
				return CombinationsValues.ONE_PAIR;
				
			case 3:
				for (Card cardSet : setHand) {
					count = 0;
					for (Card ogCard : this.cards) {
						if (cardSet.equals(ogCard)) {
							count++;
							if (count == 3) return CombinationsValues.THREE_OF_A_KIND;
						}
					}
					return CombinationsValues.TWO_PAIRS;
				}

			case 2:
				for (Card cardSet : setHand) {
					count = 0;
					for (Card ogCard : this.cards) {
						if (cardSet.equals(ogCard)) {
							count++;
							if (count == 4) return CombinationsValues.FOUR_OF_A_KIND;
						}
					}
					return CombinationsValues.FULL_HOUSE;
				}
			default:
				return CombinationsValues.HIGH_CARD;
		}
	}

	@Override
	public String toString() {
		return this.cards.toString();
	}
}
