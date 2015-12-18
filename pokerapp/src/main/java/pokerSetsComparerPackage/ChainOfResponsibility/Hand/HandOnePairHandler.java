package pokerSetsComparerPackage.ChainOfResponsibility.Hand;

import pokerSetsComparerPackage.ChainOfResponsibility.Handler;
import pokerSetsComparerPackage.ChainOfResponsibility.Request;
import pokerSetsComparerPackage.Enums.PokerSets;

public class HandOnePairHandler extends HandHandler {
	
	public HandOnePairHandler(Handler succesor) {
		this.succesor = succesor;
	}
	
	@Override
	public void handle(Request request) {
		handRequest = (HandRequest)request;
		if(isPair()) {
			handRequest.setOldestSetInHand(PokerSets.OnePair);
		} else {
			forward(request);
		}
	}

	private boolean isPair() {
		if(handRequest.getCardsPattern().contains(2)) {
			return true;
		}
		return false;
	}
}
