package models;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;

import utils.CardValues;
import utils.Symbols;

public class Deck {
	private ArrayList<Card> cards;
	
	public Deck() {
		this.cards = new ArrayList<Card>();
		this.fillDeck();
	}
	
	private void fillDeck() {
		Field[] fields = CardValues.class.getDeclaredFields();
		int value = -1;
		String name;
		
		for (Field f : fields) {
			name = f.getName();
			try {
				value = f.getInt(f);
			} catch(final Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
			
			try {
				for (Symbols enumVal : Symbols.class.getEnumConstants()) {
					this.cards.add(new Card(value, enumVal, name));
				}
			} catch (final Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(this.cards);
	}
	
	@Override
	public String toString() {
		return this.cards.toString();
	}
}
