package pokerSetsComparerPackage.ChainOfResponsibility.Hand;

import java.util.List;

import pokerSetsComparerPackage.Card;
import pokerSetsComparerPackage.ChainOfResponsibility.Request;
import pokerSetsComparerPackage.Enums.PokerSets;

public class HandRequest extends Request {
	private List<Card> cards;
	private PokerSets oldestSetInHand;
	private List<Integer> cardsPattern;
	
	public HandRequest(List<Card> cards, List<Integer> cardsPattern) {
		this.cards = cards;
		this.cardsPattern = cardsPattern;
	}
	
	protected void setOldestSetInHand(PokerSets oldestSetInHand) {
		this.oldestSetInHand = oldestSetInHand;
	}
	
	public PokerSets getOldestSetInHand() {
		return oldestSetInHand;
	}

	public List<Card> getCards() {
		return cards;
	}

	public List<Integer> getCardsPattern() {
		return cardsPattern;
	}
}
