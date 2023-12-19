package utils;

public enum Symbols {
	HEART("Heart"),
	DIAMOND("Diamond"),
	CLUB("Club"),
	SPADE("Spade");
	
	private String name;
	private Symbols(final String name) {
		this.name = name;	
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
