package pokerSetsComparerPackage.ChainOfResponsibility.Hand;

import pokerSetsComparerPackage.ChainOfResponsibility.Handler;
import pokerSetsComparerPackage.ChainOfResponsibility.Request;
import pokerSetsComparerPackage.Enums.PokerSets;

public class HandFourOfAKindHandler extends HandHandler {

	public HandFourOfAKindHandler(Handler succesor) {
		this.succesor = succesor;
	}
	
	@Override
	public void handle(Request request) {
		handRequest = (HandRequest)request;
		if(isFourOfAKind()) {
			handRequest.setOldestSetInHand(PokerSets.FourOfAKind);
		} else {
			forward(request);
		}
	}

	private boolean isFourOfAKind() {
		if(handRequest.getCardsPattern().contains(4)) {
			return true;
		}
		return false;
	}
}
