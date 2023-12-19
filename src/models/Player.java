package models;

public class Player {
	private String name;
	private Hand hand;
	
	public Player(final String name) {
		this.name = name;
		this.hand = new Hand();
	}
}
