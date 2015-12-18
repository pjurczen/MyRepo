package pokerSetsComparerPackage;

import java.util.Comparator;
import java.util.List;

import pokerSetsComparerPackage.Enums.PokerSets;
import pokerSetsComparerPackage.Enums.Value;

public class HandsComparator implements Comparator<Hand> {
	private List<Value> cardsValuesInHand;
	private List<Value> cardsValuesInHandOne;
	private PokerSets oldestSetInHand;
	private PokerSets oldestSetInHandOne;
	
	private int solveDraw(Hand hand, Hand handOne) {
		cardsValuesInHand = hand.getCardsValuesInHand();
		cardsValuesInHandOne = handOne.getCardsValuesInHand();
		
		for(int i = 0; i < 5; i++) {
			int result = Integer.compare(cardsValuesInHand.get(i).getValueOfValue(), cardsValuesInHandOne.get(i).getValueOfValue());
			if(result != 0) {
				return result;
			}
		}
		return 0;
	}

	@Override
	public int compare(Hand hand, Hand handOne) {
		oldestSetInHand = hand.getOldestSetInHand();
		oldestSetInHandOne = handOne.getOldestSetInHand();
		if(oldestSetInHand.getValue() > oldestSetInHandOne.getValue()) {
			return 1;
		}
		if(oldestSetInHand.getValue() < oldestSetInHandOne.getValue()) {
			return -1;
		}
		return solveDraw(hand, handOne);
	}
}