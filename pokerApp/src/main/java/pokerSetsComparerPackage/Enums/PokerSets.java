package pokerSetsComparerPackage.Enums;

public enum PokerSets {
	Poker(8),
	FourOfAKind(7),
	FullHouse(6),
	Flush(5),
	Straight(4),
	ThreeOfAKind(3),
	TwoPairs(2),
	OnePair(1),
	HighCard(0);
	
	private int value;
	
	private PokerSets(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
}
