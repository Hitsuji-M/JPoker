package models;

import utils.Symbols;

public class Card {
	private int value;
	private Symbols symbol;
	private String name;
	
	
	public Card(final int value, final Symbols symbol, final String name) {
		this.value = value;
		this.symbol = symbol;
		this.name = name;
	}

	public int getValue() {
		return this.value;
	}

	public Symbols getSymbol() {
		return this.symbol;
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		return this.name + " of " + this.symbol.toString().toLowerCase() + "s";
	}
}
