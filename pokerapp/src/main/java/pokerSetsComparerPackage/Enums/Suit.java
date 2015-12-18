package pokerSetsComparerPackage.Enums;

import java.util.Arrays;

public enum Suit {
	Hearths(1, "H"),
	Diamonds(2, "D"),
	Clubs(3, "C"),
	Spades(4, "S");
	
	private int value;
	
	private String name;
	
	private Suit(int value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public int getValue() {
		return value;
	}
	
	public static Suit fromString(String name) {
		if (name != null) {
			return Arrays.asList(Suit.values()).stream().filter(suit -> name.equalsIgnoreCase(suit.name))
			.findFirst().get();
		}
		return null;
	}
}
