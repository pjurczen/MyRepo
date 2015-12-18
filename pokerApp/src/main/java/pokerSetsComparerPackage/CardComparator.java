package pokerSetsComparerPackage;

import java.util.Comparator;


public class CardComparator implements Comparator<Card> {
	
	public int compare(Card card1, Card card2) {
		if(card1.getValue().getValueOfValue() > card2.getValue().getValueOfValue()) {
				return 1;
			}
			if (card1.getValue().getValueOfValue() < card2.getValue().getValueOfValue()) {
				return -1;
			}
			if(card1.getSuit().getValue() > card2.getSuit().getValue()) {
				return 1;
			}
			if (card1.getSuit().getValue() < card2.getSuit().getValue()) {
				return -1;
			}
			return 0;
	}
}
