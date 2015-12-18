package pokerSetsComparerPackage.ChainOfResponsibility.Hand;

import java.util.ListIterator;
import java.util.stream.Collectors;

import pokerSetsComparerPackage.Card;

public abstract class HandComplexHandler extends HandHandler {
	
	protected boolean isSequence() {
		if(handRequest.getCardsPattern().stream().filter(x -> x > 1).collect(Collectors.toList()).isEmpty()) {
			if((handRequest.getCards().get(4).getValue().getValueOfValue() - handRequest.getCards().get(0).getValue().getValueOfValue()) == 4) {
				return true;
			}
		}
		return false;
	}
	
	protected boolean isOneColor() {
		if(handRequest.getCardsPattern().stream().filter(x -> x > 1).collect(Collectors.toList()).isEmpty()) {
			int colorCount = 0;
			ListIterator<Card> iterator = handRequest.getCards().listIterator();
			Card tmpCard = iterator.next();
			for(Card card : handRequest.getCards()) {
				if(iterator.hasNext()) {
					tmpCard = iterator.next();
					if(card.getSuit() == tmpCard.getSuit()) {
						colorCount++;
					}
				}
			}
			if(colorCount == 4) {
				return true;
			}
		}
		return false;
	}
}
