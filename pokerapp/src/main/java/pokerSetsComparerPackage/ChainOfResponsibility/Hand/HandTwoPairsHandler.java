package pokerSetsComparerPackage.ChainOfResponsibility.Hand;

import java.util.Arrays;
import java.util.List;

import pokerSetsComparerPackage.ChainOfResponsibility.Handler;
import pokerSetsComparerPackage.ChainOfResponsibility.Request;
import pokerSetsComparerPackage.Enums.PokerSets;

public class HandTwoPairsHandler extends HandHandler {
	private List<Integer> twoPairsPattern = Arrays.asList(2, 2, 1);

	public HandTwoPairsHandler(Handler succesor) {
		this.succesor = succesor;
	}

	@Override
	public void handle(Request request) {
		handRequest = (HandRequest)request;
		if(isTwoPairs()) {
			handRequest.setOldestSetInHand(PokerSets.TwoPairs);
		} else {
			forward(request);
		}
	}
	
	private boolean isTwoPairs() {
		if(handRequest.getCardsPattern().equals(twoPairsPattern)) {
			return true;
		}
		return false;
	}
}
