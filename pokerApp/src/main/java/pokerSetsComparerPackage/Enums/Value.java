package pokerSetsComparerPackage.Enums;

import java.util.Arrays;

public enum Value {
	Deuce(2, "2"),
	Three(3, "3"),
	Four(4, "4"),
	Five(5, "5"),
	Six(6, "6"),
	Seven(7, "7"),
	Eight(8, "8"),
	Nine(9, "9"),
	Ten(10, "T"),
	Jack(11, "J"),
	Queen(12, "Q"),
	King(13, "K"),
	Ace(14, "A");

	private int value;
	private String name;
	public int frequency;

	private Value(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public int getValueOfValue() {
		return this.value;
	}

	public static void setAceToLow() {
		Ace.value = 1;
	}

	public static void setAceToHigh() {
		Ace.value = 14;
	}

	public static Value fromString(String name) {
		if (name != null) {
			return Arrays.asList(Value.values()).stream().filter(value -> name.equalsIgnoreCase(value.name))
			.findFirst().get();
		}
		return null;
	}
}
