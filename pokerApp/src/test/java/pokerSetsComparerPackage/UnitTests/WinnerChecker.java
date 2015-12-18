package pokerSetsComparerPackage.UnitTests;

import pokerSetsComparerPackage.CardReader;
import pokerSetsComparerPackage.Hand;
import pokerSetsComparerPackage.HandsComparator;
import java.util.List;

public class WinnerChecker {
	private HandsComparator handsComparer = new HandsComparator();
	private CardReader cardReader = new CardReader();
	
	public WinnerChecker() {
		cardReader.loadFile();
	}
	
	public int getWinner(int index) {
		return handsComparer.compare(loadHands().get(index), loadHandsOne().get(index));
	}
	
	private List<Hand> loadHands() {
		return cardReader.getHands();
	}
	
	private List<Hand> loadHandsOne() {
		return cardReader.getHandsOne();
	}
}
