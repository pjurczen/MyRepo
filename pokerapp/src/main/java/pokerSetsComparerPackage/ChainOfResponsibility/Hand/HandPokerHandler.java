package pokerSetsComparerPackage.ChainOfResponsibility.Hand;


import pokerSetsComparerPackage.ChainOfResponsibility.Handler;
import pokerSetsComparerPackage.ChainOfResponsibility.Request;
import pokerSetsComparerPackage.Enums.PokerSets;

public class HandPokerHandler extends HandComplexHandler {
	
	public HandPokerHandler(Handler succesor) {
		this.succesor = succesor;
	}
	
	@Override
	public void handle(Request request) {
		handRequest = (HandRequest)request;
		if(isPoker()) {
			handRequest.setOldestSetInHand(PokerSets.Poker);
		} else {
			forward(request);
		}
	}

	private boolean isPoker() {
		if(isSequence() && isOneColor()) {
			return true;
		}
		return false;
	}

	
}
