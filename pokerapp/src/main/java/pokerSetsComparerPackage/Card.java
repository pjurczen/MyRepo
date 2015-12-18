package pokerSetsComparerPackage;

import pokerSetsComparerPackage.Enums.Suit;
import pokerSetsComparerPackage.Enums.Value;

public class Card implements Comparable<Card>{
	private Value value;
	private Suit suit;
	
	public Card(Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
	}
	
	
	public Value getValue() {
		return value;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	@Override
	public String toString() {
		return value + " of " + suit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (value != other.value)
			return false;
		return true;
	}


	@Override
	public int compareTo(Card obj) {
		if (this.value.getValueOfValue() < obj.getValue().getValueOfValue()) {
			return -1;
		}
	    if (this.value.getValueOfValue() == obj.getValue().getValueOfValue()) {
	        return 0;
	    }
	    return 1;
	}
}
