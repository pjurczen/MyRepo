package pokerSetsComparerPackage.ChainOfResponsibility.Hand;

import pokerSetsComparerPackage.ChainOfResponsibility.Handler;
import pokerSetsComparerPackage.ChainOfResponsibility.Request;
import pokerSetsComparerPackage.Enums.PokerSets;

public class HandThreeOfAKindHandler extends HandHandler {
	
	public HandThreeOfAKindHandler(Handler succesor) {
		this.succesor = succesor;
	}

	@Override
	public void handle(Request request) {
		handRequest = (HandRequest)request;
		if(isThreeOfAKind()) {
			handRequest.setOldestSetInHand(PokerSets.ThreeOfAKind);
		} else {
			forward(request);
		}
	}
	
	private boolean isThreeOfAKind() {
		if(handRequest.getCardsPattern().contains(3)) {
			return true;
		}
		return false;
	}
}
